package com.ranjit.springboot.service;

import java.util.List;

import com.ranjit.springboot.bo.EmployeeBo;

public interface EmployeeService {	
	public List<EmployeeBo> getAllEmployee();
	public EmployeeBo getEmployeeById(String empId);
	public EmployeeBo addNewEmployee(EmployeeBo empBo);
	
	

}
