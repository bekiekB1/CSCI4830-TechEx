import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Employeekarki;
import util.Info;
import util.UtilDBkarki;

@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	   
	  String username = request.getParameter("UserName").trim();
	  String password = request.getParameter("Password").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Login Sucessful";
    	  if(UtilDBkarki.checkPassword(username,password)) {
    	      out.println("\n"+title+"\n");
    	  }
    	  else {
    	      out.println("\n"+"Username or Password incorrect"+"\n");
    	  }
      
   }

   void display(List<Employeekarki> listEmployees, PrintWriter out) {
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
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
