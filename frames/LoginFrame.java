//Shihab

package frames;

import entities.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import repositories.*;


public class LoginFrame extends JFrame implements ActionListener 
{
	private JLabel userIdLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, signUpBtn, forgetpassBtn;
	private JPanel panel;
	private Color myColor;
	private ImageIcon img, backImg;
	
	public LoginFrame()
	{
		super("Login Panel");
		this.setSize(1600,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.myColor = new Color(36,163,59);
		this.backImg = new ImageIcon("frames/image/back.jpg");
		
		this.panel = new JPanel()

		{
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(backImg.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};

		
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id");
		//this.userIdLabel.setBounds(100, 80, 150, 30);
		//this.panel.add(userIdLabel);
		
		this.userTF = new JTextField();
		this.userTF.setBounds(970, 310, 375, 45);
		this.userTF.setBorder(null);
		this.panel.add(userTF);
		
		
		this.passLabel = new JLabel("Password");
		//this.passLabel.setBounds(100, 130, 150, 30);
		//this.panel.add(passLabel);
		
		this.passPF = new JPasswordField();
		this.passPF.setBounds(970, 417, 375, 40);
		this.passPF.setBorder(null);
		this.panel.add(passPF);
		
		this.loginBtn = new JButton("Login");
		this.loginBtn.setBounds(930, 495, 270, 55);
		this.loginBtn.addActionListener(this);
		this.loginBtn.setBorder(null);
		this.panel.add(loginBtn);
		
		this.exitBtn = new JButton("Exit");
        this.exitBtn.setBounds(1322, 27, 240, 50);
        this.exitBtn.addActionListener(this); 
		this.exitBtn.setBorder(null);
        this.panel.add(exitBtn);
		
		this.signUpBtn = new JButton("Sign Up");
        this.signUpBtn.setBounds(1198,637,240,55);
		this.signUpBtn.setBorder(null);
        this.signUpBtn.addActionListener(this); 
        this.panel.add(signUpBtn);
		
		this.forgetpassBtn = new JButton("Forgot Password?");
        this.forgetpassBtn.setBounds(1225, 495, 240, 55);
        this.forgetpassBtn.addActionListener(this);
		this.forgetpassBtn.setBorder(null);
        this.panel.add(forgetpassBtn);
		
		
		this.add(panel);
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			String usId=userTF.getText();
			String pass=passPF.getText();
			UserRepo urp=new UserRepo();
			User user=urp.searchUser(usId);
			if(user!=null)
			{
				if(user.getUserId().equals(usId) && user.getPassword().equals(pass) 
					&& user.getRole()==1)
				{
					OwnerHomeFrame ohf=new OwnerHomeFrame(user);
					this.setVisible(false);
					ohf.setVisible(true);
				}
				
				else if(user.getUserId().equals(usId) && user.getPassword().equals(pass)
						&& user.getRole()==2)
				{
						EmployeeHomeFrame ohf=new EmployeeHomeFrame(user);
						this.setVisible(false);
						ohf.setVisible(true);
				}
					
				else if(user.getUserId().equals(usId) && user.getPassword().equals(pass)
						&& user.getRole()==3)
				{
						CustomerHomeFrame ohf =new CustomerHomeFrame();
						this.setVisible(false);
						ohf.setVisible(true);		
								
				}
				
				
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong User Id or Password!");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "User not found!");
			}
			
		}
		
		
		if(command.equals(signUpBtn.getText()))
		{
			SignUpFrame sf=new SignUpFrame();
			this.setVisible(false);
			sf.setVisible(true);
		}
						
		if(command.equals(forgetpassBtn.getText()))
		{
			
		}
						
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
									
	}
}