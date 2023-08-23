package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public String displayBlog(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("blogs",blogService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String viewCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping ("/create")
    public String doCreate(@ModelAttribute Blog blog){
        blogService.write(blog);
        return "redirect:/blog";
    }
    @GetMapping("/update")
    public String viewUpdate(Model model , @RequestParam("id") String id){
        model.addAttribute("blog",blogService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Blog blog){
        blogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String viewDetail(Model model , @RequestParam("id") String id){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "detail";
    }
    @GetMapping("/delete")
    public String doDelete(Model model, @RequestParam("id") String id){
       blogService.delete(id);
       model.addAttribute("blogs",blogService.findAll());
       return "redirect:/blog";
    }

}
