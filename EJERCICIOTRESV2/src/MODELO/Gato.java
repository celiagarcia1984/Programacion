package MODELO;

import java.util.ArrayList;

public class Gato extends Mascota{
    private String leucemia;

    public Gato(String raza, String nombre, Cliente dueño, Veterinario veterinarioAsignado, String leucemia) {
        super(raza, nombre, dueño, veterinarioAsignado);
        this.leucemia = leucemia;
    }

    public Gato(String raza, String nombre, String leucemia) {
        super(raza, nombre);
        this.leucemia = leucemia;
    }

    public Gato(String raza, String nombre, Cliente dueño, String leucemia) {
        super(raza, nombre, dueño);
        this.leucemia = leucemia;
    }

    public Gato(String raza, String nombre, Veterinario veterinarioAsignado, String leucemia) {
        super(raza, nombre, veterinarioAsignado);
        this.leucemia = leucemia;
    }

    public String getLeucemia() {
        return leucemia;
    }

    public void setLeucemia(String leucemia) {
        this.leucemia = leucemia;
    }
}
