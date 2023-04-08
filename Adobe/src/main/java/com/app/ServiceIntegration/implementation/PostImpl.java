package com.app.ServiceIntegration.implementation;

import com.app.ServiceIntegration.PostService;
import com.app.model.Post;
import com.app.model.User;
import com.app.repointegration.PostDao;
import com.app.repointegration.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Post createPost(Integer userId, String  content) throws Exception {
        Optional<User> optUser = userDao.findById(userId);
        if (optUser.isEmpty()) {
            throw new Exception(userId + "  This User Id Not Prsent !");
        }
        Post post=new Post();
        post.setContent(content);
        post.setLikes(0);
        post.setCreateAtTime(LocalDateTime.now());
        post.setUser(optUser.get());
        post.setUpdateAtTime(null);

        return postDao.save(post);
    }

    @Override
    public Post getPostbyID(Integer postId) throws Exception {
        Optional<Post> optpost = postDao.findById(postId);
        if (optpost.isEmpty()) {
            throw new Exception(postId + "    This Post Id Is Wrong ! ");
        }
        return optpost.get();
    }

    @Override
    public Post updatePostContentByPostId(Integer postId, String content) throws Exception {
        Post post = getPostbyID(postId);
        post.setContent(content);
        return postDao.save(post);
    }

    @Override
    public Post deletePostByPostId(Integer postId) throws Exception {
        Post post = getPostbyID(postId);
        postDao.delete(post);
        return post;
    }

    @Override
    public Post incrementPostLikeByPostId(Integer postId) throws Exception {
        Post post = getPostbyID(postId);
        post.setLikes(post.getLikes() + 1);
        return postDao.save(post);

    }

    @Override
    public Post dcrementPostLikeByPostId(Integer postId) throws Exception {
        Post post = getPostbyID(postId);
        if(post.getLikes()<=0){
            post.setLikes(0);
        }else {
            post.setLikes(post.getLikes() - 1);
        }
        return postDao.save(post);
    }
}
