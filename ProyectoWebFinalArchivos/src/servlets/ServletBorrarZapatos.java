package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import daos.ZapatosDAO;

import daosImpl.ZapatosDAOImpl;


@WebServlet("/admin/ServletBorrarZapatos")
public class ServletBorrarZapatos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ZapatosDAO zapatosDAO = new ZapatosDAOImpl();
		zapatosDAO.borrarZapatos(id);
		
		request.getRequestDispatcher("ServletListadoZapatos").forward(request, response);
		
	}
	}

