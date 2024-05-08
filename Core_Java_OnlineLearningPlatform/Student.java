package onkar.Core_Java_OnlineLearningPlatform;

public class Student extends User{
	boolean assignment;

	public Student(String username, String Courses, String email,boolean assignment) {
		super(username, Courses, email);
		this.assignment=assignment;
	}
	
	public void StudentDetails() {
		System.out.println("******* Student Details*******");
        super.userDetails();
        if (assignment == true) {
        	System.out.println("\nCompleted assignment\n");			
		}else {
			System.out.println("\nAssignment not Completed\n");
		}
        
	}

}
