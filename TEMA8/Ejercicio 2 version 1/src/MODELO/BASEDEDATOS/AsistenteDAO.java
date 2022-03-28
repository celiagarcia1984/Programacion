package MODELO.BASEDEDATOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AsistenteDAO {

    private Connection conexion;


    public AsistenteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public static int consultarPlazasLibres(String nombre){
        int plazasOcupadas=0;
        try{
            String plantilla = "select count* where nombreEvento =?";
            PreparedStatement ps = BD.getCon().prepareStatement(plantilla);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            rs.next(); //hace que se coloque en la primera fila. Solo tengo 1 porque solo me va a devolver el nº de filas para ese evento
            plazasOcupadas = rs.getInt(1);

        }catch (Exception e){System.out.println(e.getClass());}
        return plazasOcupadas;
    }

    public Connection getConexion() {
        return conexion;
    }


}
