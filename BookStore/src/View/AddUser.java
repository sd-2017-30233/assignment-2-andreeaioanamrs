package View;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddUser extends JPanel {
	JTextField textUsername,textPassword,textName,textCNP;
	JButton btnAddUser;

	public AddUser() {
		this.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(17, 6, 75, 16);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(17, 34, 61, 16);
		add(lblPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(17, 62, 61, 16);
		add(lblName);
		
		JLabel lblCNP = new JLabel("CNP");
		lblCNP.setBounds(17, 90, 61, 16);
		add(lblCNP);
	
		textUsername = new JTextField();
		textUsername.setBounds(104, 1, 199, 26);
		add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(104, 29, 199, 26);
		add(textPassword);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(104, 57, 199, 26);
		add(textName);
		
		textCNP = new JTextField();
		textCNP.setColumns(10);
		textCNP.setBounds(104, 85, 199, 26);
		add(textCNP);
		
		btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(104, 113, 199, 26);
		add(btnAddUser);
	}

	public String getTextUsername() {
		return this.textUsername.getText();
	}
	public String getTextPassword() {
		return this.textPassword.getText();
	}
	public String getTextName() {
		return this.textName.getText();
	}
	public String getTextCNP() {
		return this.textCNP.getText();
	}
	public void adaugareUserListener(ActionListener a){
		btnAddUser.addActionListener(a);
	}

}
