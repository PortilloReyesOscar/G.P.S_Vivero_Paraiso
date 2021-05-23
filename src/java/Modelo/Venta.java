/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author peldd
 */
public class Venta {

    /**
     * @return the IdVenta
     */
    private int IdVenta;
    private java.util.Date  fecha;
    private double total;
    public int getIdVenta() {
        return IdVenta;
    }

    /**
     * @param IdVenta the IdVenta to set
     */
    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    /**
     * @return the fecha
     */
    public java.util.Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }


 
    
    
}
