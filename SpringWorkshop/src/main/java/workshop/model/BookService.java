package workshop.model;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBookList();
    void add(Book book);
    Optional<Book> getBookById(long id);
    void delete(long id);
    void update (Book book);
}
