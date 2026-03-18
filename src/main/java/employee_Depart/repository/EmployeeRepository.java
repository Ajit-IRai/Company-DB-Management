package employee_Depart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import employee_Depart.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
 
	List<Employee> findByDepartDepartmentId(Integer departmentId);
	
	
}
