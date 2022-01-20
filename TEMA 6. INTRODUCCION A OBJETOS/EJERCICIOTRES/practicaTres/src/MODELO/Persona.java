package MODELO;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String direccion;
    private String telefono;
    private ArrayList<Mascota> listaMascotas;

    public Persona(String nombre, String direccion, ArrayList<Mascota> listaMascotas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaMascotas = listaMascotas;
    }

    public Persona(String nombre, String direccion, String telefono, ArrayList<Mascota> listaMascotas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaMascotas = listaMascotas;
    }

    public Persona(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Persona(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
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

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
