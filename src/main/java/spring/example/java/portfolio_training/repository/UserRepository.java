package spring.example.java.portfolio_training.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.example.java.portfolio_training.beans.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u where u.username= :name")
    public User searchByName(@Param("name") String username);
}