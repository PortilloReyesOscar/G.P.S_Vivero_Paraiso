package ModeloDAO;

import Config.Conexion;
import Interfaces.VentaTemplate;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peldd
 */
public class VentaDAO implements VentaTemplate {
 public Connection conn = null;

	public VentaDAO() {
		Conexion cn = new Conexion();
	
		conn = 	cn.conectar();
	}

     
    @Override
    public List getAll() {
    System.out.println("Error cargar lista");
     List <Venta> list= new ArrayList<>();
  
     String sql= "select*from vivero.venta order by id_venta";
        try {
     
            PreparedStatement ps= conn.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
             Venta venta= new Venta();
             venta.setIdVenta(rs.getInt("id_venta"));
             venta.setFecha(rs.getDate("fecha"));
             venta.setTotal(rs.getDouble("total"));
        
             list.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Error cargar lista");
        }
     return list;   
    }

    @Override
    public Venta getVenta(int idVenta) {
     String sql= "select*from vivero.venta where id_venta= "+idVenta;
     Venta venta=null;
        try {
           
             PreparedStatement ps= conn.prepareStatement(sql);
           ResultSet  rs=ps.executeQuery();
           rs.next();
          venta= new Venta();
             venta.setIdVenta(rs.getInt("id_venta"));
             venta.setFecha(rs.getDate("fecha"));
             venta.setTotal(rs.getDouble("total"));
        
            
            
        } catch (SQLException e) {
        }   
    return venta;
            }

    @Override
    public Venta save(Venta venta) {
          String sql="insert into  vivero.venta (fecha,total)values \n" +"('"+venta.getFecha()+"','"+venta.getTotal()+";";
        try {
           
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
   
        return null;
       }

    @Override
    public void delete(int idVenta) {
         String sql="delete from vivero.planta where idplanta="+idVenta;
        try {
          
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        }
    
}
