package com.ranjit.springboot.repositoryimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.ranjit.springboot.bo.EmployeeBo;
import com.ranjit.springboot.repository.EmplyeeRepository;

/**
 * This is a Repository Implementation to interact with the DB.
 * 
 * @author Ranjit Kumar Patel
 * @since 09/07/2020 11:00PM
 */
@Repository
public class EmployeeRepositoryImpl implements EmplyeeRepository {
	/* JDBC template Instance for JDBC Operation */
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplateObject;

	public NamedParameterJdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(NamedParameterJdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	/* Retrieve All Employee From DB */
	public List<EmployeeBo> getAllEmployee() {

		List<EmployeeBo> listEmployee = new ArrayList<EmployeeBo>();
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		String reteriveQuery = "select * from employee";
		SqlRowSet rs = jdbcTemplateObject.queryForRowSet(reteriveQuery, mapSql);
		while (rs.next()) {
			EmployeeBo employeeBo = new EmployeeBo();
			employeeBo.setId(rs.getString("ID"));
			employeeBo.setName(rs.getString("NAME"));
			employeeBo.setEmail(rs.getString("EMAIL"));
			employeeBo.setOrganization(rs.getString("ORGANIZATION"));
			employeeBo.setSalary(rs.getString("SALARY"));

			/* Adding fetched data to BO */
			listEmployee.add(employeeBo);
		}

		return listEmployee;
	}

	public EmployeeBo getEmployeeById(String empId) {
		// TODO Auto-generated method stub

		return null;
	}

	public EmployeeBo addNewEmployee(EmployeeBo empBo) {
		
		int isInserted = 0;
		MapSqlParameterSource mapSql = new MapSqlParameterSource();
		mapSql.addValue("ID", empBo.getId());
		mapSql.addValue("NAME", empBo.getName());
		mapSql.addValue("EMAIL", empBo.getEmail());
		mapSql.addValue("ORGANIZATION", empBo.getOrganization());
		mapSql.addValue("SALARY", empBo.getSalary());
		String addQuery = "insert into employee values(:ID,:NAME,:EMAIL,:ORGANIZATION,:SALARY)";

		isInserted = jdbcTemplateObject.update(addQuery, mapSql);
		if (isInserted > 0) {
			// here we can send do some other stuff.
		}
		return empBo;
	}

}
