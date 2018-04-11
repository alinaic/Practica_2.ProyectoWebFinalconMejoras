package modelo;

import javax.management.loading.PrivateClassLoader;

public class Clientes {

	private String nombre;
	private String calle;
	private String numero_calle;
	private String codigo_postal;
	private String telefono;
	private String email;
	private String particular;
	private String empresa;
	private int id;


	public Clientes() {
	}
	
	public Clientes(String nombre, String calle, String numero_calle, String codigo_postal, String telefono, String email, String particular, String empresa) {
		super();
		this.nombre = nombre;
		this.calle = calle;
		this.numero_calle = numero_calle;
		this.codigo_postal = codigo_postal;
		this.telefono = telefono;
		this.email = email;
		this.particular = particular;
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero_calle() {
		return numero_calle;
	}

	public void setNumero_calle(String numero_calle) {
		this.numero_calle = numero_calle;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", calle=" + calle
				+ ", numero_calle=" + numero_calle + ", codigo_postal="
				+ codigo_postal + ", telefono="
				+ telefono + ", email=" + email + ", particular=" + particular
				+ ", empresa=" + empresa + ", id=" + id + "]";
	}

}


