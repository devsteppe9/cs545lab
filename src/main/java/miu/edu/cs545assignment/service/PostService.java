package miu.edu.cs545assignment.service;

import miu.edu.cs545assignment.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    List<PostDto> filterByAuthor(String author);
    PostDto getById(long id);
    void save(PostDto post);
    void delete(long id);
    void update(long id, PostDto post);
    List<PostDto> findUserPosts(long userId);
}
