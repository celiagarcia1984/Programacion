package MisClases;

import java.util.ArrayList;

public class Pelicula {
    String titulo;
    int año;
    int duracion;
    String tipo;

    /*Establece la relacion con la clase estudios*/
    ArrayList<Estudio> Estudios;

    public Pelicula(String titulo, int año, int duracion, String tipo) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public Pelicula(String titulo, int año, int duracion, String tipo, ArrayList<Estudio> estudios) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.tipo = tipo;
        Estudios = estudios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Estudio> getEstudios() {
        return Estudios;
    }

    public void setEstudios(ArrayList<Estudio> estudios) {
        Estudios = estudios;
    }
}
