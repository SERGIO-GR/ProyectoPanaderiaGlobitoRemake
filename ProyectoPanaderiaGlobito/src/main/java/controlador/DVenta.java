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
public class DVenta {
    
    private int id_dventa, id_pan, cant_dventa, id_venta, id_eusu;
    private float subtotal_dventa;
    
    public DVenta(){
    
    }

    public int getId_dventa() {
        return id_dventa;
    }

    public void setId_dventa(int id_dventa) {
        this.id_dventa = id_dventa;
    }

    public int getId_pan() {
        return id_pan;
    }

    public void setId_pan(int id_pan) {
        this.id_pan = id_pan;
    }

    public int getCant_dventa() {
        return cant_dventa;
    }

    public void setCant_dventa(int cant_dventa) {
        this.cant_dventa = cant_dventa;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_eusu() {
        return id_eusu;
    }

    public void setId_eusu(int id_eusu) {
        this.id_eusu = id_eusu;
    }

    public float getSubtotal_dventa() {
        return subtotal_dventa;
    }

    public void setSubtotal_dventa(float subtotal_dventa) {
        this.subtotal_dventa = subtotal_dventa;
    }
    
    
    
}
