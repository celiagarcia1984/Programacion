package com.company;

import MODELO.Cliente;
import MODELO.Producto;
import MODELO.Proveedor;
import VISTA.VentanaPrincipal;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static boolean productoEncontrado=false;
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static Proveedor Mercadona ;
    static Proveedor Carrefour;
    static Proveedor Lidl;
    static Proveedor Aldi;
    static Proveedor[] listaProveedores;
    static int posicionDelProducto;

    public static void main(String[] args) {
        try{
            llenarListaProductos();
            ventanaPrincipal();

        }catch (Exception e){
            System.out.println(e.getClass());
        }
	// write your code here

    }
    public static boolean comprobarProducto(String tproducto)throws Exception{
        int i=0;
        for(i=0; i<listaProductos.size()&& !listaProductos.get(i).getNombre().equalsIgnoreCase(tproducto); i++ ){}
        if(i<listaProductos.size()){
            posicionDelProducto = i;
            productoEncontrado = true;
            System.out.println("Estoy en la funcion ComprobarProducto y e encontrado  el producto. La variable producto encontrado esta: "+ productoEncontrado);
        }
        else{
            System.out.println("Estoy en la funcion ComprobarProducto y no e econtrado el producto. La variable está " + productoEncontrado);
            /*Mostrar cuadro de dialogo de error*/
            JOptionPane.showMessageDialog(null,"El producto no existe","Error", JOptionPane.ERROR_MESSAGE);
        }
        if(tproducto.isEmpty()){
            JOptionPane.showMessageDialog(null,"El campo es obligatorio","Error", JOptionPane.ERROR_MESSAGE);
        }


        return productoEncontrado;
    }
    public static boolean comprobarCantidad(int cantidadIntroducida){
        boolean cantidadCorrecta = false;
        try{
            int i=0;
            if(cantidadIntroducida==0){
                JOptionPane.showMessageDialog(null,"El campo es obligatorio", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
                cantidadCorrecta =true;
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return cantidadCorrecta;
    }
    public static void llenarListaProductos()throws Exception{
        try{
            listaProductos.add(new Producto("Manzanas",50,3.5f,new Proveedor("Mercadona")));
            listaProductos.add(new Producto("Peras",150,1.5f,new Proveedor("Carrefour")));
            listaProductos.add(new Producto("Atun",50,3.5f,new Proveedor("Lidl")));
            listaProductos.add(new Producto("Kiwi",150,1.5f,new Proveedor("Aldi")));
            listaProductos.add(new Producto("Platanos",50,3.5f,new Proveedor("Mercadona")));
            listaProductos.add(new Producto("Mango",150,1.5f,new Proveedor("Carrefour")));
            listaProductos.add(new Producto("Zanahoria",50,3.5f,new Proveedor("Lidl")));
            listaProductos.add(new Producto("Patatas",150,1.5f,new Proveedor("Mercadona")));

            System.out.println("funcion llenarListaProductos: imprimo el arraylist de productos: " + listaProductos.toString());
            System.out.println(listaProductos.get(0).getProveedor().getNombreProveedor());

        }catch (Exception e){
            System.out.println(e.getClass());
        }

    }
    public static void ventanaPrincipal()throws Exception{
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getJpVentanaPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
