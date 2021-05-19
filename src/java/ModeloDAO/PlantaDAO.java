/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Planta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author porti
 */
public class PlantaDAO implements CRUD{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Planta p= new Planta();
    
    @Override
    public List listar() {
     ArrayList <Planta> list= new ArrayList<>();
     String sql= "select*from vivero.planta order by idplanta";
        try {
            con=cn.conectar();
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
             Planta planta= new Planta();
             planta.setIdplanta(rs.getInt("idplanta"));
             planta.setNombre_planta(rs.getString("nombre_planta"));
             planta.setDescripcion(rs.getString("descripcion"));
             planta.setCantidad_disponible(rs.getInt("cantidad_disponible"));
             planta.setPrecio_unitario(rs.getInt("precio_unitario"));
             list.add(planta);
            }
        } catch (Exception e) {
        }
     return list;
    }

    @Override
    public Planta list(int idplanta) {
      String sql= "select*from vivero.planta where idplanta="+idplanta;
        try {
            con=cn.conectar();
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
             p.setIdplanta(rs.getInt("idplanta"));
             p.setNombre_planta(rs.getString("nombre_planta"));
             p.setDescripcion(rs.getString("descripcion"));
             p.setCantidad_disponible(rs.getInt("cantidad_disponible"));
             p.setPrecio_unitario(rs.getInt("precio_unitario"));
             
            }
        } catch (Exception e) {
        }
     return p;

    }

    @Override
    public boolean add(Planta planta) {
    String sql="insert into  vivero.planta(nombre_planta,descripcion,cantidad_disponible,precio_unitario)values \n" +
"('"+planta.getNombre_planta()+"','"+planta.getDescripcion()+"',"+planta.getCantidad_disponible()+","+planta.getPrecio_unitario()+");";
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    return false;
    }

    @Override
    public boolean edit(Planta planta) {
      String sql="update vivero.planta set " +
"nombre_planta='"+planta.getNombre_planta()+"',descripcion='"+planta.getDescripcion()+"',cantidad_disponible="+planta.getCantidad_disponible()+",precio_unitario="+planta.getPrecio_unitario()+"where idplanta="+planta.getIdplanta();
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    return false;
    }

    @Override
    public boolean eliminar(int idplanta) {
    String sql="delete from vivero.planta where idplanta="+idplanta;
        try {
            con=cn.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
  return false;
    }
    
}
