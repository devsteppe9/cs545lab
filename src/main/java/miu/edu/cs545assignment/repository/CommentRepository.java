package miu.edu.cs545assignment.repository;

import miu.edu.cs545assignment.domain.Comment;
import miu.edu.cs545assignment.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
