package com.codeup;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Austin on 1/6/17.
 */
public class HibernatePostsDao implements Posts  {

    private Session session;

    public HibernatePostsDao(Session session) {
        this.session = session;
    }

    @Override
    public List<Post> all() {
        return session.createQuery("from Post").list();
    }

    @Override
    public void insert(Post post) {
        Transaction tx = session.beginTransaction();
        session.save(post);
        tx.commit();
    }

}
