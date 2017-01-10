package com.codeup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Austin on 1/5/17.
 */

public class DaoFactory {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = sessionFactory.openSession();

    private static Posts postDao;

    public static Posts getPostDao() {
        if  (postDao == null){
            postDao = new HibernatePostsDao(session);
        }
        return postDao;
    }

}
