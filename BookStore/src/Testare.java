import Controller.AdministratorController;
import Controller.UserController;
import Model.User;
import View.AdministratorView;
import View.Information;
import View.UserView;

public class Testare {
	public static void main(String args[]){
//		AdministratorView aView = new AdministratorView();
//		AdministratorController aController = new AdministratorController(aView);
		UserView uView = new UserView();
		UserController uController = new UserController(uView,new User("test","123","Test User","CNP TEST"));
	}
}
