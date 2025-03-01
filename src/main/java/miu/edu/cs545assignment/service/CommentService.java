package miu.edu.cs545assignment.service;

import miu.edu.cs545assignment.domain.Comment;

public interface CommentService {

    Comment getById(Long id);
    void delete(Long id);
    void update(Long id, Comment comment);

}
