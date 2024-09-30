//Samin

package interfaces;
import java.lang.*;
import entities.*;

public interface IOwnerRepo
{
	public void addOwner(Owner o);
	public void updateOwner(Owner o);
	public void deleteOwner(String id);
	public Owner searchOwner(String id);
	public Owner[] getAllOwner();
}