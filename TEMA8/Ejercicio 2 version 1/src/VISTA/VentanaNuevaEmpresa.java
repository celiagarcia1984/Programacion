package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaNuevaEmpresa extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpContenido;
    private JPanel jpInferior;
    private JPanel jpBotones;
    private JPanel jpTitutlo;
    private JLabel lTitulo;
    private JLabel lIdEmpresa;
    private JTextField tfIdEmpresa;
    private JLabel lNombre;
    private JTextField tfnombre;
    private JLabel lDireccion;
    private JTextField tfDireccion;
    private JLabel lTelefono;
    private JTextField tfTelefono;

    public VentanaNuevaEmpresa() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(validarIdEmpresa()&&validarNombreEmpresa()&&validarTelefono()&&validarDireccion()){
                    Main.insertEmpresa(tfIdEmpresa.getText(),tfnombre.getText(),tfDireccion.getText(),tfTelefono.getText());
                }
                dispose();
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

        //dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VentanaNuevaEmpresa dialog = new VentanaNuevaEmpresa();
        dialog.pack();
        dialog.setVisible(true);

    }
    public boolean validarIdEmpresa(){
        boolean idValido=false;
        try{
            if(!tfIdEmpresa.getText().isEmpty()){
                if(tfIdEmpresa.getText().length()==4){
                    /*Comprobar si el id existe en la tabla empresa*/
                  idValido = Main.comprobarIdEmpresa(tfIdEmpresa.getText());
                  if(!idValido){
                      llenarDatosVentana();
                      JOptionPane.showConfirmDialog(null,"La empresa ya existe. Desea modificarla?");
                      /*Aqui tengo que programar el update de la empresa. Al hacer click en si, se cierran las dos ventanas. ARREGLARLO*/
                  }
                }
            }
        }catch (Exception e){System.out.println();}
        return idValido;
    }
    public void llenarDatosVentana(){
        try{
            System.out.println("Estoy llenando los input de la ventana");
            tfnombre.setText(Main.getNombreEmpresa());
            tfDireccion.setText(Main.getDireccionEmpresa());
            tfTelefono.setText(Main.getTelefonoEmpresa());
            tfnombre.setEditable(false);
            tfTelefono.setEditable(false);
            tfDireccion.setEditable(false);
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public boolean validarNombreEmpresa(){
        boolean nombreValido=false;
        try{
            if(!tfnombre.getText().isEmpty()){
                nombreValido=true;
            }
        }catch (Exception e){System.out.println(e.getClass());}

        return nombreValido;
    }
    public boolean validarDireccion(){
        boolean direccionValida=false;
        try{
            if(!tfnombre.getText().isEmpty()){
                direccionValida=true;
            }
        }catch (Exception e){System.out.println(e.getClass());}

        return direccionValida;
    }
    public boolean validarTelefono(){
        boolean telefonoValido=false;
        try{
            if(!tfTelefono.getText().isEmpty()){
                telefonoValido=true;
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return telefonoValido;
    }


}
