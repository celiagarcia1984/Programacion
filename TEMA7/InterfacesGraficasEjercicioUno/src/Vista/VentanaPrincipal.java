package Vista;
import Excepciones.datoNoValido;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Main.listaPersonas;

public class VentanaPrincipal {
    private JPanel VentanaDeAlta;
    private JTextPane tnombre;
    private JTextPane tApellido;
    private JTextPane tDni;
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel lDni;
    private JLabel lapellido;
    private JLabel lTitulo;
    private JLabel lNombre;
    private JPanel panelPrincipal;

    public VentanaPrincipal() { /*Esta parte de aqui es lo que va a pasar cuando se acepte el cuadro de dialogo.
    Aqui tengo que validar todos los datos igual que hacia antes*/
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validarNombre(tnombre);
                    validarApellido(tApellido);
                    validarDni(tDni);
                    System.out.println("LOS DATOS SE HAN VALIDADO");
                    Main.tenDatos(tnombre.getText(),tApellido.getText(),tDni.getText());
                    tnombre.setText("");
                    tApellido.setText("");
                    tDni.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,listaPersonas.toString());
            }
        });
    }

    public static void main(String[] args) {
        try{
            JFrame frame = new JFrame("VentanaPrincipal");
            frame.setContentPane(new VentanaPrincipal().panelPrincipal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "El campo es obligatorio");
        }
    }
    public JPanel getPanelPrincipal() { /*Este get esta generado porque me e llevado al main el main de esta ventana,
    para que el programa se ejecute desde el main y no desde la Vista*/
        return panelPrincipal;
    }
    /*Esta es la validacion de los datos introducidos*/
    static public void validarNombre(JTextPane tnombre)throws Exception {
        try {
            if (tnombre.getText().isEmpty()) {
                throw new datoNoValido();
            }

        } catch (Exception datoNoValido) {
            JOptionPane.showMessageDialog(null, "El campo es obligatorio");

        }

    }
    static public void validarApellido(JTextPane tApellido)throws Exception {
        try {
            if (tApellido.getText().isEmpty()) {
                throw new datoNoValido();
            }

        } catch (Exception datoNoValido) {
            JOptionPane.showMessageDialog(null, "El campo es obligatorio");

        }

    }
    static public void validarDni(JTextPane tDni)throws Exception {
        try {
            if (tDni.getText().isEmpty()) {
                throw new datoNoValido();
            }

        } catch (Exception datoNoValido) {
            JOptionPane.showMessageDialog(null, "El campo es obligatorio");

        }

    }
}

