//Samin

package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class OwnerHomeFrame extends JFrame implements ActionListener
{
	
	private JButton ownerBtn, customerBtn, employeeBtn, salesBtn, supplierBtn, inventoryBtn, paymentBtn, profileBtn, passBtn, logOutBtn;
	private JPanel panel;
	private User u;

	public OwnerHomeFrame(User u)
	{
		
		super("Owner Home Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.ownerBtn=new JButton("Owner operation");
		this.ownerBtn.setBounds(50,50,200,40);
		this.ownerBtn.addActionListener(this);
		this.panel.add(ownerBtn);
		
		this.customerBtn=new JButton("Employee Operation");
		this.customerBtn.setBounds(270,50,200,40);
		this.customerBtn.addActionListener(this);
		this.panel.add(customerBtn);
		
		this.employeeBtn=new JButton("Customer operation");
		this.employeeBtn.setBounds(490,50,200,40);
		this.employeeBtn.addActionListener(this);
		this.panel.add(employeeBtn);
		
		this.salesBtn=new JButton("Sales History");
		this.salesBtn.setBounds(50,120,200,40);
		this.salesBtn.addActionListener(this);
		this.panel.add(salesBtn);
		
		this.supplierBtn=new JButton("Supplier Operation");
		this.supplierBtn.setBounds(270,120,200,40);
		this.supplierBtn.addActionListener(this);
		this.panel.add(supplierBtn);
		
		this.inventoryBtn=new JButton("Current Inventory");
		this.inventoryBtn.setBounds(490,120,200,40);
		this.inventoryBtn.addActionListener(this);
		this.panel.add(inventoryBtn);

		this.paymentBtn=new JButton("View all payment");
		this.paymentBtn.setBounds(50,190,300,40);
		this.paymentBtn.addActionListener(this);
		this.panel.add(paymentBtn);
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(380,190,150,40);
		this.profileBtn.addActionListener(this);
		this.panel.add(profileBtn);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(550,190,150,40);
		this.passBtn.addActionListener(this);
		this.panel.add(passBtn);
		
		this.logOutBtn = new JButton("Log Out");
		this.logOutBtn.setBounds(50, 300, 100, 30);
		this.logOutBtn.addActionListener(this);
		this.panel.add(logOutBtn);
		
		
		
		
		
		this.add(panel);
		this.u=u;

	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(ownerBtn.getText()))
		{
			OwnerOperationFrame oof=new OwnerOperationFrame(this.u);
			this.setVisible(false);
			oof.setVisible(true);
			

		}

		else if(command.equals(customerBtn.getText()))
		{
			CustomerHomeFrame chf = new CustomerHomeFrame();
			chf.setVisible(true);
			this.setVisible(false);
		}

		
		else if(command.equals("Log Out"))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
	}
	
}
