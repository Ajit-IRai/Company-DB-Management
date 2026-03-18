package employee_Depart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employee_Depart.dto.ResponseStructure;
import employee_Depart.entity.Department;
import employee_Depart.entity.Employee;
import employee_Depart.service.Company_service;

@RestController
public class CompanyController {

	@Autowired
	Company_service service;
	
	/*
	 * getAllEmployee
	 */
	@GetMapping("/employee")
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee(){
		return service.getAllEmployee(); 
	}
	
	/*
	 * save one record
	 */
	@PostMapping("/employee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee emp){
		return service.saveEmployee(emp); 
	}
	
	/*
	 * save one department
	 */
	@PostMapping("/department")
	public ResponseEntity<ResponseStructure<Department>> createDepartment(@RequestBody Department dept){
		return service.createDepartment(dept); 
	}  
	
	/*
	 * getAllDepartment
	 */
	@GetMapping("/department")
	public ResponseEntity<ResponseStructure<List<Department>>> getAllDepartment(){
		return service.getAllDepartment(); 
	}
	/*
	 * fetch record by Id
	 */
	@GetMapping("/department/{id}")
	public ResponseEntity<ResponseStructure<Optional<Department>>> getDeptById(@PathVariable Integer id){
		return service.getDeptById(id);
	}
	
	/*
	 * update a department
	 */
	@PostMapping("/api/department")
	public ResponseEntity<ResponseStructure<Department>> updateDepartment(@RequestBody Department dept){
		return service.updateDepartment(dept); 
	}
	
	/*
	 * delete department by id
	 */
	@DeleteMapping("/department/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteDepartment(@PathVariable Integer id){
		return service.deleteDepartment(id); 
	}
	
	/*
	 * fetching employee by id
	 */
	@GetMapping("/api/employee/{id}")
	public ResponseEntity<ResponseStructure<Optional<Employee>>> getEmployeeById(@PathVariable Integer id){
		return service.getEmployeeById(id);  
	}
	
	/*
	 * delete employee by id
	 */
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployee(@PathVariable Integer id){
		return service.deleteEmployee(id);
	}
	
	/*
	 * update an employee
	 */
	@PostMapping("/api/employee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee emp){
		return service.updateEmployee(emp);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByDept(@PathVariable Integer id){
		return service.getEmployeeByDept(id);
	}
}
