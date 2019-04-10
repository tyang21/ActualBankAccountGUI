import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Accounts extends JPanel
{
	private static final double OVER_DRAFT_FEE = 15;
	private static double RATE = .0025;
	private static final double TRANSACTION_FEE = 1.5;
	private static final double MIN_BAL = 300;
	private static final double MIN_BAL_FEE = 10;
	private static final int FREE_TRANSACTIONS = 10;
	
	public Accounts(ArrayList<BankAccount> acclist)
	{
		setBounds(0,0,600,600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel name = new JLabel("Enter Name: ");
		add(name,gbc);
		gbc.gridx = 1;
		JTextField nametxt = new JTextField();
		nametxt.setPreferredSize(new Dimension(100,30));
		add(nametxt,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel dep = new JLabel("Enter Initial Deposit");
		add(dep,gbc);
		gbc.gridx = 1;
		JTextField deptxt = new JTextField();
		deptxt.setPreferredSize(new Dimension(100,30));
		add(deptxt,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel acctype = new JLabel("Choose Menu Type");
		add(acctype,gbc);
		gbc.gridx = 1;
		String[] choices = {"Savings Account", "Checkings Account"};
		JComboBox<String> type = new JComboBox<String>(choices);
		add(type,gbc);
		String x  = type.getSelectedItem().toString();
		
		setVisible(true);
	gbc.gridx = 0;
	gbc.gridy = 3;
	JButton create = new JButton("Create");
	create.addActionListener(new ActionListener()
			{
				public void actionPerformed (ActionEvent e)
				{
					if(isNumeric(deptxt.getText()))
					{
						if(x.equals("Checkings Account"))
						{
							BankAccount b = new CheckingAccount(nametxt.getText(),Double.parseDouble(deptxt.getText()),OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS);
							acclist.add(b);
							nametxt.setText("");
							deptxt.setText("");
						}
						if(x.equals("Savings Account"))
						{
							BankAccount b = new SavingsAccount(nametxt.getText(),Double.parseDouble(deptxt.getText()),RATE, MIN_BAL, MIN_BAL_FEE);
							acclist.add(b);
							nametxt.setText("");
							deptxt.setText("");
						}
					}
				}
			});
	add(create, gbc); 
		
		
		
		
		
	}
	private static boolean isNumeric(String str)
	{
		try
		{
				Double.parseDouble(str);
				return true;
		}
		catch(IllegalArgumentException e)
		{
				return false;
		}
	}
	

}
