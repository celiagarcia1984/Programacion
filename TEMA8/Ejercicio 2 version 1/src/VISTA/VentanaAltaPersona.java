package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaAltaPersona extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpInferior;
    private JPanel jpBotonesInferiores;
    private JPanel jpContenido;
    private JPanel jpTitulo;
    private JLabel lAñadirPersona;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JComboBox cbEmpresa;
    private JLabel lEmpresa;
    private JRadioButton rbOtra;
    private JComboBox cbEvento;
    private JPanel jpEvento;
    private ArrayList<String>listaNombresEventos;
    private ArrayList<String>listaNombresEmpresas;
    private int posicionEvento;
    private String eventoSeleccionado;

    public VentanaAltaPersona() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        /*Cargar combo Eventos*/
        /*Para llenar el combo tengo que hacer un select para traer los nombres de los eventos*/
        Main.obtenerDatosEventos();
        Main.obtenerDatosEmpresas();
        llenarComboBoxEmpresas();
        llenarComboEventos();
        cbEmpresa.setSelectedIndex(-1);
        if(rbOtra.isSelected()){
            Main.abrirVentanaNuevaEmpresa();
        }

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

        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(validarDniPersona()){/*Si el dni tiene el formato correcto*/


                }
            }
        });
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        rbOtra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbOtra.isSelected()){
                    Main.abrirVentanaNuevaEmpresa();
                }
            }
        });

    }

    private void onOK() {
        if(buscarDni()){ /*Si la persona esta dada de alta, se carga su nombre y apellido y habilita el combo
                   de eventos.*/
            tfNombre.setText(Main.getNombre());
            tfNombre.setEditable(false);
            tfApellido.setText(Main.getApellido());
            tfApellido.setEditable(false);
            jpEvento.setVisible(true);
            /*Cojo la posicion del evento para buscarlo en el array de eventos*/
            posicionEvento = cbEvento.getSelectedIndex();
            eventoSeleccionado = listaNombresEventos.get(posicionEvento);
            Main.insertAsistente(tfDni.getText(),eventoSeleccionado);
        }

       // dispose();
    }
/*Si el dni es valido, carga datos de la persona y hace visible comboEvento. Con El dni y el evento, lo paso al main para
* hacer un insert en asistente*/
    private boolean buscarDni(){
        boolean dniExiste=false;
        try{
           dniExiste = Main.buscarDni(tfDni.getText());/*Esta funcion mira si ese dni esta dado de alta*/
        }catch (Exception e){System.out.println(e.getClass());}
        return dniExiste;
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public static void main(String[] args) {
        VentanaAltaPersona dialog = new VentanaAltaPersona();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    private void llenarComboBoxEmpresas(){
        listaNombresEmpresas = new ArrayList<>();
        System.out.println("imprimo listaNombreEmpresas");
        try{
            listaNombresEmpresas = Main.obtenerNombreEmpresas();
            for(int i=0;i<listaNombresEmpresas.size();i++){
                cbEmpresa.addItem(listaNombresEmpresas.get(i));
            }

        }catch (Exception e){System.out.println(e.getClass());}
    }
    private void llenarComboEventos(){
        listaNombresEventos = Main.llenaCombo();
        try{
            for(int i=0;i<listaNombresEventos.size();i++){
                cbEvento.addItem(listaNombresEventos.get(i));
                cbEvento.setSelectedIndex(-1);
            }

        }catch (Exception e){System.out.println(e.getClass());}
    }
    private boolean validarDniPersona(){
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
    private boolean validarNombre(){
        boolean nombreValido=false;
        try{
            if(!tfNombre.getText().isEmpty()){
                nombreValido=true;
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return nombreValido;
    }
}
