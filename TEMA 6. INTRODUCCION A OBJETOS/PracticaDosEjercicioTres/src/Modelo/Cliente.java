package Modelo;

public class Cliente extends Persona{
    String telefono;

    public Cliente(String nombre, int edad, String telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return  "Cliente: " +
                "Nombre='" + nombre + "\n" +
                "Edad=" + edad + "\n" +
                "Telefono='" + telefono + "\n" ;
    }
}
