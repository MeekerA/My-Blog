package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Austin on 1/5/17.
 */
@Controller
@RequestMapping("/posts")
public class PostsController {

    @GetMapping
        public String showPosts(Model model){
        List posts = new ArrayList(DaoFactory.getPostDao().all());
        Collections.reverse(posts);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/create")
    public String showCreatePost(Model model){
            model.addAttribute("post", new Post());
            return "posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post posting){

        DaoFactory.getPostDao().insert(posting);
        return "redirect:/posts";
    }

}
