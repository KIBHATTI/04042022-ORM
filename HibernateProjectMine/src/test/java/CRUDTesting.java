import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entity.Employee;

public class CRUDTesting
{
	@Test
	public void createEmployeeTest()
	{
		
		Employee e = new Employee();
		Employee e1 = new Employee();
		
		e.setName("Kanwar");
		e.setJob("Manager");
		e.setJoiningDate(LocalDate.of(2019, 2,8));
		e.setSalary(61000);
		e.setAge(35);
		
		e1.setName("Sonny");
		e1.setJob("Salesman");
		e1.setJoiningDate(LocalDate.of(2021, 3,11));
		e1.setSalary(4500);
		e1.setAge(25);
		
		EmployeeDAOTest empDao = new EmployeeDAOTest(); //call the the Implementation
		empDao.insertEmployee(e);		//pass the project object and call the function of EmployeeDAO for inserting
	
		System.out.println("Created the record");
		
		
		
	}
	
	@Test
	public void updateEmplTest() {
		
		System.out.println("Trying to read persistence.xml file...");
		
		//3
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJPA");
	Assertions.assertTrue(emf!=null);
		
		System.out.println("EntityManagerFactory created....");
		
		EntityManager em = emf.createEntityManager();
	Assertions.assertTrue(em!=null);
		System.out.println("EntityManager created....");
		
		EntityTransaction et = em.getTransaction();
	Assertions.assertTrue(em!=null);
		System.out.println("EntityTransaction created....");
		
		System.out.println("Trying to read record.....");
		
		et.begin();
			System.out.println("Transactin started....");
			Employee theEmp = em.find(Employee.class, 8); // ATTACHED OBJECT
		Assertions.assertTrue(theEmp!=null);
		//	System.out.println("Current Emp number : "+theEmp.getEmployeeNumber());
			System.out.println("Current Emp name   : "+theEmp.getName());
			System.out.println("Current Emp doj    : "+theEmp.getJob());
			System.out.println("Current Emp salary : "+theEmp.getSalary());
			System.out.println("Current Emp age    : "+theEmp.getAge());
			
			System.out.println("Trying to make changes in the ATTACHED object's state via setter methods....");
			theEmp.setName("GoldSmith");
			theEmp.setJob("Sr.Analyst");
			theEmp.setSalary(theEmp.getSalary()+500);
			theEmp.setAge(theEmp.getAge()+2);
			
			em.merge(theEmp); //fires the update Query....
			System.out.println("Transactin completed.......");
		et.commit();
		
	}
	
	
	@Test
	public void findEmpTest()
	{
		System.out.println("Trying to read persistence.xml file");
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EntityManagerFactory is created");
		
		EntityManager em = emf.createEntityManager();
		System.out.println("EntityManager is created");
		
		EntityTransaction et = em.getTransaction();
		System.out.println("EntityManagerTransaction  is created");
		
		System.out.println("Trying to read the record");
		
		et.begin();
		Employee emp = em.find(Employee.class, 5); //ATTACHED OBJECTS
		Assertions.assertTrue(emp!=null);
		
		System.out.println("Employee number :"+emp.getNumber());
		System.out.println("Employee name :"+emp.getName());
		System.out.println("Employee age :"+emp.getAge());
		System.out.println("Employee job :"+emp.getJob());
		System.out.println("Employee salary :"+emp.getSalary());
		
		System.out.println("trying to update the query");
		
		emp.setName("Howard");
		emp.setAge(emp.getAge()+2);
		emp.setSalary(41000);
		emp.setJob("Analayst");
		
		em.merge(emp);			//THIS WILL FIRE THE UPDATE QUERY
		System.out.println("Updated the query");
		
		
		
		
		et.commit();
		
	}
	@Test
	public void deleteEmployeeTest()
	{
		System.out.println("Trying to read persistence.xml file");
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EntityManagerFactory is created");
		
		EntityManager em = emf.createEntityManager();
		System.out.println("EntityManager is created");
		
		EntityTransaction et = em.getTransaction();
		System.out.println("EntityManagerTransaction  is created");
		et.begin();
		System.out.println("Trying to delete the employee");
		Employee emp1 = em.find(Employee.class,11);
		em.remove(emp1);
		System.out.println("deleted the record");
		
		et.commit();
		
	}
	@Test
	public void findAllEmpTest()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("Entity Manager Factory is Created");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		Assertions.assertTrue(em!=null);
		System.out.println("Entity Transaction created \n ");
		
		System.out.println("Trying to read all the rows f the table");
		
		Query query = em.createQuery("from Employee");
		System.out.println("till query");
		List<Employee> list1 = query.getResultList(); 
		
		Assertions.assertTrue(list1.size()>0);
		System.out.println("list size > 0");
		
	
		for(Employee emp2 : list1 )
		{
			System.out.println("Emp No         :"+emp2.getNumber());
			System.out.println("Emp job        :"+emp2.getJob());
			System.out.println("Emp DOJ        :"+emp2.getJoiningDate());
			System.out.println("Emp job        :"+emp2.getName());
			System.out.println("Emp salary     :"+emp2.getSalary());
			System.out.println("Emp Age        :"+emp2.getAge());
			System.out.println("=============================================");
			
		}
		
	}

}
