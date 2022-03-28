package MODELO.BASEDEDATOS;

import MODELO.UML.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class EmpresaDAO {

    private Connection conexionEm;
    private Empresa empresaEncontrada;

    public EmpresaDAO(Connection conexionEm) {
        this.conexionEm = conexionEm;
    }
    public ArrayList<Empresa>  buscarEmpresa(){
        ArrayList<Empresa> listaEmpresas=new ArrayList<>();
        try{
            String plantilla= "select * from empresa";
            PreparedStatement ps = conexionEm.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                empresaEncontrada = new Empresa(rs.getString("nombre"),rs.getString("direccion"),
                        rs.getString("telefono"));
                listaEmpresas.add(empresaEncontrada);
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return listaEmpresas;
    }
    public boolean insertEmpresa(Empresa emp){
        boolean insertHecho=false;
        try{
<<<<<<< Updated upstream
            String plantilla="insert into empresa values(?,?,?)";
            PreparedStatement ps = conexionEm.prepareStatement(plantilla);
            ps.setString(1,emp.getNombre());
            ps.setString(2,emp.getDireccion());
            ps.setString(3,emp.getTelefono());
            int res = ps.executeUpdate();
            if(res == 1){
                System.out.println("insert hecho");
                insertHecho = true;
            }
=======
>>>>>>> Stashed changes

        }catch (Exception e){System.out.println(e.getClass());}
        return insertHecho;
    }


}
