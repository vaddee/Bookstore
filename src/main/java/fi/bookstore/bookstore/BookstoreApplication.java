package fi.bookstore.bookstore;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.bookstore.bookstore.domain.Book;
import fi.bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {

			
			Book book1 = new Book("Taru Sormusten Herrasta", "JJ.Tolken", 2000, "344141", 20);
			Book book2 = new Book("vares", "Jaska Jokunen", 2011, "322213", 15);
			Book book3 = new Book("Valtaistuinpeli", "George RR Martin", 1991, "5555666", 40);
			
		
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			
		};
	}

}
