package kz.kaitanov.fitnessbackend.repository.model;

import kz.kaitanov.fitnessbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            SELECT u
            FROM User u JOIN FETCH u.role
            WHERE u.username = :username
            """)
    Optional<User> findByUsername(@Param("username") String username);

    @Query("""
            SELECT CASE WHEN COUNT(c) > 0 
            THEN true ELSE false END FROM User c 
            WHERE c.username = :username
            """)
    boolean existsByUsername(@Param("username") String username);

    @Query("""
            SELECT CASE WHEN COUNT(c) > 0 
            THEN true ELSE false END FROM User c 
            WHERE c.email = :email
            """)
    boolean existsByEmail(@Param("email") String email);

    @Query("""
            SELECT CASE WHEN COUNT(c) > 0 
            THEN true ELSE false END FROM User c 
            WHERE c.phone = :phone
            """)
    boolean existsByPhone(@Param("phone") String phone);
}
