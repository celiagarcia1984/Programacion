package MODELO.UML;

import java.util.ArrayList;

public class Empresa {
    String idEmpresa;
    String nombre;
    String direccion;
    String telefono;
    ArrayList<Persona> listaPersonas = new ArrayList<>();
    /*Una empresa tiene muchas personas pero una persona solo tiene una empresa.
    * Relacion UNIDIRECCIONAL*/
/*Constructor sin array de personas. Lo añado despues*/
    public Empresa(String idEmpresa, String nombre, String direccion, String telefono) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa='" + idEmpresa + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaPersonas=" + listaPersonas +
                '}';
    }
}
