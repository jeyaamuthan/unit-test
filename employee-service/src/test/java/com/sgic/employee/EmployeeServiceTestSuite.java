package com.sgic.employee;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sgic.employee.tests.controller.EmployeeControllerTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	EmployeeControllerTest.class
})
public class EmployeeServiceTestSuite {

}
