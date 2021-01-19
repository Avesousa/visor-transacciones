package com.imagosur.visor_transacciones.response.model;

public class TipoFront {

	private int id;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Tipo [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
}
