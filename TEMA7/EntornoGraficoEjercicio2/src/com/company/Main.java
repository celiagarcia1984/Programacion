package com.company;

import MODELO.Alumnos;
import MODELO.Cursos;
import VISTA.V1;
import VISTA.V2;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Cursos> listaCursos;
    private static JFrame ventana1;
    private static ArrayList<Alumnos> listaAlumnos;
    private static int posicionDelAlumno;
    private static boolean existe;

    public static void main(String[] args) {
        try{
            listaAlumnos = new ArrayList<>();
            crearListadoCursos(); //Crear el ArrayList de los cursos
            // Crea la primera ventana para introducir datos
            mostrarVentana1();


        }catch (Exception e){
            System.out.println(e.getClass());
        }

    }
    public static void mostrarVentana2(){
        JFrame frame = new JFrame("V2");
        frame.setContentPane(new V2().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    public static void mostrarVentana1(){
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().getJpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    public static void opcion(String opcion){
        if(opcion.equalsIgnoreCase("1")){
            darDeBajaAlumno();
        }
        else{
            modificarCurso();
        }

    }
    public static void darDeBajaAlumno(){
    System.out.println("vas a dar de baja");
    listaAlumnos.remove(posicionDelAlumno);


        for (int i=0; i<listaAlumnos.size(); i++){
            System.out.println(listaAlumnos.get(i).getDni());
        }
    }

    public static void modificarCurso(){
        System.out.println("vas a modificar el curso");

    }
    public static void crearAñadirAlumno(String dni, String nombre, String apellido, String curso ){
        listaAlumnos.add(new Alumnos(dni, nombre, apellido, new Cursos(curso) ));
        System.out.println("funcion crearAñadirAlumno"+ listaAlumnos.toString());
    }
    public static void crearListadoCursos()throws Exception{
        listaCursos = new ArrayList<>();
        listaCursos.add(new Cursos("1A"));
        listaCursos.add(new Cursos("1B"));
        listaCursos.add(new Cursos("1C"));
        listaCursos.add(new Cursos("1D"));
        listaCursos.add(new Cursos("2A"));
        listaCursos.add(new Cursos("2B"));
        listaCursos.add(new Cursos("2C"));
        listaCursos.add(new Cursos("2D"));
        listaCursos.add(new Cursos("3A"));
        listaCursos.add(new Cursos("3B"));
        listaCursos.add(new Cursos("3C"));
        listaCursos.add(new Cursos("3D"));
        listaCursos.add(new Cursos("4A"));
        listaCursos.add(new Cursos("4B"));
        listaCursos.add(new Cursos("4C"));
        listaCursos.add(new Cursos("4D"));
        listaAlumnos.add(new Alumnos("celia", "garcia", "72738006", listaCursos.get(2)));
        listaAlumnos.add(new Alumnos("fran","garcia","48961088",listaCursos.get(1)));
        for (int i=0; i<listaAlumnos.size(); i++){
            System.out.println(listaAlumnos.get(i).getDni());
        }
    }
    //tengo que hacer una funcion para que busque el dni en el arrrayList de alumnos

    public static boolean comprobarSiExisteAlumno(String tDni){ //tengo que llamar a esta funcion en v1
        int i;

        for( i=0; i<listaAlumnos.size()&& !listaAlumnos.get(i).getDni().equalsIgnoreCase(tDni); i++){}
            if(i == listaAlumnos.size()){
                existe = false;
                System.out.println("el alumno no existe");
            }
            else{
                posicionDelAlumno =i;
                System.out.println("El alumno existe");
                existe = true;
            }

        return existe;
    }
}
