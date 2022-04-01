package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    private JPanel jpElegirEvento;
    private JLabel lnombreEvento;
    private JComboBox cbEvento;
    private boolean dniValido;
    private boolean dniEncontrado=false;
    private  ArrayList<String>  listaNombres = new ArrayList<>();
    private int posicionEvento;
    private  boolean empresaExiste = false;
    private boolean datoValido =false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("VentanaAsistentes");
        frame.setContentPane(new VentanaAsistentes().jpPrincipal);
        frame.pack();
        frame.setVisible(true);

    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public VentanaAsistentes() {
        llenarComboBox();
        cbEvento.setSelectedIndex(-1);

        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                dniValido = validarDni();
                if(dniValido){
                    /*Buscar en la bbdd si existe el dni*/
                   dniEncontrado = Main.compruebaDni(tfDni.getText());
                    if(dniEncontrado){
                        cargarDatosPersona();
                        /*Al darle al ok si no se esta a falso, manda los datos al main para crear un objeto e insertarlo*/
                        /*Si encuentra el dni, carga los datos de la persona y abre una ventana o habilita la seleccion de evento*/
                    }
                    else{
                        System.out.println("La persona no existe, tengo que crearla");
                    }
                }


            }
        });
        tfNombreEmpresa.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                    datoValido = validarNombreEmpresa();

                if(!datoValido){
                    tfNombreEmpresa.requestFocus();
                }else{
                    empresaExiste = Main.comprobarEmpresa(tfNombreEmpresa.getText());
                    if(empresaExiste){
                        tfDireccion.setText(Main.tenDireccionEmpresa());
                        tfTelefono.setText(Main.tenTelefonoEmpresa());
                    }
                }

            }
        });


        bOk.addActionListener(new ActionListener() {
            @Override/*Si no se encuentra la empresa ni el dni*/
            public void actionPerformed(ActionEvent e) {
                /*Cuando hacen ok ya estan todos los datos validados. si el dni no ha sido encontrado...le da los
                * datos al main para hacer el insert*/
                if (validarDatos()) {
                    if(dniEncontrado){
                        /*crear objeto empresa y objeto persona*/
                        Main.creaNuevaEmpresa(tfNombreEmpresa.getText(),tfDireccion.getText(),tfTelefono.getText());

                        boolean insertOk = Main.creaNuevaPersona(tfDni.getText(),tfNombre.getText(),tfApellido.getText(),
                                dniEncontrado,posicionEvento);
                        if(insertOk){
                            JOptionPane.showMessageDialog(null, "Se ha añadido un asistente al evento " + cbEvento.getItemAt(posicionEvento).toString() );
                        }
                    }
                    else{ /*Si la persona no existe*/
                        /*Si la empresa no existe*/
                        boolean empresaCreadaEinsertada = false;
                        boolean personaCreada=false;
                        boolean empresaInsertada=false;
                        boolean asistenteInsertado=false;
                        if(!empresaExiste){
                            empresaCreadaEinsertada = Main.creaNuevaEmpresa(tfNombreEmpresa.getText(),tfDireccion.getText(),tfTelefono.getText());

                            if(empresaCreadaEinsertada){
                                JOptionPane.showMessageDialog(null, "Se ha añadido una nueva empresa");
                                empresaExiste = true;
                                personaCreada = Main.creaNuevaPersona(tfDni.getText(),tfNombre.getText(),tfApellido.getText(),dniEncontrado,posicionEvento);
                                if(personaCreada){
                                    asistenteInsertado = Main.insertAsistente(posicionEvento);
                                    if(asistenteInsertado){
                                        JOptionPane.showMessageDialog(null, "Se ha añadido un nuevo asistente");
                                    }
                                }
                            }
                        }
                        else{ /*SI LA EMPRESA EXISTE*/
                            personaCreada = Main.creaNuevaPersona(tfDni.getText(),tfNombre.getText(),tfApellido.getText(),dniEncontrado,posicionEvento);
                            if(personaCreada){
                                JOptionPane.showMessageDialog(null, "Se ha añadido una nueva persona");
                            }
                        }
                    }
                }
            }
        });
        cbEvento.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                posicionEvento = cbEvento.getSelectedIndex();
            }
        });
    }
    public void cargarDatosPersona(){
        tfNombre.setText(Main.getNombre());
        tfApellido.setText(Main.getApellido());
        tfNombreEmpresa.setText(Main.getNombreEmpresa());
        tfDireccion.setText(Main.getDireccionEmpresa());
        tfTelefono.setText(Main.getTelefonoEmpresa());
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
            else{
                JOptionPane.showMessageDialog(null,"El dni no es correcto");
                tfDni.requestFocus();

            }
        }catch (Exception e){System.out.println(e.getClass());}
        return dniValido;
    }/*Faltaria hacer la validacion buena del dni.*/
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
                datoValido = false;
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
    private void llenarComboBox() {
        System.out.println("Estoy en la funcion LLenarComboBOx de la ventanaModificar");
        listaNombres = new ArrayList<>();
        try {
            /*Llamo a una funcion del Main que me va a dar los datos para llenarlo. Lo tengo que llenar en el MAIN con funciones que llamo aqui*/
            System.out.println("llamo a la funcion llenaCombo DEL MAIN");
            listaNombres = Main.llenarComboInscripcion();
            for (int i = 0; i < listaNombres.size(); i++) {
                cbEvento.addItem(listaNombres.get(i));
                System.out.println("estoy llenando el combobox");
            }

        } catch (Exception e) {
            System.out.println(e.getClass() + " algo va mal en llenarComboBox. VentanaModificar");
        }

    }
    private boolean validarDatos() {
        boolean datosValidos = false;

        try {
            if (validarDni() &&validarNombre() &&  validarApellido() && validarNombreEmpresa() && validarDireccion() &&
                    validarTelefonoEmpresa()){
                datosValidos = true;

            }
            return datosValidos;

        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datosValidos;
    }

}
