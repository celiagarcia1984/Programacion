package MODELO;

public class Productos {
    private String nombre;
    private float precioUnitario;
    private int unidades;

    public Productos(String nombre, float precioUnitario, int unidades) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", unidades=" + unidades +
                '}';
    }
}
