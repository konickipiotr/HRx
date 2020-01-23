package com.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hr.db.EmployeeDAO;
import com.hr.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@PostMapping("/addemployee")
	public String addemployee(Employee emp) {
		employeeDAO.save(emp);
		return "redirect:/show";
	}
	
	@GetMapping("/employeeedit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Employee emp = employeeDAO.findById(id).orElse(null);
		
		if(emp == null) {
			return "redirect:/show";
		}
		
		model.addAttribute("emp", emp);
		return "edit";
	}
	
	@PostMapping("/modif")
	public String modif(Employee emp) {
		employeeDAO.save(emp);
		return "redirect:/show";
	}
	
	@GetMapping("/employeeremove/{id}")
	public String remove(@PathVariable("id") Long id){
		employeeDAO.deleteById(id);
		return "redirect:/show";
	}
	
	@GetMapping("/statistic")
	public String statistic(Model model) {
		List<Employee> emp_list = employeeDAO.findAll();
		int empNum = emp_list.size();
		
		int sum = 0;
		
		for(Employee e : emp_list) {
			sum+=e.getSalary();
		}
		
		int average;
		if(empNum == 0) {
			average = 0;
		}else {
			average = sum / empNum;
		}
		
		int foryear = sum * 12;
		
		model.addAttribute("empNum", empNum);
		model.addAttribute("sum",sum );
		model.addAttribute("average", average);
		model.addAttribute("foryear", foryear);
		return "statistic";
	}
}
