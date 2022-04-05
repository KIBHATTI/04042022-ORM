import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import entity.Department;
import entity.Employee;
import entity.Passport;

public class CRUDOneToMany
{
	EntityManagerFactory emf;
	EntityManager em ;
	
	CRUDOneToMany()
	{
		System.out.println("CRUD testing");
		
		this.emf = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EntityManagerFactory created....");
		
		this.em = emf.createEntityManager();
		System.out.println("EntityManager created....");
	}
	@Test
	public void createSingleDepartmentTest()
	{
		
		
	}
	
	@Test
	public void createDepartmentWithEmployeeAndPassport()
	{
		Department dept = new Department("Sales","NY");
		
		Passport pass = new Passport();
		pass.setIssuebdBy("Govt of Australia");
		pass.setPassportExpiryDate(LocalDate.of(2022,12, 30));
		pass.setPassportIssuedDate(LocalDate.of(2012,12, 29));
		
		Passport pass1 = new Passport();
		pass1.setIssuebdBy("Govt of Australia");
		pass1.setPassportExpiryDate(LocalDate.of(2032,11, 13));
		pass1.setPassportIssuedDate(LocalDate.of(2022,11, 12));
		
		Employee emp = new Employee("Karan","Analyst",LocalDate.of(2007, 11, 11),70000,36,pass,dept);
		Employee emp1 = new Employee("Bob","Salesman",LocalDate.of(2017, 11, 11),35000,37,pass1,dept);
		
		pass.setEmp1(emp);
		pass1.setEmp1(emp1);
		
		Set<Employee> tempStaff = new HashSet<Employee>();
		
		tempStaff.add(emp1);
		tempStaff.add(emp);
		
		dept.setStaff(tempStaff);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
			em.persist(dept);
		et.commit();
		
	}

}
