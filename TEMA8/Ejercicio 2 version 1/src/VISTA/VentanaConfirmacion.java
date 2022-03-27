package VISTA;

import MODELO.UML.Evento;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaConfirmacion extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpContenido;
    private JPanel jpInferior;
    private JPanel jpBotones;
    private JPanel jpTitulo;
    private JTextArea taEvento;
    private Evento evento;

    public VentanaConfirmacion() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        evento= Main.eventoSeleccionado(); /*Recibe los datos del evento y los muestra en el text area.
        No deberia pasar el objeto sino un String. */
        taEvento.setText(evento.toString());

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        /*Aqui empieza el delete. Cuando hace click en OK*/
        if(Main.deleteEvento(evento)){
            JOptionPane.showMessageDialog(null,"El evento se ha eliminado");
        }

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public static void main(String[] args) {
        VentanaConfirmacion dialog = new VentanaConfirmacion();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
