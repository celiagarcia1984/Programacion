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
    /*Metodo para añadir empresa*/
    public boolean insertEmpresa(Empresa emp){
        boolean insertHecho=false;
        try{
            System.out.println("Estoy haciendo el insert de una empresa");
            String plantilla="insert into empresa values(?,?,?,?)";
            PreparedStatement ps= conexionEm.prepareStatement(plantilla);
            ps.setString(1,emp.getIdEmpresa());
            ps.setString(2,emp.getNombre());
            ps.setString(3,emp.getDireccion());
            ps.setString(4,emp.getTelefono());
            int res= ps.executeUpdate();
            if(res==1){
                System.out.println("fila Insertada");
                insertHecho =true;
            }

        }catch (Exception e){System.out.println(e.getClass());}
        return insertHecho;
    }
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
            String plantilla= "select * from empresa where idEmpresa=?";
            PreparedStatement ps = conexionEm.prepareStatement(plantilla);
            ps.setString(1,idEmpresa);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nombre = rs.getString("nombre");
                System.out.println("Ya hay una empresa con ese id. nombre: "+nombre);
                empresaEncontrada = new Empresa(rs.getString("idEmpresa"),rs.getString("nombre"),
                        rs.getString("direccion"),rs.getString("telefono"));
            }
            else{
                idValido=true;
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return idValido;
    }
    public Empresa getEmpresaEncontrada(){
        return empresaEncontrada;
    }
}
