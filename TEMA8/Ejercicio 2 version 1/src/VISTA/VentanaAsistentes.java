package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaAsistentes {
    private JPanel jpPrincipal;
    private JPanel jpDatosPersona;
    private JLabel lDni;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JLabel lApellido;
    private JTextField tfApellido;
    private JPanel jpDatosEmpresa;
    private JLabel lNombre;
    private JTextField tfNombreEmpresa;
    private JTextField tfDireccion;
    private JLabel lTelefono;
    private JTextField tfTelefono;
    private JPanel jpBotones;
    private JButton bOk;
    private JButton bCancelar;
    private boolean dniValido;
    private boolean dniEncontrado=false;
    private boolean empresaEncontrada=false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaAsistentes");
        frame.setContentPane(new VentanaAsistentes().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public VentanaAsistentes() {

        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);


                dniValido = validarDni();
                if(dniValido){
                    /*Buscar en la bbdd si existe el dni*/
                   dniEncontrado = Main.compruebaDni(tfDni.getText());

                    if(dniEncontrado){
                        /*Al darle al ok si no se esta a falso, manda los datos al main para crear un objeto e insertarlo*/
                    }
                }

            }
        });

        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarNombre();
            }
        });

        tfApellido.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarApellido();
            }
        });
        tfNombreEmpresa.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                if(validarNombreEmpresa()){
                    empresaEncontrada= Main.compruebaEmpresa(tfNombreEmpresa.getText());
                }
                if(empresaEncontrada){
                    tfDireccion.setText(Main.dameDireccion());
                    tfTelefono.setText(Main.dameTelefono());
                }
            }
        });

        tfDireccion.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarDireccion();
            }
        });

        tfTelefono.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarTelefonoEmpresa();
            }
        });

        bOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Cuando hacen ok ya estan todos los datos validados. si el dni no ha sido encontrado...le da los
                * datos al main para hacer el insert*/
                if(!empresaEncontrada){
                    Main.creaNuevaEmpresa(tfNombreEmpresa.getText(),tfDireccion.getText(),tfTelefono.getText());
                }
                if(!dniEncontrado){
                    Main.creaNuevaPersona(tfDni.getText(),tfNombre.getText(),tfApellido.getText());
                }

            }
        });
    }
    public boolean validarDni(){
        boolean dniValido=false;
        try{
            if(!tfDni.getText().isEmpty()){
                Pattern patron = Pattern.compile("[1-9]{1}[0-9]{7}[a-zA-Z]{1}$");
                Matcher mat= patron.matcher(tfDni.getText());
                if(mat.matches()){
                    System.out.println("he validado el dni. es correcto");
                    dniValido=true;
                }
                else {
                    JOptionPane.showMessageDialog(null,"El dni no es correcto");
                    tfDni.requestFocus();
                }
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return dniValido;
    }
    public boolean validarNombre(){
        boolean nombreValido=false;
        try{
            if(!tfNombre.getText().isEmpty()){
                nombreValido=true;
            }
            else{
                JOptionPane.showMessageDialog(null,"El nombre es un campo obligatorio");
                tfNombre.requestFocus();
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return nombreValido;
    }
    public boolean validarApellido(){
        boolean apellidoValido=false;
        try{
            if(!tfApellido.getText().isEmpty()){
                apellidoValido=true;
            }
            else{
                JOptionPane.showMessageDialog(null,"El apellido es un campo obligatorio");
                tfApellido.requestFocus();
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return apellidoValido;
    }
    public boolean validarNombreEmpresa(){
        boolean nombreValido=false;
        try{
            if(!tfNombreEmpresa.getText().isEmpty()){
                nombreValido=true;
            }
            else{
                JOptionPane.showMessageDialog(null,"El nombre de la empresa es un campo obligatorio");
                tfNombreEmpresa.requestFocus();
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return nombreValido;
    }
    public boolean validarDireccion(){
        boolean nombreValido=false;
        try{
            if(!tfDireccion.getText().isEmpty()){
                nombreValido=true;
            }
            else{
                JOptionPane.showMessageDialog(null,"La direccion de la empresa es un campo obligatorio");
                tfDireccion.requestFocus();
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return nombreValido;
    }
    public boolean validarTelefonoEmpresa(){
        boolean nombreValido=false;
        try{
            if(!tfTelefono.getText().isEmpty()){
                nombreValido=true;
            }
            else{
                JOptionPane.showMessageDialog(null,"El telefono de la empresa es un campo obligatorio");
                tfTelefono.requestFocus();
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return nombreValido;
    }
}
