//Shihab

package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class SignUpFrame extends JFrame implements ActionListener 
{
	private JLabel userIdLabel,nameLabel,passLabel,emailLabel,phoneNoLabel,
			genderLabel,ageLabel,recoveryAnsLabel,addressLabel;
	private JTextField userIdTF,nameTF,emailTF,phoneNoTF,genderTF,
			ageTF,recoveryCodeTF,recoveryAnsTF,addressTF;
	private JPasswordField passPF;
	private JRadioButton maleRB,femaleRB;
	private ButtonGroup bg;
	private JButton createBtn,backBtn;
	private JPanel panel;
	
	
	public SignUpFrame()
	{
		super("Sign Up Panel");
		this.setSize(500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new JPanel();
        this.panel.setLayout(null);
		
		
		this.userIdLabel = new JLabel("User ID:");
        this.userIdLabel.setBounds(50, 50, 100, 30);
        this.panel.add(userIdLabel);
		
		this.userIdTF = new JTextField();
        this.userIdTF.setBounds(200, 50, 150, 30);
        this.panel.add(userIdTF);
		
		
		this.nameLabel = new JLabel("Name:");
        this.nameLabel.setBounds(50, 100, 100, 30);
        this.panel.add(nameLabel);
		
		this.nameTF = new JTextField();
        this.nameTF.setBounds(200, 100, 150, 30);
        this.panel.add(nameTF);
	
	
		this.passLabel = new JLabel("Password:");
        this.passLabel.setBounds(50, 150, 100, 30);
        this.panel.add(passLabel);

        this.passPF = new JPasswordField();
        this.passPF.setBounds(200, 150, 150, 30);
        this.panel.add(passPF);
		
		
		this.emailLabel = new JLabel("Email:");
        this.emailLabel.setBounds(50, 200, 100, 30);
        this.panel.add(emailLabel);

        this.emailTF = new JTextField();
        this.emailTF.setBounds(200, 200, 150, 30);
        this.panel.add(emailTF);
		
		
		this.phoneNoLabel = new JLabel("Phone No:");
        this.phoneNoLabel.setBounds(50, 250, 100, 30);
        this.panel.add(phoneNoLabel);

        this.phoneNoTF = new JTextField();
        this.phoneNoTF.setBounds(200, 250, 150, 30);
        this.panel.add(phoneNoTF);
	
	
		this.genderLabel = new JLabel("Gender:");
        this.genderLabel.setBounds(50, 300, 100, 30);
        this.panel.add(genderLabel);
	
		this.maleRB = new JRadioButton("Male");
        this.maleRB.setBounds(200, 300, 70, 30);
        this.panel.add(maleRB);

        this.femaleRB = new JRadioButton("Female");
        this.femaleRB.setBounds(270, 300, 80, 30);
        this.panel.add(femaleRB);
	
	
		this.bg = new ButtonGroup();
        this.bg.add(maleRB);
        this.bg.add(femaleRB);
		
		
		this.ageLabel = new JLabel("Age:");
        this.ageLabel.setBounds(50, 350, 100, 30);
        this.panel.add(ageLabel);

        this.ageTF = new JTextField();
        this.ageTF.setBounds(200, 350, 150, 30);
        this.panel.add(ageTF);
	
	
		        
		
		
		this.recoveryAnsLabel = new JLabel("Recovery Answer:");
        this.recoveryAnsLabel.setBounds(50, 400, 120, 30);
        this.panel.add(recoveryAnsLabel);

        this.recoveryAnsTF = new JTextField();
        this.recoveryAnsTF.setBounds(200, 400, 150, 30);
        this.panel.add(recoveryAnsTF);
		
		
		this.addressLabel = new JLabel("Address:");
        this.addressLabel.setBounds(50, 450, 100, 30);
        this.panel.add(addressLabel);

        this.addressTF = new JTextField();
        this.addressTF.setBounds(200, 450, 150, 30);
        this.panel.add(addressTF);
		
		
		this.createBtn = new JButton("Create Account");
        this.createBtn.setBounds(150, 500, 200, 30);
        this.createBtn.addActionListener(this);
        this.panel.add(createBtn);
		
		
		this.backBtn = new JButton("Back");
        this.backBtn.setBounds(150, 550, 200, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
		
		
		
		
		
		this.add(panel);
		
	
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(createBtn.getText()))
		{
			String userId,name,password,email,phoneNo,
			gender,recoveryAns,address;
			int age;
			
			if((!userIdTF.getText().isEmpty()) && (!nameTF.getText().isEmpty())
				&& (!passPF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) && (!recoveryAnsTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()) && (!ageTF.getText().isEmpty()) && ((maleRB.isSelected()) || (femaleRB.isSelected())))
			{
				
				userId=userIdTF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUser(userId);
				
				if(user==null)
				{
					
					try
					{
						name=nameTF.getText();
						email=emailTF.getText();
						phoneNo=phoneNoTF.getText();
						
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
						
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
						
						else
						{
							gender=maleRB.getText();
						}
						
						int role=3;
						recoveryAns=recoveryAnsTF.getText();
						password = passPF.getText();
						address = addressTF.getText();
						age =Integer.parseInt( ageTF.getText());
						
						Customer c=new Customer(userId, name, password, recoveryAns, gender, email, phoneNo, address, age, role);
						
						urp.addUser(c);
						
						CustomerRepo csr = new CustomerRepo();
						csr.addCustomer(c);
						JOptionPane.showMessageDialog(this, "Customer Account Created Succesfully.");
						
					}
					
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Enter Valid age");
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(this,"User Id already exists.");
					
				}
				
			}
				else
				{
					JOptionPane.showMessageDialog(this,"Please Fill Up Everything");
				}
				
		}
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lnf = new LoginFrame();
			this.setVisible(false);
			lnf.setVisible(true);
		}	
	}
		
		
		
}
	
	






	
		

