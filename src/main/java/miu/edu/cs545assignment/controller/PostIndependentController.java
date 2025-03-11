package miu.edu.cs545assignment.controller;

import miu.edu.cs545assignment.domain.dto.PostDto;
import miu.edu.cs545assignment.service.PostService;
import miu.edu.cs545assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostIndependentController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostIndependentController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll() {
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDto getById(@PathVariable("id") long id) {
        return postService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        postService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody PostDto postDto) {
        postService.update(id, postDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody PostDto postDto) {
        postService.save(postDto);
    }

}
