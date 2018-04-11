package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Clientes;
import daos.GenericDAO;
import daos.ClientesDAO;
import daos.ConstantesSQL;

public class ClientesDAOImpl extends GenericDAO implements ClientesDAO {

	@Override
	public boolean registrarClientes(Clientes cliente) {
		
		conectar();
		
		try {
			PreparedStatement ps = miConnection.prepareStatement(ConstantesSQL.INSERCION_CLIENTE);

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumero_calle());
			ps.setString(4, cliente.getCodigo_postal());
			ps.setString(5, cliente.getTelefono());
			ps.setString(6, cliente.getEmail());
			ps.setString(7, cliente.getParticular());
			ps.setString(8, cliente.getEmpresa());
			ps.execute();
			ps.close();
			desconectar();
			
			return true;
			
		} catch (SQLException e) {
			
			System.out.println("la sql de insercion del cliente esta mal");
			System.out.println(e.getMessage());
			desconectar();
			
			return false;
			
		}
	}

	@Override
	public List<Clientes> obtenerClientes() {
		
		conectar();
		
		List<Clientes> clientes = new ArrayList<Clientes>();
		
		try {
			
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.SELECION_CLIENTES);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				
				Clientes cliente = new Clientes();
				cliente.setNombre(resultado.getString("nombre"));
				cliente.setCalle(resultado.getString("calle"));
				cliente.setNumero_calle(resultado.getString("numero_calle"));
				cliente.setCodigo_postal(resultado.getString("codigo_postal"));
				cliente.setTelefono(resultado.getString("telefono"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setParticular(resultado.getString("particular"));
				cliente.setEmpresa(resultado.getString("empresa"));
				cliente.setId(resultado.getInt("id"));

				clientes.add(cliente);
			}

		} catch (SQLException e) {
			System.out.println("sql select clientes esta mal");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		
		return clientes;

	}

	@Override
	public void borrarClientes(int id) {

		conectar();

		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.BORRAR_CLIENTE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			System.out.println("sql borrado usuario esta mal");
		}

		desconectar();

	}

	@Override
	public void guardarCambiosClientes(Clientes clientes) {

		conectar();

		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_CLIENTE);
			ps.setString(1, clientes.getNombre());
			ps.setString(2, clientes.getCalle());
			ps.setString(3, clientes.getNumero_calle());
			ps.setString(4, clientes.getCodigo_postal());
			ps.setString(5, clientes.getTelefono());
			ps.setString(6, clientes.getEmail());
			ps.setString(7, clientes.getParticular());
			ps.setString(8, clientes.getEmpresa());
			ps.setInt(9, clientes.getId());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			System.out.println("posible la sql de guardar cambios esta mal");
			System.out.println(e.getMessage());
		}

		desconectar();

	}

	@Override
	public Clientes obtenerClientesPorId(int id) {
		
		conectar();
		
		Clientes cliente = new Clientes();
		
		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.OBTENER_CLIENTE_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				cliente.setNombre(rs.getString("nombre"));
				cliente.setCalle(rs.getString("calle"));
				cliente.setNumero_calle(rs.getString("numero_calle"));
				cliente.setCodigo_postal(rs.getString("codigo_postal"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setEmail(rs.getString("email"));
				cliente.setParticular(rs.getString("particular"));
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setId(id);
			}
			
			ps.close();

		} catch (SQLException e) {
			System.out.println("seguramente la sql esta mal");
			System.out.println(e.getMessage());
		}

		desconectar();
		
		return cliente;

	}

}
