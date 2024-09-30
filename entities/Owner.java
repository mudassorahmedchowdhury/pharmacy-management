//Samin

package entities;
import java.lang.*;

public class Owner extends User 
{
    private String ownerType;

    public Owner() 
	{
        super();
    }

    public Owner(String userId, String name, String password, String recoveryCode,
				String gender,String email, String phoneNo, String address, int age,
				int role, String ownerType)
	{
		
        super(userId, name,password, recoveryCode, gender, 
				email, phoneNo, address, age, role);
        this.ownerType = ownerType;
		
    }
	
	public void setOwnerType(String ownerType) 
	{
        this.ownerType = ownerType;
    }

    public String getOwnerType() 
	{
        return this.ownerType;
    }
	
    public String toStringOwner() 
	{
        String str=this.userId+","+ this.name+","+this.password+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.ownerType+"\n";
		return str;
    }
	
    public Owner formOwner(String str) 
	{
        String[] info=str.split(",");
        Owner o=new Owner();
        o.setUserId(info[0]);
        o.setName(info[1]);
        o.setPassword(info[2]);
        o.setEmail(info[3]);
        o.setPhoneNo(info[4]);
        o.setGender(info[5]);
        o.setAge(Integer.parseInt(info[6]));
        o.setAddress(info[7]);
        o.setOwnerType(info[8]);
       
        return o;
	}
}

