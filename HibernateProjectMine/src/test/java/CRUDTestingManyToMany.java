import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import entity.Customer;
import entity.Subscription;

public class CRUDTestingManyToMany 
{
	EntityManagerFactory emf;
	EntityManager em ;
	
	CRUDTestingManyToMany()
	{
		System.out.println("CRUD testing");
		
		this.emf = Persistence.createEntityManagerFactory("MyJPA");
		System.out.println("EntityManagerFactory created....");
		
		this.em = emf.createEntityManager();
		System.out.println("EntityManager created....");
	}
	
	@Test
	public void createCustomer()
	{
		Customer cust1 = new Customer();
		cust1.setCustomerId(111);
		cust1.setCustomerName("Sonia");
		cust1.setEmailAddress("sonia.124@gmail.com");
		
		Customer cust2 = new Customer();
		cust2.setCustomerId(121);
		cust2.setCustomerName("Summer");
		cust2.setEmailAddress("summer.124@gmail.com");
		
		Customer cust3 = new Customer();
		cust3.setCustomerId(131);
		cust3.setCustomerName("Winter");
		cust3.setEmailAddress("winter.124@gmail.com");
		
		Customer c = new Customer();
		c.setCustomerId(141);
		c.setCustomerName("Spring");
		c.setEmailAddress("spring.123@gmail.com");
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
			em.persist(cust1);
			em.persist(cust2);
			em.persist(cust3);
		et.commit();	
	}
	
	@Test
	public void createSubscriptions()
	{
		Subscription sub1 = new Subscription();
		sub1.setSubscriptionId(55);
		sub1.setSubscriptionName("Times Magazine");
		sub1.setSubscrptionType("2 Month");
		
		Subscription sub2 = new Subscription();
		sub2.setSubscriptionId(66);
		sub2.setSubscriptionName("The Herald");
		sub2.setSubscrptionType("6 months");
		
		Subscription sub3 = new Subscription();
		sub3.setSubscriptionId(77);
		sub3.setSubscriptionName("Netflix");
		sub3.setSubscrptionType("1year");
		
		EntityTransaction et = em.getTransaction();
		et.begin();
			em.persist(sub1);
			em.persist(sub2);
			em.persist(sub3);
		et.commit();
		
	}
	
	@Test
	public void assignSubscritpionsToExistingCustomer()
	{
		Customer cust = em.find(Customer.class, 121);
		
		Subscription sub1 = em.find(Subscription.class,55);
		Subscription sub2 = em.find(Subscription.class,66);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
			cust.getSubscriptions().add(sub1);
			cust.getSubscriptions().add(sub2);
			em.merge(cust);
		et.commit();
	}

	@Test
	public void assignCustomerToExistingSubscription()
	{
		Subscription sub1 = em.find(Subscription.class,77);
		
		Customer cust1 = em.find(Customer.class,141);
		//Customer cust2 = em.find(Customer.class,121);
		sub1.getCustomers().add(cust1);
		EntityTransaction et = em.getTransaction();
		et.begin();
			
		
			//sub1.getCustomers().add(cust2);
			em.merge(sub1);
		
		et.commit();	
		
		
	}
	
	//print the subscription name for customer                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	
	@Test
	public void printSubscriptionNameByCustomerName()
	{
		Customer cust = em.find(Customer.class,121);
		Set<Subscription> subs = cust.getSubscriptions();
		
		System.out.println("=== Subscriptions of "+cust.getCustomerName()+" are ===");
		for(Subscription subscription : subs)
		{
			System.out.println("Subscription name :"+subscription.getSubscriptionName());
			System.out.println("Subscription Type :"+subscription.getSubscrptionType());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
		
		
	}
	
}
