package miu.edu.cs545assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;
}
