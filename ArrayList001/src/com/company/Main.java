package com.company;

import Excepciones.opcionIncorrecta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
    private static ArrayList<Double> numeros;
    private static int opcion;
    private static boolean terminar = false;
    private static String mensaje = "";

    public static void main(String[] args) {
        new ArrayList<>();
        String continuar = "";
        boolean opcionCorrecta;

        do {
            try {
                //pedirNumeros();
                pedirNumerosPruebas();

                do{
                    opcion = mostrarMenu();
                    opcionCorrecta = comprobarPosicion(opcion);
                    if (opcionCorrecta) {
                        opciones(opcion);
                        JOptionPane.showMessageDialog(null, mensaje);
                    }
                }while (!terminar);

            } catch (opcionIncorrecta e) {
                System.out.println("La opcion no es correcta");
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        } while (!terminar);

    }
    static String sumaYmedia ()throws Exception{

        Double suma = 0.0;
        Double media;
        int i;
        for(i = 0; i<numeros.size(); i++){
            suma = suma + numeros.get(i);
        }

        media = suma/numeros.size();
        mensaje= "La suma del ArrayList es " + suma +"\n"+
                "La media del ArrayList es " + media;
        return mensaje;
    }

    static String borrarUnaPosicion()throws Exception{
        int posicion = pedirPosicion();
        mensaje = "El numero " + numeros.get(posicion)+ " de la posicion " + posicion +" se ha borrado del ArrayList "
                + numeros + "\n";
        numeros.remove(posicion);
        mensaje = mensaje + " y queda así: "+ numeros;

        return mensaje;
    }

    static String añadirEnPosicion()throws Exception{
        Double numero;
        numero = pedirNumero();
        int posicion = pedirPosicion();

        mensaje = "El numero " + numero + " se ha añadido al ArrayList " + numeros + " en la posicion " + posicion +"\n";
        numeros.add(posicion,numero);
        mensaje = mensaje + " y queda así: "+ numeros;

        return mensaje;
    }

    static String añadirAlFinal()throws Exception{

         Double numero;
         numero = pedirNumero();

         System.out.println(numeros);

        mensaje = "Al arrayList "+ numeros + " \n le añadimos el numero " + numero;
        numeros.add(numero);
        mensaje = mensaje + " y queda asi: \n" + numeros;

         JOptionPane.showMessageDialog(null, mensaje);
        return mensaje;
    }

    static String mostrarNumeroElementos()throws Exception{

        mensaje = "El arrayList contiene "+ numeros.size()+ " elementos";
        System.out.println(mensaje);

        return mensaje;
    }

    static String convertir()throws Exception{

            int posiciones = numeros.size();
            Double[] arrayListConvertido = new Double[posiciones];

            for(int i = 0; i<numeros.size(); i++){
                arrayListConvertido[i]= numeros.get(i);
                System.out.println(arrayListConvertido[i]);
               // Double[] fran = numeros.toArray(new Double[numeros.size()]);
            }
            mensaje = "El ArrayList es ahora un array";

        return mensaje;
    }

    static String solicitarBuscarBorrar()throws Exception{

        Double numeroAencontrar = pedirNumero();

        if (numeros.contains(numeroAencontrar)){

            numeros.remove(numeros.indexOf(numeroAencontrar));
            mensaje = "El numero " + numeroAencontrar + " se ha encontrado y se ha borrado";
        }
        else{
            mensaje = "El numero " + numeroAencontrar + " no existe";
        }

        return mensaje;
    }

    static String buscarMaximoMinimo()throws Exception{
        Collections.sort(numeros);
        //System.out.println(numeros);
        // los ordena de menor a mayor. Ahora tengo que coger la primera posicion y la ultima.
         Double minimo = numeros.get(1);
         int posicionDelMaximo = numeros.size() -1;
        // System.out.println(posicionDelMaximo);
         Double maximo = numeros.get(posicionDelMaximo);
         mensaje = "El minimo es " + minimo + ", El maximo es "+ maximo;

        return mensaje;
    }

    static Double pedirNumero()throws Exception {
        Double numero;
           numero = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Introduce un numero"));
        return numero;
    }

    static int pedirPosicion(){
        int posicion;
        posicion = Integer.parseInt(JOptionPane.showInputDialog(null,
                "¿Con que posicion quieres trabajar?"));
        return posicion;
    }

    static boolean comprobarPosicion(int posicion) throws Exception {
        boolean posicionCorrecta = true;
        if (posicion >= 11) {
            // Aqui tengo que poner la excepcion
            posicionCorrecta = false;
        }
        return posicionCorrecta;
    }

    static void opciones(int opcion) throws Exception {

            switch (opcion) {
                case 1:
                    mensaje = buscarMaximoMinimo();
                    break; //maximo y minimo
                case 2:
                    mensaje = buscarNumero();
                    break; // buscar numero y decir si lo has encontrado
                case 3:
                    mensaje = solicitarBuscarBorrar();
                    break; // solicitar, buscar y borrar. Si no se encuentra mensaje de error
                case 4:
                    convertir();
                    break; // convertir en array
                case 5:
                    mostrarNumeroElementos();
                    break; // mostrar numero de elementos
                case 6:
                    añadirAlFinal();
                    break; // insertar por el final
                case 7:
                    añadirEnPosicion();
                    break; //  insertar en posicion dada
                case 8:
                    borrarUnaPosicion();
                    break; // borrar de una posicion dada
                case 9:
                    sumaYmedia();
                    break; // calcular suma y media
                case 10:
                    terminar = true;
                    break; // salir
                default: throw new opcionIncorrecta();
            }
            System.out.println(mensaje);

    }

    static String buscarNumero() throws Exception{

        Double numeroAencontrar = pedirNumero();

        if (numeros.contains(numeroAencontrar)){
            mensaje = "El numero " + numeroAencontrar + " se ha encontrado";
        }
        else{
            mensaje = "Error. El numero " + numeroAencontrar + " no existe";
        }
        return mensaje;
    }

    static int mostrarMenu() throws Exception{
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Elige la opcion que quieras: \n" +
                        "1. Visualizar el maximo y el minimo \n" +
                        "2. Buscar un numero \n" +
                        "3. Solicitar, buscar y borrar \n" +
                        "4. Convertir el arrayList en array \n" +
                        "5. Mostar el numero de elementos\n" +
                        "6. Insertar un nuevo elemento por el final \n" +
                        "7. Insertar un nuevo elemento en la posicion que indiques \n" +
                        "8. Borrar un elemento de una posicion concreta\n" +
                        "9. Calcular la suma y la media aritmetica\n" +
                        "10. Finalizar\n"));
        return opcion;
    }

    static void pedirNumeros() throws Exception {
        boolean continuar = true;
        String respuesta = "S";
        while (continuar == true) {
            numeros.add(Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Introduce un numero")));
            respuesta = JOptionPane.showInputDialog(null, "¿Quieres continuar?");
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
    }

    static void pedirNumerosPruebas()throws Exception {
        for (int i =0; i<10; i++){
            numeros.add(Math.floor(Math.random()*10));
            System.out.println(numeros);

        }
    }

}
