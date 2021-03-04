package edu.eci.cvds.servlet.model;

public class Todo {
	private int userId;
	private int id;
	private String title;
	private boolean completed;
	
	public Todo(){
		
	}
	
	public void setUserId(int UserId) {
		userId=UserId;
	}
	
	public void setId(int Id) {
		id=Id;
	}
	
	public void setTitle(String Title) {
		title=Title;
	}
	
	public void setCompleted(boolean Completed) {
		completed=Completed;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public boolean getCompleted() {
		return completed;
	}

}
