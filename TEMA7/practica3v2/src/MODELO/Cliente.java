package MODELO;

import java.util.ArrayList;
import java.util.Arrays;

public class Cliente {
    String nombre;
    String dni;
    String clave;
    ArrayList<Cuenta> listaCuentas = new ArrayList<>();

    public Cliente(String nombre, String dni, String clave) {
        this.nombre = nombre;
        this.dni = dni;
        this.clave = clave;
    }


    public Cliente(String nombre, String dni, String clave, ArrayList<Cuenta> listaCuentas) {
        this.nombre = nombre;
        this.dni = dni;
        this.clave = clave;
        this.listaCuentas = listaCuentas;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


}
