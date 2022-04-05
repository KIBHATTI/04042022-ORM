package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Passport;

public class PassportDAOImpl implements PassportInterface
{
	EntityManagerFactory emf;
	EntityManager em;
	
	
	PassportDAOImpl()
	{
		System.out.println("Constructor()....");
		
		System.out.println("Trying to read persistence.xml file...");
		this.emf = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EntityManagerFactory created....");
			
		this.em = emf.createEntityManager();
		System.out.println("EntityManager created....");
		
	}
	
	public void addPassport(Passport p) {
		EntityTransaction et = em.getTransaction();
		System.out.println("Adding new Passport");
		et.begin();
		
			em.persist(p);
		
		et.commit();
		
	}

	public void deletePassport(int p_id) {
		EntityTransaction et = em.getTransaction();
		System.out.println("deleting  Passport");
		et.begin();
		
			em.persist(p_id);
		
		et.commit();
		
	}

	public void modifyPassport(Passport p) {
		// TODO Auto-generated method stub
		
	}

}
