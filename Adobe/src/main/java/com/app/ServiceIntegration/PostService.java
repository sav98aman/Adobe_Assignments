package com.app.ServiceIntegration;

import com.app.model.Post;

public interface PostService {
    public Post createPost(Integer userId ,String content) throws Exception;// create a post by userID

    public Post getPostbyID(Integer postId) throws Exception;

    public Post updatePostContentByPostId(Integer postId,String content) throws Exception;

    public Post deletePostByPostId(Integer postId) throws Exception;

    public Post incrementPostLikeByPostId(Integer postId) throws Exception;//like

    public Post dcrementPostLikeByPostId(Integer postId) throws Exception;//unlike


}
