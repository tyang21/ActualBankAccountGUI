import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JPanel
{
		public Welcome()
	{
		setBounds(0,0,600,600);
		setLayout(new GridBagLayout());
		setVisible(true);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lab = new JLabel("Welcome to the Tyler Bank Oppurating system");
		add(lab,gbc);
		
		
		
	}
}



