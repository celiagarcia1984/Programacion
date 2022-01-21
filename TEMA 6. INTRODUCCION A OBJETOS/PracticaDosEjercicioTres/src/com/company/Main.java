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

            System.out.println( listaEmpresas.get(0).toString());
            System.out.println(listaEmpleados.get(0).toString());

            /*Mostrar el nombre del directivo que mas subordinados tiene*/

           String mensaje = buscarElDirectivoQueTieneMasEmpleados();
           System.out.println(mensaje);

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    static String buscarElDirectivoQueTieneMasEmpleados()throws Exception{
        /*Tengo que entrar en el arrayList lista de Directivos, y buscar el arrayList de empleados mas largo*/
        String mensaje = "";
        int i = 0;
        int posicionDelMasLargo = 0;
        for(i = 0; i<listaDirectivos.size(); i++){
            if(i == 0){
                posicionDelMasLargo = i;
            }
            else{
                if(listaDirectivos.get(i).getListaEmpleados().size()>listaDirectivos.get(posicionDelMasLargo).getListaEmpleados().size()){
                    posicionDelMasLargo = i;
                }
            }
            mensaje = "El directivo que mas subordinados tiene es " + listaDirectivos.get(posicionDelMasLargo).getNombre() +
                    " con " + listaDirectivos.get(posicionDelMasLargo).getListaEmpleados().size() + " empleados";
        }
        return mensaje;
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
        /*EMPRESA 1*/
        listaClientes.add(new Cliente("Hortensia", 67,"666666777"));
        listaClientes.add(new Cliente("Eladio", 54,"666666888"));
        listaClientes.add(new Cliente("David", 56, "666666999"));
        listaClientes.add(new Cliente("Sergio", 67,"666666777"));
        /*EMPRESA DOS*/
        listaClientes.add(new Cliente("Ramon", 54,"666666888"));
        listaClientes.add(new Cliente("Estibaliz", 56, "666666999"));
        listaClientes.add(new Cliente("Vicente", 67,"666666777"));
        /*EMPRESA TRES*/
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
        ArrayList<Cliente> clientes = new ArrayList<>();
        /*EMPRESA UNO EMPLEADOS*/
        empleados.add(listaEmpleados.get(0));
        empleados.add(listaEmpleados.get(1));
        empleados.add(listaEmpleados.get(2));
        empleados.add(listaEmpleados.get(3));
        empleados.add(listaEmpleados.get(4));
        empleados.add(listaEmpleados.get(5));
        empleados.add(listaEmpleados.get(6));
       /*EMPRESA UNO CLIENTES del 0-3*/
        clientes.add(listaClientes.get(0));
        clientes.add(listaClientes.get(1));
        clientes.add(listaClientes.get(2));
        clientes.add(listaClientes.get(3));

        /*Ahora voy a llenar el arrayList listaEmpresas*/
        listaEmpresas.add(new Empresa("UNO", empleados,clientes));


       /*EMPRESA DOS*//*Vuelvo a crear los ArrayList para los empleados y clientes de la empresa DOS*/
        empleados= new ArrayList<>();
        clientes =new ArrayList<>();
        empleados.add(listaEmpleados.get(7));
        empleados.add(listaEmpleados.get(8));
        empleados.add(listaEmpleados.get(9));
        empleados.add(listaEmpleados.get(10));
        empleados.add(listaEmpleados.get(11));
        empleados.add(listaEmpleados.get(12));
        empleados.add(listaEmpleados.get(13));
        empleados.add(listaEmpleados.get(14));

        /*EMPRESA DOS CLIENTES del 0-3*/

        clientes.add(listaClientes.get(4));
        clientes.add(listaClientes.get(5));
        clientes.add(listaClientes.get(6));

        listaEmpresas.add(new Empresa("DOS", empleados,clientes));

        /*EMPRESA TRES*/
        empleados= new ArrayList<>();
        clientes =new ArrayList<>();
        empleados.add(listaEmpleados.get(15));
        empleados.add(listaEmpleados.get(16));
        empleados.add(listaEmpleados.get(17));
        empleados.add(listaEmpleados.get(18));
        empleados.add(listaEmpleados.get(19));

        /*EMPRESA TRES CLIENTES del 0-3*/
        clientes.add(listaClientes.get(7));
        clientes.add(listaClientes.get(8));
        clientes.add(listaClientes.get(9));
        clientes.add(listaClientes.get(10));
        clientes.add(listaClientes.get(11));

        listaEmpresas.add(new Empresa("TRES",empleados,clientes));
    }
}













