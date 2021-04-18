package workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import workshop.model.Book;
import workshop.model.BookService;
import workshop.model.MemoryBookService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public @ResponseBody List<Book> getList(){
        return this.bookService.getBookList();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        bookService.add(book);
    }

//    @GetMapping("/{id}")
//    @ResponseBody
//    public Optional<Book> getBookById(@PathVariable long id){
//        return bookService.getBookById(id);
//    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return this.bookService.getBookById(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable long id){
        bookService.delete(id);
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        Book book1=new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");

        return book1;
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }
}
