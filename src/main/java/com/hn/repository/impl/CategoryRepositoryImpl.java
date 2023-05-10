/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hn.repository.impl;

import com.hn.pojo.Category;
import org.springframework.stereotype.Repository;
import com.hn.repository.CategoryRepository;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HUYNH NHU
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean SessionFactory;
    
    
    @Override
    public List<Category> getCategories() {
        Session s = this.SessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Category");
        
        return q.getResultList();
    }
   
}
