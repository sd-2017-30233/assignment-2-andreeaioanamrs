package View;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteUser extends JPanel {
	JTextField textField;
	JButton btnDelete;
	public DeleteUser() {
		this.setLayout(null);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(94, 108, 117, 29);
		add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(84, 70, 136, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(118, 42, 76, 16);
		add(lblUsername);
	}
	
	public String getTextUsername() {
		return this.textField.getText();
	}
	
	public void deleteUserListener(ActionListener a){
		btnDelete.addActionListener(a);
	}

}
