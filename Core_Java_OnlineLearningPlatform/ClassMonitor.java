package onkar.Core_Java_OnlineLearningPlatform;

public class ClassMonitor extends Student {

	public ClassMonitor(String username, String Courses, String email, boolean assignment) {
		super(username, Courses, email, assignment);

	}

	public void classMonitorDetails() {
		System.out.println("\n******* ClassMonitor Details*******");
		super.userDetails();
		if (assignment == true) {
			System.out.println("\nassignment collected information from students");
		} else {
			System.out.println("\nStudent not Completed Assignment ");
		}

	}

}
