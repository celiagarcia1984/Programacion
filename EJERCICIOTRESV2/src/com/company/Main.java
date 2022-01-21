package com.company;

import EXCEPCIONES.DatoNoValido;
import MODELO.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static boolean datoNoValido = false;
    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Mascota> mascotasDelCliente = new ArrayList<>();
    static ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
    static Cliente cliente;
    static Gato gato;
    static Perro perro;
    static Veterinario VeterinarioAsignado;

    public static void main(String[] args) {
        try {
            solicitarDatos(); /*Dentro de esta funcion otras funciones para veterinarios, masccotas y clientes*/


        } catch (DatoNoValido e) {
            System.out.println("El dato no es valido");
            datoNoValido = true;
        } catch (Exception e) {
            System.out.println(e.getClass());
        }

    }

    static void solicitarDatos() throws Exception {
        /*Primero Veterinario*/
        añadirVeterinario();
        mascotasDelCliente = new ArrayList<>();
        darDeAltaUnCliente();
    }

    static void añadirVeterinario() throws Exception {
        String otroVeterinario = "";
        while (otroVeterinario.equalsIgnoreCase("s")) {

            JOptionPane.showMessageDialog(null, "Introduce los datos del veterinario");
            String nombre = solicitarYvalidarNombre();
            String direccion = solicitarYvalidarDireccion();
            String dni = solicitarYvalidarDni();
            String numeroSS = solicitarYvalidarNumeroSS();
            String telefono = solicitarYvalidarTelefono();

            mascotasDelCliente = new ArrayList<>();/*Inicio el arrayList de mascotas aqui para añadir los objetos veterinarios
            con el arrayList ya creado y poder buscar el que menos tiene y añadirle una mascota*/

            listaVeterinarios.add(new Veterinario(nombre, direccion, telefono, dni, numeroSS));
            otroVeterinario = JOptionPane.showInputDialog(null, "¿Quieres añadir otro veterinario? S/N");
        }
    }

    static void darDeAltaUnCliente() throws Exception {
        String otroCliente = "";
        do {
            /*Para dar de alta un cliente, primero añado pido datos del cliente*/
            String nombre = "";
            String direccion = "";
            String telefono = "";
            do {
                nombre = solicitarYvalidarNombre();
                direccion = solicitarYvalidarDireccion();
                telefono = solicitarYvalidarTelefono();
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
            tipo = solicitarYvalidarTipo();

            raza = solicitarYvalidarRaza();
            JOptionPane.showInputDialog(null, "Raza: ");
            nombreMascota = solicitarYvalidarNombre();

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
    static String solicitarYvalidarRaza()throws Exception {
        String raza = "";
        do {
            try {
                raza = JOptionPane.showInputDialog(null, "Raza");

                if (raza.isEmpty())  {
                    datoNoValido = true;
                    throw new DatoNoValido();
                } else {
                    throw new DatoNoValido();
                }
            } catch (Exception DatoNoValido) {
                datoNoValido = true;
                System.out.println("El tipo debe ser Perro o Gato");
            }
        } while (datoNoValido);
        return raza;

    }

    static String solicitarYvalidarTipo() throws Exception {
        String tipo = "";
        do {
            try {
                tipo = JOptionPane.showInputDialog(null, "Perro o Gato");
                Pattern patron = Pattern.compile("(Gato|Perro)");
                Matcher mat = patron.matcher(tipo);
                if (!mat.matches())  {
                    datoNoValido = true;
                    throw new DatoNoValido();
                } else {
                    throw new DatoNoValido();
                }
            } catch (Exception DatoNoValido) {
                datoNoValido = true;
                System.out.println("El tipo debe ser Perro o Gato");
            }
        } while (datoNoValido);
        return tipo;
    }

    static String solicitarYvalidarTelefono() throws Exception {
        String telefono = "";
        do {
            try {
                telefono = JOptionPane.showInputDialog(null, "Telefono: ");
                if (telefono.length() != 9)
                    throw new DatoNoValido();
                Pattern pat = Pattern.compile("^[0-9]{9}$");
                Matcher mat = pat.matcher(telefono);
                if (!mat.matches()) {
                    datoNoValido = true;
                    throw new DatoNoValido();
                } else {
                    datoNoValido = false;
                }
            } catch (Exception datoNoValido) {
                System.out.println("El formato del telefono no es valido");
            }
        } while (datoNoValido);

        return telefono;

    }

    static String solicitarYvalidarNombre() throws Exception {
        String nombre = "";
        do {
            try {

                nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                if (nombre.isEmpty())
                    throw new DatoNoValido();
                Pattern patron = Pattern.compile("^[A-Z]{1}+.*$");
                Matcher mat = patron.matcher(nombre);
                if (!mat.matches()) {
                    datoNoValido = true;
                    throw new DatoNoValido();
                } else {
                    datoNoValido = false;
                }

            } catch (Exception datoNoValido) {
                System.out.println("El nombre debe empezar por mayuscula");

            }
        } while (datoNoValido);
        return nombre;
    }

    static String solicitarYvalidarDireccion() throws Exception {
        String direccion = "";
        do {
            try {
                direccion = JOptionPane.showInputDialog(null, "Direccion: ");
                if (direccion.isEmpty())
                    throw new DatoNoValido();
                Pattern patron = Pattern.compile("^[A-Z].* [0-9]{1,3}.* $");
                Matcher mat = patron.matcher(direccion);
                if (!mat.matches()) {
                    datoNoValido = true;
                    throw new DatoNoValido();
                } else {
                    datoNoValido = false;
                }
            } catch (Exception datoNoValido) {
                System.out.println("El formato de la direccion no es valido");
            }
        } while (datoNoValido);

        return direccion;
    }

    static String solicitarYvalidarDni() throws Exception {
        String dni = "";
        do {
            try {
                dni = JOptionPane.showInputDialog(null, "DNI: ");
                if (dni.length() != 8)
                    throw new DatoNoValido();
                Pattern patron = Pattern.compile("^[0.9]{8}[a-z A-z]$");
                Matcher mat = patron.matcher(dni);
                if (!mat.matches()) {
                    datoNoValido = true;
                    throw new DatoNoValido();
                } else {
                    datoNoValido = false;
                }
            } catch (Exception datoNoValido) {
                System.out.println("El formato de la direccion no es valido");
            }
        } while (datoNoValido);

        return dni;
    }

    static String solicitarYvalidarNumeroSS() throws Exception {
        String numeroSS = "";
        do {
            try {
                numeroSS = JOptionPane.showInputDialog(null, "Numero de la SS: ");
                if (numeroSS.length() != 12) {
                    datoNoValido = true;
                    throw new DatoNoValido();
                }
            } catch (Exception datoNoValido) {
                System.out.println("El numero debe tener 12 cifras");
            }
        } while (datoNoValido);

        return numeroSS;
    }
}









