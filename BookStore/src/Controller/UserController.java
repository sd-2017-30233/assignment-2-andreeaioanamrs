package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Addition.BookOperations;
import Model.Book;
import Model.User;
import View.AddBook;
import View.Information;
import View.SellBook;
import View.UserView;

public class UserController {

		UserView uView;
		User _user;
		
		public UserController(UserView uView,User user){
			this.uView = uView;
			this._user = user;
			this.uView.addSearchByListener(new SearchByListener());
			this.uView.addSellBookListener(new SellBookListener());	
		}

private class SearchByListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		List<Book> list = new ArrayList<Book>();
		String by = uView.getComboBokOption();
		if (by.equals("Genre")) list = BookOperations.searchByGenre(uView.getOption());
		else if (by.equals("Title")) list = BookOperations.searchByTitle(uView.getOption());
		else if (by.equals("Author")) list = BookOperations.searchByAuthor(uView.getOption());
		uView.textArea.setText("");
		for(Book b : list)
			uView.textArea.append(b.prettyPrint()+"\n");;
	}
}

private class SellBookListener implements ActionListener{

	SellBook panel;
	@Override
	public void actionPerformed(ActionEvent e){
		panel = new SellBook();
		Information iView = new Information();
		iView.setPanel(panel);
		iView.afisare();
		panel.sellBookListener(new adaugat());
}

private class adaugat implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		String title = panel.getTextTitle();
		String author = panel.getTextAuthor();
		String genre = panel.getTextGenre();
		String quantity = panel.getTextQuantity();
		String price = panel.getTextPrice();

		if( title == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(author == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if (genre == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(quantity == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(price == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else BookOperations.sell(new Book(title,author,genre,Integer.parseInt(quantity),Double.parseDouble(price)),3,_user.getUsername());	
		}
}
}
		
		
}
