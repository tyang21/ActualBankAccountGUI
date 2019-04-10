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

public class RemoveAccount extends JPanel
{
	public RemoveAccount(ArrayList<BankAccount> acclist)
	{
		setBounds(0,0,600,600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel accnum = new JLabel("Account Number");
		add(accnum,gbc);
		gbc.gridx = 1;
		JTextField accnumtxt = new JTextField();
		accnumtxt.setPreferredSize(new Dimension(100,30));
		add(accnumtxt,gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		JButton remove = new JButton("remove");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				if(isNumeric(accnumtxt.getText()))
				{
					acclist.remove(accnumtxt.getText());
					accnumtxt.setText("");
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
