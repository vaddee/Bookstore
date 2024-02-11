package fi.bookstore.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    //peritään findAll(), findById(), deleteById(), save();
    //findByModel() voi määritellä omia find-metodeita

}
