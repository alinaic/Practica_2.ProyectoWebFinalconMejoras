package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Zapatos;

import daos.ZapatosDAO;
import daosImpl.ZapatosDAOImpl;

@WebServlet("/admin/ServletEditarZapatos")
public class ServletEditarZapatos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ZapatosDAO zapatosDAO = new ZapatosDAOImpl();
		
		Zapatos zapatosAeditar = zapatosDAO.obtenerZapatosPorId(id);
		
		request.setAttribute("zapatosAeditar", zapatosAeditar);
		request.getRequestDispatcher("editarZapatos.jsp").forward(request,
				response);

	}

}
