package in.adsingh.springrestapi.service;

import java.util.List;

import in.adsingh.springrestapi.model.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployees(int pageNumber, int pageSize);
	
	Employee saveEmployee (Employee employee);
	
	Employee getSingleEmployee (Long id);
	
	void deleteEmployee (Long id);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> geEmployeesByName(String name);
	
	List<Employee> geEmployeesByNameAndDepartment(String name, String department);
	
	List<Employee> getEmployeesByKeyword(String name);
	



}
