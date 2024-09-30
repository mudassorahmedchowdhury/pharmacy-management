//Parvez

package entities;
import java.lang.*;

public class Customer extends User
{
	private String  prescription;
	
	public Customer()
	{
		super();
	}
	public Customer(String userId, String name, String password, String recoveryCode,
		String gender,String email, String phoneNo, String address, int age,int role)
	{
		super(userId, name, password, recoveryCode, gender, email, phoneNo, address, age, role);
		
	}

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    public String getPrescription() {
        return this.prescription;
    }


    public String toStringCustomer() {
    String str = this.userId + "," + this.name + "," + this.gender + "," + this.email + "," + this.phoneNo + "," + this.address + "," + this.age + "\n";
    return str;
    }

	public Customer formCustomer(String str)
	{
		String[] info=str.split(",");
		Customer c =new Customer();
		c.setUserId(info[0]);
		c.setName(info[1]);
		c.setGender(info[2]);
		c.setEmail(info[3]);
		c.setPhoneNo(info[4]);
		c.setAddress(info[5]);
		c.setAge(Integer.parseInt(info[6]));
		
		return c;
	}

}

