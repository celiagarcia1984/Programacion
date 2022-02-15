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
    private JPanel jpImporte;
    private JLabel limporteVenta;
    private JTextField tImporteVenta;
    private boolean productoEncontrado=false;
    private boolean unidadesCorrectas=false;
    private String proveedor="";
    private float importeVenta=0f;
    private int DescProntoPago = 3;
    private int DescVolumen = 2;

     
    public VentanaPrincipal() {
        /*ACTIONLISTENER DE PRODUCTO*/


        tProducto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                /*En el momento que quitamos el cursor de PRODUCTO, llamamos a una funcion que se llama comprobarProducto
                * y que está en el MAIN*/

                productoEncontrado = Main.comprobarProducto(tProducto.getText());
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
                    if(tUnidades.getText().isEmpty()){
                        tUnidades.setText("0");
                    }
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

                validarCantidadVenta();/*COMPRUEBA QUE EL STOCK ES SUFICIENTE*/

                jpDatosVenta.setVisible(true);
                String precioVenta = Main.mostrarPrecioVenta();/*Carga el precio de venta*/
                tPrecioVenta.setText(precioVenta);


                jpDatosCompra.setVisible(false);
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
                        calcularImporteCompra();

                    }
                } catch (Exception x) {
                    System.out.println(x.getClass());
                }
            }
        });
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbCompra.isSelected()){
                   Main.actualizarStockDespuesDeUnaCompra(Integer.parseInt(tUnidades.getText()),Float.parseFloat(tPrecioCompra.getText()));
                   Main.mostrarConfirmacionDeCompra(tProducto.getText(),Integer.parseInt(tUnidades.getText()),Float.parseFloat(tPrecioCompra.getText()));
                   reiniciarVentanaDespuesDeCompra();

                }
                else
                if(rbVenta.isSelected()){
                    prepararVentanaParaVenta();

                }
            }
        });

        tCliente.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try{
                    if(tCliente.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"El campo es obligatorio","ERROR",JOptionPane.WARNING_MESSAGE);
                    }

                    Main.comprobarCliente(tCliente.getText());
                    System.out.println("focusLost de cliente,despues de comprobar cliente");
                    calcularImporteVenta();
                }
                catch (Exception y){
                    System.out.println(y.getClass());
                }

            }
        });


        tCliente.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if(Main.comprobarCliente(tCliente.getText())){
                        tCliente.setEditable(false);
                    }

                } catch (Exception z) {
                    System.out.println(z.getClass());
                }
            }
        });

        cbVolumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularImporteVenta();
            }
        });
        cbProntoPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               calcularImporteVenta();
            }
        });

        /*FIN DEL PROGRAMA. REINICIA TODO EL FORMULARIO*/
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                tFOperacion.setVisible(true);
                tPrecioVenta.setText("");
                tCliente.setText("");
                tPrecioVenta.setText("");
                cbProveedores.setSelectedIndex(-1);
                tCliente.setEditable(true);
                tCliente.setText("");

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

    public void validarCantidadVenta(){
        try{
            if(!Main.comprobarCantidadVenta(Integer.parseInt (tUnidades.getText()))){
                tUnidades.setEditable(true);
                tUnidades.setText("");
                System.out.println("rbVenta comprobarCantidadVenta.");
            }
        }catch (Exception f){
            System.out.println(f.getClass());
        }
    }

    public void calcularImporteCompra(){
        try{
            float importeCompra=0f;
            importeCompra = Float.parseFloat(tPrecioCompra.getText()) * Float.parseFloat(tUnidades.getText());
            String sImporteCompra = String.valueOf( importeCompra );
            tImporteCompra.setText(sImporteCompra);
            tImporteCompra.setEditable(false);
            bAceptar.setEnabled(true);
            tFOperacion.setVisible(false);

        }catch (Exception g){
            System.out.println(g.getClass());
        }
    }

    public void prepararVentanaParaVenta(){
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
        tFOperacion.setVisible(true);
        tPrecioVenta.setText("");
        tCliente.setText("");
        cbVolumen.setSelected(false);
        cbProntoPago.setSelected(false);
        tImporteVenta.setText("");
    }

    public void calcularImporteVenta(){
        try{
            int descuento=1;
            importeVenta= Float.parseFloat (tPrecioVenta.getText())* Float.parseFloat(tUnidades.getText());
            if(cbProntoPago.isSelected()){
                descuento=DescProntoPago;
                System.out.println("el descuento es ppp");
            }
            if(cbVolumen.isSelected()){
                descuento=+DescVolumen;
                System.out.println("el descuento es por volumen" );
            }
            System.out.println("el importe de la venta es:" + importeVenta);
            importeVenta = (importeVenta-importeVenta*descuento/100);
            System.out.println("despues de ");
            tImporteVenta.setText(String.valueOf(importeVenta));

        }catch (Exception s){
            System.out.println(s.getClass());
        }

    }

    public void reiniciarVentanaDespuesDeCompra(){
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
        tFOperacion.setVisible(true);
        tPrecioVenta.setText("");
    }
}
