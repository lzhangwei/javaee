package com.tw.core.dao;

import com.tw.core.entity.User;
import com.tw.core.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by weizhang on 7/8/15.
 */
@Repository
public class UserDao {

    public List<User> getUsers() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from users").addEntity(User.class);
        List<User> users = query.list();

        session.close();

        return users;
    }

    public void addUser(User user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();

        session.close();

    }

    public void deleteUser(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();
        user.setId(id);

        session.delete(user);

        session.getTransaction().commit();

        session.close();

    }

    public void updateUser(User user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.update(user);

        session.getTransaction().commit();

        session.close();

    }

    public User getUserById(int userId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from users WHERE id = " + userId).addEntity(User.class);
        List<User> users = query.list();

        session.close();

        return users.get(0);
    }

    public boolean login(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from users WHERE name = '" + name +"' and password = '" + password + "'").addEntity(User.class);
        List<User> users = query.list();

        session.close();

        return users.size() > 0 ? true : false;
    }
}
