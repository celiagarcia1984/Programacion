package MODELO;

import java.time.LocalDate;

public class Movimiento {
    LocalDate fecha;
    double importe;
    String descripcion;

    public Movimiento(LocalDate fecha, double importe, String descripcion) {
        this.fecha = fecha;
        this.importe = importe;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "fecha=" + fecha +
                ", importe=" + importe +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
