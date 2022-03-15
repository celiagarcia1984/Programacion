package VISTA;

import MODELO.UML.Evento;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaEliminarEvento extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpPanelInferior;
    private JPanel jpContenido;
    private JPanel jpBotonesInferiores;
    private JPanel jpTitutlo;
    private JLabel lTitulo;
    private JLabel lNombreEvento;
    private JTextField tfNombre;
    private Evento eventoSelect;

    public VentanaEliminarEvento() {
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

        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
               if(validarNombre() ) {
                  Main.getNombre(tfNombre.getText());
               }
               buttonOK.setEnabled(true);
                Main.abrirVentanaConfirmacion();
            }
        });

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void main(String[] args) {
        VentanaEliminarEvento dialog = new VentanaEliminarEvento();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }
    public boolean validarNombre () {
        boolean nombreValido = false;
        try {
            do {
                if (!tfNombre.getText().isEmpty()) {
                    Pattern patronNombre = Pattern.compile("^([A-Z][a-z]+[\s]?)+$");
                    Matcher mat = patronNombre.matcher(tfNombre.getText());
                    if (mat.matches()) {
                        nombreValido = true;
                        System.out.println("El nombre es correcto");
                    } else {
                        nombreValido = false;
                        JOptionPane.showMessageDialog(null, "El formato del nombre no es correcto");
                        throw new Exception();
                    }
                } else {
                    nombreValido = false;
                    JOptionPane.showMessageDialog(null, "Campo obligatorio", null, JOptionPane.ERROR_MESSAGE);
                    throw new Exception();
                }

            } while (!nombreValido);

        } catch (Exception e) {
            tfNombre.setText("");
            nombreValido = false;
            System.out.println(e.getClass());
        }
        return nombreValido;
    }
}
