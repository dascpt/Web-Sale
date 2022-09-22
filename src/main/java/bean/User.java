package bean;

public class User {
	private String email = "";
	private String password = "";
	private int role;
	private String username;
	private String address;
	private String phone;

	private String message = "";

	public User() {

	}

	public User(String email, String password,int role, String username, String address, String phone) {
		this.email = email;
		this.password = password;
		this.role = role;
		this.username = username;
		this.address = address;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getMessage() {
		return message;
	}

	public boolean validate() {
		if (email == null) {
			message = "Invalid email address";
			return false;
		}
		if (password == null) {
			message = "Invalid password";
			return false;
		}
		if (!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email address";
			return false;
		}
		if (password.length() < 8) {
			message = "Password must be at least 8 characters";
			return false;
		} else if (password.matches("\\w*\\s+\\w*")) {
			message = "Password can't be contain space";
			return false;
		}
		return true;
	}
}
