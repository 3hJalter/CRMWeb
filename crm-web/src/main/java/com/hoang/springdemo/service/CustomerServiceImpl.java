package com.hoang.springdemo.service;

import com.hoang.springdemo.dao.CustomerDAO;
import com.hoang.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    @Override
    public List<Customer> getCustomers(){
        return customerDAO.getCustomers();
    }

}
