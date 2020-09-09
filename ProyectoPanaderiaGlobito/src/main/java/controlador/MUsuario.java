/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.*;

public class MUsuario {
   private int id_usu;
   private String nom_usu, appat_usu, user_usu, pass_usu;
   
   public MUsuario(){
       
   }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getAppat_usu() {
        return appat_usu;
    }

    public void setAppat_usu(String appat_usu) {
        this.appat_usu = appat_usu;
    }

    public String getUser_usu() {
        return user_usu;
    }

    public void setUser_usu(String user_usu) {
        this.user_usu = user_usu;
    }

    public String getPass_usu() {
        return pass_usu;
    }

    public void setPass_usu(String pass_usu) {
        this.pass_usu = pass_usu;
    }
    public MUsuario verificarUsuario(String user, String pass) throws ClassNotFoundException{
        MUsuario u = null;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
           con=conexion.getConexion();
           String q ="select * from MUsuario where user_usu = ? and pass_usu = ?";
           ps=con.prepareStatement(q);
           ps.setString(1,user);
           ps.setString(2,user);
           rs=ps.executeQuery();
           while(rs.next()){
               u=new MUsuario();
               u.setId_usu(rs.getInt("id_usu"));
               u.setId_usu(rs.getInt("nom_usu"));
               u.setId_usu(rs.getInt("appat_usu"));
               u.setId_usu(rs.getInt("user_usu"));
               u.setId_usu(rs.getInt("pass_usu"));
               u.setId_usu(rs.getInt("priv_usu"));
               break;
           }

        }catch(SQLException e){
            System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            u=null;
                    
        }finally{
            try{
              rs.close();
              ps.close();
              con.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());  
            }
        }
        return u;
        
        
    }
   
}
