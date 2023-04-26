import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    PreparedStatement ps;
    ResultSet rs;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        ServletContext context = getServletContext();
        resp.setContentType("text/html");


            try {
                Class.forName(context.getInitParameter("driver"));
                Connection con = DriverManager.getConnection(context.getInitParameter("url"),
                        context.getInitParameter("username"), context.getInitParameter("password"));
                ps=con.prepareStatement("select * from pictures");
                rs=ps.executeQuery();

                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Image</th><th>Action</th></tr>");

                while(rs.next()){
                    int id = rs.getInt(1);
                    String image=rs.getString(2);

                    out.println("<tr>");
                    out.println("<td>" + id + "</td>");
                    out.println("<td><img src='Images/"+image+"' width='50' height='50'></td>");
                    out.println("<td><a href='display?id3=" + id + "'>Show</a></td>");
                    out.println("<td><a href='delete?id3=" + id + "'>Delete</a></td>");
                    out.println("</tr>");
                }

                out.println("</table>");



            }
            catch (SQLException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }

