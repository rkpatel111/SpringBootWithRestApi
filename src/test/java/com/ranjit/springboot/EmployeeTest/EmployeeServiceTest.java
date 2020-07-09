package com.ranjit.springboot.EmployeeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ranjit.springboot.AbstractTest.AbstractTest;
import com.ranjit.springboot.bo.EmployeeBo;

public class EmployeeServiceTest extends AbstractTest{
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	@Test
	   public void getAllEmployee() throws Exception {
	      String uri = "/getAllEmployee";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      EmployeeBo[] employeelist = super.mapFromJson(content, EmployeeBo[].class);
	      assertTrue(employeelist.length > 0);
	   }
	
	@Test
	   public void addEmployee() throws Exception {
	      String uri = "/addEmployee";
	      EmployeeBo employeeObj = new EmployeeBo();
	      employeeObj.setId("109");
	      employeeObj.setName("jack");
	      employeeObj.setEmail("jack.rk@hotmail.com");
	      employeeObj.setOrganization("TCS");
	      employeeObj.setSalary("20000");
	      String inputJson = super.mapToJson(employeeObj);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(201, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "added");
	   }

}
