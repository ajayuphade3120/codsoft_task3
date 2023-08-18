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

@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchRollNumberStr = request.getParameter("searchRollNumber");

        // Perform input validation, e.g., check if required fields are not empty
        if (searchRollNumberStr.isEmpty()) {
            // Handle the error, display an error message, or redirect back to the search_student.jsp with an error message
            response.sendRedirect("search_student.jsp?error=Please enter a roll number to search.");
            return;
        }

        int searchRollNumber = Integer.parseInt(searchRollNumberStr);

        // Perform the search in the database
        List<Student> searchedStudents = searchStudentsByRollNumber(searchRollNumber);

        // Set the search results as a request attribute
        request.setAttribute("searchedStudents", searchedStudents);

        // Forward the request to the search_student.jsp page for rendering
        request.getRequestDispatcher("display_student.jsp").forward(request, response);
    }

    private List<Student> searchStudentsByRollNumber(int rollNumber) {
        List<Student> searchedStudents = new ArrayList<>();
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

            // Prepare the SQL statement to search for students with the given roll number
            String sql = "SELECT * FROM students WHERE rollnumber = ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, rollNumber);

            // Execute the query and retrieve the results
            resultSet = preparedStatement.executeQuery();

            // Process the results and create Student objects
            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setRollNumber(resultSet.getInt("rollnumberstr"));
                student.setGrade(resultSet.getString("grade"));
                // Add other relevant attributes

                searchedStudents.add(student);
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

        return searchedStudents;
    }
}
