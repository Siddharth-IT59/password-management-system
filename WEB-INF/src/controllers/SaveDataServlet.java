package controllers ;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import models.Platform ;
import models.SaveToFile ;

public class SaveDataServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession() ;
		String nextPage = "save_password.jsp" ;
		
		String platform = request.getParameter("platform") ;
		String userName = request.getParameter("uname") ;
		String password = request.getParameter("password") ;
		
		SaveToFile.savePassword(password) ;
		Platform plat = new Platform(platform,userName,password) ;

		if(plat.saveData()){
			nextPage = "next.jsp" ;
		}
		
		request.getRequestDispatcher(nextPage).forward(request,response) ;
	}
}