package MODELO.BASEDEDATOS;

import MODELO.UML.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonaDAO {
    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public PersonaDAO(Connection conexion) {
        this.conexion = conexion;
    }
    /*Buscar un dni. Devuelvo objeto persona al main*/
    public Persona buscaPersona(String dni){
        Persona pers = new Persona();
        try{
            String plantilla= "select * from persona where dni =?";
            PreparedStatement ps =conexion.prepareStatement(plantilla);
            ps.setString(1,dni);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pers.setDni(rs.getString("dni"));
                pers.setNombre(rs.getString("nombre"));
                pers.setApellido(rs.getString("apellido"));
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return pers;
    }

    }


