import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.EmployeeProject;

public class ProjectDAOImpl implements EmpProjectInterface
{
	EntityManagerFactory emf;
	EntityManager em;
	int project_id;
	ProjectDAOImpl()
	{
		System.out.println("INSERTING PROJECT");
		 this.emf= Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EMF create");
		
		 this.em= emf.createEntityManager();
		System.out.println("EM created");
	}
	
	public void addProject(EmployeeProject empPr) {
		EntityTransaction et = em.getTransaction();
		System.out.println("ET created");
			
		et.begin();
		System.out.println("In begin projectImp");
		em.persist(empPr);	//PERSIST INSERT DATA IN TABLE
		et.commit();
		
	}

	public void deleteProject(int project_id) {
		this.project_id=project_id;
		System.out.println("prject id is "+project_id);
		
		EntityTransaction et = em.getTransaction();
	
			
		et.begin();
		System.out.println("In delete  projectImp");
		EmployeeProject pr = em.find(EmployeeProject.class,project_id);
		em.remove(pr);	//remove  invokes delete statement IN TABLE
		et.commit();
		
	}

}
