import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Employeekarki;
import util.UtilDBkarki;

@WebServlet("/MyServletHibernateDBkarki")
public class MyServletHibernateDBkarki extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateDBkarki() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
      UtilDBkarki.createEmployees("Jack", "Huskey", "jhuskey123", "jhusky@gmail.com","abc1234");
      UtilDBkarki.createEmployees("Matt", "Ryan", "mryan234", "mryan@gmail.com", "cde1234 ");
      UtilDBkarki.createEmployees("AB", "Devillers", "adeviller445", "adeviller445@gmail.com", "fgh1234");
      
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Employeekarki> listEmployees = UtilDBkarki.listEmployees();
      for (Employeekarki employeekarki : listEmployees) {
         System.out.println("[DBG] " + employeekarki.getId() + ", " //
               + employeekarki.getFirstName() + ", " //
               + employeekarki.getLastName() + ", " 
               + employeekarki.getUserName() + ", " 
               + employeekarki.getEmail() + ", " 
               + employeekarki.getPassword());

         out.println("<li>" + employeekarki.getId() + ", " //
        		+ employeekarki.getFirstName() + ", " //
                + employeekarki.getLastName() + ", " 
                + employeekarki.getUserName() + ", " 
                + employeekarki.getEmail() + ", " 
                + employeekarki.getPassword() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
      
   }
}
