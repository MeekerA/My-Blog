package com.codeup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Austin on 1/5/17.
 */

public class ListPosts implements Posts {

    private List<Post> posts;

    public ListPosts() {
        posts = new ArrayList<>();
    }

    @Override
    public List<Post> all() {
        return posts;
    }

    @Override
    public void insert(Post post) {
        post.setId(posts.size()+ 1);
        posts.add(post);
    }

}
