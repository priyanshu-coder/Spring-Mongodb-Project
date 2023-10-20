package com.priyanshu.SpringProject.Models;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;
import javax.validation.constraints.*;
import java.util.Map;

@Document(collection = "Author")
public class Author {

    @Size(min=1)
    private String authorName;

    @Min(1)
    private int authorID;

    @NotNull
    Map<String,String> address;

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                ", authorID=" + authorID +
                ", address=" + address +
                '}';
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Author(int authorID, String authorName, Map<String,String> address){
        this.authorID = authorID;
        this.authorName = authorName;
        this.address = address;
    }
}
