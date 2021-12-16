package MisClases;

import javax.swing.*;

public class Alumnos {
    int codigo;
    String nombre;
    String domicilio;
    String telefono;

    public Alumnos(int codigo, String nombre, String domicilio, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Alumnos() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String mostrarDatos(){
        String mensaje = "";
        mensaje = JOptionPane.showMessageDialog("Nombre: " + nombre + " ");

        return mensaje;
    }

}
