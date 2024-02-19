package fi.bookstore.bookstore;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.bookstore.bookstore.domain.Book;
import fi.bookstore.bookstore.domain.BookRepository;
import fi.bookstore.bookstore.domain.Category;
import fi.bookstore.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category category1 = new Category("Horror");
			
			Category category2 = new Category("Fantasy");
			
			Category category3 = new Category("Dramaa");
			

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			



			
			Book book1 = new Book("Taru Sormusten Herrasta", "JJ.Tolken", 2000, "344141", 20.5, category1);
			Book book2 = new Book("vares", "Jaska Jokunen", 2011, "322213", 15.4, category2);
			Book book3 = new Book("Valtaistuinpeli", "George RR Martin", 1991, "5555666", 40.4, category3);
			
		
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			
		};
	}

	
	}


