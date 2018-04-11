package daos;

import java.util.List;

import modelo.Clientes;

public interface ClientesDAO {

	boolean registrarClientes(Clientes clientes);

	List<Clientes> obtenerClientes();

	void borrarClientes(int id);

	void guardarCambiosClientes(Clientes clientes);

	Clientes obtenerClientesPorId(int id);
}
