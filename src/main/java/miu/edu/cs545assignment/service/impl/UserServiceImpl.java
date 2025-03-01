package miu.edu.cs545assignment.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miu.edu.cs545assignment.domain.Post;
import miu.edu.cs545assignment.domain.User;
import miu.edu.cs545assignment.domain.dto.PostDto;
import miu.edu.cs545assignment.helper.ListMapper;
import miu.edu.cs545assignment.repository.UserRepository;
import miu.edu.cs545assignment.repository.UserRepositoryDao;
import miu.edu.cs545assignment.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final UserRepositoryDao userRepositoryDao;

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

    @Override
    @Transactional
    public void savePost(long userId, PostDto postDto) {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null)
            return;

        Post post = modelMapper.map(postDto, Post.class);
        user.getPosts().add(post);
    }

    @Override
    public void deleteById(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> findUsersWithPostsMoreThan(int number) {
        return userRepo.findUsersWithPostsMoreThan(number);
    }

    @Override
    public List<User> findUsersWithPostsContainingKeyword(String titleQuery) {
        return userRepositoryDao.findUsersWithPostsContainingTitleKeyword(titleQuery);
    }
}
