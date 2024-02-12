package fi.bookstore.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.bookstore.bookstore.domain.Book;
import fi.bookstore.bookstore.domain.BookRepository;


@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String indexPage() {
        return "index"; //index.html
    }
    
    
    @RequestMapping(value = "/booklist", method=RequestMethod.GET)
    public String getBooks(Model model) {

        
        model.addAttribute("books", bookRepository.findAll());

        return "booklist"; // .html
    }
    
    
    @RequestMapping(value ="/addbook", method = RequestMethod.GET)
    public String getNewBookForm(Model model) {

        
        model.addAttribute("book", new Book()); 
        return "addbook"; // .html
    }

    @RequestMapping(value= "/savebook", method = RequestMethod.POST)
    public String saveBook(Book newBook, Model model) {

        
        bookRepository.save(newBook);
        
        return "redirect:/booklist"; 
    }

    @RequestMapping(value ="/delete/{bookId}", method = RequestMethod.POST)
public String deleteBook(@PathVariable Integer bookId) {

    // poistaa Book Id perusteella
    bookRepository.deleteById(bookId);

    return "redirect:/booklist"; 
}

@RequestMapping(value = "/edit/{bookId}", method = RequestMethod.GET)
public String editBookForm(@PathVariable Integer bookId, Model model) {
    Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + bookId));
    model.addAttribute("book", book);
    return "editbook";
}

@RequestMapping(value = "/saveeditedbook", method = RequestMethod.POST)
public String saveEditedBook(Book editedBook, Model model) {
    bookRepository.save(editedBook);
    return "redirect:/booklist";
}



}
