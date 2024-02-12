package fi.bookstore.bookstore.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Category {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long categoryId;
    private String name;

    

    public Category() {
    };

    public Category(String name) {
        super();
        this.name = name;
    }

    // getit
    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }

    // setit
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }


}
