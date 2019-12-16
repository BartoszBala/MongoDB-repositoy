package pl.sda.nosql.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryMongoDB implements BookRepository {

    private MongoClient mongo;
    private MongoDatabase db;

    public BookRepositoryMongoDB() {
        this.mongo = new MongoClient("localhost", 27017);
        this.db = mongo.getDatabase("books");
    }

    @Override
    public List<Book> findAll() {

        MongoCollection<Document> books = db.getCollection("books");
        Document findPublished = new Document("publishedDate", new Document("$ne", null));          //to jest zapytanie

        MongoCursor<Document> cursor = getDocuments(books, findPublished);
        List<Book> booksCollection = convertToBooks(cursor);

        return booksCollection;
    }

    private List<Book> convertToBooks(MongoCursor<Document> cursor) {
        List<Book> booksCollection = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                Book book = Book.fromDocument(doc);
                booksCollection.add(book);
        }
        } finally {
            cursor.close();
        }
        return booksCollection;
    }

    private MongoCursor<Document> getDocuments(MongoCollection<Document> books, Document findPublished) {
        return books.find(findPublished).sort(new Document("title", 1)).iterator();
    }

//    public Car findById(Long id) {
//        Car car =   getSession().get(Car.class,id);
//
//        return car;
//    }
//

    @Override
    public Book finbyId(String id) {

        MongoCollection<Document> books = db.getCollection("books");
        Document findBook = new Document("isbn", id);

        MongoCursor<Document> documents = getDocuments(books, findBook);
        List<Book> booksCollection = convertToBooks(documents);

        return booksCollection.get(0);
    }
    @Override
    public void create(Book book) {
        MongoCollection<Document> books = db.getCollection("books");
        books.insertOne(Book.toDocument(book));

    }

    @Override
    public void update(Book book) {
        MongoCollection<Document> books = db.getCollection("books");
//        Document findBook = new Document("isbn", book.getIsbn());
        Document querry = new Document();
        querry.append("isbn",book.getIsbn());
        Document setData = new Document();
        setData.append("isbn",book.getIsbn()).append("title",book.getTitle()).append("pageCount",book.getPageCount());
        Document update = new Document("$set",setData);

//        MongoCursor<Document> documents = getDocuments(books, findBook);
     books.updateOne(querry,update);
    }

    @Override
    public void delete(String id) {

        MongoCollection<Document> books = db.getCollection("books");
        Document findBook = new Document("isbn", id);
        books.deleteOne(findBook);


    }


}
