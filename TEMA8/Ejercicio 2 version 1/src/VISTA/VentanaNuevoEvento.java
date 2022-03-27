package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    private LocalDate fecha = null;
    private LocalTime horaFin = null;
    private LocalTime horaInicio = null;


    public VentanaNuevoEvento() {
        /*Llenar ComboBox*/
        System.out.println("llamo a la funcion llenarCombobox de esta misma clase");
        llenarComboBox();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        /*Esta parte es para añadir evento*/
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("E pulsado el boton Ok. Si los datos son validos Llamo a la funcion del Main.getDatos. Me voy al Main");
                if (validarDatos()) {
                    Main.getDatos(tfNombre.getText(), String.valueOf(cbLugar.getSelectedItem()), fecha, horaInicio,
                            horaFin, Integer.parseInt(tfAforo.getText()), Integer.parseInt(tfAforoDisponible.getText()));
                    System.out.println("La funcion Main.getDatos me ha devuelto la confirmacion del insert");
                    if (Main.getConfirmacion()) {
                        JOptionPane.showMessageDialog(null, "Evento añadido");
                        dispose();
                    }
                }
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
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,
                0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


    }
     public void main(String[] args) {

        VentanaNuevoEvento dialog = new VentanaNuevoEvento();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    } /*Copia pega en el Main*/
     private void llenarComboBox() {
        try {
            System.out.println("f(x)llenarComboBox de eventos.");
            cbLugar.addItem("Artium");
            cbLugar.addItem("Europa");
            cbLugar.addItem("Canciller");
            cbLugar.addItem("Giralda");
            cbLugar.addItem("Florida");
            cbLugar.addItem("Plaza");
            System.out.println("Aqui termino de llenar el combo");
        } catch (Exception e) {
            System.out.println("Hay un problema al llenar el combo"+e.getClass());

        }
    } /*Lo primero que se hace al abrir la ventana*/

     private void onOK() {
        // add your code here
        dispose();
    }
     private void onCancel() {
        // add your code here if necessary
        dispose();
    }

     /* ***********************FUNCIONES PARA VALIDAR DATOS DEL EVENTO**********************************************/
     private boolean validarDatos() {
        boolean datosValidos = false;

        try {
            if (validarNombre() && validarFecha() && validarHoraInicio() && validarHoraFin() && validarAforo() &&
                    validarAforoDisponible()){
                datosValidos = true;

            }
            return datosValidos;

        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return datosValidos;
    }
     public boolean validarAforoDisponible() {
        boolean aforoDispValido = false;
        try {
            if (!tfAforoDisponible.getText().isEmpty()) {
                Pattern patronAforoDisponible = Pattern.compile("^[0-9]+$");
                Matcher mat = patronAforoDisponible.matcher(tfAforoDisponible.getText());
                if (mat.matches()) {
                    aforoDispValido = true;
                }
                if (Integer.parseInt(tfAforo.getText()) >= (Integer.parseInt(tfAforoDisponible.getText()))) {
                    aforoDispValido = true;
                } else {
                    aforoDispValido = false;
                    JOptionPane.showMessageDialog(null, "El aforo disponible no puede ser mayor que el aforo");

                }
            }
            }catch(Exception e){
                System.out.println(e.getClass());
            }
            return aforoDispValido;
        }
     public boolean validarAforo () {
            boolean aforoValido = false;
            try {
                if (!tfAforo.getText().isEmpty()) {
                    Pattern patronAforo = Pattern.compile("^[0-9]+$");
                    Matcher mat = patronAforo.matcher(tfAforo.getText());
                    if (mat.matches()) {
                        aforoValido = true;
                    } else {
                        aforoValido = false;
                        System.out.println("El formato no es correcto");
                        throw new Exception();
                    }
                } else {
                    aforoValido = false;
                    System.out.println("El campo no puede estar vacio");
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
            return aforoValido;
        }
     public boolean validarHoraFin () {
            boolean horaFinValida = false;
            try {
                if (!tfHoraFin.getText().isEmpty()) {
                    Pattern patronHora = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
                    Matcher mat = patronHora.matcher(tfHoraFin.getText());
                    if (mat.matches()) {
                        horaFinValida = true;
                        horaFin = LocalTime.parse(tfHoraFin.getText());
                        System.out.println("He hecho la conversion de la hora y la variable horaInicio es " + horaFin);
                    } else {
                        horaFinValida = false;
                        tfHoraFin.setText("");
                        JOptionPane.showMessageDialog(null, "El formato de hora no es correcto");
                    }
                    if (horaFin.isAfter(horaInicio)) {
                        horaFinValida = true;
                    } else {
                        horaFinValida = false;
                        tfHoraFin.setText("");
                        JOptionPane.showMessageDialog(null, "La hora de fin no es correcta");
                    }

                } else {
                    horaFinValida = false;
                    JOptionPane.showMessageDialog(null, "La hora es un campo obligatorio");
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
            return horaFinValida;
        }
     public boolean validarHoraInicio () {
            boolean horaInValida = false;
            try {
                if (!tfHoraInicio.getText().isEmpty()) {
                    Pattern patronHora = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
                    Matcher mat = patronHora.matcher(tfHoraInicio.getText());
                    if (mat.matches()) {

                        horaInicio = LocalTime.parse(tfHoraInicio.getText());
                        System.out.println("He hecho la conversion de la hora y la variable horaInicio es " + horaInicio);
                        horaInValida = true;
                    } else {
                        horaInValida = false;
                        tfHoraInicio.setText("");
                        JOptionPane.showMessageDialog(null, "El formato de hora no es correcto");
                    }
                } else {
                    horaInValida = false;
                    JOptionPane.showMessageDialog(null, "La hora es un campo obligatorio");
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
            return horaInValida;
        }
     public boolean validarFecha () {
            boolean fechaValida = false;
            try {
                if (!tfFecha.getText().isEmpty()) {
                    DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    fecha = LocalDate.parse(tfFecha.getText(), patron);
                    System.out.println("He hecho la conversion a local date. " + fecha);
                    fechaValida = true;
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha es un campo obligatorio");
                }
            }catch (DateTimeParseException e){
                tfFecha.setText("");
                JOptionPane.showMessageDialog(null,"El formato de fecha no es valido");
            }
            catch (Exception e) {
                System.out.println(e.getClass());
            }
            return fechaValida;
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
