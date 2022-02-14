package com.company;

import EXCEPCIONES.DatoNoValido;
import MODELO.Cliente;
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
    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static Proveedor Mercadona ;
    static Proveedor Carrefour;
    static Proveedor Lidl;
    static Proveedor Aldi;
    static Proveedor[] listaProveedores;
    static int posicionDelProducto;



    public static void main(String[] args) {

	llenarListaProductos();

	/*Una vez creados los datos. Se abre la ventana Principal*/
        ventanaPrincipal();

    }
    public static boolean comprobarPrecioCompra(float precioCompra)throws Exception{
        boolean precioCompraCorrecto=false;
        try{
            if(precioCompra>0){
                precioCompraCorrecto=true;
            }
            else{
                JOptionPane.showMessageDialog(null,"El campo es obligatorio","ERROR",JOptionPane.WARNING_MESSAGE);
                throw new DatoNoValido();

            }

        }catch (DatoNoValido e){
            System.out.println(e.getClass()+ "El precio no puede estar vacio");
        }

        return precioCompraCorrecto;
    }
    public static String llenarProveedores(){
        String proveedor="";
        try{
            System.out.println(posicionDelProducto+ "posicion del producto");
           proveedor=listaProductos.get(posicionDelProducto).getProveedor().getNombreProveedor() ;
           System.out.println("FUNCION LLENAR PROVEEDORES: el proveedor es :" + proveedor);

        }catch (Exception e ){
            System.out.println(e.getClass()+"Tengo un error");
        }
        return proveedor;
    }
    public static boolean comprobarCliente(String tCliente)throws Exception{
        boolean nombreClienteCorrecto =false;
        int i=0;
        for(i=0;i<listaClientes.size()&& !listaClientes.get(i).getNombreCliente().equalsIgnoreCase(tCliente);i++){}
        if(i==listaClientes.size()){
            listaClientes.add(new Cliente(tCliente));
            nombreClienteCorrecto =true;
        }
        else{
            nombreClienteCorrecto =true;
            System.out.println("Se ha encontrado al cliente");
        }
        if(tCliente.isEmpty()){
            JOptionPane.showMessageDialog(null,"El nombre es un campo obligatorio");
            nombreClienteCorrecto=false;
        }
       return nombreClienteCorrecto;
    }
    public static String mostrarPrecioVenta(){
        float precioVenta=0f;
        String sprecioVenta="";
        precioVenta = listaProductos.get(posicionDelProducto).getPrecioVenta();
         sprecioVenta=String.valueOf(precioVenta);
        return sprecioVenta;
    }
    public static void mostrarConfirmacionDeCompra(String producto, int cantidadComprada, float precioCompra){

            JOptionPane.showMessageDialog(null,"El stock actual de: "+producto+"\n"+
                            " es de: " + listaProductos.get(posicionDelProducto).getStockDisponible() + "\n"+
                    " el precio de venta del producto es ahora: "+ listaProductos.get(posicionDelProducto).getPrecioVenta(),
                    "CONFIRMACION DE COMPRA",JOptionPane.INFORMATION_MESSAGE);


    }
    public static void actualizarStockDespuesDeUnaCompra(int cantidadComprada, float precioCompra){
        float valorStockActual = 0f;
        valorStockActual= listaProductos.get(posicionDelProducto).getStockDisponible()*listaProductos.get(posicionDelProducto).getPrecioVenta();
        System.out.println("funcion actualizarStockDespuesDeUnaCompra: El Valor del stock del almacen es: "+ valorStockActual);
        float valorStockComprado = 0f;
        valorStockComprado = cantidadComprada*(precioCompra*2);
        System.out.println("funcion actualizarStockDespuesDeUnaCompra: El Valor del stock comprado es: "+ valorStockComprado);
        int StockTotal = listaProductos.get(posicionDelProducto).getStockDisponible()+cantidadComprada;
        float precioActualizado = 0f;
        precioActualizado= (valorStockActual+valorStockComprado)/StockTotal;
        System.out.println("funcion actualizarStockDespuesDeUnaCompra: El precio Unitario Actualizado es: "+ valorStockActual);
        listaProductos.get(posicionDelProducto).setStockDisponible(StockTotal);
        listaProductos.get(posicionDelProducto).setPrecioVenta(precioActualizado);
        System.out.println(listaProductos.toString());
    }
    public static boolean comprobarCantidadVenta(int cantidadIntroducida)throws Exception{
        boolean cantidadCorrecta = false;

            if(listaProductos.get(posicionDelProducto).getStockDisponible()<cantidadIntroducida){
                /*Si hay menos stock hay que mostrar un mensaje de error*/
                /*PARA CUANDO SE REALICE UNA VENTA:*/
                JOptionPane.showMessageDialog(null, "La cantidad supera el stock", "ATENCION",JOptionPane.WARNING_MESSAGE);
            }
            else{
                cantidadCorrecta = true;
            }

        return cantidadCorrecta;
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
    public static boolean comprobarProducto(String tproduto){

        try{
            int i=0;
            for(i=0; i<listaProductos.size()&& !listaProductos.get(i).getNombre().equalsIgnoreCase(tproduto); i++ ){}
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
            if(tproduto.isEmpty()){
                JOptionPane.showMessageDialog(null,"El campo es obligatorio","Error", JOptionPane.ERROR_MESSAGE);
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

    static void llenarListaProductos(){
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


}
