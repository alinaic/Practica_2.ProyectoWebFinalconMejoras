package modelo;

import java.util.List;

import javax.servlet.http.Part;

public class Zapatos {
	private String categoria;
	private String temporada;
	private String talla;
	private String material;
	private String tipo;
	private String color;
	private String marcas;
	private Part   imagenSubida;
	private String rutaImagen;
	private int id;
	
	public Zapatos() {
	}

	public Zapatos(String categoria, String temporada, String talla,
			String material, String tipo, String color, String marcas, Part imagenSubida) {
		super();
		this.categoria = categoria;
		this.temporada = temporada;
		this.talla = talla;
		this.material = material;
		this.tipo = tipo;
		this.color = color;
		this.marcas = marcas;
		this.imagenSubida = imagenSubida;
		
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarcas() {
		return marcas;
	}

	public void setMarcas(String marcas) {
		this.marcas = marcas;
	}
	
	public Part getImagenSubida() {
		return imagenSubida;
	}

	public void setImagenSubida(Part imagenSubida) {
		this.imagenSubida = imagenSubida;
	}
	
	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Zapatos [categoria=" + categoria + ", temporada=" + temporada
				+ ", talla=" + talla + ", material=" + material + ", tipo="
				+ tipo + ", color=" + color + ", marcas=" + marcas + ", id="
				+ id + "]";
	}

}
