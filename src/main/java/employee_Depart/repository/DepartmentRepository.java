package employee_Depart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employee_Depart.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	
}
