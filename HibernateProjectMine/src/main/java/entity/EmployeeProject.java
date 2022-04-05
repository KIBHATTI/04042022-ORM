package entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Emp_Project")
public class EmployeeProject 
{
	@Id
	@GeneratedValue
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="project_title",length=20)
	private String projectTitle;
	
	@Column(name="project_deadline")
	private LocalDate projectDeadline;
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public LocalDate getProjectDeadline() {
		return projectDeadline;
	}
	public void setProjectDeadline(LocalDate projectDeadline) {
		this.projectDeadline = projectDeadline;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectTitle=" + projectTitle + ", projectDeadline="
				+ projectDeadline + "]";
	}

}
