package gui;

import javax.swing.JTextField;

import hsa2.GraphicsConsole;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class SignUpDialog extends JDialog implements ActionListener
{
	JTextField usernameField = new JTextField();
	JTextField passwordField = new JTextField();
	JButton submit = new JButton("submit");
	
	
	JPanel panel = new JPanel(new GridLayout(3,1));
	
	public SignUpDialog()
	{
		this.setSize(400, 400);
		this.setVisible(true);
		
		usernameField.setSize(200, 20);
		passwordField.setSize(200, 20);
		submit.setSize(100, 50);
		
		panel.add(usernameField);
		panel.add(passwordField);
		panel.add(submit);
		
		this.add(panel);
	}
	
	public String[] getCredentials()
	{
		
		Object[] fields = {"Username: ", usernameField, "Password: ", passwordField};
		int option = JOptionPane.showConfirmDialog(null, fields, "Sign Up", JOptionPane.OK_CANCEL_OPTION);
		String[] credentials = new String[2]; //The user's specified username and password.
		
		if(option == JOptionPane.OK_OPTION)
		{
			credentials[0] = usernameField.getText();
			credentials[1] = passwordField.getText();
		}
		else
		{
			credentials[0] = null;
			credentials[1] = null;
		}
		
		return credentials;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
