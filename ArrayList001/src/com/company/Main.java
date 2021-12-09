package com.company;

import Excepciones.opcionIncorrecta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static ArrayList<Double> numeros = new ArrayList<>();
    static int opcion;
    static boolean terminar = false;
    static String mensaje = "";

    public static void main(String[] args) {
        String maximoYminimo ="";
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
                    }
                }while (!terminar);

            } catch (opcionIncorrecta e) {
                System.out.println("La opcion no es correcta");
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        } while (!terminar);

    }
    static String añadirAlFinal()throws Exception{

         Double numero;
         numero = (double) pedirNumeroPosicion();
         //numeros.add(numero);
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
            double[] arrayListConvertido = new double[posiciones];

            for(int i = 0; i<numeros.size(); i++){
                arrayListConvertido[i]= numeros.get(i);
                System.out.println(arrayListConvertido[i]);
               // Double[] fran = numeros.toArray(new Double[numeros.size()]);
            }

        return mensaje;
    }

    static String solicitarBuscarBorrar()throws Exception{

        double numeroAencontrar = pedirNumeroPosicion();

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

    // Como voy a tener que solicitar un numero y una posicion varias veces, voy a hacer una funcion para ello
    static int pedirNumeroPosicion()throws Exception {
        int numero=0; // lo pongo como int, pero luego tengo que cambiarlo a Double
        if (opcion == 2 || opcion == 3 || opcion == 6){
            numero = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Introduce un numero"));

        };
        if (opcion == 7 || opcion == 8){
            numero = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Introduce una posicion"));
        }
        return numero;
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
                    // añadirEnPosicion();
                    break; //  insertar en posicion dada
                case 8:
                    // borrarUnaPosicion();
                    break; // borrar de una posicion dada
                case 9:
                    //SumaYmedia();
                    break; // calcular suma y media
                case 10:
                    terminar = true;
                    break; // salir
            }
            System.out.println(mensaje);

    }

    static String buscarNumero() throws Exception{

        double numeroAencontrar = pedirNumeroPosicion();

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
