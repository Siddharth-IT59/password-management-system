package controllers ;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession ;
import java.io.IOException;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String pin = request.getParameter("pin") ;
		String nextPage = "index.jsp" ;

		if(pin.equals("542600")){
			HttpSession session = request.getSession() ;
			session.setAttribute("pin",pin) ;
			nextPage = "save_password.jsp" ;
			request.getRequestDispatcher(nextPage).forward(request,response) ;
		}
		else{
			request.getRequestDispatcher("index.jsp").forward(request,response) ;
		}
	}
}