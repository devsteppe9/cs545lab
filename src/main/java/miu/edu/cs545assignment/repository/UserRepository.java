package miu.edu.cs545assignment.repository;

import miu.edu.cs545assignment.domain.Post;
import miu.edu.cs545assignment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM user u WHERE size(u.posts) > 1 ")
    List<User> findUsersWithMoreThanOnePost();
}
