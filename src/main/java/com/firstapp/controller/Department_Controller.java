package com.firstapp.controller;

import com.firstapp.model.Department;
import com.firstapp.service.DepartmentService;

import jakarta.servlet.http.HttpServletRequest;

// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String psswd = request.getParameter("psswd");
	
	String emailRegex = "^\\w+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
	String phoneRegex = "^[6-9]{1}[0-9]{9}$";
	String psswdRegex = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
	
	Pattern p = Pattern.compile(emailRegex);
	Matcher m = p.matcher(email);
	boolean valid = true;
	if(!m.matches()) {
		valid = false;
		request.setAttribute("isValid", "This email is invalid");
	}
	
	p = Pattern.compile(phoneRegex);
	m = p.matcher(phone);
	if(!m.matches()) {
		valid = false;
		request.setAttribute("isValid", "This phone number is invalid");
	}
	p = Pattern.compile(psswdRegex);
	m = p.matcher(psswd);
	if(!m.matches()) {
		valid = false;
		request.setAttribute("isValid", "This password is invalid");
	}
	
	if(valid) {
		request.setAttribute("isValid", "Login Successful");
	}
	
	RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
	rd.forward(request, response);
}
*/

@Controller
public class Department_Controller {
	@Autowired
	private DepartmentService service;

	@GetMapping("/")
	public String index() {
		return "home";
	}

	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}

	@GetMapping("/records")
	public String records(HttpServletRequest request) {
		request.setAttribute("data", service.getAllDepartment());
		return "records";
	}
	/*
	 * Model file contains class which is the representation of a table. The class contains attributes and we also need to create 
	 * getters and setters for getting value to the table
	 * */
	@GetMapping("/welcome")
	public String welcome(String remarks, String department, HttpServletRequest request){
		// String emailRegex = "^\\w+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
		// String passwdRegex = "^(?=.{8,})((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])|(?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W_])|(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_])).*$";
		// Pattern p = Pattern.compile(emailRegex);
		// Matcher m = p.matcher(department);
		// if(!m.matches()) {
		// 	System.out.println("Error Occurred: Invalid Email");
		// 	return "feedback";
		// }
		// p = Pattern.compile(passwdRegex);
		// m = p.matcher(remarks);
		// if(!m.matches()) {
		// 	System.out.println("Error Occurred: Invalid Password");
		// 	return "feedback";
		// }
		Department d = new Department();
		d.dept = department;
		d.remk = remarks;
		if(service.saveDept(d)) {
			request.setAttribute("data", service.getAllDepartment());
			return "records";
		}
		else {
			return "error";
		}
	}

	@GetMapping("/deleteID")
	public String deptRemove(long id, HttpServletRequest request){
		if(service.deleteDept(id)){
			request.setAttribute("data", service.getAllDepartment());
			return "records";
		}
		else
			return "error";
	}
	
	@GetMapping("/editId")
	public String deptEdit(long id, HttpServletRequest request){
		Department d = service.findById(id);
		request.setAttribute("oldData", d);
		return "editFeedback";
	}

	@GetMapping("/edit")
	public String updateDepartment(long id, String remarks, String department, HttpServletRequest request) {
		Department d = service.findById(id);
		d.dept = department;
		d.remk = remarks;
		service.saveDept(d);
		request.setAttribute("data", service.getAllDepartment());
		return "records";
	}
	
//	@GetMapping("/departments/{id}")
//	public Department getDepartmentById(@PathVariable("id") Long id) {
//		return service.getDepartmentById(id);
//	}
//	
//	@PostMapping("/department")
//	public Department saveDepartment(@RequestBody Department department) {
//		return service.saveDepartment(department);
//	}
}
