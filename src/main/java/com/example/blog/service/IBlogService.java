package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    void write(Blog blog);
    List<Blog> findAll();
    void update(Blog blog);
    void delete(String id);
    Blog findById(String id);
}
