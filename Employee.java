import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


// Object(java) Relation (Table)  Mapping

/*
 * create table emp_table (
 * 	emp_no int PRIMARY KEY, 
 * 	emp_name varchar(20),
 *  emp_job varchar(20),
 *  emp_doj date,
 *  emp_sal int
 * );
 *  
 */


@Entity
@Table(name="emp_table")
public class Employee     //CREATE POJO
{
	@Id
	@GeneratedValue					//it will create a sequence in SQL
	@Column(name="emp_no")
	private int empNumber;
	
	@Column(name="emp_name",length = 20)
	private String name;
	
	@Column(name="emp_job",length = 20)
	private String job;
	
	@Column(name="emp_doj")
	private LocalDate joiningDate;
	
	@Column(name="emp_sal")
	private double salary;
	
	@Column(name="emp_age")
	private Integer age;
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Employee()
	{
		super();
		System.out.println("Employee Created!!!!!");
	}

	public int getNumber() {
		return empNumber;
	}

	public void setNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
