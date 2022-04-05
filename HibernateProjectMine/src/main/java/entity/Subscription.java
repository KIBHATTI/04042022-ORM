package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="subscription")
public class Subscription
{
	@Id
	@Column(name="sub_id")
	private int subscriptionId;
	
	@Column(name="sub_name")
	private String subscriptionName;
	
	@Column(name="sub_type")
	private String subscrptionType;
	
	@ManyToMany
	@JoinTable(name="CustomerSubscriptionLink",
	joinColumns = {@JoinColumn(name="sid")},
	inverseJoinColumns = {@JoinColumn(name="cid")})
	Set<Customer> customers = new HashSet<Customer>();						//BOTH CUSTOMER AND SUBSCRIPTIONS FOR ANOTHER TABLE

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public String getSubscrptionType() {
		return subscrptionType;
	}

	public void setSubscrptionType(String subscrptionType) {
		this.subscrptionType = subscrptionType;
	}
	
	
	
	
}
