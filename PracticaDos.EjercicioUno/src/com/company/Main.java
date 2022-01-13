package com.company;

import MisClases.Estudio;
import MisClases.Pelicula;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    static ArrayList<Pelicula> aPeliculas = new ArrayList<>();
    static ArrayList<Estudio> aEstudios = new ArrayList<>();
    static int posicionDeLaMasLarga = 0;
    static String estudiosParticipantes = "";
    static ArrayList<Estudio> estudiosPelicula = new ArrayList<>();
    static ArrayList<String> estudiosEncontrados = new ArrayList<>();
    static ArrayList<Integer> contadorEstudios = new ArrayList<>();

    public static void main(String[] args) {
        /*Creo un arrayList para guardar las peliculas*/
        aPeliculas.add(new Pelicula("El rey Leon", 2006, 180, "Infantil"));
        aPeliculas.add(new Pelicula("Cenicienta", 2005, 190, "Infantil"));
        aPeliculas.add(new Pelicula("La bella y la bestia", 2001, 210, "Infantil"));
        aPeliculas.add(new Pelicula("Cars", 2002, 120, "Infantil"));

        /*Creo un arrayList para guardar los estudios*/
        aEstudios.add(new Estudio("Uno", "Vitoria", "calle Vitoria", "uno@gmail.com",
                "22/10/1990", "España"));
        aEstudios.add(new Estudio("Dos", "Vitoria", "Calle Vitoria", "dos@gmail.com",
                "22/11/1990", "España"));
        aEstudios.add(new Estudio("Tres", "Vitoria", "Calle Vitoria", "tres@gmail.com",
                "22/12/1990", "España"));

        /*Creo este arrayList para añadir los estudios que luego voy a añadir a la primera pelicula*/


        estudiosPelicula.add(aEstudios.get(0)); /*He añadido el estudio Uno*/
        estudiosPelicula.add(aEstudios.get(1)); /*He añadido el estudio Dos*/
        /*Ahora el arrayList estudiosPelicula tiene los estudios que voy a añadir a la pelicula El rey Leon*/
        aPeliculas.get(0).setEstudios(estudiosPelicula);

        estudiosPelicula = new ArrayList<>();   /*Vuelvo a crear el arrayList para guardar los estudios que forman parte de
        la pelicula cenicienta*/
        estudiosPelicula.add(aEstudios.get(1));
        estudiosPelicula.add(aEstudios.get(2));

        aPeliculas.get(1).setEstudios(estudiosPelicula);

        estudiosPelicula = new ArrayList<>();

        estudiosPelicula.add(aEstudios.get(0));

        aPeliculas.get(2).setEstudios(estudiosPelicula);

        estudiosPelicula = new ArrayList<>();

        estudiosPelicula.add(aEstudios.get(1));
        estudiosPelicula.add(aEstudios.get(2));

        aPeliculas.get(3).setEstudios(estudiosPelicula);
        /*Todas las peliculas tienen estudios añadidos*/

        /*Voy a añadir telefonos a los estudios. voy a crear un arrayList telefonos para ir añadiendo*/

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("666666666666");
        telefonos.add("777777777777");

        aEstudios.get(0).setListaTelefonos(telefonos);
        aEstudios.get(1).setListaTelefonos(telefonos);
        aEstudios.get(2).setListaTelefonos(telefonos);
        /*Al hacer un debug se ve que se han añadido todos los datos bien*/
        /*Mostrar el nombre del estudio o estudios en los que se ha producido la pelicula mas larga*/

        /*Tengo que buscar en el arraylIST peliculas la mayor duracion y de esa posicion sacar el nombre de los estudios*/


        for (int i = 0; i < aPeliculas.size(); i++) {

            if (i == 0) {
                posicionDeLaMasLarga = i;
            } else {
                if (aPeliculas.get(i).getDuracion() > aPeliculas.get(posicionDeLaMasLarga).getDuracion()) {
                    posicionDeLaMasLarga = i;
                }
            }
        }
        for (int i = 0; i < aPeliculas.get(posicionDeLaMasLarga).getEstudios().size(); i++) {
            estudiosParticipantes = estudiosParticipantes + " " + aPeliculas.get(posicionDeLaMasLarga).getEstudios().get(i).getNombre();
        }

        System.out.println("Los estudios que han realizado esta pelicula son: " + estudiosParticipantes);
        /*Buscar el estudio que mas peliculas ha producido*/
        /*Voy a usar el arrayList de estudiosPeliculas para guardar los diferentes estudios que hay y luego contarlos*/


        for (int i = 0; i < aPeliculas.size(); i++) {
            for (int x = 0; x < aPeliculas.get(i).getEstudios().size(); x++) {
                String nombreEncontrado = aPeliculas.get(i).getEstudios().get(x).getNombre();
                int y = 0;
                for (y = 0; y < estudiosEncontrados.size() && !estudiosEncontrados.get(y).equalsIgnoreCase(nombreEncontrado); y++) {
                }
                boolean existe = estudiosEncontrados.contains(nombreEncontrado);
                if (!existe) {
                    estudiosEncontrados.add(y, nombreEncontrado);
                    contadorEstudios.add(y, 0);
                }
                int acumulado = 0;
                acumulado = contadorEstudios.get(y);
                acumulado = acumulado + 1;
                contadorEstudios.set(y, acumulado);
            }

        }

        for (int a = 0; a < estudiosEncontrados.size(); a++) {
            System.out.println("El estudio " + estudiosEncontrados.get(a) + " ha participado en " + contadorEstudios.get(a) + " peliculas");
        }
        int numeroDeProduciones = 0;
        String estudioConMasProducciones="";
        for(int i =0; i< contadorEstudios.size();i++){
            if(contadorEstudios.get(i)> numeroDeProduciones){
                numeroDeProduciones = contadorEstudios.get(i);
                estudioConMasProducciones = estudiosEncontrados.get(i);
            }
        }
        System.out.println("El estudio con mas producciones es: "+estudioConMasProducciones );
         /* si el array contadordEstudios en la posicion i es mayor que numero de numeroDeProduciones
                    numero de produciones = al contador en la posicion i
                 estudio con mas produciones=estudios Encontrados en la posicion i   */

    }


}
