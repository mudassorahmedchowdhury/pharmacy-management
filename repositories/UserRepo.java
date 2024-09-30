//Shihab

package repositories;

import java.lang.*;
import entities.*;
import interfaces.*;

public class UserRepo implements IUserRepo
{
	private String file="repositories/data/users.txt";
	private FileIO fio=new FileIO();
	public void addUser(User s)
	{
		
		User usrs[]=this.getAllUser();
		for(int i=0;i<100;i++)
		{
			if(usrs[i]==null)
			{
				usrs[i]=s;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(usrs[i]!=null)
			{
				data[i]=usrs[i].toStringUser();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	public void updateUser(User s)
	{
		User std=this.searchUser(s.getUserId());
		if(std!=null)
		{
			this.deleteUser(s.getUserId());
			this.addUser(s);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	public void deleteUser(String id)
	{
		User usrs[]=this.getAllUser();
		
		for(int i=0;i<100;i++)
		{
			if(usrs[i]!=null)
			{
				if(usrs[i].getUserId().equals(id))
				{
					usrs[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(usrs[i]!=null)
			{
				data[i]=usrs[i].toStringUser();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	public User searchUser(String id)
	{
		User usrs[]=this.getAllUser();
		
		for(int i=0;i<100;i++)
		{
			if(usrs[i]!=null)
			{
				if(usrs[i].getUserId().equals(id))
				{
					return usrs[i];
				}
			}
		}
		
		return null;
	}
	public User[] getAllUser()
	{
		String data[]=fio.readFile(this.file);
		User usrs[]=new User[100];
		User std=new User();
		
		for(int i=0;i<usrs.length;i++)
		{
			if(usrs[i]==null)
			{
				if(data[i]!=null)
				{
					usrs[i]=std.formUser(data[i]);
				}
				
			}
		}
		
		return usrs;
	}
	
	
}
	