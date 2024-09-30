//Samin

package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class OwnerRepo implements IOwnerRepo
{
	private String file="repositories/data/owner.txt";
	private FileIO fio=new FileIO();
	public void addOwner(Owner o)
	{
		Owner own[]=this.getAllOwner();
		for(int i=0;i<100;i++)
		{
			if(own[i]==null)
			{
				own[i]=o;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(own[i]!=null)
			{
				data[i]=own[i].toStringOwner();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	
	public void updateOwner(Owner o)
	{
		Owner own=this.searchOwner(o.getUserId());
		if(own!=null)
		{
			this.deleteOwner(o.getUserId());
			this.addOwner(o);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	public void deleteOwner(String id)
	{
		Owner own[]=this.getAllOwner();
		
		for(int i=0;i<100;i++)
		{
			if(own[i]!=null)
			{
				if(own[i].getUserId().equals(id))
				{
					own[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(own[i]!=null)
			{
				data[i]=own[i].toStringOwner();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	public Owner searchOwner(String id)
	{
		Owner own[]=this.getAllOwner();
		
		for(int i=0;i<100;i++)
		{
			if(own[i]!=null)
			{
				if(own[i].getUserId().equals(id))
				{
					return own[i];
				}
			}
		}
		
		return null;
	}
	public Owner[] getAllOwner()
	{
		String data[]=fio.readFile(this.file);
		Owner own[]=new Owner[100];
		Owner ownr = new Owner();
		
		for(int i=0;i<own.length;i++)
		{
			if(own[i]==null)
			{
				if(data[i]!=null)
				{
					own[i]=ownr.formOwner(data[i]);
				}
				
			}
		}
		
		return own;
	}
}
