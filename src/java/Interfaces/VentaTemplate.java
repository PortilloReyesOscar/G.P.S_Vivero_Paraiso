/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Venta;
import java.util.List;

/**
 *
 * @author peldd
 */
public interface VentaTemplate {

    public List getAll();
    public Venta getVenta(int idVenta);
    public Venta save(Venta venta);
    public void delete(int idVenta);
}
