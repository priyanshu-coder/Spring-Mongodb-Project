package com.priyanshu.SpringProject.Controllers;

import com.priyanshu.SpringProject.Exceptions.InvalidAuthorTypeException;
import com.priyanshu.SpringProject.Models.Author;
import com.priyanshu.SpringProject.Models.Book;
import com.priyanshu.SpringProject.Repository.AuthorRepository;
import com.priyanshu.SpringProject.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/")
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidAuthorTypeException("Invalid Input");
        }
        Author save = authorService.createAuthor(author);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/")
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/{authorName}/books")
    public List<Book> getAllBooksOfAuthor(@PathVariable String authorName){
        authorService.getAllBooksOfAuthor(authorName);
        return authorService.getAllBooksOfAuthor(authorName);
    }

    @GetMapping("/{expression}")
    public List<Author> getAllAuthorWithRegex(@PathVariable String expression){
        return authorService.getAllAuthorWithRegex(expression);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteAll(){
        authorService.deleteAll();
        return ResponseEntity.ok("successfully deleted");
    }
}
