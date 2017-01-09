package com.codeup;

import java.util.List;

/**
 * Created by Austin on 1/5/17.
 */

public interface Posts {
//     get a list of all the posts
    List<Post> all();

    void insert(Post post);

    Post singlePost(int postId);

    void updatePost(Post post);

    void deletePost(int postId);
}
