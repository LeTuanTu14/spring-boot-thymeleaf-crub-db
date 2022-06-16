package com.example.demothymeleafcrubdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demothymeleafcrubdb.entity.Employee;
import com.example.demothymeleafcrubdb.service.EmployeeService;


@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService= theEmployeeService;
	}
	
	@GetMapping("/")
	public String getEmployees(Model model) {
		model.addAttribute("employees", employeeService.getEmployees());
		return "employee/employees";
	}
	
	@GetMapping("/showForm")
	public String showFormEmployees(Model model) {
		Employee em= new Employee();
		model.addAttribute("employee", em);
		return "employee/form";
	}
	
	@GetMapping("/update")
	public String showFormUpdateEmployees(@RequestParam("id") int id,Model model) {
		Employee em= employeeService.getEmployee(id);
		model.addAttribute("employee", em);
		return "employee/form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.saveEmployee(theEmployee);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
}
