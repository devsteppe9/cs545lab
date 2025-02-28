package miu.edu.cs545assignment.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miu.edu.cs545assignment.domain.Comment;
import miu.edu.cs545assignment.domain.Post;
import miu.edu.cs545assignment.domain.User;
import miu.edu.cs545assignment.domain.dto.PostDto;
import miu.edu.cs545assignment.helper.ListMapper;
import miu.edu.cs545assignment.repository.PostRepository;
import miu.edu.cs545assignment.repository.UserRepository;
import miu.edu.cs545assignment.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper listMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepo.findAll();
        return listMapper.mapList(posts, new PostDto());
    }

    @Override
    public List<PostDto> filterByAuthor(String author) {
        List<Post> posts = postRepo.findByAuthorContaining(author);
        return listMapper.mapList(posts, new PostDto());
    }

    @Override
    public PostDto getById(long id) {
        Post post = postRepo.findById(id).orElse(null);
        if (post == null)
            return null;
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public void save(PostDto post) {
        postRepo.save(modelMapper.map(post, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(long id, PostDto post) {
        postRepo.save(modelMapper.map(post, Post.class));
    }

    @Override
    public List<PostDto> findUserPosts(long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return List.of();

        return user.getPosts()
                .stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .toList();
    }

    @Override
    @Transactional
    public void saveComment(long postId, Comment comment) {
        Post post = postRepo.findById(postId).orElse(null);
        if (post == null)
            return;
        post.getComments().add(comment);
    }

    @Override
    public List<PostDto> filterByTitleAndUserId(String title, long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return List.of();

        return user.getPosts()
                .stream()
                .filter(p -> p.getTitle().toLowerCase().contains(title.toLowerCase()))
                .map(p -> modelMapper.map(p, PostDto.class))
                .toList();
    }


}
