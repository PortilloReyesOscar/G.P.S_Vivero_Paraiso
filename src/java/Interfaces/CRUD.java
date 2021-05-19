/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Planta;
import java.util.List;

/**
 *
 * @author porti
 */
public interface CRUD {
    public List listar();
    public Planta list(int idplanta);
    public boolean add(Planta planta);
    public boolean edit(Planta planta);
    public boolean eliminar(int idplanta);

}
