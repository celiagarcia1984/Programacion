package com.company;

import MODELO.Alumnos;
import MODELO.Cursos;
import VISTA.V1;

import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Cursos> listaCursos;
    private static JFrame ventana1;
    private static ArrayList<Alumnos> listaAlumnos;

    public static void main(String[] args) {
        try{
            crearListadoCursos(); //Crear el ArrayList de los cursos
            // Crea la primera ventana para introducir datos
            listaAlumnos =new ArrayList<>();
            mostrarVentana();



        }catch (Exception e){
            System.out.println();
        }

    }
    public static void mostrarVentana(){
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().getJpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
    }
    //tengo que hacer una funcion para que busque el dni en el arrrayList de alumnos

    public static boolean comprobarSiExisteAlumno(String tDni){ //tengo que llamar a esta funcion en v1
        boolean existe=true;
        for(int i =0; i<listaAlumnos.size(); i++){
            if(!listaAlumnos.get(i).getDni().equalsIgnoreCase(tDni)){
                existe = false; //Si no encuentra el dni se pone a false
            }
            else{
                existe = true;
            }
        }
        return existe;
    }
}
