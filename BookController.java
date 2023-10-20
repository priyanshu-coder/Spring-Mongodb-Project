package com.priyanshu.SpringProject.Controllers;

import com.priyanshu.SpringProject.Exceptions.InvalidBookTypeException;
import com.priyanshu.SpringProject.Models.Book;
import com.priyanshu.SpringProject.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidBookTypeException("Invalid Book Type");
        }
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping("/")
    public List<Book> getAllBooks(){
        return bookService.getAllBook();
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable(value="genre") String genre){
        return bookService.getAllBooksByGenre(genre);
    }

    @GetMapping("/{genre}/{copies}")
    public List<Book> getBooksByGenreCopies(@PathVariable(value = "genre") String genre, @PathVariable(value="copies") int copies){
        return bookService.getBooksByGenreCopies(genre,copies);
    }

    @GetMapping("/id/{authorID}")
    public List<Book> getBooksByID(@PathVariable int authorID){
        return bookService.getByID(authorID);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBook();
        return ResponseEntity.ok("Deleted all books from db");
    }
}
