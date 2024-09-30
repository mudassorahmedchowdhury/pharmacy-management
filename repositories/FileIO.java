package repositories;
import java.lang.*;
import java.io.*;

public class FileIO
{
	public void createFile(String file)
	{
		try
		{
			File f=new File(file);
			if(f.createNewFile())
			{
				System.out.println("File created successfully.");
			}
			else
			{
				System.out.println("File already exists.");
			}
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String[] readFile(String file)
	{
		String data[]=new String[100];
		try
		{
			FileReader fdr=new FileReader(file);
			BufferedReader bfr=new BufferedReader(fdr);
			String temp="";
			int i=0;
			while((temp=bfr.readLine())!=null)
			{
				data[i]=temp;
				i++;
			}
			bfr.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void writeFile(String file, String data[])
	{
		try
		{
			FileWriter fwr=new FileWriter(file);
		
			for(int i=0;i<data.length;i++)
			{
				if(data[i]!=null)
				{
					fwr.write(data[i]);
				}
			}
			
			fwr.flush();
			fwr.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void writeFile(String file, String data)
	{
		try
		{
			FileWriter fwr=new FileWriter(file);
			fwr.write(data);
			fwr.flush();
			fwr.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}