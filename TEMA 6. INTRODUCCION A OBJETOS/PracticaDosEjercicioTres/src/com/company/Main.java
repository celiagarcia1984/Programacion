package com.company;

import Modelo.*;

import java.util.ArrayList;

public class Main {
    static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Directivo> listaDirectivos = new ArrayList<>();
    static ArrayList<Empresa> listaEmpresas = new ArrayList<>();

    public static void main(String[] args) {
        try{
            /*La clase padre persona no se llena.*/
            /*1. Crear un arrayList con Empleados*/
            /*2. Llenar el ArrayList listaEmpleados*/
            llenarArrayListListaEmpleados();
            /*3. Crear un arrayList listaClientes*/
            llenarArrayListListaClientes();
            /*4. Crear un arrayList listaDirectivos*/
            llenarArrayListListaDirectivos();
            /*En la clase directivo tengo un metodo para añadir a Lista de Directivos los empleados subordinados*/
            /*5.Crear un ArrayList Empresa*/
            llenarArrayListListaEmpresas();

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    static void llenarArrayListListaEmpleados()throws Exception{
        listaEmpleados.add(new Empleado("Fran",42,42000));
        listaEmpleados.add(new Empleado("Alba",37, 24000));
        listaEmpleados.add(new Empleado("Ivan",43, 15000));
        listaEmpleados.add(new Empleado("Cristina",50,28000));
        listaEmpleados.add(new Empleado("Carolina",53, 34000));
        listaEmpleados.add(new Empleado("Eutimio",42,41000));
        listaEmpleados.add(new Empleado("Chari",37, 23000));
        listaEmpleados.add(new Empleado("Juan",43, 15000));
        listaEmpleados.add(new Empleado("Olga",50,28000));
        listaEmpleados.add(new Empleado("Itsaso",53, 34000));
        listaEmpleados.add(new Empleado("Esti",42,42000));
        listaEmpleados.add(new Empleado("Gorka",37, 24000));
        listaEmpleados.add(new Empleado("Patricia",43, 15000));
        listaEmpleados.add(new Empleado("Trinidad",50,28000));
        listaEmpleados.add(new Empleado("Anne",53, 34000));
        listaEmpleados.add(new Empleado("Alain",42,41000));
        listaEmpleados.add(new Empleado("Ohian",37, 23000));
        listaEmpleados.add(new Empleado("Inar",43, 15000));
        listaEmpleados.add(new Empleado("Idoia",50,28000));
        listaEmpleados.add(new Empleado("Kepa",53, 34000));
    }
    static void llenarArrayListListaClientes()throws Exception{
        listaClientes.add(new Cliente("Hortensia", 67,"666666777"));
        listaClientes.add(new Cliente("Eladio", 54,"666666888"));
        listaClientes.add(new Cliente("David", 56, "666666999"));
        listaClientes.add(new Cliente("Sergio", 67,"666666777"));
        listaClientes.add(new Cliente("Ramon", 54,"666666888"));
        listaClientes.add(new Cliente("Estibaliz", 56, "666666999"));
        listaClientes.add(new Cliente("Vicente", 67,"666666777"));
        listaClientes.add(new Cliente("Santiago", 54,"666666888"));
        listaClientes.add(new Cliente("Arantxa", 56, "666666999"));
        listaClientes.add(new Cliente("Enrique", 67,"666666777"));
        listaClientes.add(new Cliente("Maider", 54,"666666888"));
        listaClientes.add(new Cliente("Estitxu", 56, "666666999"));
    }
    static void llenarArrayListListaDirectivos()throws Exception{

        /*Empresa UNO, Tiene 2 jefes*/
        listaDirectivos.add(new Directivo("Mikel", 47, 50000, "Informatica"));
        listaDirectivos.add(new Directivo("Vicky", 46,50000, "SAT"));
        /*Al jefe en la posicion 0. Mikel. Le añado los empleados del array empleados de las posiciones 0,1,2 */
        listaDirectivos.get(0).setEmpleado(listaEmpleados.get(0));
        listaDirectivos.get(0).setEmpleado(listaEmpleados.get(1));
        listaDirectivos.get(0).setEmpleado(listaEmpleados.get(2));
        /*Al jefe en la posicion 1. Vicky. Le añado los empleados del array empleados de las posicions 3,4,5,6 */
        listaDirectivos.get(1).setEmpleado(listaEmpleados.get(3));
        listaDirectivos.get(1).setEmpleado(listaEmpleados.get(4));
        listaDirectivos.get(1).setEmpleado(listaEmpleados.get(5));
        listaDirectivos.get(1).setEmpleado(listaEmpleados.get(6));
        /*Empresa DOS TIENE 1 Jefe*/
        listaDirectivos.add(new Directivo("Francisco", 47, 50000, "Informatica"));
        /*Al jefe en la posicion 2. FRANCISCO. Le añado */
        listaDirectivos.get(2).setEmpleado(listaEmpleados.get(7));
        listaDirectivos.get(2).setEmpleado(listaEmpleados.get(8));
        listaDirectivos.get(2).setEmpleado(listaEmpleados.get(9));
        listaDirectivos.get(2).setEmpleado(listaEmpleados.get(10));
        listaDirectivos.get(2).setEmpleado(listaEmpleados.get(11));
        listaDirectivos.get(2).setEmpleado(listaEmpleados.get(12));
        listaDirectivos.get(2).setEmpleado(listaEmpleados.get(13));
        listaDirectivos.get(2).setEmpleado(listaEmpleados.get(14));

        /*Empresa TRES tiene 1 jefe*/
        listaDirectivos.add(new Directivo("Jesus", 44,50000, "SAT"));
        /*Al jefe en la posicion 3. JESUS. */
        listaDirectivos.get(3).setEmpleado(listaEmpleados.get(15));
        listaDirectivos.get(3).setEmpleado(listaEmpleados.get(16));
        listaDirectivos.get(3).setEmpleado(listaEmpleados.get(17));
        listaDirectivos.get(3).setEmpleado(listaEmpleados.get(18));
        listaDirectivos.get(3).setEmpleado(listaEmpleados.get(19));
    }
    static void llenarArrayListListaEmpresas()throws Exception{
        /*Voy a crear un ArrayList empleados para guardar los empleados y meterlos en cada empresa*/
        ArrayList<Empleado> empleados = new ArrayList<>();
        
    }
}













