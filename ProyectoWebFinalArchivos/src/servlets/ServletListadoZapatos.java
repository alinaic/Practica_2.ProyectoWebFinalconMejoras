package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ZapatosDAO;
import daosImpl.ZapatosDAOImpl;


@WebServlet("/admin/ServletListadoZapatos")
public class ServletListadoZapatos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda = request.getParameter("campoBusqueda");
		if(busqueda==null){
			busqueda="";
		}
		
		String desde = request.getParameter("desde");
		String cuantos = request.getParameter("cuantos");
		int desdeInt = 0;
		int cuantosInt = 2;
		
		if(desde!=null && cuantos!=null){
			// Entra aqui cuando buscamos, por lo que el número de registros que aparecerán serán cuantosInt
			desdeInt = Integer.parseInt(desde);
			cuantosInt = Integer.parseInt(cuantos);
		}
		
		ZapatosDAO zapatosDAO = new ZapatosDAOImpl();
		request.setAttribute("zapatos", zapatosDAO.obtenerZapatos(desdeInt, cuantosInt, busqueda));
		request.setAttribute("zapatosTotales", zapatosDAO.obtenerTotalZapatos(busqueda));
		request.setAttribute("desdeSiguiente", desdeInt + 2);
		request.setAttribute("desdeAnterior", desdeInt - 2);
		request.getRequestDispatcher("gestionZapatos.jsp").forward(request, response);
		
	}

}
