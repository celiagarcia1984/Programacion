package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOpciones {
    private JPanel PanelPrincipal;
    private JLabel lTitulo;
    private JButton bCompra;
    private JButton bVenta;

    public JPanel getPanelPrincipal() { /*Este getter es para poder llamar a la ventana desde el Main*/
        return PanelPrincipal;
    }

    public static void main(String[] args) {/*Copio esto en el Main para que sea el Main quien abra la ventana*/
        JFrame frame = new JFrame("VentanaOpciones");
        frame.setContentPane(new VentanaOpciones().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public VentanaOpciones() { /*Aqui se pone lo que tengo que hacer cuando se pulsa compra*/
        bCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            /*PASO 4. Cuando se selecciona Compra: Tengo que llamar a una f(x) que esta en el Main que se llama COMPRA y esa
            * funcion abre la segunda ventana*/
                Main.Ccompras();
            }
        });
        bVenta.addActionListener(new ActionListener() {/*Aqui se pone lo que tengo que hacer cuando se pulsa venta*/
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.Cventas();
            }
        });
    }
}
