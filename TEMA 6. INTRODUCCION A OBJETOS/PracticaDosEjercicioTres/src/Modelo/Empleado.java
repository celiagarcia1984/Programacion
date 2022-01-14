package Modelo;

public class Empleado extends Persona{
    int sueldoBruto;

    public Empleado(String nombre, int edad) {
        super(nombre, edad);
    }

    public Empleado(String nombre, int edad, int sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    public float getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(int sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }


    public void calcularSalario(){}

}
