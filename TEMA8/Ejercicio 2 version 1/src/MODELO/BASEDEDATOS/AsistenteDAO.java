package MODELO.BASEDEDATOS;

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


}
