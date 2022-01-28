package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class V1 {

    private JPanel jpPrincipal;
    private JLabel lTitulo;
    private JLabel lApellido;
    private JTextField tapellido;
    private JLabel lNombre;
    private JTextField tDnia;
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel lCurso;
    private JTextField tCurso;
    private JLabel lDni;
    private JTextField tDni;

    private boolean elAlumnoExiste;

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }



    public V1() {
        //Lo primero que pone es el dni. Cuando se quita del DNI¿que hace?-> Valida DNI
        tDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                validarDni();// En esta funcion compruebo valido el formato y busco si el alumno existe.
                //Si el alumno no existe:

                //Si el alumno existe:
                if(elAlumnoExiste){
                    //Si exite paso a validar el resto de datos
                    validarNombre();
                    validarApellido();
                }

            }
        });

    }

    public void main(String[] args) {
        JFrame frame = new JFrame("V1");
        frame.setContentPane(new V1().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void validarApellido(){}
    public void validarDni() {
        try {
            if (tDnia.getText().isEmpty()) {
                throw new Exception();
            } else {
                elAlumnoExiste = Main.comprobarSiExisteAlumno(tDnia.getText());
                if(elAlumnoExiste){

                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
    public void validarNombre(){

    }

}
