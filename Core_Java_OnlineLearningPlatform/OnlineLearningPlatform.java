package onkar.Core_Java_OnlineLearningPlatform;

public class OnlineLearningPlatform {
	public static void main(String args[]) {
	Student stu = new Student("Onkar", "java", "Onkar@.com",true);
	stu.StudentDetails();
	
	Teacher teacher = new Teacher("Rainak", "Java", "Rainak@.com","JAVA" );
	teacher.teacherdetails();
	
	ClassMonitor monitor = new ClassMonitor("omu", "Java", "omu@.com",true);
	monitor.classMonitorDetails();
		
	}

}

