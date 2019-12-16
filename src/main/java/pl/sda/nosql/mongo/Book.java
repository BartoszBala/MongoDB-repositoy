package pl.sda.nosql.mongo;

import org.bson.Document;

import javax.print.Doc;

public class Book {

    private String title;
    private int pageCount;
    private String isbn;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }


    public Book(String title, int pageCount, String isbn) {
        this.title = title;
        this.pageCount = pageCount;
        this.isbn = isbn;
    }

    public static Book fromDocument(Document doc) {
        String title = doc.getString("title");
        int pageCount = doc.getInteger("pageCount");
        String isbn = doc.getString("isbn");

        return new Book(title, pageCount,isbn);
    }

    public static Document toDocument(Book book) {
        Document document = new Document("title",book.getTitle()).append("pageCount", book.pageCount).append("isbn",book.getIsbn());
        return document;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
