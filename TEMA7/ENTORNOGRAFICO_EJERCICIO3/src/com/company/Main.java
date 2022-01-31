package com.company;

import MODELO.Productos;
import VISTA.VentanaCompra;
import VISTA.VentanaOpciones;
import VISTA.VentanaVenta;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
   static ArrayList<Productos> listaProductos = new ArrayList<>();
   static boolean productoEncontrado;
   static int posicionDelProducto;

    public static void main(String[] args) {
	/*PASO 1. Crear la clase Productos*/
    /*PASO 2. Crear arraylist con Productos*/
    /*Creo los diferentes objetos para añadirlos al ArrayList. Creo la funcion CrearYllenarListaProductos*/
        crearYllenarListaProductos();
    /*Paso 3. Crear la VentanaOpciones*/
        mostrarVentanaOpciones();
    /*Paso 4. En ventaOpciones. Establecer lo que van a hacer los botones COMPRA Y VENTA*/
    /*PASO 5. Creo una funcion para mostrar la segunda ventana que se llama Compras() y lo que hace es abrir la
    * segunda ventana. La funcion la llamo en el listener del boton COMPRAR*/
    /*PASO 6. Creo una funcion para mostrar la tercera ventana que se llama VENTAS() Y se la llama en el listener
    * del boton venta*/
    /*PASO 7. ¿QUE HACE CUANDO VENDE? VentanaVenta*/
    }
    public static boolean comprobarProducto(String tProducto){
        int i=0;
        for(i=0; i<listaProductos.size()&&listaProductos.get(i).getNombre().equalsIgnoreCase(tProducto);i++){}//Para de
        //cuando lo encuentra.
        if(i<listaProductos.size()){
            productoEncontrado=true;
            System.out.println("Funcion comprobarProductos. Ha entrado en a encontrado el producto" + productoEncontrado
                    + "el producto está en la posicion de i: "+ i );
        }
        else{
            productoEncontrado=false;
            System.out.println("Funcion comprobarProductos. Ha entrado en no a encontrado el producto" + productoEncontrado
                    + "i vale: "+ i );
        }
        posicionDelProducto = i; /*Me guardo la posicion del producto para cargar la informacion del importe en la ventana
        ventas y no tener que marcarlo*/

        return productoEncontrado;
    }/*Esta funcion busca si existe el producto en el arrray*/
    public static void ventas(){/*Tiene el main de la ventanaVenta. Se llama en el listener Ventas*/
        JFrame frame = new JFrame("VentanaVenta");
        frame.setContentPane(new VentanaVenta().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void compras(){
        JFrame frame = new JFrame("VentanaCompra");
        frame.setContentPane(new VentanaCompra().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }/*Tiene el Main de la VentanaCompra Se llama en el listener COMPRAS*/
    public static void crearYllenarListaProductos(){
        Productos Manzana = new Productos("manzana",1,20);
        Productos Naranja = new Productos("Naranja",2,30);
        Productos Pera = new Productos("Pera", 3,30);
        /*Añado los productos a la lista de productos*/
        listaProductos.add(Manzana);
        listaProductos.add(Naranja);
        listaProductos.add(Pera);
        /*Este for es solo para probar que funciona*/
        for(int i=0;i<listaProductos.size();i++){
            System.out.println("He añadido los productos al arrayList. f(x): crearYllenarListaProductos"
                    + listaProductos.toString());
        }
    }/*Crea y llena la lista de productos*/
    public static void mostrarVentanaOpciones(){
        JFrame frame = new JFrame("VentanaOpciones");
        frame.setContentPane(new VentanaOpciones().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    } /*Aqui tengo que poner el Main de la ventana Opciones*/

}
