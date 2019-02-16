import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author manoj
 */
@WebServlet(urlPatterns = {"/ResultName"})
public class ResultName extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();  
        
         String name=request.getParameter("name"); 
         String city=request.getParameter("city");
          try {
             Connection con = DriverManager.getConnection("jdbc:odbc:worcester");  
             PreparedStatement s = con.prepareStatement("SELECT * FROM [Sheet1$] WHERE [BANK] = ? and [CITY] = ?");
               s.setString(1, name); 
               s.setString(2, city);
               s.execute();
             ResultSet rs = s.getResultSet();
             if (rs!=null) {
                
                out.println("<table border=2>");
                out.println("<tr>");
                out.println("<td>PCode</td>");
                out.println("<td>Name</td>");
                out.println("<td>Desc</td>");
                out.println("<td>Catg</td>");
                out.println("<td>Price</td>");
                out.println("<td>Rem</td>");
                out.println("</tr>");
                
                  while (rs.next()) {
                     String s1=rs.getString(1);
                     String s2=rs.getString(2);
                     String s3=rs.getString(3);
                     String s4=rs.getString(4);
                     String s5=rs.getString(5);
                     String s6=rs.getString(6);
                     String s7=rs.getString(7);
                     String s8=rs.getString(8);
                     
                     out.println("<tr>");
                     out.println("<td>"+s1+"</td>");
                     out.println("<td>"+s2+"</td>");
                     out.println("<td>"+s3+"</td>");
                     out.println("<td>"+s4+"</td>");
                     out.println("<td>"+s5+"</td>");
                     out.println("<td>"+s6+"</td>");
                     out.println("<td>"+s7+"</td>");
                     out.println("<td>"+s8+"</td>");
                     out.println("</tr>");
                      }
                   
                     out.println("</table>");
                 }
 
               s.close();
               con.close();
 
        }catch (Exception ex) {
            out.print("Exception: ");
            out.println(ex.getMessage());
        }
        
 }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
