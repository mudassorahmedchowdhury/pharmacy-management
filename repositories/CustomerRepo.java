//Parvez

package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class CustomerRepo implements ICustomerRepo
{
	private String file="repositories/data/customer.txt";
	private FileIO fio=new FileIO();
	public void addCustomer(Customer c)
	{
		
		fio.writeFile(this.file,c.toStringCustomer());
	}
	public void updateCustomer(Customer c)
	{
		Customer c1=this.searchCustomer(c.getUserId());
		if(c1!=null)
		{
			this.deleteCustomer(c.getUserId());
			this.addCustomer(c);
		}
		else
		{
			System.out.println("Not found");
		}
		
	}
	public void deleteCustomer(String userId)
	{
		Customer c1[]=this.getAllCustomer();
		for(int i=0;i<100;i++)
		{
			if(c1[i]!=null)
			{
				if(c1[i].getUserId().equals(userId))
				{
					c1[i]=null;
				}
			}
		}
		String data[]=new String[100];
		for(int i=0;i<100;i++)
		{
			if(c1!=null)
			{
				data[i]=c1[i].toStringCustomer();
			}
		}
		fio.writeFile(this.file,data);
	}
	
	public Customer searchCustomer(String userId)
	{
		Customer c1[]=this.getAllCustomer();
		
		for(int i=0;i<100;i++)
		{
			if(c1[i]!=null)
			{
				if(c1[i].getUserId().equals(userId))
				{
					return c1[i];
				}
			}
		}
		return null; 
	}
	public Customer[] getAllCustomer()
	{
		String data[]=fio.readFile(this.file);
		Customer c1[]=new Customer[100];
		Customer c2=new Customer();
		
		for(int i=0;i<100;i++)
		{
			if(c1[i]!=null)
			{
				if(data[i]!=null)
				{
					c1[i]=c2.formCustomer(data[i]);
				}
			}
		}
		return c1;
		
	}
	
}