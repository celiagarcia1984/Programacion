package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaNuevoEvento extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpBotones;
    private JPanel jpContenido;
    private JLabel lNombre;
    private JTextField tfNombre;
    private JLabel lLugar;
    private JComboBox cbLugar;
    private JTextField tfFecha;
    private JLabel lFecha;
    private JLabel lHoraIncio;
    private JTextField tfHoraInicio;
    private JTextField tfHoraFin;
    private JLabel lHoraFin;
    private JLabel lAforo;
    private JTextField tfAforo;
    private JLabel lAforoDisponible;
    private JTextField tfAforoDisponible;
    private JPanel jpTitutlo;
    private JLabel lTitulo;
    private LocalDate fecha;
    private LocalTime horaFin = null;
    private LocalTime horaInicio =null;

    public VentanaNuevoEvento() {
        /*Llenar ComboBox*/
        llenarComboBox();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(validarDatos()){
                    Main.getDatos(tfNombre.getText(),String.valueOf(cbLugar.getSelectedItem()) ,fecha,horaInicio,
                            horaFin,Integer.parseInt(tfAforo.getText()),Integer.parseInt(tfAforoDisponible.getText()));
                }

               // onOK();

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
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void main(String[] args) {

        VentanaNuevoEvento dialog = new VentanaNuevoEvento();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    private void llenarComboBox(){
        try{
            cbLugar.addItem("Artium");
            cbLugar.addItem("Europa");
            cbLugar.addItem("Canciller");
            cbLugar.addItem("Giralda");
            cbLugar.addItem("Florida");
            cbLugar.addItem("Plaza");
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    private boolean validarDatos(){
        boolean datosValidos= false;

        try{
            if(validarNombre()){
                datosValidos = true;
                /*El lugar no se valida porque es un comboBox*/
                    /*FechaInicio*/
                    if(!tfFecha.getText().isEmpty()){
                        DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fecha = LocalDate.parse(tfFecha.getText(),patron);
                        System.out.println("He hecho la conversion a local date. "+fecha );
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "La fecha es un campo obligatorio");
                    }
                    /*Hora de inicio*/
                    if(!tfHoraInicio.getText().isEmpty()){
                        Pattern patronHora= Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
                        Matcher mat =patronHora.matcher(tfHoraInicio.getText());
                        if(mat.matches()){

                            horaInicio = LocalTime.parse(tfHoraInicio.getText());
                            System.out.println("He hecho la conversion de la hora y la variable horaInicio es "+ horaInicio);
                        }
                        else{
                            tfHoraInicio.setText("");
                            JOptionPane.showMessageDialog(null, "El formato de hora no es correcto");
                        }
                }else {
                    JOptionPane.showMessageDialog(null, "La hora es un campo obligatorio");
                    throw new Exception();
                }
                    /*Hora de fin*/
                if(!tfHoraFin.getText().isEmpty()){
                    Pattern patronHora= Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
                    Matcher mat =patronHora.matcher(tfHoraFin.getText());
                    if(mat.matches()){
                        horaFin = LocalTime.parse(tfHoraFin.getText());
                        System.out.println("He hecho la conversion de la hora y la variable horaInicio es "+ horaFin);
                    }
                    else{
                        tfHoraFin.setText("");
                        JOptionPane.showMessageDialog(null, "El formato de hora no es correcto");
                    }
                    if(horaFin.isAfter(horaInicio)){
                        datosValidos=true;
                    }
                    else{
                        tfHoraFin.setText("");
                        JOptionPane.showMessageDialog(null, "La hora de fin no es correcta");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "La hora es un campo obligatorio");
                    throw new Exception();
                }
                /*VALIDAR AFORO*/
                if(!tfAforo.getText().isEmpty()){
                    Pattern patronAforo = Pattern.compile("^[0-9]+$");
                    Matcher mat = patronAforo.matcher(tfAforo.getText());
                    if(mat.matches()){
                        datosValidos=true;
                    }
                    else{
                        System.out.println("El formato no es correcto");
                        throw new Exception();
                    }
                }else{
                    System.out.println("El campo no puede estar vacio");
                    throw new Exception();
                }

                if(!tfAforoDisponible.getText().isEmpty()){
                    Pattern patronAforoDisponible = Pattern.compile("^[0-9]+$");
                    Matcher mat = patronAforoDisponible.matcher(tfAforoDisponible.getText());
                    if(mat.matches()){
                        datosValidos=true;
                    }
                    else{
                        throw new Exception();
                    }
                    if(Integer.parseInt(tfAforo.getText())>=(Integer.parseInt(tfAforoDisponible.getText()))){
                        datosValidos=true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El aforo disponible no puede ser mayor que el aforo");
                        throw new Exception();
                    }
                }
            }
            else{
                throw new Exception();
            }

        }catch (Exception e){
            datosValidos=false;
            System.out.println(e.getClass());
        }
        return datosValidos;
    }
    public boolean validarNombre(){
        boolean nombreValido=false;
        try{
            if(!tfNombre.getText().isEmpty()){
                Pattern patronNombre= Pattern.compile("^[A-Z][a-z]+$");
                Matcher mat = patronNombre.matcher(tfNombre.getText());
                if(mat.matches()){
                    nombreValido =true;
                    System.out.println("El nombre es correcto");
                }
                else{
                    JOptionPane.showMessageDialog(null, "El formato del nombre no es correcto");
                    throw new Exception();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Campo obligatorio",null, JOptionPane.ERROR_MESSAGE);
                throw new Exception();
            }
        }catch (Exception e){
            tfNombre.setText("");
            nombreValido = false;
            System.out.println(e.getClass());
        }
        return nombreValido;
    }
}
