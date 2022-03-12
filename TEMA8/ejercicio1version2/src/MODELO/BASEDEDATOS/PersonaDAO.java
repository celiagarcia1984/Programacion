package MODELO.BASEDEDATOS;

import MODELO.UML.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersonaDAO {
Connection conexion;

    public PersonaDAO(Connection con) {
        this.conexion = con;
    }

    /*Tantos metodos como operaciones SQL tenga que realizar. Una clase DAO para cada tabla*/
    public void registrarPersona(Persona p){
        try{
            /*Sentencia insert*/
            System.out.println("estoy en la sentencia insert");
            String plantilla= "insert into personas values (?,?,?,?)";
            PreparedStatement ps= this.conexion.prepareStatement(plantilla);
            ps.setString(1,p.getNombre());
            ps.setInt(2,p.getEdad());
            ps.setString(3,p.getProfesion());
            ps.setString(4,p.getTelefono());
            int n =ps.executeUpdate();
            if(n!=1){
                throw new Exception();
            }

        }catch (Exception e ){
            System.out.println(e.getClass());
        }
    }
}