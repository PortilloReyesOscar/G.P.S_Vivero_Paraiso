/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author porti
 */
public class Planta {
    int idplanta;
    String nombre_planta;
    String descripcion;
    int cantidad_disponible;
    int precio_unitario;

    public Planta(int idplanta, String nombre_planta, String descripcion, int cantidad_disponible, int precio_unitario) {
        this.idplanta = idplanta;
        this.nombre_planta = nombre_planta;
        this.descripcion = descripcion;
        this.cantidad_disponible = cantidad_disponible;
        this.precio_unitario = precio_unitario;
    }

    public Planta() {

    }

    public int getIdplanta() {
        return idplanta;
    }

    public void setIdplanta(int idplanta) {
        this.idplanta = idplanta;
    }

    public String getNombre_planta() {
        return nombre_planta;
    }

    public void setNombre_planta(String nombre_planta) {
        this.nombre_planta = nombre_planta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    
    
}


