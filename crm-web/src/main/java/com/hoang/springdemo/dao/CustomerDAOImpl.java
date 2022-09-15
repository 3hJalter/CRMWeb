package com.hoang.springdemo.dao;

import com.hoang.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCustomer(Customer customer) {
        // get current hibernate session
        Session session = sessionFactory.getCurrentSession();
        // save the customer
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, id);
        currentSession.delete(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query that get and sort customers by lastName
        Query<Customer> query =
                currentSession.createQuery("FROM Customer ORDER BY lastName", Customer.class);

        // return the results

        return query.getResultList();
    }

    @Override
    public Customer getCustomer(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // retrieve from database using primary key
        Customer customer = currentSession.get(Customer.class, id);
        return customer;
    }
}
