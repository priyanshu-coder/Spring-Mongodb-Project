package com.priyanshu.SpringProject.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Document(collection = "Book")
public class Book {

    @Min(1)
    private int bookID;

    @Min(0)
    private int copiesAvailable;

    @Min(1)
    private int authorID;

    @Size(min=1)
    private String genre;

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", copiesAvailable=" + copiesAvailable +
                ", authorID=" + authorID +
                ", genre='" + genre + '\'' +
                '}';
    }

    public Book(int bookID, int copiesAvailable, int authorID, String genre) {
        this.bookID = bookID;
        this.copiesAvailable = copiesAvailable;
        this.authorID = authorID;
        this.genre = genre;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
