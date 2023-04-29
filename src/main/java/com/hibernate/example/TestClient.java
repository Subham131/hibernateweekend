package com.hibernate.example;

import com.hibernate.example.dao.EmployeeDao;
import com.hibernate.example.domain.Employee;

public class TestClient {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		Employee employee = new Employee();
		employee.setAge(11);
		employee.setEmpId(5);
		employee.setEmployeeName("xyz");
		
		String createEmployee = employeeDao.createEmployee(employee);
		
		System.out.println(createEmployee);
	}
}
