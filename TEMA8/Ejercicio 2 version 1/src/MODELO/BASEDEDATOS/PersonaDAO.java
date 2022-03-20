package MODELO.BASEDEDATOS;

import java.sql.Connection;

public class PersonaDAO {
    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public PersonaDAO(Connection conexion) {
        this.conexion = conexion;
    }
}
