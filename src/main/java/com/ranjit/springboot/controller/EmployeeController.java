package com.ranjit.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ranjit.springboot.bo.EmployeeBo;
import com.ranjit.springboot.serviceimpl.EmployeServiceImpl;
/**
 * This is a Controller class to handle the client request.
 * @author Ranjit Kumar Patel from bangalore.........
 * @since 09/07/2020 11:00PM
 */
@RestController
public class EmployeeController {
	
	/*EmployeeServiceImpl instance to call the service layer corresponding method*/
	@Autowired
	EmployeServiceImpl employeeService;
	
	@GetMapping(value="/getAllEmployee")	
	public List<EmployeeBo> reteriveAllEmployee(){	
		/*Calling service*/
		List<EmployeeBo> listEmployee=employeeService.getAllEmployee();		
		return listEmployee;
		
	}
	
	@PostMapping(value="addEmployee")
	public ResponseEntity<Object> addNewEmployee(@RequestBody EmployeeBo employeBo) {
		/*Calling Employee Service to add the new employee details*/
		employeeService.addNewEmployee(employeBo);
		return new ResponseEntity<Object>("added",HttpStatus.CREATED);
	}

}
