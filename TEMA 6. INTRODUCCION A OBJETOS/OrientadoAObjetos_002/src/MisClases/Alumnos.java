package MisClases;

import javax.swing.*;

public class Alumnos {
    int codigo;
    String nombre;
    String domicilio;
    String telefono;

    /*CONSTRUCTORES*/

    /*Constructor con todos los datos*/
    public Alumnos(int codigo, String nombre, String domicilio, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    /*Constructor vacio*/
    public Alumnos() {
    }

    /*GET Y SET de cada atributo*/

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    /*Funcion que mostrará el mensaje*/

    public String mostrarDatos(){
        String mensaje = "";
        mensaje = "Nombre: " + nombre + " "+ "\n "+
                    "Codigo: " + codigo + "\n"+
                     "Domicilio: " + domicilio + "\n" +
                        "Telefono: " + telefono;
        return mensaje;
    }

}
