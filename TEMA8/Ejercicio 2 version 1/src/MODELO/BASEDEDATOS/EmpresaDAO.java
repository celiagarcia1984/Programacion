package MODELO.BASEDEDATOS;

import MODELO.UML.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpresaDAO {

    private Connection conexionEm;
    private Empresa empresaEncontrada;

    public EmpresaDAO(Connection conexionEm) {
        this.conexionEm = conexionEm;
    }
    public Empresa buscarEmpresa(String nombre){
        try{
            String plantilla= "select * from empresa where nombre=?";
            PreparedStatement ps = conexionEm.prepareStatement(plantilla);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                empresaEncontrada = new Empresa(rs.getString("nombre"),rs.getString("direccion"),
                        rs.getString("telefono"));
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return empresaEncontrada;
    }
    public boolean insertEmpresa(Empresa emp){
        boolean insertHecho=false;
        try{
            
        }catch (Exception e){System.out.println(e.getClass());}
        return insertHecho;
    }


}
