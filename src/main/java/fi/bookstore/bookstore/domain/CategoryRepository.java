package fi.bookstore.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{

     //peritään findAll(), findById(), deleteById(), save();
    //findByModel() voi määritellä omia find-metodeita
}


