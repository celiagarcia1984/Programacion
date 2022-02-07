package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

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
    private JPanel jpDatosCompra;
    private JLabel lPrecioCompra;
    private JTextField tPrecioCompra;
    private JLabel lProveedor;
    private JLabel lImporte;
    private JTextField tImporteCompra;
    private JPanel jpDatosVenta;
    private JLabel lPrecioVenta;
    private JTextField tPrecioVenta;
    private JLabel lCliente;
    private JTextField tCliente;
    private JPanel jpDescuentos;
    private JCheckBox cbVolumen;
    private JCheckBox cbProntoPago;
    private JPanel jpBotones;
    private JButton bAceptar;
    private JButton bCancelar;
    private JPanel jpProducto;
    private JComboBox<String> cbProveedores;
    private boolean productoEncontrado=false;
    private boolean unidadesCorrectas=false;
    private String proveedor="";
    public VentanaPrincipal() {
        /*ACTIONLISTENER DE PRODUCTO*/


        tProducto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                /*En el momento que quitamos el cursor de PRODUCTO, llamamos a una funcion que se llama comprobarProducto
                * y que está en el MAIN*/

                productoEncontrado =Main.comprobarProducto(tProducto.getText());
                if(productoEncontrado){
                    tProducto.setEditable(false);
                    productoEncontrado=true;
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
                if(productoEncontrado){
                    unidadesCorrectas = Main.comprobarCantidad(Integer.parseInt(tUnidades.getText()));
                }
                if(unidadesCorrectas){
                    tUnidades.setEditable(false);
                    tFOperacion.setVisible(true);
                    proveedor = Main.llenarProveedores();
                    cbProveedores.addItem(proveedor);
                }
                else{
                    tUnidades.setText("");
                    /*Si la cantidad es correcta. Pongo la casilla que no se pueda editar*/

                }
            }
        });
        rbCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpDatosCompra.setVisible(true);
                jpDatosVenta.setVisible(false);
                jpDescuentos.setVisible(false);
            }
        });
        rbVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jpDatosVenta.setVisible(true);
                String precioVenta = Main.mostrarPrecioVenta();/*Carga el precio de venta*/
                tPrecioVenta.setText(precioVenta);
                jpDatosCompra.setVisible(false);
                jpDescuentos.setVisible(true);
            }
        });
        tCliente.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                jpDescuentos.setVisible(true);
            }
        });
            /*Cuando el precio es correcto, se inhabilita la ediccion. Se calcula el nuevo precio de venta en una funcion en el MAIN*/
        tPrecioCompra.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if(Main.comprobarPrecioCompra(Float.parseFloat (tPrecioCompra.getText()))){
                        tPrecioCompra.setEditable(false);
                        float importeCompra=0f;
                        importeCompra = Float.parseFloat(tPrecioCompra.getText()) * Float.parseFloat(tUnidades.getText());
                        String sImporteCompra = String.valueOf( importeCompra );
                        tImporteCompra.setText(sImporteCompra);
                        tImporteCompra.setEditable(false);
                        bAceptar.setEnabled(true);
                        tFOperacion.setVisible(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbCompra.isSelected()){
                    Main.actualizarStockDespuesDeUnaCompra(Integer.parseInt(tUnidades.getText()),Float.parseFloat(tPrecioCompra.getText()));
                   Main.mostrarConfirmacionDeCompra(tProducto.getText(),Integer.parseInt(tUnidades.getText()),Float.parseFloat(tPrecioCompra.getText()));
                   tProducto.setText("");
                   tUnidades.setText("");
                   tProducto.setEditable(true);
                   tUnidades.setEditable(true);
                   tImporteCompra.setText("");
                   jpDatosCompra.setVisible(true);
                   bAceptar.setEnabled(false);
                   jpDatosVenta.setVisible(true);
                   jpDescuentos.setVisible(true);
                   tPrecioVenta.setEditable(true);
                   tPrecioVenta.setText("");
                }
                else{
                    /*Aqui la venta*/
                }

            }
        });

        tCliente.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

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
