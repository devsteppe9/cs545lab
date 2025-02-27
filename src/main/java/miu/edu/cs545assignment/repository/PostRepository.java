package miu.edu.cs545assignment.repository;

import miu.edu.cs545assignment.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorContaining(String author);

    List<Post> findByUserId(long userId);
}
