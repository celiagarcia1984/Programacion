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
    public Persona getDatosPersona(String dni){
        Persona persona = new Persona();
        String nombre= "";
        String nombreEvento = "";
        String idEmpresa = "";
        String apellido="";
        try {
            String plantilla = "select * from persona where dni =?";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1,dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                nombre= rs.getString("nombre");
                nombreEvento = rs.getString("nombreEvento");
                idEmpresa = rs.getString("idEmpresa");
                apellido =rs.getString("apellido");
                persona = new Persona(dni,nombre,apellido,nombreEvento,idEmpresa);
            }

        }catch (Exception e){System.out.println(e.getClass());}
        return persona;
    }

}
