package com.company;
import Vista.*;
import Modelo.Persona;


import javax.swing.*;
import java.util.ArrayList;

public class Main {

    static public  ArrayList<Persona> listaPersonas;
    //referencias a las ventanas
    private static JFrame VentanaPrincipal;

    public static void main(String[] args) {
        listaPersonas = new ArrayList<>();


        //Creaccion y cisualizacion de la primera venta.
        //Copia y adaptacion del main de la propia ventana
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.setVisible(true);

    }

    public static void tenDatos(String tnombre, String tapelllido, String tdni) {
     listaPersonas.add(new Persona(tnombre,tapelllido,tdni));
    }
    public static void tomaDatos(){}
}
