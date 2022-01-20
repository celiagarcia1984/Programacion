package MODELO;

import java.util.ArrayList;

public class Veterinario extends Persona{
    private String dni;
    private String numeroSS;

    public Veterinario(String nombre, String direccion, ArrayList<Mascota> listaMascotas, String dni, String numeroSS) {
        super(nombre, direccion, listaMascotas);
        this.dni = dni;
        this.numeroSS = numeroSS;
    }

    public Veterinario(String nombre, String direccion, String dni, String numeroSS) {
        super(nombre, direccion);
        this.dni = dni;
        this.numeroSS = numeroSS;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

}
