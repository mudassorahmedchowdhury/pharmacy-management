package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class EmployeeRepo implements IEmployeeRepo
{
	private String file="repositories/data/employees.txt";
	private FileIO fio=new FileIO();
	public void addEmployee(Employee e)
	
	{
		Employee empls[]=this.getAllEmployee();
		for(int i=0;i<100;i++)
		{
			if(empls[i]==null)
			{
				empls[i]=e;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(empls[i]!=null)
			{
				data[i]=empls[i].toStringEmployee();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	
	public void updateEmployee(Employee e)
	{
		Employee empl=this.searchEmployee(e.getUserId());
		if(empl!=null)
		{
			this.deleteEmployee(e.getUserId());
			this.addEmployee(e);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	
	public void deleteEmployee(String id)
	{
		Employee empls[]=this.getAllEmployee();
		
		for(int i=0;i<100;i++)
		{
			if(empls[i]!=null)
			{
				if(empls[i].getUserId().equals(id))
				{
					empls[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(empls[i]!=null)
			{
				data[i]=empls[i].toStringEmployee();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	
	public Employee searchEmployee(String id)
	{
		Employee empls[]=this.getAllEmployee();
		
		for(int i=0;i<100;i++)
		{
			if(empls[i]!=null)
			{
				if(empls[i].getUserId().equals(id))
				{
					return empls[i];
				}
			}
		}
		
		return null;
	}
	
	public Employee[] getAllEmployee()
	{
		String data[]=fio.readFile(this.file);
		Employee empls[]=new Employee[100];
		Employee empl=new Employee();
		
		for(int i=0;i<empls.length;i++)
		{
			if(empls[i]==null)
			{
				if(data[i]!=null)
				{
					empls[i]=empl.formEmployee(data[i]);
				}
				
			}
		}
		
		return empls;
	}
}