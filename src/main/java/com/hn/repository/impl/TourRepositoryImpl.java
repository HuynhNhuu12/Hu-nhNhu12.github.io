/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.repository.impl;

import com.hn.pojo.Booking;
import com.hn.pojo.Comments;
import com.hn.pojo.Tour;
import com.hn.repository.TourRepository;
import com.hn.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HUYNH NHU
 */
@Repository
@PropertySource("classpath:databases.properties")
@Transactional
public class TourRepositoryImpl implements TourRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Tour> getTours(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Tour> q = b.createQuery(Tour.class);
        Root root = q.from(Tour.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }

//            String fp = params.get("fromPrice");
//            if (fp != null) {
//                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Long.class), Long.parseLong(fp));
//
//                predicates.add(p);
//            }
//
//            String tp = params.get("toPrice");
//            if (tp != null) {
//                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Long.class), Long.parseLong(tp));
//
//                predicates.add(p);
//            }
//
//            String cateId = params.get("cateId");
//            if (cateId != null) {
//                Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
//                predicates.add(p);
//            }
            q.where(predicates.toArray(new Predicate[]{}));
            q.orderBy(b.desc(root.get("id")), b.desc(root.get("name")));

        }
        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.zize").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

    @Override
    public int countTour() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Tour");
        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addTour(Tour t) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(t);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTour(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            Tour t = session.get(Tour.class, id);
            session.delete(t);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Tour getTourById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Tour.class, id);
    }

    @Override
    public List<Comments> getComments(int tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Comments WHERE tourId.id =:tourId");
        q.setParameter("tourId", tourId);
        return q.getResultList();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Comments> q = b.createQuery(Comments.class);
//        Root root = q.from(Comments.class);
//        q.select(root);
//        
//        q.where(b.equal(root.get("productId"), tourId));
//        
//        Query query = session.createQuery(q);
//        return query.getResultList();
    }

    @Override
    public Comments addComment(String content, int tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Comments c = new Comments();
        c.setContent(content);
        c.setTourId(this.getTourById(tourId));

        Authentication authentication
                = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        c.setUserId(this.userRepository.getUserByUsername(currentPrincipalName));

        session.save(c);

        return c;
    }

    @Override
    public boolean addBooking(Booking book) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(book);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
}
