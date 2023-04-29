package com.hibernate.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.example.domain.Employee;

public class EmployeeDao {

	public String createEmployee(Employee employee) {

		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			configuration = new Configuration();
			configuration.configure();// hibernate configuration file
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Integer pkId = (Integer) session.save(employee);
			tx.commit();
			System.out.println(pkId);
			return "success";
		} catch (Exception e) {
			System.out.println("inside catch block");
			throw new RuntimeException(e);
		} finally {
			if (sessionFactory != null) {
				sessionFactory.close();
			}
			if (session != null) {
				session.close();
			}
		}
	}
}
