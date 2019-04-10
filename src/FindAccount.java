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

public class FindAccount extends JPanel
{
	public FindAccount(ArrayList<BankAccount> acclist)
	{
		setBounds(0,0,600,600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel name = new JLabel("Name:");
		add(name, gbc);
		gbc.gridx = 1;
		JTextField nametxt = new JTextField();
		nametxt.setPreferredSize(new Dimension(100,30));
		add(nametxt, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton find = new JButton("Find Accounts");
		add(find, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel display = new JLabel("");
		add(display, gbc);
		find.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String name1 = "";
						for(BankAccount a : acclist)
						{
							if(a.getName().equals(nametxt.getText()))
							{
								name1 = name1 +  a.toString();
								nametxt.setText("");
							}
						}
						display.setText(name1);
						
					}
				});
		
	}
}
