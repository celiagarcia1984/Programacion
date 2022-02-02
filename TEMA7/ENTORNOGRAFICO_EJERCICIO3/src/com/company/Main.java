package com.company;

import MODELO.Productos;
import VISTA.VentanaCompra;
import VISTA.VentanaOpciones;
import VISTA.VentanaVenta;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
   static ArrayList<Productos> listaProductos = new ArrayList<>();
   static boolean productoEncontrado;
   static int posicionDelProducto;
   static Productos A;

    public static void main(String[] args) {
	/*PASO 1. Crear la clase Productos*/
    /*PASO 2. Crear arraylist con Productos*/
    /*Creo los diferentes objetos para añadirlos al ArrayList. Creo la funcion CrearYllenarListaProductos*/
        crearYllenarListaProductos();
        mostrarVentanaOpciones();
    /*Paso 3. Crear la VentanaOpciones*/
    /*Paso 4. En ventaOpciones. Establecer lo que van a hacer los botones COMPRA Y VENTA*/
    /*PASO 5. Creo una funcion para mostrar la segunda ventana que se llama Compras() y lo que hace es abrir la
    * segunda ventana. La funcion la llamo en el listener del boton COMPRAR*/
    /*PASO 6. Creo una funcion para mostrar la tercera ventana que se llama VENTAS() Y se la llama en el listener
    * del boton venta*/
    /*PASO 7. ¿QUE HACE CUANDO VENDE? VentanaVenta*/
        /*PASO 8. SE COMPRUEBA QUE EL PRODUCTO EXISTE CON LA F(X) COMPROBARPRODUCTO. DEVUELVE LA POSICION DEL PRODUCTO
        * EN EL ARRAY LISTAPRODUCTOS.*/
        /*PASO 9. Genero una nueva funcion GETPRODUCTO en la que guardo el producto del cual me he guardado la posicion y la llamo en
        * la ventanaVenta en la FUNCION VALIDAR PRODUCTO */
        /*PASO 10. Ahora en la ventanaVENTA -> */
    /****************************EMPIEZA LA PARTE DE COMPRAS***********************************************************/
    /*Cuando se elige la opcion COMPRA, Se introducen y comprueban todos los datos*/
    }

    public static void actualizarStock(int cantidadComprada, float precioUnitario)/*Para compras*/{
        /*valor del stock antes de actualizar*/
        float valorStockAnterior=0f;
        valorStockAnterior = listaProductos.get(posicionDelProducto).getUnidades()* listaProductos.get(posicionDelProducto).getPrecioUnitario();
        System.out.println("FUNCION ACTUALIZARSTOCK: EL VALOR DEL STOCK ANTES DE LA COMPRA ES"+ valorStockAnterior);
        /*Actualizo el stock con la cantidad comprada*/
        float valorDeLaCompra=0f;
        valorDeLaCompra= cantidadComprada*precioUnitario;
        System.out.println("FUNCION ACTUALIZARSTOCK el valor total de los productos que se compran es:" + valorDeLaCompra);
        /*ACTUALIZO EL STOCK*/
        listaProductos.get(posicionDelProducto).setUnidades(Integer.parseInt(String.valueOf(listaProductos.get(posicionDelProducto).getUnidades()+cantidadComprada)));
        System.out.println("FUNCION ACTUALIZARSTOCK: EL STOCK AHORA ES: " + listaProductos.get(posicionDelProducto).getUnidades());
        System.out.println("funcion actualizarstock. el importe por unidad esta sin actualizar y es " + listaProductos.get(posicionDelProducto).getPrecioUnitario());
        /*ACTUALIZO EL PRECIO*/
        float precioActualizado = (valorStockAnterior + valorDeLaCompra)/listaProductos.get(posicionDelProducto).getUnidades();
        listaProductos.get(posicionDelProducto).setPrecioUnitario(precioActualizado);
        System.out.println("FUNCION ACTUALIZAR STOCK: El precio actualizado es: "+ listaProductos.get(posicionDelProducto).getPrecioUnitario());

    }
    public static void ajustarStock(int cantidadVendida){
        System.out.println("FUncion ajustarStock: este es el stock antes de una venta" + listaProductos.get(posicionDelProducto).getUnidades());
                listaProductos.get(posicionDelProducto).setUnidades(listaProductos.get(posicionDelProducto).getUnidades()-cantidadVendida);
        System.out.println("FUncion ajustarStock: este es el stock despues de una venta" + listaProductos.get(posicionDelProducto).getUnidades());
        JOptionPane.showMessageDialog(null, "El stock restante es de "+ listaProductos.get(posicionDelProducto).getUnidades());
    }/*PARA VENTAS*/
    public static void mostrarStockActualizado(int cantidadComprada, float precioCompra){
        JOptionPane.showMessageDialog(null, "Despues de la compra de "+ cantidadComprada + "El stock es de "+
                listaProductos.get(posicionDelProducto).getUnidades()+" unidades. A un precio unitario de: " +
                listaProductos.get(posicionDelProducto).getPrecioUnitario());
    }
    public static Productos getProduto(){
        A = listaProductos.get(posicionDelProducto);
        System.out.println(A.toString() + "funcion GETPRODUCTO: El objeto A es el que se ha creado para pasar los datos a la venta venta");

        return A;
    }
    public static void comprobarProducto(String tProducto){
        int i=0;
        for(i=0; i<listaProductos.size()&&!listaProductos.get(i).getNombre().equalsIgnoreCase(tProducto);i++){}//Para de
        //cuando lo encuentra.
        System.out.println(tProducto);
        if(i<listaProductos.size()){
            productoEncontrado=true;
            System.out.println("Funcion comprobarProductos. Ha entrado en a encontrado el producto" + productoEncontrado
                    + "el producto está en la posicion de i: "+ i );
            posicionDelProducto = i; /*Me guardo la posicion del producto para cargar la informacion del importe en la ventana
        ventas y no tener que marcarlo*/
        }
        else{
            productoEncontrado=false;
            System.out.println("Funcion comprobarProductos. Ha entrado en no a encontrado el producto" + productoEncontrado
                    + "i vale: "+ i );
        }

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
