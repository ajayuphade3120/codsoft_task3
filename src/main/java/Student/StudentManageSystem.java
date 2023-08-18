package Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManageSystem {
    private List<Student> students;

    public StudentManageSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        // Implement adding a student to the list
    }

    public void removeStudent(int rollnumber) {
        // Implement removing a student from the list based on roll number
    }

    public static  Student searchStudent(int rollnumber) {
		return null;
        // Implement searching for a student based on roll number and return the student object
    }

    public List<Student> getAllStudents() {
        // Implement returning the list of all students
        return students;
    }

	public static StudentManageSystem getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

    // Implement other methods as required, such as read/write data from storage
}
