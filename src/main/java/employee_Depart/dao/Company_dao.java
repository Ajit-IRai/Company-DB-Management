package employee_Depart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import employee_Depart.entity.Employee;
import employee_Depart.entity.Department;
import employee_Depart.repository.DepartmentRepository;
import employee_Depart.repository.EmployeeRepository;

@Repository
public class Company_dao {

	@Autowired
	EmployeeRepository employee;
	
	@Autowired
	DepartmentRepository department;
	
	public List<Employee> getAllEmployee(){
		return employee.findAll(); 
	}
	
	public Employee saveEmployee(Employee emp ) {
		return employee.save(emp); 
	}
	
	public Department createDepartment(Department dept) {
		return department.save(dept); 
	}
	
	public List<Department> getAllDepartment(){
		return department.findAll();
	}
	
	public Optional<Department> getDeptById(Integer id) {
		return department.findById(id);  
	}
	
	public Department updateDepartment(Department dept) {
		return department.save(dept);
	}
	
	public String deleteDepartment(Integer id) {
		return "the Department deleted by this "+id;
	}
	
	public Optional<Employee> getEmployeeById(Integer id) {
		return employee.findById(id);  
	}
	
	public String deletEmployee(Integer id) {
		return "The Employee is deleted by this "+id;
	}
	
	public Employee updateEmployee(Employee emp) {
		return employee.save(emp);
	}
	
	public List<Employee> getEmployeeByDept(Integer departmentId){
		return employee.findByDepartDepartmentId(departmentId);
	}
}
