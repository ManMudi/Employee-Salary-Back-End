package iki.fadhila.back_end.repository;

import iki.fadhila.back_end.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);

    @Query("Select u from User u where id =:userId")
    List<User> findUserProfile(@Param("userId") Long userId);
}
