package controllers ;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import models.Platform ;
import java.util.* ;
import models.SaveToFile ;

public class DecryptServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String newPin = request.getParameter("pass") ;
		String nextPage = "show.jsp" ;

		if( newPin.equals("149900") ){
			HttpSession session = request.getSession() ;
			
			ArrayList<Platform> rec = Platform.decryptRecords() ;
			ArrayList<String> passList = SaveToFile.collectPassword() ;
			
			session.setAttribute("newPin",newPin) ;
			session.setAttribute("rec",rec) ;
			session.setAttribute("passList",passList) ;
			
			nextPage = "decrypt_pass.jsp" ;
			request.getRequestDispatcher(nextPage).forward(request,response) ;
		}
		else{
			request.getRequestDispatcher(nextPage).forward(request,response) ;
		}
	}
}