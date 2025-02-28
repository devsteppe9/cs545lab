package miu.edu.cs545assignment.controller;

import miu.edu.cs545assignment.domain.Comment;
import miu.edu.cs545assignment.domain.Post;
import miu.edu.cs545assignment.domain.dto.PostDto;
import miu.edu.cs545assignment.service.CommentService;
import miu.edu.cs545assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users/{userid}/posts/{postid}/comments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public CommentController(PostService postService, CommentService commentService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Comment> getAll(@PathVariable long userid, @PathVariable long postid) {
        PostDto post = postService.getById(postid);
        if (post == null)
            return List.of();

        return post.getComments();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Comment getById(@PathVariable("id") long id, @PathVariable long userid, @PathVariable long postid) {
        return commentService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id, @PathVariable long userid, @PathVariable long postid) {
        commentService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Comment comment, @PathVariable long userid, @PathVariable long postid) {
        commentService.update(id, comment);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Comment comment, @PathVariable long userid, @PathVariable long postid) {
        postService.saveComment(postid, comment);
    }

}
