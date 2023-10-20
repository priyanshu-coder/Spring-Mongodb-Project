package com.priyanshu.SpringProject.Repository;

import com.priyanshu.SpringProject.Models.Author;
import com.priyanshu.SpringProject.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends MongoRepository<Author,Integer> {

    @Query(value="{'authorName':{$regex: '?0', '$options':'i'}}")
    public List<Author> getAllAuthorWithRegex(String expression);

    @Query("{'authorName':'?0'}")
    public Author getAuthorByName(String authorName);

}
