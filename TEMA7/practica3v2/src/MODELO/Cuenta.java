package MODELO;

import java.util.ArrayList;

public class Cuenta {
    String numeroCuenta;
    ArrayList<Movimiento> listaMovimientos;

    public Cuenta(String numeroCuenta, ArrayList<Movimiento> listaMovimientos) {
        this.numeroCuenta = numeroCuenta;
        this.listaMovimientos = listaMovimientos;
    }

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
        listaMovimientos=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                '}';
    }
}
