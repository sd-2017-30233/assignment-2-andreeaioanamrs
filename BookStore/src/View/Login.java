package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmLogIn;
	private JTextField usernameText;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In");
		frmLogIn.setBounds(100, 100, 450, 300);
		frmLogIn.getContentPane().setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setBounds(150, 49, 130, 26);
		frmLogIn.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(181, 21, 67, 16);
		frmLogIn.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(181, 87, 61, 16);
		frmLogIn.getContentPane().add(lblPassword);
		
		JButton Login = new JButton("Log In");
		Login.setBounds(150, 164, 130, 29);
		frmLogIn.getContentPane().add(Login);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 115, 130, 26);
		frmLogIn.getContentPane().add(passwordField);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
