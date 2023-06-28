package spring.example.java.portfolio_training.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.example.java.portfolio_training.beans.Product;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    //JAVA persistence SQL, Product - class Product
    //@Query("select p from Product p where p.name like %:name%")
    public List<Product> findByNameLike(@Param("name") String name);
}
