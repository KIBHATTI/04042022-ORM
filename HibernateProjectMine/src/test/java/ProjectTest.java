import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import entity.EmployeeProject;

public class ProjectTest 
{
	EmployeeProject emppr;
	@Test
	public void createProjectTest()
	{
		emppr = new  EmployeeProject();
		//emppr.setProjectId(256);
		emppr.setProjectTitle("BANKING PROJECT");
		emppr.setProjectDeadline(LocalDate.of(2022, 11	, 30));
		
		ProjectDAOImpl prObj = new ProjectDAOImpl();
		prObj.addProject(emppr);
		
	}
	@Test
	public void deleteProjectTest()
	{
		emppr = new EmployeeProject();
		ProjectDAOImpl prObj = new ProjectDAOImpl();
		prObj.deleteProject(24);
		System.out.println("deleted the project");
	}
}
