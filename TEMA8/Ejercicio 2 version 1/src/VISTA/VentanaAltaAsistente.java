package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaAltaAsistente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpInferior;
    private JPanel jpBotonesInferiores;
    private JPanel jpContenido;
    private JPanel jpTitulo;
    private JLabel lAñadirAsistente;
    private JPanel jpEvento;
    private JLabel lEvento;
    private JComboBox cbEvento;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JComboBox cbEmpresa;
    private JLabel lEmpresa;
    private JRadioButton rbOtra;
    private ArrayList<String>listaNombresEventos;
    private ArrayList<String>listaNombresEmpresas;
    private int posicionEvento;

    public VentanaAltaAsistente() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        /*Cargar combo Eventos*/
        /*Para llenar el combo tengo que hacer un select para traer los nombres de los eventos*/
        Main.obtenerDatosEventos();
        llenarComboBox();
        cbEvento.setSelectedIndex(-1);
        Main.obtenerDatosEmpresas();
        llenarComboBoxEmpresas();
        cbEmpresa.setSelectedIndex(-1);


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
        cbEvento.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                /*Voy a validar el dni y si es correcto, busco el dni en la base de datos, si está cargo los datos,
            y doy de alta al asistente.Lo añado al array de personas de ese evento*/
                /*1ª Al seleccionar el evento. Cojo la posicion del evento para consultar el dni en el arrayEventos que
                 * ya tengo usando la funcion obtenerDatoSeventos*/
                posicionEvento = cbEvento.getSelectedIndex(); /*tengo la posicion del evento*/
                /*Necesito una funcion en el main que consulte la tabla asistentes y si no encuentra añadirlo*/

            }
        });
    }

    private void onOK() {
        /*Validar datos*/
        boolean asistenteEncontrado =false;
        if(validarDniAsistente()){
           asistenteEncontrado= Main.buscarAsistente(tfDni.getText(),posicionEvento);
        }


       // dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VentanaAltaAsistente dialog = new VentanaAltaAsistente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    private void llenarComboBox() {
        System.out.println("Estoy en la funcion LLenarComboBOx de la ventanaModificar");
        listaNombresEventos = new ArrayList<>();
        try {
            /*Llamo a una funcion del Main que me va a dar los datos para llenarlo. Lo tengo que llenar en el MAIN con funciones que llamo aqui*/
            System.out.println("llamo a la funcion llenaCombo DEL MAIN");
            listaNombresEventos = Main.llenaCombo();
            for (int i = 0; i < listaNombresEventos.size(); i++) {
                cbEvento.addItem(listaNombresEventos.get(i));
                System.out.println("estoy llenando el combobox");
            }

        } catch (Exception e) {
            System.out.println(e.getClass() + " algo va mal en llenarComboBox. VentanaModificar");
        }
    }
    private void llenarComboBoxEmpresas(){
        listaNombresEmpresas =new ArrayList<>();
        try{
            listaNombresEmpresas =Main.obtenerNombreEmpresas();
            for(int i=0;i<listaNombresEventos.size();i++){
                cbEmpresa.addItem(listaNombresEmpresas.get(i));
            }

        }catch (Exception e){System.out.println(e.getClass());}
    }
    private boolean validarDniAsistente(){
        boolean dniValido=false;
        try{
            if(!tfDni.getText().isEmpty()){
                Pattern patronNombre= Pattern.compile("^[0-9]{8}[A-Za-z]$");
                Matcher mat = patronNombre.matcher(tfDni.getText());
                if(mat.matches()){
                    dniValido =true;
                    System.out.println("El dni es valido");
                }
                else{
                    JOptionPane.showMessageDialog(null,"El formato de DNI no es valido");
                    tfDni.setText("");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"El campo DNI es obligatorio");

            }

        }catch (Exception e){System.out.println(e.getClass()+" Problemas al validar el idEmpresa");}
        return dniValido;
    }
}
