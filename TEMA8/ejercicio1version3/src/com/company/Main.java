package com.company;

import MODELO.BD.BaDa;
import MODELO.BD.PersonaDao;
import MODELO.UML.Persona;
import VISTA.VentanaDatos;
import VISTA.VentanaOpciones;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    private static BaDa bd;
    private static PersonaDao pDao;

    private static JFrame vOpciones;
    private static JFrame vDatos;

    private static Persona pers = new Persona();
    private static ArrayList<Persona> listaPersonas;



    public static void main(String[] args) {
	/*Objeto BaDa para establecer la conexion. Voy a abrir la conexion al principio del ejercicio y cerrarla al final*/
        bd = new BaDa();
        bd.abrirConexion();
    /*Objeto personaDao*/
        pDao = new PersonaDao(bd.getCon());
    /*Hasta aqui para establecer la conexion con la base de datos*/

        /*Ahora Abro ventana Opciones*/
        abrirVentanaOpciones();

    }
   /*Estas funciones son para sacar todas las personas. Necesito un arrayList*/
    public static ArrayList<Persona> getDatosPersonas(){
        listaPersonas = new ArrayList<>();
        try{
            /*Guardo lo que me devuelve el select* */
            listaPersonas = pDao.selectDeTodo();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return listaPersonas;
    }
    public static void salir(){
        vDatos.dispose();
        abrirVentanaOpciones();
    }
    public static void cerrarPrograma(){
        vOpciones.dispose();
    }

    /*Estas funciones son para realizar la consulta de una persona*/
    public static void getNombre(String nombre){
        try{
            /*Le paso el nombre a la clase pDao*/
           pers = pDao.buscarPersona(nombre);
           /*Tengo los datos de la persona y se los tengo que pasar a la vista*/
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static Persona setDatosPersona(){
        return pers;
    }

    /*Estas funciones son para realizar el insert*/
    public static void getDatos(String nombre, int edad, String profesion, String telefono){
        try{
            /*Tengo que crear un objeto persona*/
            pers = new Persona(nombre,edad, profesion,telefono);
            pDao.registrarPersona(pers);
            if(pDao.resultado()){
                vDatos.dispose();
                abrirVentanaOpciones();
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static boolean confirmarInsert(){
        boolean confirmado=true;
        return confirmado;
    }

    /*Estas funciones son para abrir las ventanas*/
    public static void getOpcion(int opcion){
        switch(opcion){
            case 1: case 2:
                abrirVentanaDatos(opcion);
                /*Si la opcion es 1 o 2. Abro la ventana datos*/
                break;
            case 3:
                abrirVentanaDatos(opcion);

        }
    }
    public static void abrirVentanaDatos(int opcion){
        vOpciones.dispose();
        vDatos = new JFrame("VentanaDatos");
        vDatos.setContentPane(new VentanaDatos(opcion).getJpPrincipal());
        vDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vDatos.pack();
        vDatos.setVisible(true);
        vDatos.setLocationRelativeTo(null);
    }
    public static void abrirVentanaOpciones(){
        vOpciones = new JFrame("VentanaOpciones");
        vOpciones.setContentPane(new VentanaOpciones().getJpPrincipal());
        vOpciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vOpciones.pack();
        vOpciones.setVisible(true);
        vOpciones.setLocationRelativeTo(null);
        /*Pongo nombre a la ventana para poder cerrarla cuando abra la ventanaDatos*/
        System.out.println("Abro la ventanaOpciones. Paso el control a la ventana"); /*Ahora el action performer del input*/
    }

}
