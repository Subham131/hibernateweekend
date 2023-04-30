package com.hibernate.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.example.domain.Employee;
import com.hibernate.example.util.HibernateUtil;

public class EmployeeDao {
//try with resources
	public String createEmployee(Employee employee) {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Integer pkId = (Integer) session.save(employee);
			tx.commit();
			System.out.println(pkId);
			return "success";
		} catch (Exception e) {
			System.out.println("inside catch block");
			throw new RuntimeException(e);
		}
	}

	public Employee retrieveEmployeeById(Integer id) {
		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Employee employee = session.load(Employee.class, id);
			tx.commit();
			return employee;
		} catch (Exception e) {
			System.out.println("inside catch block");
			throw new RuntimeException(e);
		}
	}
}
