
package controlador;


import java.sql.*;
import java.util.*;

public class MVenta {
    
    private int id_venta;
    private String fecha_venta;
    private float total_venta;
    
    public MVenta(){
    
    }
    
    //saber cual fue el ultimo registro que se inserto de la venta
    
    private int ultimoCodigoInsertoVenta(Connection con){
        int codigo = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String q = "select max(id_venta) as Codigo from MVenta";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            //buscar el registro
            while(rs.next()){
                codigo = rs.getInt("Codigo");
                break;
            }
        
        }catch(SQLException e){
            System.out.println("No conecto con la tabla de la venta");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            
        }finally{
            //vamos a cerrar conexiones
            try{
                rs.close();
                ps.close();
                
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        } 
        return codigo;
        
    }
    
    //registrar una venta
    public boolean registrarVenta(MVenta v, Vector<DVenta> ldvp) throws ClassNotFoundException{
        boolean registro = false;
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = conexion.getConexion();
            String q = "insert into MVenta(fecha_venta, total_venta) values (?, ?)";
            ps = con.prepareStatement(q);
            ps.setString(1, v.fecha_venta);
            ps.setFloat(2, v.total_venta);
            //si se registro en la bd
            if(ps.executeUpdate()==1){
                int codigo = this.ultimoCodigoInsertoVenta(con);
                registro = this.registrarDetalleVenta(codigo, ldvp, con);
            }else{
                registro = false;
            }
        
        }catch(SQLException e){
            System.out.println("No conecto registro la venta");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            //vamos a cerrar conexiones
            try{
               
                ps.close();
                con.close();
                
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        } 
        return registro;
    }
    
    //registrar el detalle de la venta
    private boolean registrarDetalleVenta(int codigo, Vector<DVenta> ldvp, Connection con){
        boolean registro = false;
        PreparedStatement ps = null;
        try{
            //debo de recorrer todo el vector del detalle de la venta de panes
            for(DVenta dv : ldvp){
                String q = "insert into DVenta (id_pan, cant_dventa, "
                        + "subtotal_dventa, id_venta, id_eusu) "
                        + "values (?, ?, ?, ?, ?)";
                
                ps = con.prepareStatement(q);
                ps.setInt(1, dv.getId_pan());
                ps.setInt(2, dv.getCant_dventa());
                ps.setFloat(3, dv.getSubtotal_dventa());
                ps.setInt(4, codigo);
                ps.setInt(5, dv.getId_eusu());
                if(ps.executeUpdate()==1){
                    registro = true;
                }else{
                    registro = false;
                    break;
                }
            }
        }catch(SQLException e){
            System.out.println("No conecto registro el detalle de la venta");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            //vamos a cerrar conexiones
            try{
               
                ps.close();
                
                
            
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        } 
        return registro;
        
    }
    

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public float getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(float total_venta) {
        this.total_venta = total_venta;
    }
    
    
    
}
