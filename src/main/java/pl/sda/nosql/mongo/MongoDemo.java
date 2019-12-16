package pl.sda.nosql.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class MongoDemo {

//    private static final Logger logger = LoggerFactory.getLogger(MongoDemo.class);

    private static final Logger logger = LoggerFactory.getLogger(MongoDemo.class);

    public static void main(String[] args) throws UnknownHostException {


        BookService bs = new BookService(new BookRepositoryMongoDB());
//        List<Book> all = bs.findAll();
//
//        for (Book book : all) {
//        logger.info(book.toString());
//
//        }

//        logger.info(bs.findOne("1933988746").toString());
//        bs.deleteById("1933988746");
////
//        Book book = new Book("Pan Tadeusz",280);
//        bs.save(book);

        Book book1 = new Book("Dzikowy Skarb2",500, "1935182234");
//        bs.save(book1);

        bs.update(book1);


//        MongoClient mongo = new MongoClient("localhost", 27017);
//        MongoDatabase db = mongo.getDatabase("books");
//        MongoCollection<Document> books = db.getCollection("books");
//
////        /**** Insert ****/
////        // create a document to store key and value
////        Document elementarz = new Document("title", "Elementarz Pierwszoklasisty")
////                .append("isbn", "9788302022432");
////        books.insertOne(elementarz);
//
//
//        Document findPublished = new Document("publishedDate", new Document("$ne", null));
//        Document orderBy = new Document("title", 1);
//        MongoCursor<Document> cursor = books.find(findPublished).sort(orderBy).iterator();
//
//        List<Book> booksCollection = new ArrayList<>();
//
//        try {
//            while (cursor.hasNext()) {
//                Document doc = cursor.next();
//
//                Book book = Book.fromDocument(doc);
//                booksCollection.add(book);
////                System.out.println(
////                    "Book " + doc.get("title") + ", published at " + doc.get("publishedDate")
////                );
//            }
//        } finally {
//            cursor.close();
//        }
//
//        System.out.println("Pobrano " + booksCollection.size() + " książek");
    }
}
