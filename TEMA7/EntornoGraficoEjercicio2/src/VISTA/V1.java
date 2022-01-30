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
    private JButton bAceptar;
    private JButton bSalir;
    private JLabel lCurso;
    private JTextField tCurso;
    private JLabel lDni;
    private JTextField tDni;
    private JTextField tnombre;

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
            }
        });

        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Cuando se pulsa aceptar*/
                validarApellido();
                validarDni();
                if(!elAlumnoExiste){/*Si el alumno no existe se añade al arrayList*/
                    Main.crearAñadirAlumno(tDni.getText(),tnombre.getText(),tapellido.getText(),tCurso.getText());
                }
                if(elAlumnoExiste){
                    /*Si el alumno existe, tengo que mostrar una ventana con dos opciones*/
                    Main.mostrarVentana2();
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

    public void validarApellido(){
        try{
            if(tapellido.getText().isEmpty()){
                throw new Exception ();
            }
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public void validarDni() {
        try {
            if (tDni.getText().isEmpty()) {
                throw new Exception();
            } else {
                elAlumnoExiste = Main.comprobarSiExisteAlumno(tDni.getText());
                if(!elAlumnoExiste){
                    /*Si no existe */
                    tDni.setEditable(false);/*Con esto no dejo que cambie el dni. Se continua metiendo datos*/
                }
            }
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
    public void validarNombre(){
        try{
            if(tnombre.getText().isEmpty()){
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }

}
