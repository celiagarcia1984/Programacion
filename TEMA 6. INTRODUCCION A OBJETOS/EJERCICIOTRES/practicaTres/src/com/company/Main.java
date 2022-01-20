package com.company;

import MODELO.*;
import MisExcepciones.DatoNoValido;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    static boolean datoNoValido = false;
    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    ;
    static ArrayList<Mascota> mascotasDelCliente = new ArrayList<>();
    static ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
    ;
    static Cliente cliente;
    static Gato gato;
    static Perro perro;
    static Veterinario VeterinarioAsignado;

    public static void main(String[] args) {
        do {
            try {
                /*Entrada de datos*/
                añadirVeterinario();
                /*Al iniciar aqui el array de mascotas del cliente, cada vez que empiece el proceso de dar de alta un cliente
                 * el array estara vacio para llenarlo con las mascotas de ese cliente*/
                mascotasDelCliente = new ArrayList<>();
                darDeAltaUnCliente();
                /*Hasta aqui funciona bien. Falta asignarle a cada mascota un veterinario. En la funcion añadirMascota
                 * voy a poner una funcion para añadirle veterinario o en añadir veterinario una funcion para añadir mascota?
                 * Mejor en mascota, ya que al dar de alta una mascota hay que asignarle un veterinario*/

            } catch (DatoNoValido e) {
                datoNoValido = true;
                JOptionPane.showMessageDialog(null, "El dato no es valido");
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        } while (datoNoValido); /*Se va a repetir mientras los datos no sean correctos*/
    }

    static void añadirVeterinario() throws Exception {
        String otroVeterinario = "";
        do {
            String nombre = "";
            String direccion = "";
            String dni = "";
            String numeroSS = "";
            do {
                nombre = JOptionPane.showInputDialog(null, "Nombre del Veterinario: ");
                datoNoValido = validarNombre(nombre);
                direccion = JOptionPane.showInputDialog(null, "Direccion: ");
                datoNoValido = validarDireccion(direccion);
                dni = JOptionPane.showInputDialog(null, "DNI(8 cifras): ");
                datoNoValido = validarDni(dni);
                numeroSS = JOptionPane.showInputDialog(null, "Numero de la SS(12 cifras): ");
                datoNoValido = validarNumeroSS(numeroSS);
            } while (datoNoValido);
            mascotasDelCliente = new ArrayList<>();/*Inicio el arrayList de mascotas aqui para añadir los objetos veterinarios
            con el arrayList ya creado y poder buscar el que menos tiene y añadirle una mascota*/

            listaVeterinarios.add(new Veterinario(nombre, direccion, dni, numeroSS));

            otroVeterinario = JOptionPane.showInputDialog(null, "¿Quieres añadir otro veterinario? S/N");

        } while (otroVeterinario.equalsIgnoreCase("s"));


    }

    static boolean validarNumeroSS(String numeroSS) throws Exception {
        if (numeroSS.length() != 12) {
            throw new DatoNoValido();
        } else {
            datoNoValido = false;
        }
        return datoNoValido;
    }

    static boolean validarDni(String dni) throws Exception {
        if (dni.length() != 8) {
            throw new DatoNoValido();
        } else {
            datoNoValido = false;
        }
        return datoNoValido;
    }

    static void darDeAltaUnCliente() throws Exception {
        String otroCliente = "";
        do {
            /*Para dar de alta un cliente, primero añado pido datos del cliente*/
            String nombre = "";
            String direccion = "";
            String telefono = "";
            do {
                nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del dueño");
                datoNoValido = validarNombre(nombre);
                direccion = JOptionPane.showInputDialog(null, "Direccion: ");
                datoNoValido = validarDireccion(direccion);
                telefono = JOptionPane.showInputDialog(null, "Telefono: ");
                datoNoValido = validarTelefono(telefono);
            } while (datoNoValido);
            /*Aqui tengo los datos del cliente. Voy a usar el constructor de cliente que no tiene las mascotas y luego
             * añado las mascotas*/
            /*Creo el objeto cliente para al añadir Mascota poder añadir el cliente*/
            cliente = new Cliente(nombre, direccion, telefono);
            JOptionPane.showMessageDialog(null, "Añade una mascota ");
            String otraMascota = "";
            do {
                mascotasDelCliente = añadirMascota(cliente);
                otraMascota = JOptionPane.showInputDialog(null, "Quieres añadir otra mascota? S/N");
            } while (otraMascota.equalsIgnoreCase("s"));
            listaClientes.add(new Cliente(nombre, direccion, telefono, mascotasDelCliente));
            otroCliente = JOptionPane.showInputDialog(null, "Quieres dar de alta otro cliente S/N");
        } while (otroCliente.equalsIgnoreCase("s"));

    }

    static ArrayList añadirMascota(Cliente cliente) throws Exception {
        String otraMascota = "";
        String tipo = "";
        String raza = "";
        String nombreMascota = "";
        String leucemia = "";
        String antirrabica = "";
        Veterinario veterinarioAsignado;
        do {
            tipo = JOptionPane.showInputDialog(null, "Perro o Gato");
            datoNoValido = validarTipo(tipo);
            raza = JOptionPane.showInputDialog(null, "Raza: ");
            datoNoValido = validarRaza(raza);
            nombreMascota = JOptionPane.showInputDialog(null, "Nombre: ");
            datoNoValido = validarNombreMascota(nombreMascota);
        } while (datoNoValido);
        /*¿Como asigno veterinario? Tengo un arraylist lista de veterinarios. Dentro de cada veterinario hay un
         * arrayList con mascotas (heredado de Persona). Cuando se da de alta una mascota nueva, busco el veterinario
         * que tiene menos mascotas y se la añado al arrayList de mascotas y me quedo con la posicion del veterinario
         * y a la mascota le añado ese veterinario*/
        /*1. Buscar en listaVeterinarios el arrayListMascotas mas corto*/
        int posicionDelVeterinarioConMenosMascotas;
        int elArrayMasCorto = 100;
        int i = 0;
        for (i = 0; i < listaVeterinarios.size() - 1; i++) {
            if (listaVeterinarios.get(i).getListaMascotas().size() < elArrayMasCorto) {
                elArrayMasCorto = listaVeterinarios.get(i).getListaMascotas().size();
                posicionDelVeterinarioConMenosMascotas = i;
            }
        }
        VeterinarioAsignado = listaVeterinarios.get(i);

        if (tipo.equalsIgnoreCase("gato")) {
            leucemia = JOptionPane.showInputDialog(null, "Prueba leucemia: S/N");
        } else {
            antirrabica = JOptionPane.showInputDialog(null, "Vacuna Antirrabica: S/N");
        }

        if (tipo.equalsIgnoreCase("gato")) {

            mascotasDelCliente.add(new Gato(raza, nombreMascota, cliente, VeterinarioAsignado, leucemia));
        } else {

            mascotasDelCliente.add(new Perro(raza, nombreMascota, cliente, VeterinarioAsignado, antirrabica));
        }
        listaVeterinarios.get(i).setListaMascotas(mascotasDelCliente);

        /*Si el tipo es gato al array mascota le añado un objeto tipo gato.*/
        /*Si no, al array mascota le añado un objeto perro*/
        /*y pregunto si tiene otra mascota. Si la respuesta es sí repito el pedir datos*/
        /*Si la respuesta es no: Al objeto cliente le añado el array mascota*/
        /*añado el objeto cliente que ya esta completo al arraylist listaClientes*/
        return mascotasDelCliente;
    }

    static boolean validarNombreMascota(String nombreMascota) throws Exception {
        if (nombreMascota.isEmpty()) {
            throw new DatoNoValido();
        } else {
            datoNoValido = false;
        }
        return datoNoValido;
    }

    static boolean validarTipo(String tipo) throws Exception {
        if (tipo.isEmpty()) {
            throw new DatoNoValido();
        } else {
            datoNoValido = false;
        }
        return datoNoValido;
    }

    static boolean validarRaza(String raza) throws Exception {
        if (raza.isEmpty()) {
            throw new DatoNoValido();
        } else {
            datoNoValido = false;
        }
        return datoNoValido;
    }

    static boolean validarNombre(String nombre) throws Exception {
        if (nombre.isEmpty()) {
            throw new DatoNoValido();
        } else {
            datoNoValido = false;
        }
        return datoNoValido;
    }

    static boolean validarDireccion(String direccion) throws Exception {
        if (direccion.isEmpty()) {
            throw new DatoNoValido();
        } else {
            datoNoValido = false;
        }
        return datoNoValido;
    }

    static boolean validarTelefono(String telefono) throws Exception {
        if (telefono.isEmpty()) {
            throw new DatoNoValido();
        } else {
            datoNoValido = false;
        }
        return datoNoValido;
    }


}
