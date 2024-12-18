package com.raysi.blogmanagementsystem.controllers;

import com.raysi.blogmanagementsystem.entities.Post;
import com.raysi.blogmanagementsystem.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    //Getting all the post from the database
    @GetMapping("/api/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPost();
    }

    @PostMapping("/api/posts")
    public String publishPost(@RequestBody Post post){
        postService.savePost(post);
        return "Post published successfully!";
    }
}
