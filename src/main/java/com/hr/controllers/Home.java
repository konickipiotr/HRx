package com.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hr.db.EmployeeDAO;
import com.hr.model.Employee;

@Controller
public class Home {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/show")
	public String show(Model model) {
		List<Employee> emp_list = employeeDAO.findAll();
		model.addAttribute("emp", emp_list);
		return "show";
	}
	
	@GetMapping("/fill")
	public String fill() {
		return "fill";
	}
}
