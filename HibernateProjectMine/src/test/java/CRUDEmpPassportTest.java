import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entity.*;
 
public class CRUDEmpPassportTest 
{
	EntityManagerFactory emf ;
	EntityManager em;
	
	CRUDEmpPassportTest()
	{
		System.out.println("Constructor()....");
		
		System.out.println("Trying to read persistence.xml file...");
		this.emf = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EntityManagerFactory created....");
			
		this.em = emf.createEntityManager();
		System.out.println("EntityManager created....");
		
	}
	
	@Test
	public void addNewEmployeeWithoutPassport()
	{
		EntityTransaction et = em.getTransaction();
		Employee e = new Employee();
		e.setName("John");
		e.setAge(45);
		e.setJoiningDate(LocalDate.of(2017,5, 13));
		e.setJob("SALESMAN");
		e.setSalary(43500);
		System.out.println("Here");
		
		
		et.begin();
		System.out.println("in begin ");
			em.persist(e);
		et.commit();
		
	}
	@Test
	public void createNewEmployeeWithNewPassportTest()
	{
		EntityTransaction et = em.getTransaction();
		Employee emp = new Employee();
		Passport pass = new Passport();
		
		emp.setName("Nidhi");emp.setJob("Officer");emp.setJoiningDate(LocalDate.of(2016, 8, 16));emp.setSalary(51000);emp.setAge(29);
		
		pass.setIssuebdBy("Govt of India"); pass.setPassportExpiryDate(LocalDate.of(2036, 10, 10)); pass.setPassportIssuedDate(LocalDate.of(2026, 10, 9));
		
		//SINCE BOTH THE TABLES HAVE THE FOREIGN KEY REFERENCES; NEED TO SET THE PRIMARY KEY COLUMNS 
		//FOR WHICH WE ARE SETTING THE CLASS OBJECTS OF OTHER CLASS AS BELOW
		emp.setPassport(pass);
		pass.setEmp1(emp);
		
		
		et.begin();
			em.persist(pass);
			em.persist(emp);
		et.commit();
	}
	
	@Test
	public void addNewPassportWithoutAnEmployee()
	{
		EntityTransaction et = em.getTransaction();
		Passport pass = new Passport();
		pass.setIssuebdBy("Govt Of Iran"); pass.setPassportExpiryDate(LocalDate.of(2022, 7, 18)); pass.setPassportIssuedDate(LocalDate.of(2011, 7, 17));
	
		et.begin();
			em.persist(pass);
		et.commit();
	
	}
	
	@Test
	public void assignExistingPassportToExistingEmployee()
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
			Passport pass = em.find(Passport.class,19);
			Employee emp = em.find(Employee.class, 16);
			
			pass.setEmp1(emp);
			emp.setPassport(pass);
			
			em.merge(pass);
			em.merge(emp);
		et.commit();
	}
	
	@Test
	public void assignExistingPassportToNewEmployee()
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
			Employee emp = new Employee();
			
			emp.setName("Tanu");emp.setAge(30);emp.setJoiningDate(LocalDate.of(2015, 11, 15));emp.setJob("CLERK");emp.setSalary(31000);
			Assertions.assertTrue(emp!=null);
			
			Passport pass = em.find(Passport.class,20);
			Assertions.assertTrue(pass!=null);
			
			pass.setEmp1(emp);
			emp.setPassport(pass);
			
			em.persist(emp);
			em.merge(pass);
		et.commit();
	}
	@Test
	public void assignNewPassportToExistingEmployee()
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		Passport pass = new Passport();
		pass.setIssuebdBy("British Govt");pass.setPassportExpiryDate(LocalDate.of(2015, 1, 7));pass.setPassportIssuedDate(LocalDate.of(2005, 1, 6));
		Assertions.assertTrue(pass!=null);
		
		Employee emp = em.find(Employee.class,22);
		Assertions.assertTrue(emp!=null);
		
		pass.setEmp1(emp);
		emp.setPassport(pass);
		
		em.persist(pass);
		em.merge(emp);
	et.commit();
		
	}

}
