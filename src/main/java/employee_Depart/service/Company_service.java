package employee_Depart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import employee_Depart.dao.Company_dao;
import employee_Depart.dto.ResponseStructure;
import employee_Depart.entity.Department;
import employee_Depart.entity.Employee;
import employee_Depart.exception.IdNotFoundException;
import employee_Depart.exception.NoRecordFoundException;
import employee_Depart.repository.DepartmentRepository;
import employee_Depart.repository.EmployeeRepository;


@Service
public class Company_service {

	@Autowired
	Company_dao companydao;
	
	@Autowired
	DepartmentRepository department;
	
	@Autowired
	EmployeeRepository employee;
	
	
	/*
	 * getAllEmployee
	 */
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployee(){
		List<Employee> e=companydao.getAllEmployee();
		
		ResponseStructure<List<Employee>> response=new ResponseStructure<List<Employee>>();
		
		if(!e.isEmpty()) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("All the records are retrieved");
			response.setData(e);
			return new ResponseEntity<ResponseStructure<List<Employee>>>(response,HttpStatus.FOUND);
		}
		else
			throw new NoRecordFoundException("There is no record in DB");
	}
	
	/*
	 * save employee.
	 */
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee emp){
		ResponseStructure<Employee> res=new ResponseStructure<Employee>();
		res.setStatusCode(HttpStatus.CREATED.value());
		res.setMessage("The Employee is stored in DB");
		res.setData(companydao.saveEmployee(emp));         
		return new ResponseEntity<ResponseStructure<Employee>>(res,HttpStatus.CREATED);
	}
	
	/*
	 * getAllDepartment
	 */
	public ResponseEntity<ResponseStructure<Department>> createDepartment(Department dept){
		ResponseStructure<Department> res=new ResponseStructure<Department>();
		res.setStatusCode(HttpStatus.CREATED.value());
		res.setMessage("The Department is stored in DB");
		res.setData(companydao.createDepartment(dept));         
		return new ResponseEntity<ResponseStructure<Department>>(res,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Department>>> getAllDepartment(){
		List<Department> e=companydao.getAllDepartment();
		
		ResponseStructure<List<Department>> response=new ResponseStructure<List<Department>>();
		
		if(!e.isEmpty()) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("All the records are retrieved");
			response.setData(e);
			return new ResponseEntity<ResponseStructure<List<Department>>>(response,HttpStatus.FOUND);
		}
		else
			throw new NoRecordFoundException("There is no record in DB");
	}
	
	/*
	 * GetDepartmentById
	 */
	public ResponseEntity<ResponseStructure<Optional<Department>>> getDeptById(Integer id){
		Optional<Department> opt=companydao.getDeptById(id);
		
		ResponseStructure<Optional<Department>> response=new ResponseStructure<Optional<Department>>();
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage(" The department records are reterived successfully");
			response.setData(opt);
			return new ResponseEntity<ResponseStructure<Optional<Department>>>(response,HttpStatus.FOUND);
		}
		else
			throw new NoRecordFoundException("The Department is not present in the DB by this:"+id);
	}
	
	/*
	 * updating a department
	 */
	public ResponseEntity<ResponseStructure<Department>> updateDepartment(Department dept){
		if(dept.getDepartmentId()==null) {
			throw new IdNotFoundException("Id must be passed to update the record");
		}
		Optional<Department> opt=department.findById(dept.getDepartmentId());
		ResponseStructure<Department> response = new ResponseStructure<Department>();
		
		if(opt.isPresent()) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("Department record with id "+dept.getDepartmentId()+" is updated");
			response.setData(companydao.updateDepartment(dept));
			return new ResponseEntity<ResponseStructure<Department>>(response,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException("Department record with id "+dept.getDepartmentId()+" is not there");
	}
	
	/*
	 * delete a department
	 */
	public ResponseEntity<ResponseStructure<String>> deleteDepartment(Integer id){
		Optional<Department> opt=department.findById(id);
		ResponseStructure<String> response=new ResponseStructure<String>();
		  
		if(opt.isPresent()) {
			department.delete(opt.get());
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("The record is deleted successfully by id ="+id);
			response.setData("i");
			return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException("The id is not exist in the DB");
	}
	
	/*
	 * fetching a employee by id
	 */
	public ResponseEntity<ResponseStructure<Optional<Employee>>> getEmployeeById(Integer id){
		Optional<Employee> opt=companydao.getEmployeeById(id);
		
		ResponseStructure<Optional<Employee>> response=new ResponseStructure<Optional<Employee>>();
		if(!opt.isEmpty()) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage(" The Employee records are reterived successfully");
			response.setData(opt);
			return new ResponseEntity<ResponseStructure<Optional<Employee>>>(response,HttpStatus.FOUND);
		}
		else
			throw new NoRecordFoundException("The Employee is not present in the DB by this:"+id);
	}
	
	/*
	 * delete employee by id
	 */
	public ResponseEntity<ResponseStructure<String>> deleteEmployee(Integer id){
		Optional<Employee> opt=employee.findById(id);
		ResponseStructure<String> response=new ResponseStructure<String>();
		  
		if(opt.isPresent()) {
			employee.delete(opt.get());
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("The record is deleted successfully by id ="+id);
			response.setData("i");
			return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException("The id is not exist in the DB");
	} 
	
	/*
	 * update an employee
	 */
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee emp){
		
		if(emp.getEmployeeId()==null) {
			throw new IdNotFoundException("Id must be passed to update the record");
		}
		Optional<Employee> opt=employee.findById(emp.getEmployeeId());
		ResponseStructure<Employee> response = new ResponseStructure<Employee>();
		
		if(opt.isPresent()) {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMessage("Department record with id "+emp.getEmployeeId()+" is updated");
			response.setData(companydao.updateEmployee(emp));
			return new ResponseEntity<ResponseStructure<Employee>>(response,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException("Employee record with id "+emp.getEmployeeId()+" is not there");
		
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> getEmployeeByDept(Integer departmentId){
		
		List<Employee> emp=employee.findByDepartDepartmentId(departmentId);
		
		ResponseStructure<List<Employee>> response=new ResponseStructure<List<Employee>>();
		
		if(!emp.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Employee with department id "+departmentId+" is fetched successfully");
			response.setData(companydao.getEmployeeByDept(departmentId));
			return new ResponseEntity<ResponseStructure<List<Employee>>>(response,HttpStatus.OK);
			
		}
		else
			throw new NoRecordFoundException("The record is not present in DB");
	}
	
}
