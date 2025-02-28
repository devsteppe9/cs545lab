package miu.edu.cs545assignment.service;

import miu.edu.cs545assignment.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment getById(Long id);
    void delete(Long id);
    void update(Long id, Comment comment);

}
