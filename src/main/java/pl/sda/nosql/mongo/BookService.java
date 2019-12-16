package pl.sda.nosql.mongo;

import java.util.List;

public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findOne(String id) {
        return repository.finbyId(id);
    }

    public void save(Book book) {
    repository.create(book);
    }

    public void deleteById(String id){

        repository.delete(id);
    }
    public void update(Book book) {


        repository.update(book);

    }
}
