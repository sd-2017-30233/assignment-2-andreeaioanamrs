package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Addition.BookOperations;
import Addition.Report;
import Addition.ReportFactory;
import Addition.UserOperations;
import Model.Book;
import Model.User;
import View.Information;
import View.UpdateBook;
import View.UpdateUser;
import View.AddBook;
import View.AddUser;
import View.AdministratorView;
import View.DeleteBook;
import View.DeleteUser;

public class AdministratorController {
	AdministratorView aView;
	Information iView;
	String title,author,genre,quantity,price;
	String username,password,name,cnp;

	boolean apasat;
	
	public AdministratorController(AdministratorView aView){
		this.aView = aView;
		this.aView.addAddBookListener(new AddBookListener());
		this.aView.addUpdateBookListener(new UpdateBookListener());
		this.aView.addDeleteBookListener(new DeleteBookListener());
		this.aView.addViewBooksListener(new ViewBooksListener());
		this.aView.addAddUserListener(new AddUserListener());
		this.aView.addUpdateUserListener(new UpdateUserListener());
		this.aView.addDeleteUserListener(new DeleteUserListener());
		this.aView.addViewUserListener(new ViewUserListener());
		this.aView.addGenerateReportListener(new GenerateReportListener() );
	}

private class AddBookListener implements ActionListener{
	AddBook panel;
	@Override
	public void actionPerformed(ActionEvent e){
		panel = new AddBook();
		iView = new Information();
		iView.setPanel(panel);
		iView.afisare();
		panel.adaugareCarteListener(new adaugat());
}

private class adaugat implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		title = panel.getTextTitle();
		author = panel.getTextAuthor();
		genre = panel.getTextGenre();
		quantity = panel.getTextQuantity();
		price = panel.getTextPrice();
		System.out.println(title+" "+author+" "+genre+" "+" "+quantity+" "+price);
		if( title == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(author == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if (genre == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(quantity == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(price == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else BookOperations.addBook(new Book(title,author,genre,Integer.parseInt(quantity),Double.parseDouble(price)));	
		}
}
}

private class UpdateBookListener implements ActionListener{
	UpdateBook panel;
	@Override
	public void actionPerformed(ActionEvent e){
		panel = new UpdateBook();
		iView = new Information();
		iView.setPanel(panel);
		iView.afisare();
		panel.addUpdateBookListener(new adaugat());
}

private class adaugat implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		title = panel.getTextTitle();
		author = panel.getTextAuthor();
		quantity = panel.getTextQuantity();
		price = panel.getTextPrice();
		if( title == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(author == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(quantity == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(price == null) JOptionPane.showMessageDialog(null, "All fields are required!");
		else BookOperations.updateBook(title,author,quantity,price);	
		}
}
}


private class DeleteBookListener implements ActionListener{
	DeleteBook panel;
	@Override
	public void actionPerformed(ActionEvent e){
		 panel = new DeleteBook();
		iView = new Information();
		iView.setPanel(panel);
		iView.afisare();
		panel.addDeleteBookListener(new Optiune());
}

private class Optiune implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		name = panel.getTextField();
		if (!name.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else BookOperations.deleteBook(name);	
		}
}}


private class AddUserListener implements ActionListener{
	AddUser panel;
	@Override
	public void actionPerformed(ActionEvent e){
		panel = new AddUser();
		iView = new Information();
		iView.setPanel(panel);
		iView.afisare();
		panel.adaugareUserListener(new Optiune());
}

private class Optiune implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		username = panel.getTextUsername();
		password = panel.getTextPassword();
		name = panel.getTextName();
		cnp = panel.getTextCNP();
		if( !username.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(!password.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if (!name.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(!quantity.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(!price.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else UserOperations.addUser(new User(username,password,name,cnp));	
		}
}}



private class ViewBooksListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		ArrayList<Book> allBooks = BookOperations.getBooks();
		for(Book bok : allBooks)
			aView.getTextArea().append(bok.prettyPrint()+"\n");;
}
}

private class UpdateUserListener implements ActionListener{
	UpdateUser panel;
	@Override
	public void actionPerformed(ActionEvent e){
		panel = new UpdateUser();
		iView = new Information();
		iView.setPanel(panel);
		iView.afisare();
		panel.updateUserListener(new Optiune());
}

private class Optiune implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		username = panel.getTextUsername();
		password = panel.getTextPassword();
		name = panel.getTextName();
		if( !username.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if(!password.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else if (!name.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else UserOperations.updateUser(username,password,name);	
		}
}}

private class DeleteUserListener implements ActionListener{
	DeleteUser panel;
	@Override
	public void actionPerformed(ActionEvent e){
		panel = new DeleteUser();
		iView = new Information();
		iView.setPanel(panel);
		iView.afisare();
		panel.deleteUserListener(new Optiune());
}

private class Optiune implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		username = panel.getTextUsername();
		if( !username.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else UserOperations.deleteUser(username);	
		}
}}

private class ViewUserListener implements ActionListener{
	DeleteUser panel;
	@Override
	public void actionPerformed(ActionEvent e){
		panel = new DeleteUser();
		iView = new Information();
		iView.setPanel(panel);
		iView.afisare();
		panel.deleteUserListener(new Optiune());
}

private class Optiune implements ActionListener{
	User x;
	@Override
	public void actionPerformed(ActionEvent e){
		username = panel.getTextUsername();
		if( !username.equals("")) JOptionPane.showMessageDialog(null, "All fields are required!");
		else 
			x = UserOperations.getUser(username);
		if(x == null ) aView.getTextArea().setText("The User doesn't exist!");
		else aView.getTextArea().setText(x.prettyPrint());
		}
}}

private class GenerateReportListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println(aView.getComboBokOption());
		Report report = ReportFactory.makeReport(aView.getComboBokOption());
		try {
			report.generateReport();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}}
}