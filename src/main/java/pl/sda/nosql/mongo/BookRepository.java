package pl.sda.nosql.mongo;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();

    Book finbyId(String id);

    void create(Book book);

    void update(Book book);

    void delete(String id);


}
