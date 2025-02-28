package miu.edu.cs545assignment.service;

import miu.edu.cs545assignment.domain.User;
import miu.edu.cs545assignment.domain.dto.PostDto;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findMoreThanOnePost();
    User findById(long id);
    void save(User user);
    void savePost(long userId, PostDto postDto);
    void deleteById(long id);
    List<User> findUsersWithPostsMoreThan(int number);
    List<User> findUsersWithPostsContainingKeyword(String titleQuery);
}
