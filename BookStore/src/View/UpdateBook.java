package View;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateBook extends JPanel {

		public JTextField textTitle;
		public JTextField textAuthor;
		public JTextField textGenre;
		public JTextField textQuantity;
		public JTextField textPrice;
		public JButton btnUpdateBook ;
		public UpdateBook() {
			this.setLayout(null);
			
			JLabel lblTitle = new JLabel("Title");
			lblTitle.setBounds(17, 6, 61, 16);
			add(lblTitle);
			
			JLabel lblAuthor = new JLabel("Author");
			lblAuthor.setBounds(17, 34, 61, 16);
			add(lblAuthor);
			
			JLabel lblQuantity = new JLabel("Quantity");
			lblQuantity.setBounds(17, 90, 61, 16);
			add(lblQuantity);
			
			JLabel lblPrice = new JLabel("Price");
			lblPrice.setBounds(17, 118, 61, 16);
			add(lblPrice);
			
			textTitle = new JTextField();
			textTitle.setBounds(104, 1, 199, 26);
			add(textTitle);
			textTitle.setColumns(10);
			
			textAuthor = new JTextField();
			textAuthor.setColumns(10);
			textAuthor.setBounds(104, 29, 199, 26);
			add(textAuthor);
			
			textQuantity = new JTextField();
			textQuantity.setColumns(10);
			textQuantity.setBounds(104, 85, 199, 26);
			add(textQuantity);
			
			textPrice = new JTextField();
			textPrice.setColumns(10);
			textPrice.setBounds(104, 113, 199, 26);
			add(textPrice);
			
			btnUpdateBook = new JButton("Update Book");
			btnUpdateBook.setBounds(144, 141, 117, 29);
			add(btnUpdateBook);
		}
		
		public String getTextTitle(){
			return this.textTitle.getText();
		}
		
		public String getTextAuthor(){
			return this.textAuthor.getText();
		}
		
		public String getTextQuantity(){
			return this.textQuantity.getText();
		}
		
		public String getTextPrice(){
			return this.textPrice.getText();
		}
		
		public JButton getOperationButton(){
			return this.btnUpdateBook;
		}
		
		public void addUpdateBookListener(ActionListener a){
			btnUpdateBook.addActionListener(a);
		}
	}
