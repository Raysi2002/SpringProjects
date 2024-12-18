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
    private CategoryRepository categoryRepository;

    @Autowired
    private PostRepository postRepository;


    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
    public void savePost(Post post) {
        Category category;
        if (post.getCategory().getCatId() == null) {
            // Category is new, persist it first
            category = post.getCategory();
            categoryRepository.save(category);
        } else {
            // Try to find the existing category
            category = categoryRepository.findById(post.getCategory().getCatId())
                    .orElse(null);
            if (category == null) {
                // Category not found, create a new one
                category = post.getCategory();
                categoryRepository.save(category);
            }
        }
        post.setCategory(category);
        postRepository.save(post);
    }
}
