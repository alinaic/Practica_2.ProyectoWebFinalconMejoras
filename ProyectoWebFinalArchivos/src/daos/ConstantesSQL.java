package daos;

public class ConstantesSQL {

	public static final String INSERCION_ZAPATOS = "insert into proyecto_web.zapatos"
			+ "(categoria, temporada, talla, material, tipo, color, marcas )"
			+ "value(?, ?, ?, ?, ?, ?, ?)";
	public static final String BORRADO_ZAPATOS = "delete from proyecto_web.zapatos where id=?";
	public static final String SELECION_ZAPATOS = "select * from proyecto_web.zapatos";
	public static final String OBTENER_ZAPATOS_POR_ID = "select * from proyecto_web.zapatos where id = ?";
	public static final String GUARDAR_CAMBIOS_ZAPATOS = "update proyecto_web.zapatos set categoria = ?, temporada = ?, talla = ?, material = ?, tipo = ?, color = ?, marcas = ? where id = ?";
	public static final String IDENTIFICACION_ADMIN = "select login from administrador where login = ? and pass = ? ";
	public static final String INSERCION_CLIENTE = "insert into proyecto_web.clientes"
			+ "(nombre, calle, numero_calle, codigo_postal, telefono, email, particular, empresa  )"
			+ "value(?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SELECION_CLIENTES = "select * from proyecto_web.clientes";
	public static final String BORRAR_CLIENTE = "delete from proyecto_web.clientes where id=?";
	public static final String GUARDAR_CAMBIOS_CLIENTE = "update proyecto_web.clientes set nombre = ?, calle = ?, numero_calle = ?, codigo_postal = ?, telefono = ?, email = ?, particular = ?, empresa = ? where id = ?";
	public static final String OBTENER_CLIENTE_POR_ID = "select * from proyecto_web.clientes where id = ?";
	public static final String CANTIDAD_TOTAL_ZAPATOS = "select count(id) as total from proyecto_web.zapatos where proyecto_web.zapatos.categoria like ?";
	public static final String SELECION_ZAPATOS_INTERVALO = "select * from proyecto_web.zapatos where proyecto_web.zapatos.categoria like ? order by id desc limit ?,? ";
	
}// end class
