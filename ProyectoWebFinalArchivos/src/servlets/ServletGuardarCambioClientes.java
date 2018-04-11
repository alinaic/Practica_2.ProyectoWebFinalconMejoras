package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;
import modelo.Clientes;

@WebServlet("/admin/ServletGuardarCambioClientes")
public class ServletGuardarCambioClientes extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
// Recuperamos los datos indicados en el formulario
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numero_calle = request.getParameter("campoNumero_calle");
		String codigo_postal= request.getParameter("campoCodigo_postal");
		String telefono= request.getParameter("campoTelefono");
		String email= request.getParameter("campoEmail");
		String tipo = request.getParameter("campoTipo");
		String particular = "";
		String empresa = "";
		String id = request.getParameter("campoId");
		
		if(tipo.equals("Particular")){
			
			particular = "Si";
			empresa = "No";
		
		} else if (tipo.equals("Empresa")){
			
			particular = "No";
			empresa = "Si";
			
		}
		
		// ValidaciÛn del campo Nombre
		String expresionRegularNombre = "[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—\\s]{3,50}";
		Pattern patter = Pattern.compile(expresionRegularNombre);
		Matcher matcher = patter.matcher(nombre);
		if (matcher.matches()) {
			System.out.println("Nombre ok");

		} else {
			
			System.out.println("Nombre no v·lido");
			request.setAttribute("mensaje", "Nombre no v·lido");
			request.getRequestDispatcher("editarClientes.jsp").forward(
					request, response);
			return;
		}

		// ValidaciÛn del campo Calle
		String expresionRegularCalle = "[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—\\s]{8,100}";
		Pattern p1 = Pattern.compile(expresionRegularCalle);
		Matcher m1 = p1.matcher(calle);
		if (m1.matches()) {
			System.out.println("Calle ok");

		} else {
			
			System.out.println("Calle no v·lida");
			request.setAttribute("mensaje", "Calle no v·lida");
			request.getRequestDispatcher("editarClientes.jsp").forward(
					request, response);
			return;
		}

		// ValidaciÛn del campo N˙mero de calle
		String expresionRegularNumeroCalle = "[0-9]{1,8}";
		Pattern p2 = Pattern.compile(expresionRegularNumeroCalle);
		Matcher m2 = p2.matcher(numero_calle);
		if (m2.matches()) {
			System.out.println("Numero_calle ok");

		} else {
			
			System.out.println("N˙mero de Calle no v·lido");
			request.setAttribute("mensaje", "N˙mero de Calle no v·lido");
			request.getRequestDispatcher("editarClientes.jsp").forward(
					request, response);
			return;
		}
		
		// ValidaciÛn del campo CÛdigo Postal
		String expresionRegularCP = "[0-9]{5}";
		Pattern p3 = Pattern.compile(expresionRegularCP);
		Matcher m3 = p3.matcher(codigo_postal);
		if (m3.matches()) {
			System.out.println("CÛdigo Postal ok");

		} else {
			
			System.out.println("CÛdigo Postal no v·lido");
			request.setAttribute("mensaje", "CÛdigo Postal no v·lido");
			request.getRequestDispatcher("editarClientes.jsp").forward(
					request, response);
			return;
		}
		
		// ValidaciÛn del campo TelÈfono
		String expresionRegularTelefono = "[0-9]{9,10}";
		Pattern p4 = Pattern.compile(expresionRegularTelefono);
		Matcher m4 = p4.matcher(telefono);
		if (m4.matches()) {
			System.out.println("Telefono ok");

		} else {
			
			System.out.println("TelÈfono no v·lido");
			request.setAttribute("mensaje", "TelÈfono no v·lido");
			request.getRequestDispatcher("editarClientes.jsp").forward(
					request, response);
			return;
		}
		
		// ValidaciÛn del campo Email
		String expresionRegularEmail = "[0-9a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—]{1,10}@[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—]{3,10}.[a-zA-Z]{3}";
		Pattern p5 = Pattern.compile(expresionRegularEmail);
		Matcher m5 = p5.matcher(email);
		if (m5.matches()) {
			System.out.println("Email ok");

		} else {
			
			System.out.println("Email no v·lido");
			request.setAttribute("mensaje", "Email no v·lido");
			request.getRequestDispatcher("editarClientes.jsp").forward(
					request, response);
			return;
		}

		// ValidaciÛn del campo Particular
		String expresionRegularParticular = "[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—\\s]{2,20}";
		Pattern p6 = Pattern.compile(expresionRegularParticular);
		Matcher m6 = p6.matcher(particular);
		if (m6.matches()) {
			System.out.println("Particular ok");

		} else {
			
			System.out.println("Particular no v·lido");
			request.setAttribute("mensaje", "Particular no v·lido");
			request.getRequestDispatcher("editarClientes.jsp").forward(
					request, response);
			return;
		}
		
		// ValidaciÛn del campo Empresa
		String expresionRegularEmpresa = "[a-zA-Z·ÈÌÛ˙Ò¡…Õ”⁄—\\s]{2,20}";
		Pattern p7 = Pattern.compile(expresionRegularEmpresa);
		Matcher m7 = p7.matcher(empresa);
		if (m7.matches()) {
			System.out.println("Empresa ok");

		} else {
			
			System.out.println("Empresa no v·lido");
			request.setAttribute("mensaje", "Empresa no v·lido");
			request.getRequestDispatcher("editarClientes.jsp").forward(
					request, response);
			return;
		}
		// fin parte de validacion de datos
		
		Clientes clientes = new Clientes(nombre, calle, numero_calle, codigo_postal, telefono, email, particular, empresa);
		clientes.setId(Integer.parseInt(id));
		
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		clientesDAO.guardarCambiosClientes(clientes);
		
		request.getRequestDispatcher("ServletListadoClientes").forward(request, response);

	}
}
