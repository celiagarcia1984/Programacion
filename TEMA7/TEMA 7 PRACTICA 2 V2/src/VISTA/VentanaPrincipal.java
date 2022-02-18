package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaPrincipal {
    private JPanel jpTitulo;
    private JLabel lTitulo;
    private JPanel jpDatosProducto;
    private JLabel lNombreProducto;
    private JTextField tProducto;
    private JLabel lUnidades;
    private JTextField tUnidades;
    private JRadioButton rbCompra;
    private JPanel jpOpciones;
    private JRadioButton rbVenta;
    private JButton bAceptar;
    private JButton bCancelar;
    private JPanel jpVentanaPrincipal;
    private boolean productoEncontrado=false;
    private boolean unidadesCorrectas=false;

    public VentanaPrincipal() {
        /*PRODUCTO*/
            tProducto.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    super.focusLost(e);
                    try {
                        productoEncontrado = Main.comprobarProducto(tProducto.getText());

                        if(productoEncontrado){
                            tProducto.setEditable(false);
                            productoEncontrado=true;
                        }
                        else{
                            /*Si no lo encuentra, se limpia el campo*/
                            tProducto.setText("");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getClass());
                    }
                }
            });

        /*UNIDADES*/
        tUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(productoEncontrado){
                    if(tUnidades.getText().isEmpty()){
                        tUnidades.setText("0");
                    }
                    unidadesCorrectas = Main.comprobarCantidad(Integer.parseInt(tUnidades.getText()));
                }
                if(unidadesCorrectas){
                    tUnidades.setEditable(false);
                    System.out.println("Las unidades son correctas");
                }
                else{
                    tUnidades.setText("");
                    /*Si la cantidad es correcta. Pongo la casilla que no se pueda editar*/

                }
            }
        });
        /*AL ACEPTAR*/


        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*SI radiobutton compra activado. ABRIR */
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().jpVentanaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpVentanaPrincipal() {
        return jpVentanaPrincipal;
    }
}
