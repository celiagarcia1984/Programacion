package MODELO;

import java.util.ArrayList;

public class Cliente extends Persona{
    public Cliente(String nombre, String direccion, ArrayList<Mascota> listaMascotas) {
        super(nombre, direccion, listaMascotas);
    }

    public Cliente(String nombre, String direccion, String telefono, ArrayList<Mascota> listaMascotas) {
        super(nombre, direccion, telefono, listaMascotas);
    }

    public Cliente(String nombre, String direccion, String telefono) {
        super(nombre, direccion, telefono);
    }

    public Cliente(String nombre, String direccion) {
        super(nombre, direccion);
    }

}
