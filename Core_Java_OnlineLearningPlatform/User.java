package onkar.Core_Java_OnlineLearningPlatform;

public class User {
	private String username;
    private String Courses;
    private String email;
	
    
    public User(String username, String Courses, String email) {
		this.username = username;
		this.Courses = Courses;
		this.email = email;
	}
    public void userDetails() {
    	System.out.print("Username " + username + "\n" + "Courses " + Courses + "\n" +"Email " + email + "\n" );
		
	}

}
