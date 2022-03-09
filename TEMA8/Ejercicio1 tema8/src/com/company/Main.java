package com.company;

import Vista.VentanaOpciones;
import Vista.VentanaPersonas;
import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    private static JFrame f;

    public Main() {
    }

    public static void main(String[] args) {
        try {
            mostrarVentanaOpciones();
        } catch (Exception var2) {
            System.out.println(var2.getClass());
        }

    }

    static void mostrarVentanaOpciones() throws Exception {
        System.out.println("Estoy en la funcion mostrarVentanaOpciones");
        f = new JFrame("VentanaOpciones");
        f.setContentPane((new VentanaOpciones()).getJpPanelPrincipal());
        f.setDefaultCloseOperation(3);
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo((Component)null);
    }

    public static void mostrarVentanas() throws Exception {
        mostrarVentanaPersonas();
    }

    static void mostrarVentanaPersonas() throws Exception {
        f.dispose();
        JFrame frame = new JFrame("VentanaPersonas");
        frame.setContentPane((new VentanaPersonas()).getJpPanelPrincipal());
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
    }
}
