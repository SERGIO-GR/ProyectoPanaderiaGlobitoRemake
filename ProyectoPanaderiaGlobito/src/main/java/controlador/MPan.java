/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Usuario1
 */
import java.util.*;
import java.sql.*;


public class MPan {
    
    private int id_pan, id_cpan, id_csp, stock_pan;
    private String nom_pan;
    private float pre_pan;
    
    
    public MPan(){
    
    }
    
   public static int Guardar(String nom,float pre, int id){
    int estatus=0; 
        MUsuario u = null;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
    try{
           con=conexion.getConexion();
           String q ="select * from MUsuario where user_usu = ? and pass_usu = ?";
           ps=con.prepareStatement(q);
           ps.setString(1,nom);
           ps.setFloat(2,pre);
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
   public static MPan getPanById(int id){
    int estatus=0;
       MPan p = new MPan();
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
               p.setId_pan(rs.getInt(1));
                p.setNom_pan(rs.getString(2));
                p.setPre_pan(rs.getFloat("pre_pan"));
                p.setStock_pan(rs.getInt("stock_pan"));
                p.setId_cpan(rs.getInt("id_cpan"));
                p.setId_csp(rs.getInt("id_csp"));
               
           }
        }catch(Exception e){
          System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            p=null;  
        }
        return  p;
   }
   public static List<MUsuario> GetAllPanes(){
       List<MUsuario> lista=new ArrayList<MUsuario>();
       Connection con=null;
        PreparedStatement ps=null;
    
       try{
         con=conexion.getConexion();
          String sql ="Select * from Datos";
          ps=con.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
              MPan p=new MPan();
                p.setId_pan(rs.getInt(1));
                p.setNom_pan(rs.getString(2));
                p.setPre_pan(rs.getFloat("pre_pan"));
                p.setStock_pan(rs.getInt("stock_pan"));
                p.setId_cpan(rs.getInt("id_cpan"));
                p.setId_csp(rs.getInt("id_csp"));
          }
          
           con.close();   
       }catch(Exception e){
          System.out.println("No conecto con la tabla");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
              
       }
       return lista;
   }
    
    public Vector<MPan> listaPanes() throws ClassNotFoundException{
        Vector<MPan> lp = new Vector<MPan>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = conexion.getConexion();
            String q = "select * from MPan";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            //buscar todos los panes de la tabla
            while(rs.next()){
                //instancia de panes
                MPan pan = new MPan();
                pan.setId_pan(rs.getInt("id_pan"));
                pan.setNom_pan(rs.getString("nom_pan"));
                pan.setPre_pan(rs.getFloat("pre_pan"));
                pan.setStock_pan(rs.getInt("stock_pan"));
                pan.setId_cpan(rs.getInt("id_cpan"));
                pan.setId_csp(rs.getInt("id_csp"));
                //los agrego a la lista de panes
                lp.add(pan);
            }
        
        }catch(SQLException e){
            System.out.println("No encontro la tabla pan");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            lp = null;
        
        }finally{
            //vamos a cerrar conexiones
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
        }
        return lp;
    }
    
    //vamos a crear el metodo para buscar un pan por codigo o id
    
    public MPan buscarPan(int idpan) throws ClassNotFoundException{
        MPan pan = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = conexion.getConexion();
            String q = "select * from MPan where id_pan = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, idpan);
            while(rs.next()){
                pan = new MPan();
                pan.setId_pan(rs.getInt("id_pan"));
                pan.setNom_pan(rs.getString("nom_pan"));
                pan.setPre_pan(rs.getFloat("pre_pan"));
                pan.setStock_pan(rs.getInt("stock_pan"));
                pan.setId_cpan(rs.getInt("id_cpan"));
                pan.setId_csp(rs.getInt("id_csp"));
            }
        
        }catch(SQLException e){
            System.out.println("No encontro la tabla pan");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            pan = null;
        }finally{
            //vamos a cerrar conexiones
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
        }
        return pan;
    }
    
    public Vector<MPan> listaPanes() throws ClassNotFoundException{
        Vector<MPan> lp = new Vector<MPan>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = conexion.getConexion();
            String q = "select * from MPan";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            //buscar todos los panes de la tabla
            while(rs.next()){
                //instancia de panes
                MPan pan = new MPan();
                pan.setId_pan(rs.getInt("id_pan"));
                pan.setNom_pan(rs.getString("nom_pan"));
                pan.setPre_pan(rs.getFloat("pre_pan"));
                pan.setStock_pan(rs.getInt("stock_pan"));
                pan.setId_cpan(rs.getInt("id_cpan"));
                pan.setId_csp(rs.getInt("id_csp"));
                //los agrego a la lista de panes
                lp.add(pan);
            }
        
        }catch(SQLException e){
            System.out.println("No encontro la tabla pan");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            lp = null;
        
        }finally{
            //vamos a cerrar conexiones
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
        }
        return lp;
    }
    
    //vamos a crear el metodo para buscar un pan por codigo o id
    
    public MPan buscarPan(int idpan) throws ClassNotFoundException{
        MPan pan = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = conexion.getConexion();
            String q = "select * from MPan where id_pan = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, idpan);
            while(rs.next()){
                pan = new MPan();
                pan.setId_pan(rs.getInt("id_pan"));
                pan.setNom_pan(rs.getString("nom_pan"));
                pan.setPre_pan(rs.getFloat("pre_pan"));
                pan.setStock_pan(rs.getInt("stock_pan"));
                pan.setId_cpan(rs.getInt("id_cpan"));
                pan.setId_csp(rs.getInt("id_csp"));
            }
        
        }catch(SQLException e){
            System.out.println("No encontro la tabla pan");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            pan = null;
        }finally{
            //vamos a cerrar conexiones
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
        }
        return pan;
    }
    
    //que se encargue de actualizar el stock una vez que haya una venta
    public boolean actualizarStock(Vector<MPan> vpan) throws ClassNotFoundException{
        boolean actualizo = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = conexion.getConexion();
            //tenemos que recorrer el vector para actualizar el stock por cada pan
            for(MPan pan : vpan){
                String q = "Update MPan set stock_pan = ? where id_pan = ?";
                ps = con.prepareStatement(q);
                ps.setInt(1, pan.stock_pan);
                ps.setInt(2, pan.id_pan);
                //viene la comprobacion del booleano
                if(ps.executeUpdate()==1){
                    actualizo = true;
                }else{
                    actualizo = false;
                    break;
                }
            }
        
        }catch(SQLException e){
            System.out.println("No encontro la tabla pan");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            actualizo = false;
        }finally{
            //vamos a cerrar conexiones
            try{
                
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
        }
        return actualizo;
    }

    public int getId_pan() {
        return id_pan;
    }

    public void setId_pan(int id_pan) {
        this.id_pan = id_pan;
    }

    public int getId_cpan() {
        return id_cpan;
    }

    public void setId_cpan(int id_cpan) {
        this.id_cpan = id_cpan;
    }

    public int getId_csp() {
        return id_csp;
    }

    public void setId_csp(int id_csp) {
        this.id_csp = id_csp;
    }

    public int getStock_pan() {
        return stock_pan;
    }

    public void setStock_pan(int stock_pan) {
        this.stock_pan = stock_pan;
    }

    public String getNom_pan() {
        return nom_pan;
    }

    public void setNom_pan(String nom_pan) {
        this.nom_pan = nom_pan;
    }

    public float getPre_pan() {
        return pre_pan;
    }

    public void setPre_pan(float pre_pan) {
        this.pre_pan = pre_pan;
    }
    
    
    
}
