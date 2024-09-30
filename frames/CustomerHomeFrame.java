//Parvez

package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
//import entities.*;
//import repositories.*;


public class CustomerHomeFrame extends JFrame implements ActionListener
{
	
	private JButton searchButton, purchaseButton, uploadButton, orderHistoryButton,logoutButton;
	private JPanel panel;
	
	public CustomerHomeFrame()
	{
		super("Employee Home Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.searchButton=new JButton("Search medicines");
		this.searchButton.setBounds(50,50,200,30);
		this.searchButton.addActionListener(this);
		this.panel.add(searchButton);
		
		this.purchaseButton=new JButton("Estimate medicines");
		this.purchaseButton.setBounds(270,50,200,30);
		this.purchaseButton.addActionListener(this);
		this.panel.add(purchaseButton);
		
		
		this.uploadButton=new JButton("Uploaded prescription prescription");
		this.uploadButton.setBounds(490,50,200,30);
		this.uploadButton.addActionListener(this);
		this.panel.add(uploadButton);
		
		
		this.orderHistoryButton=new JButton("Order History ");
		this.orderHistoryButton.setBounds(270,100,250,30);
		this.orderHistoryButton.addActionListener(this);
		this.panel.add(orderHistoryButton);
        

		this.logoutButton = new JButton("Logout");
		this.logoutButton.setBounds(50, 300, 100, 30);
		this.logoutButton.addActionListener(this);
		this.panel.add(logoutButton);

		
				
		
		this.add(panel);
	}
	
