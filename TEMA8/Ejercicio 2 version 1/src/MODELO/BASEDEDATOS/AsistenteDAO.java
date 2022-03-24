package MODELO.BASEDEDATOS;

import MODELO.UML.Asistente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AsistenteDAO {
    private Connection conexion;


    public AsistenteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public Connection getConexion() {
        return conexion;
    }

    public ArrayList<Asistente> selectTodosAsistentes() {
        ArrayList<Asistente> listaAsistentes = new ArrayList<>();
        try {
            String plantilla = "select * from asistentes";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                listaAsistentes.add(new Asistente(rs.getString("idAsistente"), rs.getString("dniPersona"),rs.getString("nombreEvento")));
            }
            System.out.println("imprimo listaAsistentes: "+ listaAsistentes.toString());
            if(!rs.next()){
                System.out.println("No hay asistentes");
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return listaAsistentes;
    }
    public boolean insertAsistente(String dni, String evento){
        boolean insertHecho=false;
        try{
            String plantilla="insert into asistente values(null,?,?)";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1,dni);
            ps.setString(2,evento);
            int res = ps.executeUpdate();
            if(res==1){
                insertHecho=true;
                System.out.println("Se ha hecho el insert");
            }
            else{
                System.out.println("no se ha hecho el insert");
            }

        }catch (Exception e){System.out.println(e.getClass());}
        return insertHecho;
    }
}
