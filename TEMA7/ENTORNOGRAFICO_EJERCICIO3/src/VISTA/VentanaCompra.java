package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
                Main.mostrarVentanaOpciones();
            }
        });
        bCancelar.addActionListener(new ActionListener() {/*Lo que hace cuando se da a cancelar*/
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaOpciones();
            }
        });
        tProducto.addFocusListener(new FocusAdapter() {/*Lo que hace cuando se pone el cursor en producto.  No se si
        lo usaré*/
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {/*Lo que hace si se quita el foco de producto. Lo usaré para que valide
            si el producto existe en el array LISTADEPRODUCTOS*/
                super.focusLost(e);
            }
        });
    }
}
