package model;

public class Comments {
	int id;
	String myUser;
	String email;
	String webpage;
	String date;
	String comments;
	
	public Comments(int id, String myUser, String email, String webpage, String date, String comm) {
		
		this.id=id;
		this.myUser=myUser; this.email=email; 
		this.webpage=webpage;
		this.date=date;
		this.comments=comm;
	}
	public void setId(int id) {
		this.id=id;
		
	}
	public void setUser(String user) {
		this.myUser=user;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setWebpage(String webpage) {
		this.webpage=webpage;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public void setComm(String comments) {
		this.comments=comments;
	}
	public int getId() {
		return this.id;
	}
	
	public String getUser() {
		return this.myUser;
	}
	public String getEmail() {
		return this.email;
	}
	public String getWebpage() {
		return this.webpage;
	}
	public String getDate() {
		return this.date;
	}
	public String getComm() {
		return this.comments;
	}

}
