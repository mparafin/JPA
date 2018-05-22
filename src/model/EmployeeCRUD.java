package model;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeCRUD {
	private EntityManagerFactory entityManagerFactory;
	
	EmployeeCRUD() {
		entityManagerFactory = Persistence.createEntityManagerFactory("SecondJPA");
	}
	
	public void createEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void readEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee =	entityManager.find(Employee.class,new BigDecimal(id));
		System.out.println(
				"ID: " + employee.getEmployeeId().toString() + "\n" +
				"First name: " + employee.getFirstName() + "\n" +
				"Last name: " + employee.getLastName() + "\n" +
				"E-mail: " + employee.getEmail() + "\n" +
				"Phone number: " + employee.getPhoneNumber() + "\n" +
				"Hire date: " + employee.getHireDate().toString() + "\n" +
				"Job ID: " + employee.getJobId() + "\n" +
				"Salary: " + employee.getSalary().toString() + "\n" +
				"Manager ID: " + employee.getManagerId().toString() + "\n" +
				"Deparment ID: " + employee.getDepartmentId().toString() + "\n"
				);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void updateSalary(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee =	entityManager.find(Employee.class,new BigDecimal(id));
		employee.setSalary(employee.getSalary().multiply(new BigDecimal(1.1)));
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void deleteEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee =	entityManager.find(Employee.class,new BigDecimal(id));
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	@Override
	public void finalize() {
		entityManagerFactory.close();
	}
}

