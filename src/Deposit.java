import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Deposit extends JPanel
{
	public Deposit(ArrayList<BankAccount> acclist)
	{
		setBounds(0,0,600,600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel accnum = new JLabel("Account Number");
		add(accnum, gbc);
		gbc.gridx = 1;
		JTextField accnumtxt = new JTextField();
		accnumtxt.setPreferredSize(new Dimension(100,30));
		add(accnumtxt, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel amount = new JLabel("Amount Deposited");
		add(amount,gbc);
		gbc.gridx = 1;
		JTextField amounttxt = new JTextField();
		amounttxt.setPreferredSize(new Dimension(100,30));
		add(amounttxt, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		JButton deposit = new JButton("Deposit");
		add(deposit, gbc);
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(isNumeric(amounttxt.getText()))
				{
						acclist.get(Integer.parseInt(accnumtxt.getText())).deposit(Integer.parseInt(amounttxt.getText()));
						accnumtxt.setText("");
						amounttxt.setText("");
				}
				
				
			}
		});
		
				
		
		
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

