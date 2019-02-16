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
@WebServlet(urlPatterns = {"/ResultIfsc"})
public class ResultIfsc extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
          
           String ifsc=request.getParameter("ifsc");
         
        try {
            Connection con = DriverManager.getConnection("jdbc:odbc:worcester");  
            PreparedStatement s = con.prepareStatement("SELECT [BANK] FROM [Sheet1$] WHERE [IFSC] = ?");
                s.setString(1, ifsc); 
                s.execute();
                ResultSet rs = s.getResultSet();
            if (rs!=null) {
                while (rs.next()) {
                    out.println(rs.getString("BANK"));
                       }
                   }
 
            s.close();
            con.close();
 
            } catch (Exception ex) {
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
