package com.company;

import MODELO.Producto;
import MODELO.Proveedor;
import VISTA.VentanaPrincipal;

import javax.swing.*;
import java.util.ArrayList;

/*1. He creado la ventana principal. Ahora preparo las clases y la "BBDD"*/
public class Main {

    /*Creo un arrayList de proveedores*/
    static boolean productoEncontrado=false;
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static Proveedor Mercadona ;
    static Proveedor Carrefour;
    static Proveedor Lidl;
    static Proveedor Aldi;
    static Proveedor[] listaProveedores;
    static int posicionDelProducto;


    public static void main(String[] args) {
	llenarListaProductos();
	crearProveedores();
	/*Una vez creados los datos. Se abre la ventana Principal*/
        ventanaPrincipal();

    }
    public static boolean comprobarCantidad(int cantidadIntroducida){
        boolean cantidadCorrecta = false;
        try{
            int i=0;
            for(i=0; i<listaProductos.size();i++){
                if(listaProductos.get(i).getStockDisponible()<cantidadIntroducida){
                    /*Si hay menos stock hay que mostrar un mensaje de error*/

                }
                else{
                    cantidadCorrecta = true;
                }
            }
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return cantidadCorrecta;
    }
    public static boolean comprobarProducto(String tproduto){

        try{
            int i=0;
            for(i=0; i<listaProductos.size()&& !listaProductos.get(i).getNombre().equalsIgnoreCase(tproduto); i++ ){}
            if(i<listaProductos.size()){
                posicionDelProducto =i;
                productoEncontrado = true;
                System.out.println("Estoy en la funcion ComprobarProducto y e encontrado  el producto. La variable producto encontrado esta: "+ productoEncontrado);
            }
            else{
                System.out.println("Estoy en la funcion ComprobarProducto y no e econtrado el producto. La variable está " + productoEncontrado);
                /*Mostrar cuadro de dialogo de error*/
            }
        }catch (Exception e ){
            System.out.println(e.getClass());
        }
        return productoEncontrado;
    }
    static void ventanaPrincipal(){
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    static void crearProveedores(){
       Mercadona  = new Proveedor("Mercadona");
       Carrefour = new Proveedor("Carrefour");
       Lidl = new Proveedor("Lidl");
       Aldi = new Proveedor("Aldi");
       listaProveedores = new Proveedor[]{Mercadona, Carrefour,Lidl,Aldi};
       for(int i=0; i<listaProveedores.length;i++ ){
           String mensaje ="funcion crearProveedores: imprimo el array: ";
           mensaje += listaProductos.get(i).getNombre();
           System.out.println(mensaje);
       }
    }
    static void llenarListaProductos(){
        listaProductos.add(new Producto("Manzanas",50,3.5f,Mercadona));
        listaProductos.add(new Producto("Peras",150,1.5f,Carrefour));
        listaProductos.add(new Producto("Atun",50,3.5f,Lidl));
        listaProductos.add(new Producto("Kiwi",150,1.5f,Aldi));
        listaProductos.add(new Producto("Platanos",50,3.5f,Mercadona ));
        listaProductos.add(new Producto("Mango",150,1.5f,Carrefour));
        listaProductos.add(new Producto("Zanahoria",50,3.5f,Lidl));
        listaProductos.add(new Producto("Patatas",150,1.5f,Mercadona));

        System.out.println("funcion llenarListaProductos: imprimo el arraylist de productos: " + listaProductos.toString());
    }


}
