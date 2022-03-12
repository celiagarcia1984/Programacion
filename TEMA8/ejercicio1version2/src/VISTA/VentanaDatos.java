package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaDatos {

    private JPanel jpPrincipal;
    private JPanel jpDatos;
    private JTextField tfNombre;
    private JTextField tfEdad;
    private JTextField tfProfesion;
    private JTextField tfTelefono;
    private JButton bRetroceso;
    private JButton bAvanzar;
    private JButton bSalir;
    private JButton bAceptar;
    private JLabel lNombre;
    private JLabel lEdad;
    private JLabel lProfesion;
    private JLabel lTelefono;
    private JPanel jpBotones;
    public  int opcion;

    public VentanaDatos(int opcion) {
        if(opcion == 3){
            bSalir.setEnabled(true);
            bAvanzar.setEnabled(true);
            bRetroceso.setEnabled(true);
        }
        /*Cuando pulso el boton ACEPTAR valido los datos que han puesto*/
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(validarDatos() ) {
                   Main.getDatos(tfNombre.getText(),Integer.parseInt(tfEdad.getText()),tfProfesion.getText(),tfTelefono.getText() );
               }
            }
        });
    }

    public void main(String[] args) {
        JFrame frame = new JFrame("VentanaDatos");
        frame.setContentPane(new VentanaDatos(opcion).jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public void setJpPrincipal(JPanel jpPrincipal) {
        this.jpPrincipal = jpPrincipal;
    }

    public JPanel getJpDatos() {
        return jpDatos;
    }

    public void setJpDatos(JPanel jpDatos) {
        this.jpDatos = jpDatos;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    public JTextField getTfEdad() {
        return tfEdad;
    }

    public void setTfEdad(JTextField tfEdad) {
        this.tfEdad = tfEdad;
    }

    public JTextField getTfProfesion() {
        return tfProfesion;
    }

    public void setTfProfesion(JTextField tfProfesion) {
        this.tfProfesion = tfProfesion;
    }

    public JTextField getTfTelefono() {
        return tfTelefono;
    }

    public void setTfTelefono(JTextField tfTelefono) {
        this.tfTelefono = tfTelefono;
    }

    public JButton getbRetroceso() {
        return bRetroceso;
    }

    public void setbRetroceso(JButton bRetroceso) {
        this.bRetroceso = bRetroceso;
    }

    public JButton getbAvanzar() {
        return bAvanzar;
    }

    public void setbAvanzar(JButton bAvanzar) {
        this.bAvanzar = bAvanzar;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }

    public JButton getbAceptar() {
        return bAceptar;
    }

    public void setbAceptar(JButton bAceptar) {
        this.bAceptar = bAceptar;
    }

    public JLabel getlNombre() {
        return lNombre;
    }

    public void setlNombre(JLabel lNombre) {
        this.lNombre = lNombre;
    }

    public JLabel getlEdad() {
        return lEdad;
    }

    public void setlEdad(JLabel lEdad) {
        this.lEdad = lEdad;
    }

    public JLabel getlProfesion() {
        return lProfesion;
    }

    public void setlProfesion(JLabel lProfesion) {
        this.lProfesion = lProfesion;
    }

    public JLabel getlTelefono() {
        return lTelefono;
    }

    public void setlTelefono(JLabel lTelefono) {
        this.lTelefono = lTelefono;
    }

    public boolean validarDatos(){
        boolean datosValidos = false;
        try{
            /*validar NOMBRE. En una funcion a parte para poder llamarla*/
            if(validarNombre()){
                datosValidos=true;
            }
            /*VALIDAR EDAD*/
            if(!tfEdad.getText().isEmpty()){
                Pattern patronEdad = Pattern.compile("^[0-9]{1,2}$");
                Matcher mat1 = patronEdad.matcher(tfEdad.getText());
                if(mat1.matches()){
                    datosValidos=true;
                    System.out.println("La edad se ha validado");
                }
                else{
                    System.out.println("la edad no es correcta");
                    tfEdad.setText("");
                    throw new Exception();
                }
            }
            else{
                System.out.println("la edad no es correcta");
                tfEdad.setText("");
                throw new Exception();
            }
            /*VALIDAR PROFESION*/
            if(!tfProfesion.getText().isEmpty()){
                Pattern patronProfesion = Pattern.compile("^[A-Z][a-z]+$");
                Matcher mat1 = patronProfesion.matcher(tfProfesion.getText());
                if(mat1.matches()){
                    datosValidos=true;
                    System.out.println("La profesion se ha validado se ha validado");
                }
                else{
                    System.out.println("la profesion no es correcta");
                    tfProfesion.setText("");
                    throw new Exception();
                }
            }
            else{
                System.out.println("la profesion no es correcta");
                tfProfesion.setText("");
                throw new Exception();
            }
            /*VALIDAR TELEFONO*/
            if(!tfTelefono.getText().isEmpty()){
                Pattern patronTelefono = Pattern.compile("^[6789][0-9]{8}$");
                Matcher mat1 = patronTelefono.matcher(tfTelefono.getText());
                if(mat1.matches()){
                    datosValidos=true;
                    System.out.println("El telefono se ha validado se ha validado");
                }
                else{
                    System.out.println("el telefono no es correcta");
                    tfTelefono.setText("");
                    throw new Exception();
                }
            }
            else{
                System.out.println("el telefono no es correcta");
                tfTelefono.setText("");
                throw new Exception();
            }

        }catch (Exception s){
            datosValidos=false;
            System.out.println(s.getClass());
        }
        return datosValidos;
    }
    public boolean validarNombre(){
        boolean nombreValido=false;
        try{
            if(!tfNombre.getText().isEmpty()){
                Pattern patronNombre = Pattern.compile("^[A-Z][a-z]+$");
                Matcher mat1 = patronNombre.matcher(tfNombre.getText());
                if(mat1.matches()){
                    nombreValido=true;
                    System.out.println("El nombre se ha validado");
                }
                else {
                    tfNombre.setText(" ");
                    throw new  Exception();
                }
            }
            else {
                tfNombre.setText(" ");
                throw new  Exception();
            }
        }catch (Exception s){
            nombreValido=false;
            System.out.println("El nombre no tiene el formato correcto");
            System.out.println(s.getClass());
        }
        return nombreValido;
    }
}
