package in.adsingh.springrestapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.*;
import java.security.cert.PKIXRevocationChecker.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.adsingh.springrestapi.model.Employee;
import in.adsingh.springrestapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	/*private static List<Employee> list = new ArrayList<>();
	
	static {
		Employee e = new Employee();

			e.setName("AD");
			e.setAge(21L);
			e.setDepartment("IT");
			e.setEmail("ad@gmail.com");
			e.setLocation("India");
			list.add(e);
			
			
			e = new Employee();
			e.setName("Mukul");
			e.setAge(20L);
			e.setDepartment("CSE");
			e.setEmail("mukul@gmail.com");
			e.setLocation("Pakistan");
			list.add(e);
			

	}
	
	
	
	
	@Override
	public List<Employee> getEmployees() {
		
		return list;
	}*/
	
	@Autowired
	private EmployeeRepository eRepository;
	
	@Override
	public List<Employee> getEmployees() {
		
		return eRepository.findAll();
	}
	
	

	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}



	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee = eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for id: "+id);
	}



	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
		
	}



	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}

}
