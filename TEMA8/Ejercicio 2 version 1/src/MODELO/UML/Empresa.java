package MODELO.UML;

import java.util.ArrayList;

public class Empresa {

    String nombre;
    String direccion;
    String telefono;
    /*La direccion con persona es unilateral. Aqui no hago referencia a Personas*/
    public Empresa( String nombre, String direccion, String telefono) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
