package fi.bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.bookstore.bookstore.domain.Book;
import fi.bookstore.bookstore.domain.Category;
import fi.bookstore.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

      
    @RequestMapping(value="/categorylist", method=RequestMethod.GET)
    public String categoryPage(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        
        return "categorylist"; //.html
    }

      @RequestMapping(value ="/addcategory", method = RequestMethod.GET)
    public String getNewCategory(Model model) {

        
        model.addAttribute("category", new Category()); 
        return "addcategory"; // .html
    }

    @RequestMapping(value= "/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category newCategory, Model model) {

        
        categoryRepository.save(newCategory);
        
        return "redirect:/categorylist"; 
    }

}
