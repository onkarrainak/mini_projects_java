package onkar.Core_Java_OnlineLearningPlatform;

public class Teacher extends User {
	String Study_Materials;

	public Teacher(String username, String Courses, String email,String Study_Materials) {
		super(username, Courses, email);
		this.Study_Materials = Study_Materials;
	}
	
	public void teacherdetails()
    {
        System.out.println("\n******* Teacher Details*******");
        super.userDetails();
        System.out.println("\n"+ Study_Materials +" notes providing" + "\n");
    }

}
