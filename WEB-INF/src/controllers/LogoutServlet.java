package controllers ;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

public class LogoutServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession() ;
		session.removeAttribute("pin") ;
		session.removeAttribute("newPin") ;
		session.invalidate() ;
		response.sendRedirect("index.jsp") ;
	}
}