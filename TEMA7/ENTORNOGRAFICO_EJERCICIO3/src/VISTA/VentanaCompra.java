package VISTA;

import MODELO.Productos;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import static java.lang.Float.valueOf;

public class VentanaCompra {
    private JPanel panelPrincipal;
    private JLabel lCompras;
    private JLabel lProducto;
    private JTextField tProducto;
    private JLabel lUnidades;
    private JTextField tUnidades;
    private JTextField tImporte;
    private JLabel lImporte;
    private JButton bAceptar;
    private JButton bCancelar;
    static Productos prodcutoSeleccionado;

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaCompra");
        frame.setContentPane(new VentanaCompra().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanelPrincipal() {/*Es para poder poner el main en el Controlador(MAIN)*/
        return panelPrincipal;
    }

    public VentanaCompra() { /*Cuando se da a aceptar o Cancelar a parte de todo lo demas que tenga que hacer tiene que
    volver a abrir la ventana opciones*/
        bAceptar.addActionListener(new ActionListener() { /*Lo que hara cuando se de a aceptar. Validar importe y cantidad*/
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.actualizarStock (Integer.parseInt(tUnidades.getText()),Float.parseFloat (tImporte.getText()));
                Main.mostrarStockActualizado(Integer.parseInt(tUnidades.getText()),Float.parseFloat(tImporte.getText()));
                Main.mostrarVentanaOpciones();
            }
        });
        bCancelar.addActionListener(new ActionListener() {/*Lo que hace cuando se da a cancelar*/
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaOpciones();
            }
        });
        tProducto.addFocusListener(new FocusAdapter() {/*Lo que hace si se quita el foco de producto. Lo usaré para que valide
            si el producto existe en el array LISTADEPRODUCTOS*/
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarProducto();
                Main.comprobarProducto(tProducto.getText());
            }
        });
        tUnidades.addFocusListener(new FocusAdapter() {/*Cuando escriban las unidades que se van a comprar. Se suma al
        stock de ese producto*/
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                /*Se actualiza la cantidad*/
            }
        });
    }
    public void validarProducto(){
        try{
            if(tProducto.getText().isEmpty()){
                throw new Exception();
            }
            Main.comprobarProducto(tProducto.getText());
            System.out.println("funcion validarProducto: El producto es: " + tProducto.getText());
            /*Aqui tengo que llamar a una funcion que me va a dar la informacion del importe para cargarlo en la ventana
             * importe*/
            tProducto.setEditable(false);
            /*Me quedo con el producto*/
            prodcutoSeleccionado = Main.getProduto(); /*En ProductoSeleccionado estoy guardando el producto que se ha
            elegido en la ventana VENTA para poder cargar el importeUnitario en la ventana*/
            System.out.println("ValidarProducto en Compra." + prodcutoSeleccionado.toString());

        }catch (Exception e){
            System.out.println(e.getClass()+ "Es un campo obligatorio");
        }
    }
}
