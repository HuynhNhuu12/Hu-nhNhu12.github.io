/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.repository.impl;

import com.hn.pojo.Booking;
import com.hn.pojo.BookingDetail;
import com.hn.pojo.Category;
import com.hn.pojo.Tour;
import com.hn.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean SessionFactory;

    @Override
    public List<Object[]> cateStats() {
        Session s = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootT = q.from(Tour.class);
        Root rootC = q.from(Category.class);

        q.where(b.equal(rootT.get("categoryId"), rootC.get("id")));

        q.multiselect(rootC.get("id"), rootC.get("name"),
                b.count(rootT.get("id")));

        q.groupBy(rootC.get("id"));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> productStats(String kw, Date fromDate, Date toDate) {
        Session s = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootT = q.from(Tour.class);
        Root rootB = q.from(Booking.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rootB.get("tourId"), rootT.get("id")));

        q.multiselect(rootT.get("id"), rootT.get("name"),
                b.sum(b.sum(b.prod(rootB.get("numAdult"), rootT.get("priceAdult")),
                        b.prod(rootB.get("numChild"), rootT.get("priceChild"))), b.prod(rootB.get("numChild"), rootT.get("priceChild"))));

        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(rootT.get("name"), String.format("%%%s%%", kw)));
        }

        if (fromDate != null) {
            predicates.add(b.greaterThanOrEqualTo(rootB.get("createdDate"), fromDate));
        }

        if (toDate != null) {
            predicates.add(b.lessThanOrEqualTo(rootB.get("createdDate"), toDate));
        }

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rootT.get("id"));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> productMonthStats(String kw, Date fromDate, Date toDate) {
        Session s = this.SessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootT = q.from(Tour.class);
        Root rootB = q.from(Booking.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rootB.get("tourId"), rootT.get("id")));

        q.multiselect(b.function("MONTH", Integer.class, rootB.get("createdDate")),
                b.function("YEAR", Integer.class, rootB.get("createdDate")),
                b.sum(b.sum(b.prod(rootB.get("numAdult"), rootT.get("priceAdult")),
                        b.prod(rootB.get("numChild"), rootT.get("priceChild"))), b.prod(rootB.get("numChild"), rootT.get("priceChild"))));

        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(rootT.get("name"), String.format("%%%s%%", kw)));
        }

        if (fromDate != null) {
            predicates.add(b.greaterThanOrEqualTo(rootB.get("createdDate"), fromDate));
        }

        if (toDate != null) {
            predicates.add(b.lessThanOrEqualTo(rootB.get("createdDate"), toDate));
        }

        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(b.function("MONTH", Integer.class, rootB.get("createdDate")),
                b.function("YEAR", Integer.class, rootB.get("createdDate")));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

}
