package workshop.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService{
    private List<Book> bookList;
    private long nextId=4L;

    public List<Book> getBookList() {
        bookList= new ArrayList<>();
        bookList.add(new Book((long) 1,"1234","Balladyna","Slowacki", "bialy kruk", "dramat"));
        bookList.add(new Book((long) 2,"2345","Makbet","Slowacki", "bialy kruk", "dramat"));
        bookList.add(new Book((long) 3,"3456","Pan Tadeusz","Mickiewicz", "centurion", "epopeja"));

        return bookList;
    }

    public Optional<Book> getBookById(long id){

        return bookList.stream().filter(item -> item.getId().equals(id)).findFirst();

//        for (Book book: bookList) {
//            if (book.getId()==id){
//                return book;
//            }
//        }
//        return null;
    }

    @Override
    public void add(Book book){
        book.setId(nextId++);
        bookList.add(book);
    }

    @Override
    public void delete(long id){
        if(getBookById(id).isPresent()){
            bookList.remove(this.getBookById(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if (this.getBookById(book.getId()).isPresent()) {
            int indexOf = bookList.indexOf(this.getBookById(book.getId()).get());
            bookList.set(indexOf, book);
        }
    }



}
