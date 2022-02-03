package in.adsingh.springrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber, pageSize),HttpStatus.OK);
	}
	
	
	
	
	//localhost:8080/employees/4 <-- id for pathvariable
	@GetMapping("/employees/{id}")
	/*public String getEmployee(@PathVariable("id") Long id) {
		return "Fetching the employee details for id: " + id;
	}*/
	
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id),HttpStatus.OK);
	}
	
	
	
	
	//localhost:8080/employees?id=4 <-- id for requestparam
	@DeleteMapping("/employees")
	/*public String deleteEmployee(@RequestParam("id") Long id) {
		return "Deleteing the employee details for id: " + id;
	}*/
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	@PostMapping("/employees")
	/*public String saveEmployee(@RequestBody Employee employee) {
		return "saving the employee details in database " + employee;
	}*/
	
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(eService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name)	{
		return new ResponseEntity<List<Employee>>(eService.geEmployeesByName(name),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/employees/filterByNameAndDepartment")
	public ResponseEntity<List<Employee>> geEmployeesByNameAndDepartment(@RequestParam String name, @RequestParam String department)	{
		return new ResponseEntity<List<Employee>>(eService.geEmployeesByNameAndDepartment(name, department),HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/employees/filterByNameKeyword")
	public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name)	{
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name),HttpStatus.OK);
		
	}
	  

}
