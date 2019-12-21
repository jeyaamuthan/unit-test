package com.sgic.employee.tests.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sgic.employee.EmployeeBaseTest;
import com.sgic.employee.server.dto.EmployeeDto;;
public class EmployeeControllerTest extends EmployeeBaseTest{
	 @Autowired
	  private JdbcTemplate jdbcTemplate;
	 
	 protected HttpHeaders httpHeaders = new HttpHeaders();
	
	 @Autowired
	  protected TestRestTemplate testRestTemplate;
	 private EmployeeDto employeeDto = new EmployeeDto();
	 
	 	@Value("http://${server.host}:${server.port}")
	    private  String employeeBaseUrl;

	  @Before
	  public void setUp() {
		  jdbcTemplate.execute("INSERT INTO employee-service.employee(id,email,firstName,lastName)VALUES(1,sjamuthan@gmail.com)");
		  
	  }

	  @Test
	  public void testCreateEmployee() throws IOException {
		  employeeDto.setEmail("harry@gmail.com");
		  employeeDto.setFirstName("Suja");
		  employeeDto.setLastName("Sukumar");
	  
	    HttpEntity<EmployeeDto> request = new HttpEntity<EmployeeDto>(employeeDto, httpHeaders);
	    ResponseEntity<String> response =
	        testRestTemplate.postForEntity(employeeBaseUrl + "/employee", request, String.class);
	    assertThat(response.getStatusCode(), is(HttpStatus.OK));
	    assertThat(response.getBody(), is(EmployeeConstants.CREATE_SUCCESS_STATUS));
	  }

	  @Test
	  public void GetAllEmployeeTest() throws IOException {
		 
	    
	    ResponseEntity<String> response =
	        testRestTemplate.getForEntity(employeeBaseUrl + "/employee", String.class);
	    assertThat(response.getStatusCode(), is(HttpStatus.OK));
	    assertThat(response.getBody(), is(EmployeeConstants.GET_SUCCESS_STATUS));
	  }

	  @After
	  public void tearDown() {
	    
	  }

	  private final class EmployeeConstants {
	    private EmployeeConstants() {}

	    private static final String CREATE_SUCCESS_STATUS = "{\"status\":\"OK\",\"statusCode\":20000,\"message\":\"Employee Created successfully!!!\"}";
	    private static final String GET_SUCCESS_STATUS = "{\"status\":\"OK\",\"statusCode\":20000,\"message\":null,\"results\":{\"listAllEmployee\":[]}}";
	  }


}
