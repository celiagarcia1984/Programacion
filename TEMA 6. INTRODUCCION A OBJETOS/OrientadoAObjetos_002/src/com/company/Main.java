package com.company;

import MisClases.Alumnos;

import javax.swing.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        try{
            /*Crear un array list con objetos tipo Alumnos*/
            ArrayList<Alumnos> agenda = new ArrayList();
            String continuar="s";

            do{
                /*Creo un objeto del tipo Alumno*/
                Alumnos alumno;
                alumno = new Alumnos();
                /*Pido los datos*/
                int codigo=0;
                String nombre;
                String domicilio;
                String telefono;

                codigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el codigo del alumno"));
                /*Validar el codigo*/
                codigo = validarCodigo(codigo);
                nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno");
                domicilio = JOptionPane.showInputDialog("Introduce el domicilio del alumno");
                telefono = JOptionPane.showInputDialog("Introduce el teléfono del alumno");
                /*Se llena el objeto en el arrayList*/
                alumno.setCodigo(codigo);
                alumno.setNombre(nombre);
                alumno.setDomicilio(domicilio);
                alumno.setTelefono(telefono);

                agenda.add(alumno);

            }while(continuar.equalsIgnoreCase("s"));


        }catch (Exception e){
            System.out.println(e.getClass());
        }
        /*Para que el codigo sea valido no tiene que estar en el arrayList, tiene que ser solo numerico*/
        /*Buscar si el codigo está repetido*/
        static validarCodigo(int codigo) throw Exception{

        }


    }

}
