package MisClases;

import java.util.ArrayList;

public class Estudio {
    String nombre;
    String ciudad;
    String direccion;
    String direccionWeb;
    String lDfundacion;
    String pais;
    ArrayList<String> listaTelefonos;
    /*La relacion es ahora bidireccional. ArrayList de Peliculas*/
    ArrayList<Pelicula> listaPeliculas;


    public Estudio(String nombre, String ciudad, String direccion, String direccionWeb, String lDfundacion, String pais,
                   ArrayList<String> listaTelefonos, ArrayList<Pelicula> listaPeliculas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.direccionWeb = direccionWeb;
        this.lDfundacion = lDfundacion;
        this.pais = pais;
        this.listaTelefonos = listaTelefonos;
        this.listaPeliculas = listaPeliculas;
    }

    public Estudio(String nombre, String ciudad, String direccion, String direccionWeb, String lDfundacion, String pais)
    {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.direccionWeb = direccionWeb;
        this.lDfundacion = lDfundacion;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionWeb() {
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }

    public String getlDfundacion() {
        return lDfundacion;
    }

    public void setlDfundacion(String lDfundacion) {
        this.lDfundacion = lDfundacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<String> getListaTelefonos() {
        return listaTelefonos;
    }

    public void setListaTelefonos(ArrayList<String> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }
}
