/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.repository.impl;

import com.hn.pojo.User;
import com.hn.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HUYNH NHU
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public User getUserByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        q.where(b.equal(root.get("username"), username));

        Query query = session.createQuery(q);
        return (User) query.getSingleResult();
    }

    @Override
    public boolean registerUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.save(user);
        return true;
//        try {
//            session.save(user);
//            return true;
//        } catch(HibernateException ex){
//            System.err.println(ex.getMessage());          
//        }
//        return false;
    }

    @Override
    public boolean addUser(User user) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        session.save(user);
        return true;
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(User.class, id);
    }

}
