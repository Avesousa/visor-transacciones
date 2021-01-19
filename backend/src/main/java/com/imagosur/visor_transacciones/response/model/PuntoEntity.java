package com.imagosur.visor_transacciones.response.model;

public class PuntoEntity{

    private Integer id;

    private String nombre;
    
    public Integer getId() {
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
