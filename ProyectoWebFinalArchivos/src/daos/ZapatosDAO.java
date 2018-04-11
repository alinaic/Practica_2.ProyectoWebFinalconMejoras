package daos;

import java.util.List;

import modelo.Zapatos;

public interface ZapatosDAO {

	void registrarZapatos(Zapatos zapatos);

	List<Zapatos> obtenerZapatos();

	void borrarZapatos(int id);

	Zapatos obtenerZapatosPorId(int id);

	void guardarCambiosZapatos(Zapatos zapatos);

	int obtenerTotalZapatos(String busqueda);

	List<Zapatos> obtenerZapatos(int desde, int cuantos, String busqueda);

	

}
