package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class AdministratorView {

	private JFrame frmAdministratorMenu;
	JTextArea textArea;
	JComboBox comboBox;
	JButton btnAddBook,btnUpdateBook,btnDeleteBook,btnViewBooks,btnDeleteUser,btnViewUser,btnUpdateUser,btnAddUser,btnGenerate; 

	public AdministratorView() {
		initialize();
	}

	private void initialize() {
		frmAdministratorMenu = new JFrame();
		frmAdministratorMenu.setTitle("Administrator Menu");
		frmAdministratorMenu.setBounds(100, 100, 450, 480);
		frmAdministratorMenu.getContentPane().setLayout(null);
		
		btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(6, 16, 117, 29);
		frmAdministratorMenu.getContentPane().add(btnAddBook);
		
		btnUpdateBook = new JButton("Update Book");
		btnUpdateBook.setBounds(6, 47, 117, 29);
		frmAdministratorMenu.getContentPane().add(btnUpdateBook);
		
		btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setBounds(6, 81, 117, 29);
		frmAdministratorMenu.getContentPane().add(btnDeleteBook);
		
		btnViewBooks = new JButton("View Books");
		btnViewBooks.setBounds(6, 111, 117, 29);
		frmAdministratorMenu.getContentPane().add(btnViewBooks);
		
		btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBounds(171, 81, 117, 29);
		frmAdministratorMenu.getContentPane().add(btnDeleteUser);
		
		btnViewUser = new JButton("View Users");
		btnViewUser.setBounds(171, 111, 117, 29);
		frmAdministratorMenu.getContentPane().add(btnViewUser);
		
		btnUpdateUser = new JButton("Update User");
		btnUpdateUser.setBounds(171, 47, 117, 29);
		frmAdministratorMenu.getContentPane().add(btnUpdateUser);
		
		btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(171, 16, 117, 29);
		frmAdministratorMenu.getContentPane().add(btnAddUser);
		
		btnGenerate = new JButton("Generate!");
		btnGenerate.setBounds(324, 81, 109, 29);
		frmAdministratorMenu.getContentPane().add(btnGenerate);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PDF", "CSV"}));
		comboBox.setBounds(324, 48, 109, 27);
		frmAdministratorMenu.getContentPane().add(comboBox);
		
		JLabel lblReport = new JLabel("Report Type");
		lblReport.setBounds(341, 21, 84, 16);
		frmAdministratorMenu.getContentPane().add(lblReport);
		
		textArea = new JTextArea();
		textArea.setBounds(17, 152, 416, 300);
		frmAdministratorMenu.getContentPane().add(textArea);
		frmAdministratorMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmAdministratorMenu.setVisible(true);
	}
	
	public JTextArea getTextArea(){
		return this.textArea;
	}
	
	public void addAddBookListener(ActionListener a){
		btnAddBook.addActionListener(a);
	}
	
	public void addUpdateBookListener(ActionListener a){
		btnUpdateBook.addActionListener(a);
	}
	
	public void addDeleteBookListener(ActionListener a){
		btnDeleteBook.addActionListener(a);
	}
	
	public void addViewBooksListener(ActionListener a){
		btnViewBooks.addActionListener(a);
	}
	
	public void addAddUserListener(ActionListener a){
		btnAddUser.addActionListener(a);
	}
	
	public void addUpdateUserListener(ActionListener a){
		btnUpdateUser.addActionListener(a);
	}
	
	public void addDeleteUserListener(ActionListener a){
		btnDeleteUser.addActionListener(a);
	}
	
	public void addViewUserListener(ActionListener a){
		btnViewUser.addActionListener(a);
	}
	
	public void addGenerateReportListener(ActionListener a){
		btnGenerate.addActionListener(a);
	}
	
	public String getComboBokOption(){
		return (String) comboBox.getSelectedItem();
	}
}
