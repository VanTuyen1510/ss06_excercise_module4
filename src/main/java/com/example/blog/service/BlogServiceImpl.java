package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public void write(Blog blog) {
        repository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Blog findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
