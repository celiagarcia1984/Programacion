package com.company;

import VISTA.VentanaOpciones;

import javax.swing.*;

public class Main {
    static JFrame f;
    static int opcion;

    public static void main(String[] args) {
	try{
        mostrarVentanaOpciones();
        f.dispose();
        int opcion=0;
        mostrarVentanaPersonas(opcion);



    }catch (Exception e){
	    System.out.println(e.getClass());
    }
    }


    public static void mostrarVentanaOpciones()throws Exception{
        f = new JFrame("VentanaOpciones");
        f.setContentPane(new VentanaOpciones().getJpPrincipal());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
    public static void mostrarVentanaPersonas(int opcion)throws Exception{

    }
}
