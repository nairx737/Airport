import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.oracle.jrockit.jfr.Transition.From;
import static com.oracle.jrockit.jfr.Transition.To;

/**
 * Created by Nairi.Sargsyan on 02.06.17.
 */
@WebServlet(name = "result")
public class result extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String FlyFrom= request.getParameter("FlyFrom");
        String FlyTO=request.getParameter("FlyTO");
        String Departing=request.getParameter("Departing");
        String Price=request.getParameter("Price");

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date DepartingDate= sdf.parse(Departing);
//            out.print(DepartingDate+"<br>");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airport", "root", "1111");
            Statement statement = connection.createStatement();
            String query="INSERT INTO airport.flights(FlyFrom, FlyTo, Departing, Price)" +
                    " VALUES ("+FlyFrom+","+FlyTO+","+Departing+","+Price+")";
            statement.executeUpdate(query);

//            ResultSet resultSet = statement.executeQuery("SELECT seller FROM shop");
//            String s = "";
//            while (resultSet.next()) {
//                s += resultSet.getString("seller") + "<br>";
//            }
//            out.println(s);


        } catch (SQLException e) {
            e.printStackTrace();
        }

out.println("<p> Successful");

    }

}
