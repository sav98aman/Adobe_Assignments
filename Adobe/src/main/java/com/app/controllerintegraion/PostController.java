package com.app.controllerintegraion;

import com.app.ServiceIntegration.PostService;
import com.app.model.Post;
import com.app.repointegration.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/{Id}")
    public ResponseEntity<Object> createPostByUserID(@PathVariable Integer Id , @RequestBody String content) throws Exception {
        return BaseResponse.responseBuilderObject("success",postService.createPost(Id,content), HttpStatus.CREATED);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<Object> getPostByPostId(@PathVariable Integer Id) throws Exception {
        return BaseResponse.responseBuilderObject("success",postService.getPostbyID(Id), HttpStatus.CREATED);
    }
    @PutMapping("/{Id}")
    public ResponseEntity<Object> updatePostContentByPostId(@PathVariable Integer Id,@RequestParam String content) throws Exception {
        return BaseResponse.responseBuilderObject("success",postService.updatePostContentByPostId(Id,content), HttpStatus.CREATED);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<Object> deletePostByPostId(@PathVariable Integer Id) throws Exception {
        return BaseResponse.responseBuilderObject("success",postService.deletePostByPostId(Id), HttpStatus.CREATED);
    }
    @PostMapping("/{Id}/like")
    public ResponseEntity<Object> likesIncrement(@PathVariable Integer Id) throws Exception {
        return BaseResponse.responseBuilderObject("success",postService.incrementPostLikeByPostId(Id), HttpStatus.CREATED);
    }

    @PostMapping("/{Id}/unlike")
    public ResponseEntity<Object> likeDecrement(@PathVariable Integer Id) throws Exception {
        return BaseResponse.responseBuilderObject("success",postService.dcrementPostLikeByPostId(Id), HttpStatus.CREATED);
    }
}
