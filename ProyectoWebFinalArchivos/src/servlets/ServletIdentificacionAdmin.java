package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.AdministradorDAO;
import daosImpl.AdministradorDAOImpl;


@WebServlet("/admin/ServletIdentificacionAdmin")
public class ServletIdentificacionAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("campoLogin");
		String pass = request.getParameter("campoPass");
		
		AdministradorDAO administradorDAO = new AdministradorDAOImpl();
		if(administradorDAO.identificarAdmin(login, pass)){
			request.getSession().setAttribute("admin", "ok");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}		
	}
}


