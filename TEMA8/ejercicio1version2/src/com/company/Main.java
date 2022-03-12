package com.company;

import MODELO.BASEDEDATOS.BD;
import MODELO.BASEDEDATOS.PersonaDAO;
import MODELO.UML.Persona;
import VISTA.VentanaDatos;
import VISTA.VentanaOpciones;

import javax.swing.*;
import java.sql.Connection;

public class Main {
    private static JFrame f;
    private static Persona p;
    private static Connection con;
    private static PersonaDAO pdao;
    private static BD b;
    public static void main(String[] args) {
        /*OBJETO BD*/
        b = new BD();
        b.abrirConexion();
        /*OBJETO PERSONADAO*/

        abrirVentanaOpciones();

    }
    public static void getDatos(String nombre,int edad,String profesion, String telefono){
        try{
            pdao=new PersonaDAO(b.getCon());
            System.out.println("e creado un objeto pdao");
            p = new Persona(nombre,edad,profesion,telefono);
            System.out.println("e creado un objeto persona");
            System.out.println("llamo a la funcion registrar persona");
            pdao.registrarPersona(p);

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static void abrirVentanaOpciones(){
        try{
            f = new JFrame("VentanaOpciones");
            f.setContentPane(new VentanaOpciones().getJpPrincipal());
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);
            f.setLocationRelativeTo(null);
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static void abrirVentanaDatos(int opcion){
        try{
            f.dispose();
            JFrame frame = new JFrame("VentanaDatos");
            frame.setContentPane(new VentanaDatos(opcion).getJpPrincipal());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}
