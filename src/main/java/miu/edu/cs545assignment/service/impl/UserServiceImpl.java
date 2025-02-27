package miu.edu.cs545assignment.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cs545assignment.domain.Post;
import miu.edu.cs545assignment.domain.User;
import miu.edu.cs545assignment.domain.dto.PostDto;
import miu.edu.cs545assignment.helper.ListMapper;
import miu.edu.cs545assignment.repository.PostRepository;
import miu.edu.cs545assignment.repository.UserRepository;
import miu.edu.cs545assignment.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public List<User> findMoreThanOnePost() {
        return userRepo.findUsersWithMoreThanOnePost();
    }

    @Override
    public User findById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
