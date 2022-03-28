package MODELO.BASEDEDATOS;

import MODELO.UML.Evento;
import java.sql.Date;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
            System.out.println("F(X)EVENTODAOinsertEvento.Recibe un objeto Evento " +
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
    /*Segundo Metodo. Select nombre. Devuelve un objeto evento a partir del nombre que recibe*/
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
    public boolean updateEvento(Evento evento){
        boolean updateHecho=false;
        try{
            String plantilla= "update evento set lugar = ?,fecha=? ,horaInicio = ?, horaFin=?, aforo=?,aforoDisponible=? where nombre=?";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1,evento.getLugar());
            ps.setDate(2,Date.valueOf(evento.getFecha()));
            ps.setTime(3,Time.valueOf(evento.getHoraInicio()));
            ps.setTime(4,Time.valueOf(evento.getHoraFin()));
            ps.setInt(5,evento.getAforo());
            ps.setInt(6,evento.getAforoDisponible());
            ps.setString(7,evento.getNombre());

            int filasActualizadas = ps.executeUpdate();

            if(filasActualizadas==1){
                System.out.println("Se ha hecho el update");
                updateHecho =true;
            }

        }catch (Exception e){System.out.println(e.getClass()+" Problemas en el update");}
        return updateHecho;
    }
    /*Cuarto Metodo. Select todos los los eventos*/
    public ArrayList<Evento> selectEventosLibres(){
        ArrayList<Evento>listaEventos = new ArrayList<>();
        int plazasOcupadas =0;
        try{
            System.out.println("Estoy en el metodo select Todos en la ventana EventoDao. llamado del main");
            /*Tengo que hacer un select de todos los eventos e ir creando objetos evento y guardandolos en el array*/
            String plantilla = "Select * from evento where fecha > ?";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            LocalDate fechaHoy = LocalDate.now();
            Date dFechaHoy = java.sql.Date.valueOf(LocalDate.now());
            ps.setDate(1,dFechaHoy);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               /*He buscado eventos que son posteriores a hoy. Ahora tengo que buscar aquellos que tienen plazas libres.
               * Tengo que hacer una consulta a Asistentes.contar las veces que aparece el nombre de un evento. Desde aqui llamo a una
               * consulta en asistenteDAO*/
               plazasOcupadas =  AsistenteDAO.consultarPlazasLibres(rs.getString("nombre"));
               if(plazasOcupadas < rs.getInt("aforo")){
                   listaEventos.add(new Evento(rs.getString("nombre"),rs.getString("lugar"),
                           rs.getDate("fecha"), rs.getInt("horaInicio"),
                           rs.getTime("horaFin"),rs.getInt("aforo"), rs.getInt("aforoDispobible")));
               }

            }
        }catch (Exception e){
            System.out.println(e.getClass()+ " Problemas con el select");
        }
       return listaEventos;
    }

    public boolean confirmarSelect(){

        return confirmarSelect;
    }


}




