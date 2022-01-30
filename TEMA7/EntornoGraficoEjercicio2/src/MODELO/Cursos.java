package MODELO;

import java.util.ArrayList;

public class Cursos {
    String codigoCurso;
    ArrayList<Alumnos> listaAlumnos;

    public Cursos(String codigoCurso, ArrayList<Alumnos> listaAlumnos) {
        this.codigoCurso = codigoCurso;
        this.listaAlumnos = listaAlumnos;
        listaAlumnos= new ArrayList<>();
    }

    public Cursos(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public ArrayList<Alumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumnos> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    //añadir borrar alumno

    @Override
    public String toString() {
        return "Cursos{" +
                "codigoCurso='" + codigoCurso + '\'' +
                ", listaAlumnos=" +
                '}';
    }

}
