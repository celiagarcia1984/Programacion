package com.company;

import MisClases.Estudio;
import MisClases.Pelicula;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    static ArrayList<Estudio> listaEstudios = new ArrayList<>();
    static ArrayList<Estudio> estudiosPelicula = new ArrayList<>(); /*Este arrayList lo e usado para ir guardando en
    lista de peliculas los estudios que han producido cada pelicula*/

    public static void main(String[] args) {
	try{

        crearLlenarArrayPeliculas();
        crearLlenarArrayEstudios();
        añadirEstudiosAPeliculas();
        añadirPeliculasAEstudios();
/* mostrar el nombre de los estudios en los que se ha producido la pel´ıcula mas larga y el ´
nombre del estudio que mas pel ´ ´ıculas ha producido.*/
        String estudiosQueParticipan = buscarLaPeliculaMasLargaYelEstudioProductor();
        String estudiosQueMasHanProducido = buscarElEstudioQueMasPeliculasHaProducido();

        JOptionPane.showMessageDialog(null, estudiosQueParticipan);
        JOptionPane.showMessageDialog(null, estudiosQueMasHanProducido);

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
    /*Buscar la pelicula mas larga*/
    static String buscarLaPeliculaMasLargaYelEstudioProductor ()throws  Exception{

        /*Creo una variable que guarde la duracion mas larga*/
        int posicionDeLaPeliculaMasLarga = 0;
        int mayorDuracion=0;
        for(int i=0; i<listaPeliculas.size(); i++){
            if(listaPeliculas.get(i).getDuracion() > mayorDuracion){
                mayorDuracion = listaPeliculas.get(i).getDuracion();
                posicionDeLaPeliculaMasLarga = i;
            }/*Aqui tengo la posicion de la pelicula mas larga. Ahora tengo que buscar en el array
            de estudios de esa pelicula que está en la posicion que e obtenido*/
        }

        String estudiosQueParticipan="";

        for(int i =0; i<listaPeliculas.get(posicionDeLaPeliculaMasLarga).getEstudios().size(); i++){
           estudiosQueParticipan = estudiosQueParticipan + "" + listaPeliculas.get(posicionDeLaPeliculaMasLarga).getEstudios().get(i).getNombre();
        }
        estudiosQueParticipan = "La pelicula mas larga es: " + listaPeliculas.get(posicionDeLaPeliculaMasLarga).getTitulo()
                + " y ha sido producida por: " + estudiosQueParticipan;
        return estudiosQueParticipan;
    }
    /*Buscar el estudio que mas peliculas ha producido. Voy a comparar los arraylist de peliculas dentro de estudios.*/
    static String buscarElEstudioQueMasPeliculasHaProducido() throws Exception{
        String mensaje="";
        /*Tengo que buscar dentro de estudios*/
        int longitudDelArrayListMasLargo=0;
        int posicionDelEstudioQueHaProducidoMasPeliculas = 0;
        int estudioEmpatado = 0;
        for (int i = 0; i< listaEstudios.size(); i++){

            if(listaEstudios.get(i).getListaPeliculas().size() > longitudDelArrayListMasLargo){
                longitudDelArrayListMasLargo = listaEstudios.get(i).getListaPeliculas().size();
                posicionDelEstudioQueHaProducidoMasPeliculas = i;
            }
            else if(listaEstudios.get(i).getListaPeliculas().size()==longitudDelArrayListMasLargo){
                estudioEmpatado = i;
            }
        }
        String estudioQueMasProduce="";
        if(estudioEmpatado == 0){
            estudioQueMasProduce = "El estudio que mas peliculas ha producido es: " + listaEstudios.get(posicionDelEstudioQueHaProducidoMasPeliculas).getNombre();
        }
        else{
            estudioQueMasProduce = "Los estudios que mas peliculas han producido son: " + listaEstudios.get(posicionDelEstudioQueHaProducidoMasPeliculas).getNombre()
                    + " y " + listaEstudios.get(estudioEmpatado).getNombre();
        }
        mensaje = estudioQueMasProduce;

        return mensaje;
    }
}
