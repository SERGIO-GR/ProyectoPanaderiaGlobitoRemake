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
      public static int Guardar(String user,String pass, int id){
    int estatus=0; 
        MUsuario u = null;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
    try{
           con=conexion.getConexion();
           String q ="select * from MUsuario where user_usu = ? and pass_usu = ?";
           ps=con.prepareStatement(q);
           ps.setString(1,user);
           ps.setString(2,pass);
           ps.setInt(3,id);
           estatus=ps.executeUpdate();
           con.close();
        
    }catch(Exception e){
        System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            u=null;
    }
    return estatus;
   }
   public static int Eliminar(int id){
       int estatus=0;
       MUsuario u = null;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
      try{
          con=conexion.getConexion();
          String q ="Delete from datos where id = ?";
          ps=con.prepareStatement(q);
           ps.setInt(1,id);
           estatus=ps.executeUpdate();
           con.close();
          
          
      }catch(Exception e){
          System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            u=null;
      }
      return estatus;
      
   }
   public static MUsuario getUsuarioById(int id){
    int estatus=0;
       MUsuario u = new MUsuario();
        Connection con=null;
        PreparedStatement ps=null;
        try{
            con=conexion.getConexion();
          String sql ="Select * from Datos where id=?";
          ps=con.prepareStatement(sql);
           ps.setInt(1,id);
           ResultSet rs = ps.executeQuery();
           con.close();
           if(rs.next()){
               u.setId_usu(rs.getInt(1));
               u.setNom_usu(rs.getString(2));
               u.setAppat_usu(rs.getString(3));
               u.setPass_usu(rs.getString(4));
               u.setPriv_usu(rs.getString(5));
               con.close();
               
           }
        }catch(Exception e){
          System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            u=null;  
        }
        return  u;
   }
   public static List<MUsuario> GetAllUsuarios(){
       List<MUsuario> lista=new ArrayList<MUsuario>();
       Connection con=null;
        PreparedStatement ps=null;
    
       try{
         con=conexion.getConexion();
          String sql ="Select * from Datos";
          ps=con.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
              MUsuario u=new MUsuario();
             u.setId_usu(rs.getInt(1));
               u.setNom_usu(rs.getString(2));
               u.setAppat_usu(rs.getString(3));
               u.setPass_usu(rs.getString(4));
               u.setPriv_usu(rs.getString(5));
               lista.add(u);
          }
          
           con.close();   
       }catch(Exception e){
          System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
              
       }
       return lista;
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
