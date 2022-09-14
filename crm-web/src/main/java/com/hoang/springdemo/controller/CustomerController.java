package com.hoang.springdemo.controller;

import com.hoang.springdemo.entity.Customer;
import com.hoang.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // inject the customerDAO
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model model) {
        // get customers from the service
        List<Customer> customers = customerService.getCustomers();

        // add the customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
