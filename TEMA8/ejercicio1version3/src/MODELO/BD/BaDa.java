package MODELO.BD;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaDa {
    /*Voy a crear variables para el usuario, la contraseña y el url*/
    private String usuario = "root";
    private String contra = "usbw";
    private String url = "jdbc:mysql://localhost:3306/practicauno"; /*Esto cambia del portatil al Mac*/

    /*Creo la conexion*/
    private Connection con;

    /*Creo un constructor vacio*/

    public BaDa() {
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    /*Tengo que generar dos metodos. Uno para abrir la conexion y otro para cerrarla*/
    public void abrirConexion() {
        try {
            /*Indico el driver*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, contra);
            /*Puede haber problemas con la conexion*/
            if (con == null) {
                throw new Exception();
            }
            else{
                System.out.println(" Esto es con.toString " + con.toString());
            }
            System.out.println("Se ha establecido la conexion con la BD");
        } catch (Exception e) {
            System.out.println("Problemas con la conexion");
            System.out.println(e.getClass());
        }
    }
    public void cerrarConexion(){
        try{
            con.close();
        }catch (Exception e){
            System.out.println("Problema al cerrar la conexion");
        }
    }
}
