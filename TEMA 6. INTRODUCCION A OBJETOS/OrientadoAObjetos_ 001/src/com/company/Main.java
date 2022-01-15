package com.company;

import MisClases.Circunferencia;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

	int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio de la circunferencia"));

        Circunferencia Circulo;
        Circulo = new Circunferencia(radio);

        //System.out.println(Circulo.getRadio());

        double area = Circulo.CalcularArea();
        double longitud = Circulo.CalcularLongitud();
        double volumen = Circulo.CalcularVolumen();
        System.out.println("El area es: " + area + ", La longitud es: " + longitud+ ", y el volumen es " + volumen);
    }

}
