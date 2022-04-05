import entity.Employee;

public interface EmployeeDAOInterface 
{
	public void insertEmployee(Employee emp);
	public void updateEmployee(Employee empUp);
	public void deleteEmployee(int empNo);
	public void selectEmployee(int empNo);
	
}
