package com.company;

import MisClases.Estudio;
import MisClases.Pelicula;

import java.util.ArrayList;

public class Main {
    static ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    static ArrayList<Estudio> listaEstudios = new ArrayList<>();
    static ArrayList<Estudio> estudiosPelicula = new ArrayList<>();

    public static void main(String[] args) {
	try{

        crearLlenarArrayPeliculas();
        crearLlenarArrayEstudios();
        añadirEstudiosAPeliculas();
        añadirPeliculasAEstudios();



    }catch (Exception e){
        System.out.println(e.getClass());
        }
    }

    static void crearLlenarArrayPeliculas() throws Exception{
        listaPeliculas.add(new Pelicula("El rey Leon", 2006, 180, "Infantil"));
        listaPeliculas.add(new Pelicula("Cenicienta", 2005, 190, "Infantil"));
        listaPeliculas.add(new Pelicula("La bella y la bestia", 2001, 210, "Infantil"));
        listaPeliculas.add(new Pelicula("Cars", 2002, 120, "Infantil"));

    }
    static void añadirEstudiosAPeliculas()throws Exception{
        /*Añadir estudios a las peliculas "El Rey Leon"*/
        estudiosPelicula.add(listaEstudios.get(0)); /*He añadido el estudio Uno*/
        estudiosPelicula.add(listaEstudios.get(1)); /*He añadido el estudio Dos*/
        /*Ahora el arrayList estudiosPelicula tiene los estudios que voy a añadir a la pelicula El rey Leon*/
        listaPeliculas.get(0).setEstudios(estudiosPelicula);
        /*a********************************************Cenicienta*************a*/
        estudiosPelicula = new ArrayList<>();   /*Vuelvo a crear el arrayList para guardar los estudios que forman parte de
        la pelicula cenicienta*/
        estudiosPelicula.add(listaEstudios.get(1));
        estudiosPelicula.add(listaEstudios.get(2));

        listaPeliculas.get(1).setEstudios(estudiosPelicula);
        /*a*******************************************La Bella y la Bestia**************a*/
        estudiosPelicula = new ArrayList<>();
        estudiosPelicula.add(listaEstudios.get(0));

        listaPeliculas.get(2).setEstudios(estudiosPelicula);
        /*a********************************************CARS*************a*/
        estudiosPelicula = new ArrayList<>();
        estudiosPelicula.add(listaEstudios.get(1));
        estudiosPelicula.add(listaEstudios.get(2));

        listaPeliculas.get(3).setEstudios(estudiosPelicula);
    }
    static void crearLlenarArrayEstudios() throws Exception{
        /*Crear y llenar el array listaEstudios sin array telefonos ni array peliculas*/
        listaEstudios.add(new Estudio("Uno", "Vitoria", "calle Vitoria", "uno@gmail.com",
                "22/10/1990", "España"));
        listaEstudios.add(new Estudio("Dos", "Vitoria", "Calle Vitoria", "dos@gmail.com",
                "22/11/1990", "España"));
        listaEstudios.add(new Estudio("Tres", "Vitoria", "Calle Vitoria", "tres@gmail.com",
                "22/12/1990", "España"));

        /*Añadir telefonos a los estudios*/
        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("666666666666");
        telefonos.add("777777777777");
        listaEstudios.get(0).setListaTelefonos(telefonos);
        listaEstudios.get(1).setListaTelefonos(telefonos);
        listaEstudios.get(2).setListaTelefonos(telefonos);

    }
    static void añadirPeliculasAEstudios()throws Exception{
        /*Añadir Peliculas a los estudios*/
        /*estudio UNO (0)*/
        ArrayList<Pelicula> peliculasPorEstudio = new ArrayList<>();
        peliculasPorEstudio.add(listaPeliculas.get(0));
        peliculasPorEstudio.add(listaPeliculas.get(2));

        listaEstudios.get(0).setListaPeliculas(peliculasPorEstudio);
        /*a*****ESTUDIO DOS (1)*******************A*/
        peliculasPorEstudio = new ArrayList<>();
        peliculasPorEstudio.add(listaPeliculas.get(0));
        peliculasPorEstudio.add(listaPeliculas.get(1));
        peliculasPorEstudio.add(listaPeliculas.get(3));

        listaEstudios.get(1).setListaPeliculas(peliculasPorEstudio);
        /*A******ESTUDIO TRE (2)***************A*/
        peliculasPorEstudio = new ArrayList<>();
        peliculasPorEstudio.add(listaPeliculas.get(1));
        peliculasPorEstudio.add(listaPeliculas.get(3));

        listaEstudios.get(2).setListaPeliculas(peliculasPorEstudio);
    }
}
