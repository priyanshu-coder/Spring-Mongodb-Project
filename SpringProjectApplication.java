package com.priyanshu.SpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {

		/*Book(id,copiesAvailable,authorId,genre)

		Author(id,name,address(house no, city,state));

		1) Create a GET api to get all the books from db
		2) Create a GET api to get all the books from db whose genre matches the query param input
		3) Create a GET api to get all the books from db whose genre matches the query param input and copiesAvailable is more than input provided in the path param.
		4) Create a POST api to save book detail in db (including validations of not blank, not null etc)
		5) Create a POST api to save author detail in db (including validations of not blank, not null etc)
		6) Create a GET api to fetch all books whose author is in one of the input provided in the query params
		7) Create a GET api to fetch all authors whose name matches the regular expression provided in the input query params.*/
		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
