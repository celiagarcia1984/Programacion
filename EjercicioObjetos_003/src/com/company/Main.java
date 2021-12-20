package com.company;

import Excepciones.datoNoValido;
import MisClases.Persona;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Persona> listaPersonas;
    static Persona p;

    public static void main(String[] args) {
        try {
            listaPersonas = new ArrayList<>();
            obtenerDatosPersonas();
            String elMasMayor = obtenerElMayor(listaPersonas);
            String cantidadDeAdultos = obtenerCantidadAdultos(listaPersonas);
            String personasQueVivenEnElche = obtenerPersonasQueVivenEnElche(listaPersonas);

            JOptionPane.showMessageDialog(null, cantidadDeAdultos + " \n"+
                    "El mas mayor es: "+ elMasMayor);
            JOptionPane.showMessageDialog(null, personasQueVivenEnElche);

        } catch (datoNoValido e) {
            System.out.println("El dato no es correcto");
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
    static String obtenerPersonasQueVivenEnElche(ArrayList<Persona> listaPersonas)throws Exception{
        String personasDeElche = "";
        for (Persona listaPersona : listaPersonas) {
            if (listaPersona.getCiudad().equalsIgnoreCase("ELCHE")) {
                personasDeElche = personasDeElche + "Las personas que viven en Elche\n"
                        + "NOMBRE: " + listaPersona.getNombre() + "\n";
            }
        }
        return personasDeElche;
    }

    static void obtenerDatosPersonas() throws Exception {
        do {
            String nombre = JOptionPane.showInputDialog(null, "Nombre: ");
            validarNombre(nombre);
            int diaNacimiento = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Dia de nacimiento: "));
            validarDiaNacimiento(diaNacimiento);
            int mesNacimiento = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Mes de nacimiento: "));
            validarMesNacimiento(mesNacimiento);
            int anoNacimiento = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Año de nacimiento: "));
            validarAnoNacimiento(anoNacimiento);
            String direccion = JOptionPane.showInputDialog(null, "Direccion: ");
            validarDireccion(direccion);
            String codigoPostal = JOptionPane.showInputDialog(null, "Codigo Postal: ");
            validarCodigoPostal(codigoPostal);
            String ciudad = JOptionPane.showInputDialog(null, "Ciudad: ");
            validarCiudad(ciudad);
            /*Creo el objeto p y lo lleno*/
            p = new Persona(nombre, diaNacimiento, mesNacimiento, anoNacimiento, direccion, codigoPostal, ciudad);
            listaPersonas.add(p);

        } while (JOptionPane.showConfirmDialog(null, "¿Quieres introducir otra persona?") == 0);


    }

    public static String obtenerElMayor(ArrayList<Persona> listaPersonas)throws Exception{
        String nombreDelMayor = "";
        int edadDelmayor=0;
        int edad =0;

        for(int i = 0; i < listaPersonas.size(); i++){
            LocalDate diaDeHoy = LocalDate.now();
            LocalDate fechaNacimiento = LocalDate.of(listaPersonas.get(i).getaNacimiento(),
                    listaPersonas.get(i).getmNacimiento(), listaPersonas.get(i).getdNacimiento());
            Period anos = Period.between(fechaNacimiento,diaDeHoy);
            edad = anos.getYears();

            if(i==0){
                nombreDelMayor = listaPersonas.get(i).getNombre();
                edadDelmayor= edad;
            }
            else if(edad>edadDelmayor){
                nombreDelMayor = listaPersonas.get(i).getNombre();
                edadDelmayor= edad;
            }
        }
        return nombreDelMayor;
    }

    public static String obtenerCantidadAdultos(ArrayList<Persona> listaPersonas)throws Exception{
        String cantidadAdultos= "";
        int mayoresDeEdad = 0;
        int i=0;
        for(i=0; i<listaPersonas.size(); i++){
            LocalDate hoy = LocalDate.now();
            LocalDate fechaNacimiento = LocalDate.of(listaPersonas.get(i).getaNacimiento(),
                    listaPersonas.get(i).getmNacimiento(), listaPersonas.get(i).getdNacimiento());
            Period edad = Period.between(fechaNacimiento,hoy);
            int edadEnAnos=edad.getYears();
            System.out.println("NOMBRE: " + listaPersonas.get(i).getNombre() + " Edad: " + edadEnAnos);
            if(edadEnAnos>18){
                mayoresDeEdad = mayoresDeEdad +1;
            }
        }
        cantidadAdultos = "Hay " + mayoresDeEdad + " adultos";

        return cantidadAdultos;
    }


 /*VALIDACIONES DE DATOS*/
    public static void validarNombre(String nombre) throws Exception {

        if (nombre.length() < 2) {
            throw new datoNoValido();
        }

    }
    public static void validarDiaNacimiento (int diaNacimiento) throws Exception{
        if (diaNacimiento>31){
            throw new datoNoValido();
        }
    }
    public static void validarMesNacimiento(int mesNacimiento)throws Exception{
        if(mesNacimiento>12){
            throw new datoNoValido();
        }
    }
    public static void validarAnoNacimiento(int anoNacimiento)throws Exception{
        LocalDate fechaActual = LocalDate.now();
        if(anoNacimiento<1900 || anoNacimiento >fechaActual.getYear()){
            throw new datoNoValido();
        }
    }
    public static void validarDireccion(String direccion)throws Exception{
        if(direccion.isEmpty()){
            throw new datoNoValido();
        }
    }
    public static void validarCodigoPostal(String codigoPostal)throws Exception{
        if(codigoPostal.length() != 5){
            throw new datoNoValido();
        }
    }
    public static void validarCiudad(String ciudad)throws Exception{
        if(ciudad.length()<2){
            throw new datoNoValido();
        }
    }
 /* ************************* */

}
