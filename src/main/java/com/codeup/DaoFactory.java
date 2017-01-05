package com.codeup;

/**
 * Created by Austin on 1/5/17.
 */

public class DaoFactory {
    private static Posts postDao;

    public static Posts getPostDao() {
        if  (postDao == null){
            postDao = new ListPosts();
        }
        return postDao;
    }

}
