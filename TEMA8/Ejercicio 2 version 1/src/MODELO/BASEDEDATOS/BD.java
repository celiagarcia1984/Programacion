package MODELO.BASEDEDATOS;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
    /*Creo las variables para la conexion*/

    private String usuario ="root";
    private String passw ="usbw";
    private String url ="jdbc:mysql://localhost:3306/ejer2";

    /*Creo un objeto conexion*/
    private Connection conexion;

    /*Creo un constructor vacio*/

    public BD() {
    }
/*Solo pongo el getter y setter de la conexion porque no voy a usar los demas*/
    public Connection getCon() {
        return conexion;
    }

    public void setCon(Connection con) {
        this.conexion = conexion;
    }
    /*Necesito los métodos abrir y cerrar conexion*/
    public  void abrirConexion(){
        try{
            /*Indico el driver*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, passw);
            System.out.println("He establecido la conexion");
            /*Puede haber problemas con la conexion*/
            if(conexion== null){
                throw new Exception("Problemas con la conexion");
            }
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public void cerrarConexion(){
        try{
            conexion.close();
            System.out.println("Cierro la conexion");
        }catch (Exception e){
            System.out.println(e.getClass());
        }

    }
    /*EN ESTA CLASE YA NO NECESITO NADA MAS*/
}
