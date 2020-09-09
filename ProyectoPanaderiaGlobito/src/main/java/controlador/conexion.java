/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.*;
public class conexion {
    public static Connection getConexion() throws ClassNotFoundException{
        try{
           Class.forName("com.mysql.jdbc.Driver");
           String user, pass, url;
           url="jdbc:mysql://localhost:3306/globito";
           user="root";
           pass="root"; 
           
           return DriverManager.getConnection(url, user, pass);
                 
        }catch(SQLException e){
            System.out.println("No se conecto");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            
        }
        return null;
    }
}
