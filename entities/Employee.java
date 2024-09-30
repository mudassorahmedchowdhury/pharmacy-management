//Shuvo

package entities;
import java.lang.*;

public class Employee extends User 
{
	private String jobTitle;
	private int salary;
	
	public Employee()
	{
		super();
	}
	
	public Employee(String userId, String name, String password, String recoveryCode, String gender, String email, String phoneNo, String address, int age,int role, String jobTitle, int salary)
	{
		super(userId, name,password, recoveryCode, gender, email,phoneNo, address, age, role);
		this.jobTitle=jobTitle;
		this.salary=salary;
	}
	
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle=jobTitle;
	}
	
	public void setSalary(int salary)
	{
		this.salary=salary;
	}
	
	public String toStringEmployee()
	{
		String str = this.userId+","+this.password+","+this.recoveryCode+","+this.role+","+this.jobTitle+","+this.salary+"\n";
		return str;
	}
	
	public Employee formEmployee(String str)
	{
		String[] info=str.split(",");
		Employee e=new Employee();
		e.setUserId(info[0]);
		e.setPassword(info[1]);
		e.setRecoveryCode(info[2]);
		e.setRole(Integer.parseInt(info[3]));
		e.setJobTitle(info[4]);
		e.setSalary(Integer.parseInt(info[5]));
		
		return e;
	}
}