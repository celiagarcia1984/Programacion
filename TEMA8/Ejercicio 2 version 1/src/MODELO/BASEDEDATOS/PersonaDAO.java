package MODELO.BASEDEDATOS;

import MODELO.UML.Empresa;
import MODELO.UML.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

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
            String plantilla= "select * from persona where dni = ? ";
            PreparedStatement ps =conexion.prepareStatement(plantilla);
            ps.setString(1,dni);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pers.setDni(rs.getString("dni"));
                pers.setNombre(rs.getString("nombre"));
                pers.setApellido(rs.getString("apellido"));
                String nombreEmpresa = rs.getString("nombreEmpresa");
                Empresa empresa;
                empresa = crearObjetoEmpresa(nombreEmpresa);
                pers.setEmpresa(empresa);
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return pers;
    }
    public Empresa crearObjetoEmpresa(String nombre){
        Empresa emp = null;
        try{
           emp = EmpresaDAO.buscarEmpresa(nombre);
        }catch (Exception e){System.out.println(e.getClass());}
        return emp;
    }
    public boolean insertPersona(Persona persona){
        boolean insertHecho =false;
        try{
            String plantilla="insert into persona values(?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1, persona.getDni());
            ps.setString(2,persona.getNombre());
            ps.setString(3,persona.getApellido());
            String nombreEmp = persona.getEmpresa().getNombre();
            ps.setString(4,nombreEmp);

            int res= ps.executeUpdate();
            if(res==1){
                insertHecho = true;
            }
        }catch (Exception e){
            System.out.println(e.getClass());}
        return insertHecho;
    }

    }


