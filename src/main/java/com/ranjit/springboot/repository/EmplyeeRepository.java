package com.ranjit.springboot.repository;

import java.util.List;

import com.ranjit.springboot.bo.EmployeeBo;

public interface EmplyeeRepository {
	
	public List<EmployeeBo> getAllEmployee();
	public EmployeeBo getEmployeeById(String empId);
	public EmployeeBo addNewEmployee(EmployeeBo empBo);
	
	

}
