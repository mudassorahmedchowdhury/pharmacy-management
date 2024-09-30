//Everyone

package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

import entities.*;
import repositories.*;

public class OwnerOperationFrame extends JFrame implements ActionListener
{
	private JLabel ownerIdLabel, nameLabel, emailLabel, phoneNoLabel,  genderLabel, ageLabel, addressLabel,  pharmacylicenseLabel, passLabel, ownerTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF,  ageTF, addressTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox ownerTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable ownerTable;
	private JScrollPane ownerTableSP;
	private JPanel panel;
	private User u;
	
	
	
	
	public OwnerOperationFrame(User u)
	{
		super("Owner Operation Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.ownerIdLabel=new JLabel("User Id:");
		this.ownerIdLabel.setBounds(60,60,50,20);
		this.panel.add(ownerIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(130,60,120,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(60,110,50,20);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(130,110,120,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setBounds(60,160,50,20);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(130,160,120,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No:");
		this.phoneNoLabel.setBounds(60,200,70,20);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(130,200,120,30);
		this.panel.add(phoneNoTF);

		
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(60,250,70,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(130,250,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,250,80,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(280,160,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(360,160,120,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(280,50,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(360,50,120,30);
		this.panel.add(addressTF);

		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(280,110,120,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(360,110,120,30);
		this.panel.add(passPF);
		
		this.ownerTypeLabel=new JLabel("Owner Type:");
		this.ownerTypeLabel.setBounds(280,250,100,30);
		this.panel.add(ownerTypeLabel);

 		String[] item={"Owner", "Pharmacy Owner"};
		this.ownerTypeCMB = new JComboBox(item);
		this.ownerTypeCMB.setBounds(390,250,200,30);
		this.panel.add(ownerTypeCMB);
		
		this.addBtn=new JButton("Add Owner");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("update Owner");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("remove Owner");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("search Owner");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,350,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		OwnerRepo arp=new OwnerRepo();
		Owner[] ownerList=arp.getAllOwner();
		String ownerData1[][]=new String[ownerList.length][8];
		for(int i=0;i<ownerList.length;i++)
		{
		
			if(ownerList[i]!=null)
			{
				System.out.println(ownerList[i].toStringOwner());
				ownerData1[i][0]=ownerList[i].getUserId();
				ownerData1[i][1]=ownerList[i].getName();
				ownerData1[i][2]=ownerList[i].getEmail();
				ownerData1[i][3]=ownerList[i].getPhoneNo();
				ownerData1[i][4]=ownerList[i].getGender();
				ownerData1[i][5]=String.valueOf(ownerList[i].getAge());
				ownerData1[i][6]=ownerList[i].getAddress();
				ownerData1[i][7]=ownerList[i].getOwnerType();
			}
			
			
			
		}
		String head1[]={"Id","Name","Email","PhoneNo","Gender","Age","Adress","OwnerType"};
		this.ownerTable=new JTable(ownerData1,head1);
		this.ownerTableSP=new JScrollPane(ownerTable);
		this.ownerTableSP.setBounds(50,380,700,200);
		this.ownerTable.setEnabled(false);
		this.panel.add(ownerTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			String userId,name,email,phoneNo, gender,address,pass,ownerType;
			int age;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				userId=userTF.getText();
				
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
						age=Integer.parseInt(ageTF.getText());
						address=addressTF.getText();
						int role=1;
						pass=passPF.getText();
						ownerType=ownerTypeCMB.getSelectedItem().toString();
						Owner a=new Owner(userId,name,pass,"",gender,email,phoneNo,address,age,role,ownerType);
						urp.addUser(a);
						OwnerRepo arp=new OwnerRepo();
						arp.addOwner(a);
						JOptionPane.showMessageDialog(this,"owner added Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
			
		}
		
		if(command.equals(updateBtn.getText()))
		{
			
			String userId,name,email,phoneNo,gender,address,ownerType;
			int age;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				userId=userTF.getText();
				OwnerRepo arp=new OwnerRepo();
				Owner a=arp.searchOwner(userId);
				if(a!=null)
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
						age=Integer.parseInt(ageTF.getText());
						address=addressTF.getText();
						ownerType=ownerTypeCMB.getSelectedItem().toString();
					
						a.setName(name);
						a.setEmail(email);
						a.setPhoneNo(phoneNo);
						a.setGender(gender);
						a.setAge(age);
						a.setAddress(address);
						a.setOwnerType(ownerType);
						arp.updateOwner(a);
						JOptionPane.showMessageDialog(this,"owner updated Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			if(!userTF.getText().isEmpty()) 
			{
				userId=userTF.getText();
				OwnerRepo arp=new OwnerRepo();
				Owner a=arp.searchOwner(userId);
				if(a!=null)
				{
					UserRepo urp=new UserRepo();
					urp.deleteUser(userId);
					arp.deleteOwner(userId);
					JOptionPane.showMessageDialog(this,"Owner removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please Provide a valid userId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			if(!userTF.getText().isEmpty())
			{
				userId=userTF.getText();
				OwnerRepo urp=new OwnerRepo();
				Owner a=urp.searchOwner(userId);
				if(a!=null)
				{
					userTF.setEditable(false);
					nameTF.setText(a.getName());
					emailTF.setText(a.getEmail());
					phoneNoTF.setText(a.getPhoneNo());
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
					if(a.getOwnerType().equals("Owner"))
					{
						ownerTypeCMB.setSelectedItem("Owner");
					}
					else
					{
						ownerTypeCMB.setSelectedItem("Pharmacy Owner");
					}
					ageTF.setText(String.valueOf(a.getAge()));
					addressTF.setText(a.getAddress());
					JOptionPane.showMessageDialog(this,"owner found");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"owner not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to search owner.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			userTF.setEditable(true);
			userTF.setText("");
			nameTF.setText("");
			emailTF.setText("");
			phoneNoTF.setText("");
			ageTF.setText("");
			addressTF.setText("");
			//pharmacylicenseTF.setText("");
			passPF.setText("");
			JOptionPane.showMessageDialog(this,"reset successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			OwnerHomeFrame adf=new OwnerHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
	
}