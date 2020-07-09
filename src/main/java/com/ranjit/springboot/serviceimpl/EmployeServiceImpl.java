package com.ranjit.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ranjit.springboot.bo.EmployeeBo;
import com.ranjit.springboot.repositoryimpl.EmployeeRepositoryImpl;
import com.ranjit.springboot.service.EmployeeService;
/**
 * This is a Service Implementation class to call repository layer.
 * @author Ranjit Kumar Patel
 * @since 09/07/2020 11:00PM
 */
@Service
public class EmployeServiceImpl implements EmployeeService{
	/*EmployeeRepositoryImpl Instance to call the corresponding repo method*/
	@Autowired
	EmployeeRepositoryImpl employeeRepository;
	
	

	public List<EmployeeBo> getAllEmployee() {
		/*Repository call*/		
		List<EmployeeBo> employeeList=employeeRepository.getAllEmployee();
		
		return employeeList;
	}

	public EmployeeBo getEmployeeById(String empId) {
		
		return null;
	}

	public EmployeeBo addNewEmployee(EmployeeBo empBo) {
		/*Repository call*/	
		EmployeeBo addEmployee=employeeRepository.addNewEmployee(empBo);
		
		return addEmployee;
	}

}
