//Shuvo

package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class EmployeeHomeFrame extends  JFrame implements ActionListener
{

	private JButton addEmployeeBtn, updateEmployeeBtn, deleteEmployeeBtn;
	private JPanel panel;
	private User u;
	
	public EmployeeHomeFrame(User u)
	{
		super("Employee Home Frame");
		this.setSize(900,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.addEmployeeBtn=new JButton("Add Employee");
		this.addEmployeeBtn.setBounds(50,40,130,30);
		this.addEmployeeBtn.addActionListener(this);
		this.panel.add(addEmployeeBtn);
		
		this.updateEmployeeBtn=new JButton("Update Employee");
		this.updateEmployeeBtn.setBounds(200,40,130,30);
		this.updateEmployeeBtn.addActionListener(this);
		this.panel.add(updateEmployeeBtn);
		
		this.deleteEmployeeBtn=new JButton("Delete Employee");
		this.deleteEmployeeBtn.setBounds(350,80,130,30);
		this.deleteEmployeeBtn.addActionListener(this);
		this.panel.add(deleteEmployeeBtn);
		
		
		
		this.add(panel);
		this.u=u;	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
	}
	

}