package Modelo;

public class Persona {
    String nombre;
    int edad;
    String profesion;
    String telefono;

    public Persona(String nombre, int edad, String profesion, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.telefono = telefono;
    }

    public Persona() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return this.profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
        return "Persona{nombre='" + this.nombre + '\'' + ", edad=" + this.edad + ", profesion='" + this.profesion + '\'' + ", telefono='" + this.telefono + '\'' + '}';
    }
}
