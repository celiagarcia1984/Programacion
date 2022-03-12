package MODELO.BASEDEDATOS;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
    private Connection con;

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public BD() {
    }
    /*Metodo para abrirConexion*/

    public void abrirConexion(){
        try{
            /*Indicar el driver. Siempre dentro de un try catch*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*abrir conexion*/
            String url = "jdbc:mysql://localhost:3306/practicaUno";
            String user ="root";
            String passwd ="usbw";
            this.con = DriverManager.getConnection(url,user,passwd);
            /*Si hay problemas con la conexion*/
            if(this.con == null){
                throw new Exception();
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    /*Metodo para cerrar Conexion*/
    public void cerrarConexion(){
        try{
            /*Dentro de un try catch*/
            this.con.close();

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}