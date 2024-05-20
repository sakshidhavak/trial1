package com.session.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.session.spring.model.Employee;
import com.session.spring.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired(required = true)
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService es) {
		this.employeeService = es;
	}
	@RequestMapping("/list")
	public String list(Model model) {

		model.addAttribute("listEmployee", this.employeeService.listEmployee());
		return "empList";

	}
	@RequestMapping(value = "/processAddEmployee", method = RequestMethod.POST)
	public String processAddEmployee(@ModelAttribute("employee") Employee emp) {
	    if(emp.getId() == 0){
	        // new employee, add it
	        this.employeeService.addEmployee(emp);
	    } else {
	        // existing employee, call update
	        this.employeeService.updateEmployee(emp);
	    }
	    return "redirect:/employee/list"; 
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String newEmployee(Model model) {
	    model.addAttribute("employee", new Employee()); // Add an empty employee object to the model
	    return "add-Employee"; // Return the view name
	}
	
	@RequestMapping("/processAddEmployee")
	public String showEmployee(@ModelAttribute("employee") Employee emp) {

		
		if(emp.getId() == 0){
			//new employee, add it
			this.employeeService.addEmployee(emp);
		}else{
			//existing employee, call update
			this.employeeService.updateEmployee(emp);
		}

		return "redirect:/list";

	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeEmployee(@PathVariable("id") int id) {
		this.employeeService.removeEmployee(id);
		return "redirect:/employee/list";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model) {


		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		model.addAttribute("listEmployee", this.employeeService.listEmployee());
		return "edit";
	}
	
	@RequestMapping("/show")
	public String show() {

		return "show";

	}

}
