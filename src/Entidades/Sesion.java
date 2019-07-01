/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.swing.JOptionPane;

/**
 *
 * @author NICOLAS RM
 */
public class Sesion {

    String nombre;
    String apellido_paterno;
    String apellido_materno;
    String genero;
    String fechaNamiento;
    String direccion;

    String user;
    String pass;
    String status;

    public Sesion(String user, String pass, String status) {
        this.user = user;
        this.pass = pass;
        this.status = status;
    }

    public Sesion(String nombre, String apellido_paterno, String apellido_materno,
            String genero, String fechaNamiento, String direccion, String user, String pass, String status) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.genero = genero;
        this.fechaNamiento = fechaNamiento;
        this.direccion = direccion;
        this.user = user;
        this.pass = pass;
        this.status = status;
    }

    public Sesion() {

    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNamiento() {
        return fechaNamiento;
    }

    public void setFechaNamiento(String fechaNamiento) {
        this.fechaNamiento = fechaNamiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String passautomatic() {
        char[] pass = new char[8];
        pass[0] = this.nombre.charAt(0);
        pass[1] = this.apellido_paterno.charAt(0);
        pass[2] = this.apellido_materno.charAt(0);
        pass[3] = this.genero.charAt(0);
        pass[4] = this.fechaNamiento.charAt(0);
        pass[5] = this.fechaNamiento.charAt(1);
        pass[6] = this.fechaNamiento.charAt(3);
        pass[7] = this.fechaNamiento.charAt(4);
        JOptionPane.showMessageDialog(null, "CONTRASEÑA GENERADA : " + (new String(pass)));
        return new String(pass);
    }

}
