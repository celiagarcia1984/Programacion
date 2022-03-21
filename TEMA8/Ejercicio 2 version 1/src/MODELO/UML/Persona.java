package MODELO.UML;

public class Persona {
    String dni;
    String nombre;
    String apellido;
    String nombreEvento;
    String idEmpresa;

    /*No me interesa saber los eventos a los que va a asistir una persona sino las
    * personas que van a asistir a un evento, relacion UNIDIRECCIONAL esta puesto un array de personas
    * en la clase evento*/

    public Persona() {
    }


    public Persona(String dni, String nombre, String apellido, String nombreEvento, String idEmpresa) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreEvento = nombreEvento;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", idEmpresa='" + idEmpresa + '\'' +
                '}';
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
