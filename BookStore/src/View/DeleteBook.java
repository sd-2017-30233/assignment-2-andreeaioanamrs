package View;

import javax.swing.JPanel;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DeleteBook extends JPanel {
	private JTextField textField;
	JButton btnDelete;
	public DeleteBook() {
		this.setLayout(null);
		
		 btnDelete = new JButton("Delete");
		btnDelete.setBounds(94, 108, 117, 29);
		add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(84, 70, 136, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setBounds(118, 42, 76, 16);
		add(lblBookTitle);
	}
	
	public String getTextField(){
		return textField.getText();
	}
	
	public void addDeleteBookListener(ActionListener a) {
		btnDelete.addActionListener(a);
	}
	
}
