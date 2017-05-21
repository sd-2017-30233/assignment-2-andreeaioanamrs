package Model;

public class User {
	String username,password,name,CNP;
	public User(String Username,String Password,String Name,String CNP){
		this.username = Username;
		this.password = Password;
		this.name = Name;
		this.CNP = CNP;
	}
	
    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
    
    public String prettyPrint(){
    	return username+" "+password+" "+name+" "+CNP;
    }
    
    
}
