package controllers ;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import models.Platform ;
import java.util.* ;

public class EncryptedRecords extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession() ;
		
		ArrayList<Platform> records = Platform.collectRecords() ;
		
		request.setAttribute("records",records) ;
		request.getRequestDispatcher("show.jsp").forward(request,response) ;
	}
}