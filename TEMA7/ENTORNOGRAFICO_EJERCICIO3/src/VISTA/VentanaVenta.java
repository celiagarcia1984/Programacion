package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaVenta {
    private JPanel panelPrincipal;
    private JLabel lProducto;
    private JTextField tProducto;
    private JLabel lUnidades;
    private JTextField tUnidades;
    private JTextField tPrecio;
    private JLabel lPrecio;
    private JButton bAceptar;
    private JButton bCancelar;

    public JPanel getPanelPrincipal() { /*Para llamar desde el MAIN*/
        return panelPrincipal;
    }

    public static void main(String[] args) { /*Copia Pega en el MAIN*/
        JFrame frame = new JFrame("VentanaVenta");
        frame.setContentPane(new VentanaVenta().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public VentanaVenta() {
        tProducto.addFocusListener(new FocusAdapter() { /*Cuando pierde el foco que compruebe si el producto es valido.
        Que no esté vacio y que exista en el array*/
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                /*funcion ValidarProducto*/
                validarProducto();
            }
        });
        tUnidades.addFocusListener(new FocusAdapter() {/*Que no está vacio y que hay suficientes unidades*/

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        tPrecio.addFocusListener(new FocusAdapter() {/*Que no esté vacio y que el precio sea correcto. O tb puedo cargar el
            precio que aparece en el objeto*/
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        bAceptar.addActionListener(new ActionListener() { /*Cuando se acepta o Cancela tiene que volver la pantalla opciones*/
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaOpciones();

            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaOpciones();
            }
        });

        }
        public void validarProducto(){
        try{
            if(tProducto.getText().isEmpty()){
                throw new Exception();
            }
            Main.comprobarProducto(tProducto.getText());
            /*Aqui tengo que llamar a una funcion que me va a dar la informacion del importe para cargarlo en la ventana
            * importe*/

        }catch (Exception e){
            System.out.println(e.getClass()+ "Es un campo obligatorio");
        }

        }/*A esta funcion la llamo en el listener focus lost de producto*/
    }

