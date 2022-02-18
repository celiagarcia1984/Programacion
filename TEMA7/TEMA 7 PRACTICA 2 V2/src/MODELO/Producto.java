package MODELO;

public class Producto {
    String nombre;
    int stockDisponible;
    float precioVenta;
    Proveedor proveedor;

    public Producto(String nombre, int stockDisponible, float precioVenta, Proveedor proveedor) {
        this.nombre = nombre;
        this.stockDisponible = stockDisponible;
        this.precioVenta = precioVenta;
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", stockDisponible=" + stockDisponible +
                ", precioVenta=" + precioVenta +
                ", proveedor=" + proveedor +
                '}';
    }
}
