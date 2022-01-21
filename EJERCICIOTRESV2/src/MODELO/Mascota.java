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
        VeterinarioAsignado = veterinarioAsignado;
    }

    public Mascota(String raza, String nombre) {
        this.raza = raza;
        this.nombre = nombre;
    }

    public Mascota(String raza, String nombre, Cliente dueño) {
        this.raza = raza;
        this.nombre = nombre;
        this.dueño = dueño;
    }

    public Mascota(String raza, String nombre, Veterinario veterinarioAsignado) {
        this.raza = raza;
        this.nombre = nombre;
        VeterinarioAsignado = veterinarioAsignado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public Veterinario getVeterinarioAsignado() {
        return VeterinarioAsignado;
    }

    public void setVeterinarioAsignado(Veterinario veterinarioAsignado) {
        VeterinarioAsignado = veterinarioAsignado;
    }
}
