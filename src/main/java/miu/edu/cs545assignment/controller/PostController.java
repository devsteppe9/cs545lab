package miu.edu.cs545assignment.controller;

import miu.edu.cs545assignment.domain.dto.PostDto;
import miu.edu.cs545assignment.service.PostService;
import miu.edu.cs545assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users/{userid}/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll(@PathVariable long userid) {
        return postService.findUserPosts(userid);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDto getById(@PathVariable("id") long id, @PathVariable long userid) {
        return postService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id, @PathVariable long userid) {
        postService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody PostDto postDto, @PathVariable long userid) {
        postService.update(id, postDto);
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter/{author_query}")
    public List<PostDto> findByAuthor(@PathVariable("author_query") String authorQuery, @PathVariable String userid) {
        return postService.filterByAuthor(authorQuery);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody PostDto postDto, @PathVariable long userid) {
        userService.savePost(userid, postDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter/title/{title}")
    public List<PostDto> findByTitle(@PathVariable("title") String title, @PathVariable long userid) {
        return postService.filterByTitleAndUserId(title, userid);
    }
}
