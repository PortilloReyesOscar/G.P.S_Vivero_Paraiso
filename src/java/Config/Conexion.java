/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author porti
 */
public class Conexion {
       private final String host = "localhost";
       private final String puerto = "5432";
       private final String baseDatos = "vivero";
       public String servidor = "jdbc:postgresql://" + host + ":" + puerto + "/" + baseDatos;
       public String usuario = "postgres";
       public String clave = "portillo24";
       
       //Registrar el driver
       public Connection conectar(){
           Connection conexion = null;
           try{
               Class.forName("org.postgresql.Driver");
           }catch( ClassNotFoundException e){
               System.err.println(e);
           } catch ( Exception e ){
               System.err.println(e);
           }
           
           //Establecer la conexión
           try{
               conexion = DriverManager.getConnection(servidor,usuario, clave);
               if(conexion!=null)
               {
                System.out.print("Conexion correcta");
               }
              
           } catch (SQLException e){
               System.err.println(e);
           } catch (Exception e){
               System.err.println(e);
           }
           
           return conexion;
       }
       
       public void desconectar(Connection conexion) throws SQLException{
            conexion.close();
       }
       
        public static void main (String [] args)
       {
        Conexion c = new Conexion();
        c.conectar();
       }
}