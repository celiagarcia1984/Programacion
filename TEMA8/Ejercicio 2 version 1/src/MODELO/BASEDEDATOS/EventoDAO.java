package MODELO.BASEDEDATOS;

import MODELO.UML.Evento;
import java.sql.Date;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class EventoDAO {

    private Connection conexion;
    private Evento ev=null;
    private boolean confirmarSelect = false;

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

            int res = ps.executeUpdate();
            if(res>=1){
                filaInsertada=true;
                System.out.println("Fila insertada");
            }
            else{
                System.out.println("No se ha hecho el insert");
            }

        } catch (Exception e) {
            filaInsertada =false;
            System.out.println(e.getClass());
        }
        System.out.println("Devuelvo la confirmacion de si se ha insertado una fila. Me voy a la funcion Main.getDatos");
        return filaInsertada;
    }
    /*Segundo Metodo. Select nombre*/
    public Evento selectNombre(String nombre){
        try{
            System.out.println("Estoy en la funcion SelectNombre.");
            String plantilla = "select * from evento where nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1,nombre);
            ResultSet resultado;
            resultado = ps.executeQuery();
            if(resultado.next()){
                String n = resultado.getString("nombre");
                String l = resultado.getString("lugar");
                Date fecha = resultado.getDate("fecha");
                LocalDate lFecha = fecha.toLocalDate();
                Time horaIn = resultado.getTime("HoraInicio");
                LocalTime horaInicio = horaIn.toLocalTime();
                Time horaF =resultado.getTime("HoraFin");
                LocalTime horaFin = horaF.toLocalTime();
                int af = resultado.getInt("aforo");
                int afD =resultado.getInt("aforoDisponible");
                ev = new Evento(n,l,lFecha,horaInicio,horaFin,af,afD);
                System.out.println("He creado un objeto evento " + ev.toString()+ "lO DEVUELVO AL MAIN");
            }else{
                System.out.println("No se ha seleccionado ningun evento");
                confirmarSelect = false;
            }

        }catch (Exception a){

            System.out.println(a.getClass());}
        return ev;
    }
    /*Tercer Metodo. Delete evento*/
    public boolean deleteEvento(Evento evento){
        boolean borrado=false;
        try{
            System.out.println("Estoy en la funcion deleteEvento");
            String plantilla = "delete from evento where nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1, evento.getNombre());
            int rs = ps.executeUpdate();
            if(rs == 1){
                borrado =true;
            }
            else{
                System.out.println("No se ha borrado nada");
            }
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return borrado;
    }
    /*Cuarto Metodo. Select todos los los eventos*/
    public ArrayList<Evento> selectTodos(){
        ArrayList<Evento>listaEventos = new ArrayList<>();
        try{
            /*Tengo que hacer un select de todos los eventos e ir creando objetos evento y guardandolos en el array*/
            String plantilla = "Select * from evento";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                S
            }
        }catch (Exception e){
            System.out.println(e.getClass());
        }
       return listaEventos;
    }

    public boolean confirmarSelect(){

        return confirmarSelect;
    }


}




