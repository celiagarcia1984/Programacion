package MODELO;

public class Mascota {
    private String raza;
    private String nombre;
    private Cliente dueño;
    private Veterinario VeterinarioAsignado;

    public Mascota(String raza, String nombre, Cliente dueño, Veterinario veterinarioAsignado) {
        this.raza = raza;
        this.nombre = nombre;
        this.dueño = dueño;
        this.VeterinarioAsignado = veterinarioAsignado;
    }

    public Mascota(String raza, String nombre, Cliente dueño) {
        this.raza = raza;
        this.nombre = nombre;
        this.dueño = dueño;
    }

}
