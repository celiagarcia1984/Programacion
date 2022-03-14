package VISTA;

import javax.swing.*;
import java.awt.event.*;

public class VentanaEliminarModificarEv extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpBotones;
    private JPanel jpPanelInferior;
    private JPanel jpContenido;
    private JPanel jpOpciones;
    private JLabel lTitulo;
    private JRadioButton rbCancelar;
    private JRadioButton rbModificar;

    public VentanaEliminarModificarEv() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        /*Cuando doy a ok, miro que radioButton esta seleccionado*/
        if(rbCancelar.isSelected()){

        }
        //dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VentanaEliminarModificarEv dialog = new VentanaEliminarModificarEv();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
