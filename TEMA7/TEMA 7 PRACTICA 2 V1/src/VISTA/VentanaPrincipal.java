package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaPrincipal {
    private JPanel PanelPrincipal;
    private JLabel lTitulo;
    private JLabel lNombreProducto;
    private JTextField tProducto;
    private JLabel lUnidades;
    private JTextField tUnidades;
    private JPanel tFOperacion;
    private JRadioButton rbCompra;
    private JRadioButton rbVenta;
    private JLabel tOperacion;
    private JPanel jpDatosCompra;
    private JLabel lPrecioCompra;
    private JTextField tPrecioCompra;
    private JLabel lTituloCompra;
    private JLabel lProveedor;
    private JLabel lImporte;
    private JTextField tImporteCompra;
    private JComboBox cbProveedor;
    private JPanel jpDatosVenta;
    private JLabel lPrecioVenta;
    private JTextField tPrecioVenta;
    private JLabel lTituloVenta;
    private JLabel lCliente;
    private JTextField tCliente;
    private JPanel jpDescuentos;
    private JLabel lTituloDescuentos;
    private JCheckBox cbVolumen;
    private JCheckBox cbProntoPago;
    private JPanel jpBotones;
    private JButton bAceptar;
    private JButton bCancelar;

    public VentanaPrincipal() {
        /*ACTIONLISTENER DE PRODUCTO*/
        tProducto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                /*En el momento que quitamos el cursor de PRODUCTO, llamamos a una funcion que se llama comprobarProducto
                * y que está en el MAIN*/
                if((Main.comprobarProducto(tProducto.getText()))){
                    tProducto.setEditable(false);
                }
                else{
                    /*Si no lo encuentra*/
                    tProducto.setText("");

                }
            }

        });/*Aqui lo que hace cuando se pierde el foco de la casilla Producto*/
        /*ACTIONLISTENER DE UNIDADES*/
        tUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                /*Cuando quitamos el cursor de unidades. llamamos a la funcion comprobarCantidad que está en el main*/
                if(!Main.comprobarCantidad(Integer.parseInt(tUnidades.getText()))){
                    /*si la cantidad introducida no es correcta porque es mayor que el stock disponible ¿que hago?
                    * MOSTRAR ERROR*/
                    tUnidades.setText("");
                }
                else{
                    /*Si la cantidad es correcta. Pongo la casilla que no se pueda editar*/
                    tUnidades.setEditable(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }


}
