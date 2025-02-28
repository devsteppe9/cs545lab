package miu.edu.cs545assignment.domain.dto;

import lombok.Data;
import miu.edu.cs545assignment.domain.Comment;

import java.util.List;

@Data
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;
}
