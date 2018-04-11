package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.Zapatos;
import daos.ZapatosDAO;
import daosImpl.ZapatosDAOImpl;

@WebServlet("/admin/ServletGuardarCambioZapatos")
public class ServletGuardarCambioZapatos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperamos los datos indicados en el formulario
		String categoria = request.getParameter("campoCategoria");
		String temporada = request.getParameter("campoTemporada");
		String talla = request.getParameter("campoTalla");
		String material = request.getParameter("campoMaterial");
		String tipo = request.getParameter("campoTipo");
		String colores[] = request.getParameterValues("CampoColor");
		String marcas = request.getParameter("campoMarcas");
		String id = request.getParameter("campoId");
		Part imagen = request.getPart("campoImagen");
				
		// ValidaciÛn del campo Categoria
		if(categoria.equals("Hombre") || categoria.equals("Mujer") || 
		   categoria.equals("NiÒos") || categoria.equals("NiÒas")) {
			System.out.println("Categoria ok");
		} else {
			
			System.out.println("Categoria no v·lida");
			request.setAttribute("mensaje", "Categoria no v·lida");
			request.getRequestDispatcher("editarZapatos.jsp").forward(
					request, response);
			return;
		}

		// ValidaciÛn del campo Temporada
		String expresionRegularTemporada = "[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—\\s]{3,20}";
		Pattern p1 = Pattern.compile(expresionRegularTemporada);
		Matcher m1 = p1.matcher(temporada);
		if (m1.matches()) {
			System.out.println("Temporada ok");
		} else {
			
			System.out.println("Temporada no v·lida");
			request.setAttribute("mensaje", "Temporada no v·lida");
			request.getRequestDispatcher("editarZapatos.jsp").forward(
					request, response);
			return;
		}
		
		// ValidaciÛn del campo Talla
		String expresionRegularTalla = "[0-9]{2,8}";
		Pattern p2 = Pattern.compile(expresionRegularTalla);
		Matcher m2 = p2.matcher(talla);
		if (m2.matches()) {
			System.out.println("Talla ok");

		} else {
			
			System.out.println("Talla no v·lida");
			request.setAttribute("mensaje", "Talla no v·lida");
			request.getRequestDispatcher("editarZapatos.jsp").forward(
					request, response);
			return;
		}

		// ValidaciÛn del campo Material
		String expresionRegularMaterial = "[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—\\s]{4,30}";
		Pattern p3 = Pattern.compile(expresionRegularMaterial);
		Matcher m3 = p3.matcher(material);
		if (m3.matches()) {
			System.out.println("Material ok");

		} else {
			
			System.out.println("Material no v·lido");
			request.setAttribute("mensaje", "Material no v·lido");
			request.getRequestDispatcher("editarZapatos.jsp").forward(
					request, response);
			return;
		}
		
		// ValidacioÛn del campo Tipo
		String expresionRegularTipo = "[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—\\s]{3,50}";
		Pattern p4 = Pattern.compile(expresionRegularTipo);
		Matcher m4 = p4.matcher(tipo);
		if (m4.matches()) {
			System.out.println("Tipo ok");

		} else {
			
			System.out.println("Tipo no v·lido");
			request.setAttribute("mensaje", "Tipo no v·lido");
			request.getRequestDispatcher("editarZapatos.jsp").forward(
					request, response);
			return;
		}
				
		String color = "";
		if(colores != null) {
			
			for(int i=0;i<colores.length;i++){
				
				if(i==0){
					color = colores[i];
				} else {
					color = color + "+" + colores[i];
				}
			}
			
		} else {
			
			System.out.println("Color no v·lido");
			request.setAttribute("mensaje", "Color no v·lido. Seleccione alguna opciÛn");
			request.getRequestDispatcher("editarZapatos.jsp").forward(
					request, response);
			return;
		}
				
		// ValidaciÛn del campo Marcas
		String expresionRegularMarcas = "[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—\\s]{3,20}";
		Pattern p6 = Pattern.compile(expresionRegularMarcas);
		Matcher m6 = p6.matcher(marcas);
		if (m6.matches()) {
			System.out.println("Marcas ok");

		} else {
			
			System.out.println("Marcas no v·lido");
			request.setAttribute("mensaje", "Marcas no v·lido");
			request.getRequestDispatcher("editarZapatos.jsp").forward(
					request, response);
			return;
		}
		// fin parte de validacion de datos
				
		Zapatos zapatos = new Zapatos(categoria, temporada, talla, material, tipo, color, marcas, imagen);
		zapatos.setId(Integer.parseInt(id));
		
		ZapatosDAO zapatosDAO = new ZapatosDAOImpl();
		zapatosDAO.guardarCambiosZapatos(zapatos);
		
		request.getRequestDispatcher("ServletListadoZapatos").forward(request, response);
		
	}

}
