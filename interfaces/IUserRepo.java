//Shihab

package interfaces;
import java.lang.*;
import entities.*;

public interface IUserRepo
{
	public void addUser(User u);
	public void updateUser(User u);
	public void deleteUser(String id);
	public User searchUser(String id);
	public User[] getAllUser();
	
}