package in.adsingh.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.adsingh.springrestapi.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
