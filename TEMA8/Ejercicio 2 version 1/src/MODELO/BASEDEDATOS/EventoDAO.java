package MODELO.BASEDEDATOS;

import MODELO.UML.Evento;
import java.sql.Date;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventoDAO {

    private Connection conexion;

    /*constructor con conexion*/

    public EventoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    /*Primer Metodo. Insert evento*/
    public boolean insertEvento(Evento evento) {
        boolean filaInsertada=false;
        try {
            /*FALTA HACER EL INSERT. Hasta aqui funciona sin problemas. */
            System.out.println("Estoy en la clase EVENTODAO, en la funcion insertEvento. Tengo un objeto evento " +
                    evento.toString());
            /*Preparo la plantilla*/
            String plantilla = "insert into evento values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1,evento.getNombre());
            ps.setString(2,evento.getLugar());
            LocalDate localD = evento.getFecha();
            Date date = Date.valueOf(localD);
            ps.setDate(3,date);
            LocalTime horaIn = evento.getHoraInicio();
            Time sqlHoraIn = Time.valueOf(horaIn);
            ps.setTime(4, Time.valueOf(String.valueOf(sqlHoraIn)));
            LocalTime horaFin = evento.getHoraFin();
            Time sqlHoraFin = Time.valueOf(horaFin);
            ps.setTime(5, Time.valueOf(evento.getHoraFin()));

            ps.setInt(6,evento.getAforo());
            ps.setInt(7,evento.getAforoDisponible());

            ps.executeUpdate();
            filaInsertada=true;

            System.out.println("Fila insertada");


        } catch (Exception e) {
            System.out.println(e.getClass());
        }

        return filaInsertada;
    }


}




