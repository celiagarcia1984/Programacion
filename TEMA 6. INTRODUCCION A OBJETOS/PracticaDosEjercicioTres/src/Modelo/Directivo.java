package Modelo;

import java.util.ArrayList;

public class Directivo extends Empleado{
    String categoria;
    ArrayList<Empleado> listaEmpleados;

    public Directivo(String nombre, int edad, String categoria, ArrayList<Empleado> listaEmpleados) {
        super(nombre, edad);
        this.categoria = categoria;
        this.listaEmpleados = listaEmpleados;

    }

    public Directivo(String nombre, int edad, int sueldoBruto, String categoria, ArrayList<Empleado> listaEmpleados) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        this.listaEmpleados = listaEmpleados;
    }

    public Directivo(String nombre, int edad, String categoria) {
        super(nombre, edad);
        this.categoria = categoria;
    }

    public Directivo(String nombre, int edad, int sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        this.listaEmpleados =new ArrayList<>(); /*añado la creacion del arrayLista de empleados para que cuando
        guarde el primer empleado no me de error por no estar creado*/
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    /*Crear un metodo set para añadir un solo empleado. Mirar en soluciones*/
    /*Este metodo me permite añadir empleados de uno en uno sin tener que crear un array*/
    public void setEmpleado(Empleado p){
        // new en el constructor.
        listaEmpleados.add(p);
    }


}
