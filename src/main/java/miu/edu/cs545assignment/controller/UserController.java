package miu.edu.cs545assignment.controller;


import miu.edu.cs545assignment.domain.Post;
import miu.edu.cs545assignment.domain.User;
import miu.edu.cs545assignment.domain.dto.PostDto;
import miu.edu.cs545assignment.service.PostService;
import miu.edu.cs545assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts/more-than-one-post")
    public List<User> getUsersMoreThanOnePost() {
        return userService.findMoreThanOnePost();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/posts")
    public List<PostDto> getPosts(@PathVariable long userId) {
        return postService.findUserPosts(userId);
    }
}
