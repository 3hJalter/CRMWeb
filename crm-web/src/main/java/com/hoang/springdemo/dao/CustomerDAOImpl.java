package com.hoang.springdemo.dao;

import com.hoang.springdemo.entity.Customer;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> query =
                currentSession.createQuery("from Customer", Customer.class);

        // execute the query and get results
        List<Customer> customers = query.getResultList();

        // return the results

        return customers;
    }
}
