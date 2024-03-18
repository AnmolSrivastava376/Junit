package authPackage;

public class User {
	private String username, email, password;
	public User (String username, String email, String password) {
		this.username=username;
		this.email=email;
		this.password=password;
	}
	public String getUsername() {
		return this.username;
	}
	public String getUserEmail() {
		return this.email;
	}
	public String getUserPassword() {
		return this.password;
	}
	public void setUsername(String newName) {
		this.username=newName;
	}
	public void setUserEmail(String newEMail) {
		this.email=newEMail;
	}
	public void setUserPassword(String newPass) {
		this.password=newPass;
	}
}
