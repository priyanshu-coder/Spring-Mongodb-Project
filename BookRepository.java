package com.priyanshu.SpringProject.Repository;

import com.priyanshu.SpringProject.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {

    @Query(value = "{'genre':'?0'}")
    public List<Book> getAllBooksByGenre(String genre);

    @Query(value = "{'genre':?0 , 'copiesAvailable':{$gt : ?1}}")
    //mongodb query: {genre:'fiction',copiesAvailable:{$gt:10}}
    public List<Book> getBooksByGenreCopies(String genre, int copies);

    @Query("{'authorID':?0}")
    public List<Book> getBooksByID(int id);
}
