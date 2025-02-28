package miu.edu.cs545assignment.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cs545assignment.domain.Comment;
import miu.edu.cs545assignment.repository.CommentRepository;
import miu.edu.cs545assignment.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Comment getById(Long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void update(Long id, Comment comment) {
        commentRepo.save(comment);
    }
}
