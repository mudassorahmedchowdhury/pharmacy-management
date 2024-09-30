package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;

public class PurchaseMedicinesFrame extends JFrame implements ActionListener
{
    private JComboBox<String> medicineComboBox;
    private JTextField quantityField;
    private JButton purchaseButton, backButton, insertButton, updateButton, deleteButton;
    private JTextArea purchaseDetailsArea;
    private JPanel panel;

    private String[] medicines;
    private int[] prices;
    private int medicineCount;

    public PurchaseMedicinesFrame()
    {
        super("Purchase Medicines");
        this.setSize(800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        // Initialize medicines and prices arrays with a fixed size (e.g., 10)
        medicines = new String[10];
        prices = new int[10];
        medicineCount = 4; // Initial count of medicines

        // Add initial medicines and prices
        medicines[0] = "Paracetamol";
        prices[0] = 5;
        medicines[1] = "Ibuprofen";
        prices[1] = 8;
        medicines[2] = "Aspirin";
        prices[2] = 6;
        medicines[3] = "Amoxicillin";
        prices[3] = 15;

        // Populate JComboBox with initial medicines
        this.medicineComboBox = new JComboBox<>(medicines);
        this.medicineComboBox.setBounds(50, 50, 200, 30);
        this.panel.add(medicineComboBox);

        this.quantityField = new JTextField();
        this.quantityField.setBounds(270, 50, 100, 30);
        this.panel.add(quantityField);

        this.purchaseButton = new JButton("Estimate");
        this.purchaseButton.setBounds(400, 50, 120, 30);
        this.purchaseButton.addActionListener(this);
        this.panel.add(purchaseButton);

        this.insertButton = new JButton("Insert");
        this.insertButton.setBounds(50, 100, 100, 30);
        this.insertButton.addActionListener(this);
        this.panel.add(insertButton);

        this.updateButton = new JButton("Update");
        this.updateButton.setBounds(160, 100, 100, 30);
        this.updateButton.addActionListener(this);
        this.panel.add(updateButton);

        this.deleteButton = new JButton("Delete");
        this.deleteButton.setBounds(270, 100, 100, 30);
        this.deleteButton.addActionListener(this);
        this.panel.add(deleteButton);

        this.backButton = new JButton("Back");
        this.backButton.setBounds(50, 300, 100, 30);
        this.backButton.addActionListener(this);
        this.panel.add(backButton);

        this.purchaseDetailsArea = new JTextArea();
        this.purchaseDetailsArea.setBounds(50, 150, 600, 130);
        this.purchaseDetailsArea.setEditable(false);
        this.panel.add(purchaseDetailsArea);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();

        if (command.equals("Estimate"))
        {
            String selectedMedicine = (String) medicineComboBox.getSelectedItem();
            String quantity = quantityField.getText();

            String purchaseDetails = simulatePurchase(selectedMedicine, quantity);

            purchaseDetailsArea.setText(purchaseDetails);
        }
        else if (command.equals("Insert"))
        {
            insertMedicine();
        }
        else if (command.equals("Update"))
        {
            updateMedicine();
        }
        else if (command.equals("Delete"))
        {
            deleteMedicine();
        }
        else if (command.equals("Back"))
        {
            CustomerHomeFrame chf = new CustomerHomeFrame();
            chf.setVisible(true);
            this.setVisible(false);
        }
    }

    private String simulatePurchase(String medicine, String quantity)
    {
        int qty;
        try {
            qty = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            return "Invalid quantity entered. Please enter a valid number.";
        }

        if (qty <= 0)
        {
            return "Quantity must be greater than zero.";
        }

        int selectedIndex = medicineComboBox.getSelectedIndex();
        int pricePerUnit = prices[selectedIndex];

        int totalCost = pricePerUnit * qty;

        return "Medicine: " + medicine + "\nQuantity: " + qty + "\nPrice per Unit: $" + pricePerUnit + "\nTotal Cost: $" + totalCost;
    }

    private void insertMedicine()
    {
        if (medicineCount >= medicines.length)
        {
            JOptionPane.showMessageDialog(this, "No space for new medicines.");
            return;
        }

        String newMedicine = JOptionPane.showInputDialog(this, "Enter new medicine name:");
        if (newMedicine != null && !newMedicine.isEmpty())
        {
            String priceInput = JOptionPane.showInputDialog(this, "Enter price for " + newMedicine + ":");
            try {
                int newPrice = Integer.parseInt(priceInput);
                medicines[medicineCount] = newMedicine;
                prices[medicineCount] = newPrice;
                medicineComboBox.addItem(newMedicine);
                medicineCount++;
                JOptionPane.showMessageDialog(this, newMedicine + " added successfully!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid price entered. Operation canceled.");
            }
        }
    }

    private void updateMedicine()
    {
        int selectedIndex = medicineComboBox.getSelectedIndex();
        if (selectedIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "No medicine selected.");
            return;
        }

        String updatedName = JOptionPane.showInputDialog(this, "Enter new name for the medicine:", medicines[selectedIndex]);
        if (updatedName != null && !updatedName.isEmpty())
        {
            medicines[selectedIndex] = updatedName;
            medicineComboBox.insertItemAt(updatedName, selectedIndex);
            medicineComboBox.removeItemAt(selectedIndex + 1);
            medicineComboBox.setSelectedIndex(selectedIndex);

            String priceInput = JOptionPane.showInputDialog(this, "Enter new price for " + updatedName + ":", prices[selectedIndex]);
            try {
                int newPrice = Integer.parseInt(priceInput);
                prices[selectedIndex] = newPrice;
                JOptionPane.showMessageDialog(this, updatedName + " updated successfully!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid price entered. Operation canceled.");
            }
        }
    }

    private void deleteMedicine()
    {
        int selectedIndex = medicineComboBox.getSelectedIndex();
        if (selectedIndex == -1)
        {
            JOptionPane.showMessageDialog(this, "No medicine selected.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + medicines[selectedIndex] + "?");
        if (confirm == JOptionPane.YES_OPTION)
        {
            for (int i = selectedIndex; i < medicineCount - 1; i++)
            {
                medicines[i] = medicines[i + 1];
                prices[i] = prices[i + 1];
            }
            medicineCount--;
            medicineComboBox.removeItemAt(selectedIndex);
            JOptionPane.showMessageDialog(this, "Medicine deleted successfully!");
        }
    }
}
