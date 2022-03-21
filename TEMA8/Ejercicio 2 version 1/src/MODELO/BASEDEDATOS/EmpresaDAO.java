package MODELO.BASEDEDATOS;

import MODELO.UML.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpresaDAO {

    private Connection conexionEm;

    public EmpresaDAO(Connection conexionEm) {
        this.conexionEm = conexionEm;
    }
    /*Metodo para añadir empresa*/

    public ArrayList selectTodos(){
        ArrayList<Empresa>listaEmpresas = new ArrayList<>();
        try{
            String plantilla= "select * from empresa";
            PreparedStatement ps = conexionEm.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listaEmpresas.add(new Empresa(rs.getString("idEmpresa"),rs.getString("nombre"),
                        rs.getString("direccion"),rs.getString("telefono")));
            }
            System.out.println("estoy llenando el array de empresas "+ listaEmpresas.toString());
        }catch (Exception e){System.out.println(e.getClass());}
        return listaEmpresas;
    }
    public boolean comprobarId(String idEmpresa){
        boolean idValido = false;
        String nombre="";
        try{
            String plantilla= "select nombre from empresa where idEmpresa=?";
            PreparedStatement ps = conexionEm.prepareStatement(plantilla);
            ps.setString(1,idEmpresa);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nombre = rs.getString("nombre");
                System.out.println("Ya hay una empresa con ese id. nombre: "+nombre);
            }
            else{
                idValido=true;
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return idValido;
    }
}