package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utilidades.GestorArchivos;
import modelo.Zapatos;
import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.ZapatosDAO;

public class ZapatosDAOImpl extends GenericDAO implements ZapatosDAO {

	@Override
	public void registrarZapatos(Zapatos zapatos) {
		
		conectar();
		
		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.INSERCION_ZAPATOS);
			ps.setString(1, zapatos.getCategoria());
			ps.setString(2, zapatos.getTemporada());
			ps.setString(3, zapatos.getTalla());
			ps.setString(4, zapatos.getMaterial());
			ps.setString(5, zapatos.getTipo());
			ps.setString(6, zapatos.getColor());
			ps.setString(7, zapatos.getMarcas());
			ps.execute();
			System.out.println("holaa");
			ResultSet rs = ps.getGeneratedKeys();
			System.out.println("holia");	
			if(rs.next()){
			System.out.println("hola");	
				int idGenerado = rs.getInt(1);
				System.out.println("Generado:"+idGenerado);
				System.out.println("id generado en bd: " + idGenerado);

				GestorArchivos.guardarArchivo(zapatos.getImagenSubida(), idGenerado + ".jpg");
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("la sql de insercion de zapatos esta mal");
		}

		desconectar();

	}

	@Override
	public List<Zapatos> obtenerZapatos() {
		
		conectar();
		
		List<Zapatos> zapatos = new ArrayList<Zapatos>();
		
		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.SELECION_ZAPATOS);
			ResultSet resultado = ps.executeQuery();
			
			while (resultado.next()) {

				Zapatos zapato = new Zapatos();
				zapato.setCategoria(resultado.getString("categoria"));
				zapato.setTemporada(resultado.getString("temporada"));
				zapato.setTalla(resultado.getString("talla"));
				zapato.setMaterial(resultado.getString("material"));
				zapato.setTipo(resultado.getString("tipo"));
				zapato.setColor(resultado.getString("color"));
				zapato.setMarcas(resultado.getString("marcas"));
				zapato.setId(resultado.getInt("id"));
				
				zapatos.add(zapato);
			}
			
			resultado.close();
			ps.close();

		} catch (SQLException e) {
			System.out.println("sql select zapatos esta mal");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		
		return zapatos;

	}
	
	@Override
	public List<Zapatos> obtenerZapatos(int desde, int cuantos, String busqueda) {
		
		conectar();
		
		List<Zapatos> zapatos = new ArrayList<Zapatos>();
		
		try {
			
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.SELECION_ZAPATOS_INTERVALO);
			ps.setString(1, "%"+busqueda+"%");
			ps.setInt(2, desde);
			ps.setInt(3, cuantos);
			
			ResultSet resultado = ps.executeQuery();	
			while (resultado.next()) {

				Zapatos zapato = new Zapatos();
				zapato.setCategoria(resultado.getString("categoria"));
				zapato.setTemporada(resultado.getString("temporada"));
				zapato.setTalla(resultado.getString("talla"));
				zapato.setMaterial(resultado.getString("material"));
				zapato.setTipo(resultado.getString("tipo"));
				zapato.setColor(resultado.getString("color"));
				zapato.setMarcas(resultado.getString("marcas"));
				zapato.setId(resultado.getInt("id"));
				
				zapatos.add(zapato);
			}
			
			resultado.close();
			ps.close();

		} catch (SQLException e) {
			System.out.println("sql select zapatos esta mal");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		
		return zapatos;
	}

	public void borrarZapatos(int id) {
		
		conectar();

		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.BORRADO_ZAPATOS);
			ps.setInt(1, id);
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			System.out.println("sql borrado zapatos esta mal");
		}

		desconectar();

	}

	@Override
	public Zapatos obtenerZapatosPorId(int id) {
		
		conectar();
		
		Zapatos zapatos = new Zapatos();
		
		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.OBTENER_ZAPATOS_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				zapatos.setCategoria(rs.getString("categoria"));
				zapatos.setTemporada(rs.getString("temporada"));
				zapatos.setTalla(rs.getString("talla"));
				zapatos.setMaterial(rs.getString("material"));
				zapatos.setTipo(rs.getString("tipo"));
				zapatos.setColor(rs.getString("color"));
				zapatos.setMarcas(rs.getString("marcas"));
				zapatos.setId(id);
			}
			
			ps.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println("seguramente la sql esta mal");
			System.out.println(e.getMessage());
		}

		desconectar();
		
		return zapatos;
	}

	@Override
	public void guardarCambiosZapatos(Zapatos zapatos) {
		
		conectar();

		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_ZAPATOS);
			ps.setString(1, zapatos.getCategoria());
			ps.setString(2, zapatos.getTemporada());
			ps.setString(3, zapatos.getTalla());
			ps.setString(4, zapatos.getMaterial());
			ps.setString(5, zapatos.getTipo());
			ps.setString(6, zapatos.getColor());
			ps.setString(7, zapatos.getMarcas());
			ps.setInt(8, zapatos.getId());

			ps.execute();
			ps.close();

		} catch (SQLException e) {
			System.out.println("posible la sql de guardar cambios esta mal");
			System.out.println(e.getMessage());
		}

		desconectar();
	}
	
	public int obtenerTotalZapatos(String busqueda) {
		
		conectar();
		
		int total = 0;
		
		try {
			
			PreparedStatement ps = miConnection.prepareStatement(ConstantesSQL.CANTIDAD_TOTAL_ZAPATOS);
			ps.setString(1, "%"+busqueda+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				total = rs.getInt("total");
			}
		
			rs.close();
			ps.close();
		
		} catch (SQLException e) {
			
			System.out.println("la sql puede estar mal");
			System.out.println(e.getMessage());
			e.printStackTrace();
		
		}
		
		desconectar();
		
		return total;
	}

}
