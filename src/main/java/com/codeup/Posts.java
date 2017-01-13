package com.codeup;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Austin on 1/5/17.
 */

public interface Posts extends CrudRepository<Post, Long> {



//    //     get a list of all the posts
//    List<Post> all();
//
//    void insert(Post post);
//
//    Post singlePost(int postId);
//
//    void updatePost(Post post);
//
//    void deletePost(int postId);
}
