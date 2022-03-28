package MODELO.BASEDEDATOS;

import MODELO.UML.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpresaDAO {

    private static Connection conexionEm;

    public EmpresaDAO(Connection conexionEm) {
        EmpresaDAO.conexionEm = conexionEm;
    }
    public static Empresa buscarEmpresa(String nombre){
        Empresa empresa =null;
        try{
            String plantilla = "select * from empresa where nombre = ?";
            PreparedStatement ps = conexionEm.prepareStatement(plantilla);
            ps.setString(1,nombre);
            ResultSet rs= ps.executeQuery();
            rs.next();

            empresa = crearObjetoEmpresa(empresa,rs);

        }catch (Exception e){System.out.println(e.getClass());}
        return empresa;
    }
    public static Empresa crearObjetoEmpresa(Empresa emp,ResultSet rs){
        Empresa empr = null;
        try{
            String nombre= rs.getString("nombre");
            String direccion=rs.getString("direccion");
            String telefono =rs.getString("telefono");
            empr = new Empresa(nombre,direccion,telefono);
        }catch (Exception e){System.out.println(e.getClass());}
        return empr;
    }
    public boolean insertEmpresa(Empresa emp){
        boolean insertHecho=false;
        try{

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


        }catch (Exception e){System.out.println(e.getClass());}
        return insertHecho;
    }


}
