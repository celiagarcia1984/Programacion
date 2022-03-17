package VISTA;

import MODELO.BASEDEDATOS.EventoDAO;
import MODELO.UML.Evento;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
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
    private static ArrayList<String>listaEventos = new ArrayList<>();

    public VentanaModificar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        llenarCombo();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();/*en esta funcion tengo que poner la confirmacion del cambio*/
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
        cbEventos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String nombre = cbEventos.getSelectedItem().toString();
                Main.getNombre(nombre);
                Evento evento;
                evento = Main.eventoSeleccionado();
                llenarDatos(evento);
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
    private void llenarCombo(){
        /*Tengo que hacer un select que me saque los nombres de todos los eventos
        * esos nombres los tengo que guardar en un array*/
        listaEventos = Main.dameNombresDeEventos();
        System.out.println("Estoy en llenar combo. tamaño del array "+ listaEventos.size());
        for(int i=0; i<listaEventos.size();i++){
            cbEventos.addItem(listaEventos.get(i));
        }
    }

    public static void main(String[] args) {
        VentanaModificar dialog = new VentanaModificar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    private void llenarDatos(Evento evento){
        try{
            tfLugar.setText(evento.getLugar());
            tfFecha.setText(evento.getFecha().toString());
            tfHoraIn.setText(evento.getHoraInicio().toString());
            tfHoraFin.setText(evento.getHoraFin().toString());
            tfAforoDisp.setText(String.valueOf(evento.getAforoDisponible()));
            tfAforo.setText(String.valueOf(evento.getAforo()));
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}
