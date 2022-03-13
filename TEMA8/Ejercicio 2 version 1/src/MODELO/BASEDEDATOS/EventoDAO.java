package MODELO.BASEDEDATOS;

import MODELO.UML.Evento;

import java.sql.Connection;

public class EventoDAO {

    private Connection conexion;

    /*constructor con conexion*/

    public EventoDAO(Connection conexion) {
        this.conexion = conexion;
    }
    /*Primer Metodo. Insert evento*/
    public void insertEvento(Evento evento){
        System.out.println("Estoy en la clase EVENTODAO, en la funcion insertEvento. Tengo un objeto evento "+
                evento.toString());
        /*FALTA HACER EL INSERT. Hasta aqui funciona sin problemas. Tengo que volver a poner el conector, cambiar el nombre
        * de la base de datos y de la tabla. */
    }

}
