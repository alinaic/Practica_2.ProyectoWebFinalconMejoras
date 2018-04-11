package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;


@WebServlet("/admin/ServletListadoClientes")
public class ServletListadoClientes extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		
		request.setAttribute("clientes", clientesDAO.obtenerClientes());
		
		request.getRequestDispatcher("gestionClientes.jsp").forward(request, response);

	}

}
