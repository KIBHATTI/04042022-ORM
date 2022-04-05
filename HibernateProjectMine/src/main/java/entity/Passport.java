package entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport_table")
public class Passport 
{
	@Id
	@GeneratedValue
	@Column(name="passport_id")
	private int passportId;	
											//------> PRIMARY KEY WILL ALWAYS BE INT IN ORM
	@Column(name="passport_no")
	private String passportNumber;
	
	@Column(name="issued_date")
	private LocalDate passportIssuedDate;
	
	@Column(name="expiry_date")
	private LocalDate passportExpiryDate;
	
	@Column(name="issuedby",length=30)
	private String issuebdBy;
	
	@OneToOne
	@JoinColumn(name="EMP_No")
	Employee emp1;		//Employee number in Employee Class  
	
	public Employee getEmp1() {
		return emp1;
	}
	public void setEmp1(Employee emp1) {
		this.emp1 = emp1;
	}
	public int getPassportId() {
		return passportId;
	}
	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getPassportIssuedDate() {
		return passportIssuedDate;
	}
	public void setPassportIssuedDate(LocalDate passportIssuedDate) {
		this.passportIssuedDate = passportIssuedDate;
	}
	public LocalDate getPassportExpiryDate() {
		return passportExpiryDate;
	}
	public void setPassportExpiryDate(LocalDate passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}
	public String getIssuebdBy() {
		return issuebdBy;
	}
	public void setIssuebdBy(String issuebdBy) {
		this.issuebdBy = issuebdBy;
	}
	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", passportNumber=" + passportNumber + ", passportIssuedDate="
				+ passportIssuedDate + ", passportExpiryDate=" + passportExpiryDate + ", issuebdBy=" + issuebdBy + "]";
	}
	
	
}
