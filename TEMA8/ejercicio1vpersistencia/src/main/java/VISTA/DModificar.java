package VISTA;

import CONTROLADOR.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class DModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfLugar;
    private JTextField tfFecha;
    private JTextField tfHoraInicio;
    private JTextField tfHoraFin;
    private JTextField tfAforo;
    private JLabel lTitulo;
    private JComboBox cbEventos;

    private LocalDate fecha;
    private LocalTime horaI;
    private LocalTime horaF;
    private int aforo;

    public DModificar() {
        llenarComboBox();

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

    /*Limpia los input cuando se pone encima*/
        tfFecha.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                tfFecha.setText("");
            }
        });
        tfHoraInicio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                tfHoraInicio.setText("");
            }
        });
        tfHoraFin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                tfHoraFin.setText("");
            }
        });
    }

    public void llenarComboBox(){
        Main.llenarCombo();
    }

    private void onOK() {
        // Validar datos de entrada y enviar al controlador.
        try
        {

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DModificar dialog = new DModificar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
