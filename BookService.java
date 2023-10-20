package com.priyanshu.SpringProject.Services;

import com.priyanshu.SpringProject.Models.Book;
import com.priyanshu.SpringProject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book){
        Book save = bookRepository.save(book);
        return save;
    }

    public void deleteAllBook(){
        bookRepository.deleteAll();
        return;
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public List<Book> getAllBooksByGenre(String genre){

        return bookRepository.getAllBooksByGenre(genre);
    }

    public List<Book> getBooksByGenreCopies(String genre, int copies){
        return bookRepository.getBooksByGenreCopies(genre,copies);
    }

    public List<Book> getByID(int id){
        return bookRepository.getBooksByID(id);
    }
}
