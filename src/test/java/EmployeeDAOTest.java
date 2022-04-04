import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import org.junit.jupiter.api.Test;

public class EmployeeDAOTest implements EmployeeDAOInterface
{
	EntityManagerFactory emf;
	EntityManager em;
	Employee emp1;
	EmployeeDAOTest()
	{
		System.out.println("INSERTING EMPLOYEE");
		 this.emf= Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EMF create");
		
		 this.em= emf.createEntityManager();
		System.out.println("EM created");
		
	}
	
	public void insertEmployee(Employee emp1)
	{
		EntityTransaction et = em.getTransaction();
		System.out.println("ET created");
			
		et.begin();
		System.out.println("in begin");
		em.persist(emp1);
		et.commit();
	}

	public void updateEmployee(int empNo) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEmployee(int empNo) {
		// TODO Auto-generated method stub
		
	}

	public void selectEmployee(int empNo) {
		// TODO Auto-generated method stub
		
	}
	
	

}
