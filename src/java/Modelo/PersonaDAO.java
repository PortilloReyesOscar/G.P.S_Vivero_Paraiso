/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.ConexionLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author porti
 */
public class PersonaDAO  implements Validar{

    Connection con;
    ConexionLogin cn = new ConexionLogin();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public int Validar(Persona per) {
     int r=0;
      String sql= "Select* from registro.persona where Nombres=? and Correo=?" ;
     try{
         con=cn.conectar();
         ps=con.prepareStatement(sql);
         ps.setString(1,per.getnom());
         ps.setString(2,per.getCorreo());
        
         rs=ps.executeQuery();
         while(rs.next())
         {
         r=r+1;
         per.setnom(rs.getString("Nombres"));
         per.setCorreo(rs.getString("Correo"));
         }
         if(r==1)
         {
          return 1;
         }else{
          return 0;
         }
         
     }catch(Exception e)
     {
          System.out.println("HAY PEDOS CON POSTGRESQL!!!");

         return 0;     
     } 
    }
    
}
