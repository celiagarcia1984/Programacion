package VISTA;

import MODELO.BASEDEDATOS.EventoDAO;
import MODELO.UML.Evento;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private ArrayList<String> listaNombres;
    private int posicionEventoSeleccionado;
    private LocalDate fecha = null;
    private LocalTime horaFin = null;
    private LocalTime horaInicio = null;
    private boolean updateHecho;

    public VentanaModificar() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        /*Llenar ComboBox. No puedo traerme un objeto Evento.*/
        Main.obtenerDatosEventos();
        llenarComboBox();
        cbEventos.setSelectedIndex(-1);
        System.out.println("Probado hasta aqui llena el combo");


        /* *************************AQUI EMPIEZAN LOS LISTENERS*****************************************/
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarDatos()) {
                    int confirmacion = JOptionPane.showConfirmDialog(null, "Vas a modificar el evento, ¿quieres continuar?");
                    if (confirmacion == 0) {
                      updateHecho =  Main.tenNuevoEvento(cbEventos.getItemAt(posicionEventoSeleccionado).toString(),tfLugar.getText() , fecha, horaInicio,
                                horaFin, Integer.parseInt(tfAforo.getText()), Integer.parseInt(tfAforoDisp.getText()));
                    }
                }
                if(updateHecho){
                    JOptionPane.showMessageDialog(null,"Se ha actualizado el evento "+ cbEventos.getItemAt(posicionEventoSeleccionado));
                }

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
        /*Es el listener del combo.*/
        cbEventos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    posicionEventoSeleccionado = cbEventos.getSelectedIndex();
                    System.out.println(posicionEventoSeleccionado + " posicion del evento seleccionado");
                    cargarDatosDelEvento();

                } catch (Exception a) {
                    System.out.println(a.getClass() + "Error en el listener del combo");
                }
            }
        });
    }

    /* ********************************AQUI EMPIEZAN LAS FUNCIONES ************************************************/
    private void llenarComboBox() {
        System.out.println("Estoy en la funcion LLenarComboBOx de la ventanaModificar");
        listaNombres = new ArrayList<>();
        try {
            /*Llamo a una funcion del Main que me va a dar los datos para llenarlo. Lo tengo que llenar en el MAIN con funciones que llamo aqui*/
            System.out.println("llamo a la funcion llenaCombo DEL MAIN");
            listaNombres = Main.llenarComboInscripcion();
            for (int i = 0; i < listaNombres.size(); i++) {
                cbEventos.addItem(listaNombres.get(i));
                System.out.println("estoy llenando el combobox");
            }

        } catch (Exception e) {
            System.out.println(e.getClass() + " algo va mal en llenarComboBox. VentanaModificar");
        }
    }

    private void cargarDatosDelEvento() {
        try {
            System.out.println("funcion cargardatosdelevento. la llamo desde el actionperformed del combo");
            Main.eventoElegidoEnElCombo(posicionEventoSeleccionado);
            tfLugar.setText(Main.getLugar());
            tfFecha.setText(Main.getFecha());
            tfHoraIn.setText(Main.getHoraInicio());
            tfHoraFin.setText(Main.getHoraFin());
            tfAforo.setText(Main.getAforo());
            tfAforoDisp.setText(Main.getAforoDisponible());
        } catch (Exception a) {
            System.out.println(a.getClass() + "PROBLEMAS AL CARGAR LOS DATOS DEL EVENTO SELECCIONADO");
        }

    }

    private void tenNuevoEvento(String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                                int aforo, int aforoDisponible) {
    }/*Para pasar al Main los datos modificados del evento*/

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

    private boolean validarDatos() {
        boolean datosValidos = false;

        try {
            if (validarFecha() && validarHoraInicio() && validarHoraFin() && validarAforo() &&
                    validarAforoDisponible()) {
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
            if (!tfAforoDisp.getText().isEmpty()) {
                Pattern patronAforoDisponible = Pattern.compile("^[0-9]+$");
                Matcher mat = patronAforoDisponible.matcher(tfAforoDisp.getText());
                if (mat.matches()) {
                    aforoDispValido = true;
                }
                if (Integer.parseInt(tfAforo.getText()) >= (Integer.parseInt(tfAforoDisp.getText()))) {
                    aforoDispValido = true;
                } else {
                    aforoDispValido = false;
                    JOptionPane.showMessageDialog(null, "El aforo disponible no puede ser mayor que el aforo");

                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return aforoDispValido;
    }

    public boolean validarAforo() {
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

    public boolean validarHoraFin() {
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

    public boolean validarHoraInicio() {
        boolean horaInValida = false;
        try {
            if (!tfHoraIn.getText().isEmpty()) {
                Pattern patronHora = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
                Matcher mat = patronHora.matcher(tfHoraIn.getText());
                if (mat.matches()) {

                    horaInicio = LocalTime.parse(tfHoraIn.getText());
                    System.out.println("He hecho la conversion de la hora y la variable horaInicio es " + horaInicio);
                    horaInValida = true;
                } else {
                    horaInValida = false;
                    tfHoraIn.setText("");
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

    public boolean validarFecha() {
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
        } catch (DateTimeParseException e) {
            tfFecha.setText("");
            JOptionPane.showMessageDialog(null, "El formato de fecha no es valido");
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return fechaValida;
    }


}
