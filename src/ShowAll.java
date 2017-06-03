import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "ShowAll")
public class ShowAll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airport", "root", "1111");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TABLE_NAME ");
            String s = "";
            while (resultSet.next()) {
                s += resultSet.getString("FlyFrom") + "<br>";
            }
            out.println(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
