//Shuvo

package interfaces;
import java.lang.*;
import entities.*;

public interface IEmployeeRepo
{
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(String id);
	public Employee searchEmployee(String id);
	public Employee[] getAllEmployee();
}