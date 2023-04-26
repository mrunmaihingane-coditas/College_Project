import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/display")
public class display extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id3 = Integer.parseInt(req.getParameter("id3"));

        PrintWriter out=resp.getWriter();
        ServletContext context = getServletContext();
        resp.setContentType("text/html");


        try {
            Class.forName(context.getInitParameter("driver"));
            Connection con = DriverManager.getConnection(context.getInitParameter("url"),
                    context.getInitParameter("username"), context.getInitParameter("password"));

             PreparedStatement ps=con.prepareStatement("select*from pictures where id=?");
             ps.setInt(1,id3);

            ResultSet rs=ps.executeQuery();
            while(rs.next()){
//
                int id = rs.getInt(1);
                String image=rs.getString(2);
                out.println("<h2>Image Id :" + id + "</h2>");
                out.println("<img src = 'Images/"+image+"' width='700' height='500'>");




            }


        }
        catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    }

