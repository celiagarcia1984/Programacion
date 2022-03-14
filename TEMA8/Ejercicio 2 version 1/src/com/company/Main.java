package com.company;

import MODELO.BASEDEDATOS.BD;
import MODELO.BASEDEDATOS.EventoDAO;
import MODELO.UML.Evento;
import VISTA.VentanaMenu;
import VISTA.VentanaNuevoEvento;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    /*Lo que necesito para establecer la conexion*/
    private static BD bd;
    private static EventoDAO evenDao;
    /**/
    static JFrame vp;
    static Evento evento;

    public static void main(String[] args) {
    /*Abro la conexion iniciando los dos objetos de la conexion*/
        bd = new BD();
        bd.abrirConexion();
    /*Objeto eventoDao*/
        evenDao =new EventoDAO(bd.getCon()); /*No entiendo muy bien el porque de esto*/
    /*Ahora tengo que abrir la ventanaMenu*/
        abrirVentanaPrincipal();

    }
    public static Evento getDatos(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                                  int aforo, int aforoDisponible){
        boolean filaInsertada;
        try{
            evento = new Evento(nombre, lugar, fecha, horaInicio,horaFin,aforo,aforoDisponible);
            System.out.println(evento + " Estoy en la funcion get datos para comprobar si la fecha es null" );

           filaInsertada =  evenDao.insertEvento(evento);
           if(filaInsertada){
               getConfirmacion();
           }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return evento;
    }
    public static boolean getConfirmacion(){
        boolean insertado = false;
        try{
            insertado =true;
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return insertado;
    }
    public static void abrirVentanaPrincipal(){
        try{
            System.out.println("Abro la ventana Principal");
            JFrame vp = new JFrame("VentanaMenu");
            vp.setContentPane(new VentanaMenu().getJpPrincipal());
            vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vp.pack();
            vp.setVisible(true);
            vp.setLocationRelativeTo(null);

        }catch (Exception e){
             System.out.println(e.getClass());
        }
    }
    public static void ventanaAñadirEvento(){
        try{
            /*Main de la ventana Añadir Evento*/
            VentanaNuevoEvento dialog = new VentanaNuevoEvento();
            dialog.pack();
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(null);
            vp.dispose();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static void abrirVentanaEliminarModificar(){}
}
