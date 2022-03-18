package VISTA;

import MODELO.BASEDEDATOS.EventoDAO;
import MODELO.UML.Evento;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class VentanaModificar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpInferior;
    private JPanel jpBotones;
    private JPanel jpContenido;
    private JPanel jpTitulo;
    private JLabel lTitulo;
    private JLabel lSeleccione;
    private JComboBox cbEventos;
    private JPanel jpDatos;
    private JTextField tfFecha;
    private JTextField tfHoraIn;
    private JTextField tfHoraFin;
    private JTextField tfAforo;
    private JTextField tfAforoDisp;
    private JTextField tfLugar;



    public VentanaModificar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        /*Llenar ComboBox. No puedo traerme un objeto Evento.*/
        llenarComboBox();



       /* *************************AQUI EMPIEZAN LOS LISTENERS*****************************************/
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
        cbEventos.addMouseMotionListener(new MouseMotionAdapter() {
        });


    }
/* ********************************AQUI EMPIEZAN LAS FUNCIONES ************************************************/
    private void llenarComboBox(){
        try{
            /*Llamo a una funcion del Main que me va a dar los datos para llenarlo. Lo tengo que llenar en el MAIN con funciones que llamo aqui*/
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public static void main(String[] args) {
        VentanaModificar dialog = new VentanaModificar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
