package View;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class UserView {

	public JFrame frame;
	JButton btnSearch,btnSellBook;
	JComboBox comboBox;
	public JTextField textField;
	public JTextArea textArea;

	public UserView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 206);
		frame.getContentPane().setLayout(null);
		
		 btnSearch = new JButton("Search");
		btnSearch.setBounds(6, 88, 117, 29);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblSearchBookBy = new JLabel("Search book by");
		lblSearchBookBy.setBounds(16, 6, 117, 16);
		frame.getContentPane().add(lblSearchBookBy);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Genre", "Title", "Author"}));
		comboBox.setBounds(6, 29, 117, 27);
		frame.getContentPane().add(comboBox);
		
		btnSellBook = new JButton("Sell Book");
		btnSellBook.setBounds(6, 131, 117, 29);
		frame.getContentPane().add(btnSellBook);
		
		textField = new JTextField();
		textField.setBounds(6, 55, 117, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(145, 6, 383, 172);
		frame.getContentPane().add(textArea);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public String getOption(){
		return textField.getText();
	}
	
	public void addSearchByListener(ActionListener a){
		btnSearch.addActionListener(a);
	}
	
	public void addSellBookListener(ActionListener a){
		btnSellBook.addActionListener(a);
	}
	
	public String getComboBokOption(){
		return (String) comboBox.getSelectedItem();
	}
}
