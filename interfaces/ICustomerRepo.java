//Parvez

package interfaces;
import java.lang.*;
import entities.*;

public interface ICustomerRepo
{
	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public void deleteCustomer(String ID);
	public Customer searchCustomer(String ID);
	public Customer[] getAllCustomer();
	
}