package com.raysi.blogmanagementsystem.services;

import com.raysi.blogmanagementsystem.entities.Category;
import com.raysi.blogmanagementsystem.entities.Post;
import com.raysi.blogmanagementsystem.repositories.CategoryRepository;
import com.raysi.blogmanagementsystem.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

}
