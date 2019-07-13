package com.lti.crm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.crm.model.Customer;
import com.lti.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/showForm")
	public ModelAndView showFormForAdd()
	{	ModelAndView mv=new ModelAndView ("customer-form");
		Customer  theCustomer = new Customer(); 
	mv.addObject("customer",theCustomer);
	
	return mv;
	}
		
	
@PostMapping("/saveCustomer")
public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
	customerService.saveCustomer(theCustomer);
	return "redirect:/customer/list";
}
@GetMapping("/list")
public String listCustomers(ModelMap theModel) {
	List<Customer> theCustomers= customerService.getCustomers();
	theModel.addAttribute("customers", theCustomers);
	return "list-customers";
}

//@GetMapping
}
