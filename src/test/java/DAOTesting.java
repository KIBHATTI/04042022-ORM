import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class DAOTesting 
{
	@Test
	public void addEmployee()
	{
		Employee emp = new Employee();
		emp.setAge(30);
		emp.setName("Micheal");
		emp.setJoiningDate(LocalDate.of(2021, 7, 3));
		emp.setSalary(45261);
		emp.setJob("Salesman");
		EmployeeDAOTest  empDAO = new EmployeeDAOTest();
		empDAO.insertEmployee(emp);
	}

}
