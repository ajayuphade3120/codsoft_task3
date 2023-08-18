package Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayStudentServlet")
public class DisplayStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve student data from the database
        List<Student> allStudents = retrieveAllStudentsFromDatabase();

        // Add the list of students to the request attributes
        request.setAttribute("studentsList", allStudents);

        // Forward to display_student.jsp for rendering
        request.getRequestDispatcher("display_student.jsp").forward(request, response);
    }

    private List<Student> retrieveAllStudentsFromDatabase() {
        List<Student> allStudents = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Initialize the database connection
        	String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "Root@123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            // Prepare the SQL statement to retrieve all students from the database
            String sql = "SELECT * FROM students";
            preparedStatement = connection.prepareStatement(sql);

            // Execute the query and retrieve the results
            resultSet = preparedStatement.executeQuery();

            // Process the results and create Student objects
            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setRollNumber(resultSet.getInt("rollnumber"));
                student.setGrade(resultSet.getString("grade"));
                // Add other relevant attributes

                allStudents.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle database errors appropriately
        } finally {
            // Close resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return allStudents;
    }
}

