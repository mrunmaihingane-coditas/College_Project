import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@MultipartConfig
@WebServlet("/Hello")
public class Hello extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext sr = getServletContext();

        Part file = request.getPart("profile-image");
        String imageFileName = file.getSubmittedFileName();
        String uploadPath = "C:/Users/Coditas/IdeaProjects/Project_College/src/main/webapp/Images/"+imageFileName;

        FileOutputStream fs = new FileOutputStream(uploadPath);
        InputStream is = file.getInputStream();

        byte[] data = new byte[is.available()];
        is.read(data);
        fs.write(data);
        fs.close();



        try {
            Class.forName(sr.getInitParameter("driver"));
            Connection con = DriverManager.getConnection(sr.getInitParameter("url"), sr.getInitParameter("username"), sr.getInitParameter("password"));
            out.println("JDBC Connection Done");
            out.println("<br>");
            out.println("<br>");
            PreparedStatement ps = con.prepareStatement("insert into pictures (pictures) values(?)");

            ps.setString(1,imageFileName);

            ps.executeUpdate();


            response.sendRedirect("ProfileServlet");


//



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

}