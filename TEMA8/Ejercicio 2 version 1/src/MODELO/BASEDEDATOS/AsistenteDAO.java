package MODELO.BASEDEDATOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AsistenteDAO {

    private static Connection conexion;


    public AsistenteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public static int consultarPlazasLibres(String nombre){
        int plazasOcupadas = 0;
        try{
            String plantilla = "select count(*) from asistentes where nombreEvento =?";
            PreparedStatement ps = BD.getCon().prepareStatement(plantilla);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            rs.next(); //hace que se coloque en la primera fila. Solo tengo 1 porque solo me va a devolver el nº de filas para ese evento
            plazasOcupadas = rs.getInt(1);


        }catch (Exception e){System.out.println(e.getClass());}
        return plazasOcupadas;
    }
    public static boolean insertAsistente(String dni, String nombreEvento){
        boolean insertOk =false;
        try{
            String plantilla = "insert into asistentes values (?,? )";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1,dni);
            ps.setString(2,nombreEvento);
            int resultado = ps.executeUpdate();
            if(resultado == 1){
                insertOk = true;
            }
        }catch (Exception e){System.out.println();}
        return insertOk;
    }

    public Connection getConexion() {
        return conexion;
    }


}
