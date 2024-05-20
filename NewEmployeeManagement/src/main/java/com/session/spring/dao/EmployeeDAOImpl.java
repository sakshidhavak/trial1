package com.session.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.session.spring.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	

	private SessionFactory sessionFactory;
	

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(emp);
		System.out.println("Employee saved successfully, Employee Details="+emp);

	}

	
	

	@Override
	public void updateEmployee(Employee emp) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(emp);
		System.out.println("Employee updated successfully, Employee Details="+emp);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployee() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		for(Employee emp : empList){
			System.out.println("Employee List::"+emp);

		}
		return empList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		System.out.println("Employee loaded successfully, Employee details="+emp);

		return emp;
	}

	@Override
	public void removeEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Integer(id));
		if(null != emp){
			session.delete(emp);
		}
		System.out.println("Employee deleted successfully, Employee details="+emp);

	}

}

