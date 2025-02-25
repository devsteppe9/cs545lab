package miu.edu.cs545assignment.repository;

import miu.edu.cs545assignment.domain.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    List<Post> filterByAuthor(String author);
    Post getById(long id);
    void save(Post post);
    void delete(long id);
    void update(long id, Post post);
}
