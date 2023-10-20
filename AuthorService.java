package com.priyanshu.SpringProject.Services;

import com.priyanshu.SpringProject.Models.Author;
import com.priyanshu.SpringProject.Models.Book;
import com.priyanshu.SpringProject.Repository.AuthorRepository;
import com.priyanshu.SpringProject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public Author createAuthor(Author author) {
        Author save = this.authorRepository.save(author);
        return save;
    }

    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    public void deleteAll(){
        authorRepository.deleteAll();
        return;
    }

    public List<Book> getAllBooksOfAuthor(String authorName){
            List<Author> authorList = authorRepository.getAllAuthorWithRegex(authorName);
            System.out.println(authorList);
            List<Book> requiredBook = new ArrayList<>();
            for(Author author : authorList){
                System.out.println(author.getAuthorID());
                List<Book> tmp = bookRepository.getBooksByID(author.getAuthorID());
                System.out.println(tmp);
                for(Book ele : tmp){
                    requiredBook.add(ele);
                }
            }

            return requiredBook;
    }
    public List<Author> getAllAuthorWithRegex(String expression){
        return authorRepository.getAllAuthorWithRegex(expression);
    }
}
