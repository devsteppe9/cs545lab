package miu.edu.cs545assignment.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cs545assignment.domain.Post;
import miu.edu.cs545assignment.domain.dto.PostDto;
import miu.edu.cs545assignment.helper.ListMapper;
import miu.edu.cs545assignment.repository.PostRepository;
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
        List<Post> userPosts = postRepo.findByUserId(userId);
        return listMapper.mapList(userPosts, PostDto.class);
    }
}
