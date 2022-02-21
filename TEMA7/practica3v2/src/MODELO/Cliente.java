package MODELO;

import java.util.Arrays;

public class Cliente {
    String nombre;
    String dni;
    String clave;
    Cuenta[] listaCuentas = new Cuenta[2];

    public Cliente(String nombre, String dni, String clave) {
        this.nombre = nombre;
        this.dni = dni;
        this.clave = clave;
    }

    public Cliente(String nombre, String dni, String clave, Cuenta[] listaCuentas) {
        this.nombre = nombre;
        this.dni = dni;
        this.clave = clave;
        this.listaCuentas = listaCuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", clave='" + clave + '\'' +
                ", listaCuentas=" + Arrays.toString(listaCuentas) +
                '}';
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

    public Cuenta[] getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(Cuenta[] listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
}
