package in.adsingh.springrestapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.adsingh.springrestapi.model.Employee;


@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	//Select * from tbl_employee where name="";
	List<Employee> findByName(String name);
	
	//Select * from tbl_employee where name="" and department="";
	List<Employee> findByNameAndDepartment(String name, String department);
	
	//Select * from tbl_employee where name like "";
	List<Employee> findByNameContaining(String keyword, Sort sort);

	

}
