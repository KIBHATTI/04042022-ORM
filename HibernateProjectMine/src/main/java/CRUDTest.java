import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Employee;

public class CRUDTest
{

	public static void main(String args[])
	{
		System.out.println("Trying to read persistence.xml file");
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EntityManagerFactory is created");
		
		EntityManager em = emf.createEntityManager();
		System.out.println("EntityManager is created");
		
		EntityTransaction et = em.getTransaction();
		System.out.println("EntityManagerTransaction  is created");
		
		System.out.println("Trying to save the record");
		Employee e = new Employee();
		e.setNumber(343442);
		e.setName("Ben");
		e.setJob("Clerk");
		e.setJoiningDate(LocalDate.of(2022, 4, 17));
		e.setSalary(35000);
		
		
		et.begin();
			em.persist(e);
		et.commit();	
		System.out.println("Created the record");
		et.begin();
		et.begin();
		
		
	}
	
}
