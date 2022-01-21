package MODELO;

public class Perro extends Mascota{
    private String antirrabica;

    public Perro(String raza, String nombre, Cliente dueño, Veterinario veterinarioAsignado, String antirrabica) {
        super(raza, nombre, dueño, veterinarioAsignado);
        this.antirrabica = antirrabica;
    }

    public Perro(String raza, String nombre, String antirrabica) {
        super(raza, nombre);
        this.antirrabica = antirrabica;
    }

    public Perro(String raza, String nombre, Cliente dueño, String antirrabica) {
        super(raza, nombre, dueño);
        this.antirrabica = antirrabica;
    }

    public Perro(String raza, String nombre, Veterinario veterinarioAsignado, String antirrabica) {
        super(raza, nombre, veterinarioAsignado);
        this.antirrabica = antirrabica;
    }

    public String getAntirrabica() {
        return antirrabica;
    }

    public void setAntirrabica(String antirrabica) {
        this.antirrabica = antirrabica;
    }
}
