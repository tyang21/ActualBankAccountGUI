import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Overall extends JFrame
{
	
	public Overall()
	{
		ArrayList<BankAccount> acclist = new ArrayList<BankAccount>();
		CardLayout cl = new CardLayout();
		JPanel big  = new JPanel();
		big.setLayout(cl);
		add(big);
		setBounds(0, 0, 600, 600);
		
		Welcome w = new Welcome();
		big.add(w, "Home");
		cl.show(big, "Home");
		
		Accounts a = new Accounts(acclist);
		big.add(a, "Create Accounts");
		
		RemoveAccount r = new RemoveAccount(acclist);
		big.add(r, "Remove Accounts");
		
		FindAccount f = new FindAccount(acclist);
		big.add(f, "Find Accounts");
		
		Deposit d = new Deposit(acclist);
		big.add(d, "Deposit");
		
		JMenuBar m = new JMenuBar();
		JMenu acc = new JMenu("Accounts");
		JMenuItem ca = new JMenuItem("Create Accounts");
		acc.add(ca);
		ca.addActionListener(new ActionListener()
				{
					public void actionPerformed (ActionEvent e)
					{
						cl.show(big, "Create Accounts");
					}
				});
		JMenuItem ra = new JMenuItem("Remove Accounts");
		acc.add(ra);
		ra.addActionListener(new ActionListener()
				{
					public void actionPerformed (ActionEvent e)
					{
						cl.show(big, "Remove Accounts");
					}
				});
		JMenuItem fa = new JMenuItem("Find Accounts");
		acc.add(fa);
		fa.addActionListener(new ActionListener() 
				{
					public void actionPerformed (ActionEvent e)
					{
						cl.show(big, "Find Accounts");
					}
			
				});	
		m.add(acc);
		JMenu tra = new JMenu("Transactions");
		JMenuItem dep = new JMenuItem("Deposit");
		tra.add(dep);
		dep.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e)
			{
				cl.show(big, "Deposit");
			}
		});
		JMenuItem wit = new JMenuItem("Withdraw");
		tra.add(wit);
		JMenuItem tran = new JMenuItem("Transfer");
		tra.add(tran);
		JMenuItem get = new JMenuItem("Get Balance");
		tra.add(get);
		m.add(tra);
		setJMenuBar(m);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	public static void main(String[] args)
	{
		new Overall();
	}
}
