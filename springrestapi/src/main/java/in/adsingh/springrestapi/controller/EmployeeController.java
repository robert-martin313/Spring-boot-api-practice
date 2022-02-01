package in.adsingh.springrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.adsingh.springrestapi.model.Employee;
import in.adsingh.springrestapi.service.EmployeeService;

//@Controller
@RestController //@Caontroller + @ResponseBody
//@RequestMapping("/api/v1") //now everything will go to lh8080/api/v1/employees
public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	
	
	/*@Value("${app.name: Employee Tracker}")
	private String appName;
	
	@Value("${app.version: 1.0}")
	private String appVersion;*/
	
	/*@GetMapping("/version")
	public String getAppDetails() {
		return appName + " - " + appVersion;
	}*/
	
	/*
	//@RequestMapping(value="/employees", method = RequestMethod.GET)
	@GetMapping("/employees") //alternate of @RequestMapping for GET method
	//@ResponseBody
	public String getEmployees() {
		return "Displaying the list of employees";
	}*/
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return eService.getEmployees();
	}
	
	
	
	
	//localhost:8080/employees/4 <-- id for pathvariable
	@GetMapping("/employees/{id}")
	/*public String getEmployee(@PathVariable("id") Long id) {
		return "Fetching the employee details for id: " + id;
	}*/
	
	public Employee getEmployee(@PathVariable("id") Long id) {
		return eService.getSingleEmployee(id);
	}
	
	
	
	
	//localhost:8080/employees?id=4 <-- id for requestparam
	@DeleteMapping("/employees")
	/*public String deleteEmployee(@RequestParam("id") Long id) {
		return "Deleteing the employee details for id: " + id;
	}*/
	public void deleteEmployee(@RequestParam("id") Long id) {
		eService.deleteEmployee(id);
	}
	
	
	
	
	
	@PostMapping("/employees")
	/*public String saveEmployee(@RequestBody Employee employee) {
		return "saving the employee details in database " + employee;
	}*/
	
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return eService.saveEmployee(employee);
	}
	
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return eService.updateEmployee(employee);
		
	}
	
	
	  

}
