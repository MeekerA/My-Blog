package com.codeup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Austin on 1/5/17.
 */

@Controller
public class PostsController extends BaseController {

    @Autowired
    private Posts postDao;

    @GetMapping
    public String Homepage(){
        return "redirect:/posts";
    }

    @GetMapping("/posts")
        public String showAllPosts(Model model){
        List<Post> posts = new ArrayList((Collection) postDao.findAll());

        Collections.reverse(posts);
        model.addAttribute("currentUser", loggedInUser());
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String showCreatePost(Model model){
            model.addAttribute("post", new Post());
            return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(@Valid Post posting, Errors validation, Model model){

        if (validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("post", posting);
            return "posts/create";
        }
        posting.setUser(loggedInUser());
        postDao.save(posting);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String showSinglePost(Model model, @PathVariable long id ){
        model.addAttribute("post", postDao.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id){

        Post existingPost = postDao.findOne(id);

        if (existingPost.getUser().getId() != loggedInUser().getId()) {
            return "redirect:/posts";
        }

        model.addAttribute("post", postDao.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@Valid Post updatedPost, Errors validation, Model model, @PathVariable long id){

        Post existingPost = postDao.findOne(id);

        if (existingPost.getUser().getId() != loggedInUser().getId()) {
            return "redirect:/posts";
        }

        if (validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("post", updatedPost);
            return "posts/edit";
        }
        updatedPost.setUser(loggedInUser());
        postDao.save(updatedPost);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@ModelAttribute Post postToDelete, @PathVariable long id){

        Post existingPost = postDao.findOne(id);

        if (existingPost.getUser().getId() != loggedInUser().getId()) {
            return "redirect:/posts";
        }

        postDao.delete(postToDelete);
        return "redirect:/posts";
    }

}
