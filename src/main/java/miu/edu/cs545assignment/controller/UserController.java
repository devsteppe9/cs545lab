package miu.edu.cs545assignment.controller;


import miu.edu.cs545assignment.aspect.ExecutionTime;
import miu.edu.cs545assignment.domain.User;
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

    @Autowired
    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
    }

    @ExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter/more-than-one-post")
    public List<User> getUsersMoreThanOnePost() {
        return userService.findMoreThanOnePost();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter/posts/{number}")
    public List<User> getUsersWithPostsMoreThan(@PathVariable int number) {
        return userService.findUsersWithPostsMoreThan(number);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter/posts/title/{keyword}")
    public List<User> getUsersWithPostsContainingKeyword(@PathVariable String keyword) {
        return userService.findUsersWithPostsContainingKeyword(keyword);
    }
}
