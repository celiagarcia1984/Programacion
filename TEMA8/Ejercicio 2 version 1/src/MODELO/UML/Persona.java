package MODELO.UML;

import java.util.ArrayList;

public class Persona {
    String dni;
    String nombre;
    String apellido;
    Empresa empresa;/* Tiene que ser objeto Empresa y arraylist eventos*/
    ArrayList<Evento> listaEventos = new ArrayList<>();

    public Persona() {
    }

    public Persona(String dni, String nombre, String apellido, Empresa empresa, ArrayList<Evento> listaEventos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;

        this.empresa = empresa;
        this.listaEventos = listaEventos;
    }

    public Persona(String dni, String nombre, String apellido, Empresa empresa) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(ArrayList<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }
}
