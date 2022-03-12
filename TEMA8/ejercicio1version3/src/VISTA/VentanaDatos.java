package VISTA;

import MODELO.UML.Persona;
import com.company.Main;

import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaDatos {

    private JPanel jpPrincipal;
    private JPanel jpTitutlo;
    private JLabel lTitulo;
    private JPanel jpDatos;
    private JLabel lNombre;
    private JLabel lEdad;
    private JLabel lProfesion;
    private JLabel lTelefono;
    private JTextField tfNombre;
    private JTextField tfEdad;
    private JTextField tfProfesion;
    private JTextField tfTelefono;
    private JPanel jpBotones;
    private JButton bAnterior;
    private JButton bSiguiente;
    private JButton bSalir;
    private JButton bAceptar;
    private Persona persona;
    private int opcion;
    private ArrayList<Persona> listaPersonas;
    private int pos;

    /*Para pasarle el parametro al constructor*/

    public  VentanaDatos(int op) {
        try{

            if(op==1) {

                bAceptar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (validarDatos()) {
                            Main.getDatos(tfNombre.getText(), Integer.parseInt(tfEdad.getText()), tfProfesion.getText(), tfTelefono.getText());
                            if (Main.confirmarInsert()) {
                                JOptionPane.showMessageDialog(null, "Insert realizado");
                            }
                        }/*valido datos y se los tengo que pasar al Main*/
                    }
                });

            }
                if(op ==2){
                    bSalir.setEnabled(true);
                    tfNombre.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(validarNombre()){
                                Main.getNombre(tfNombre.getText());
                                persona = Main.setDatosPersona();
                                tfEdad.setText(String.valueOf(persona.getEdad()));
                                tfProfesion.setText(persona.getProfesion());
                                tfTelefono.setText(persona.getTelefono());
                            }
                        }
                    });
                    bAceptar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tfTelefono.setText("");
                            tfNombre.setText("");
                            tfProfesion.setText("");
                            tfEdad.setText("");
                        }
                    });
                    bSalir.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Main.salir();
                        }
                    });
                }
            if(op == 3){
                /*Se habilitan los botones*/
                bSalir.setEnabled(true);
                bAnterior.setEnabled(true);
                bSiguiente.setEnabled(true);
                /*En cuanto se abre la ventana tiene que estar cargada la informacion de la primera persona*/
                listaPersonas = new ArrayList<>();
                listaPersonas = Main.getDatosPersonas();
                System.out.println("Estoy en ventanaDatos. tengo el array y el toString es: " +listaPersonas.toString());
                cargarDatos();

                bSalir.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Main.salir();
                    }
                });
            }
            if(op==4){

            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }

    }
    public void cargarDatos(){

        try{
            pos = 0;
            tfNombre.setText(listaPersonas.get(pos).getNombre());
            tfEdad.setText(String.valueOf(listaPersonas.get(pos).getEdad()));
            tfProfesion.setText(listaPersonas.get(pos).getProfesion());
            tfTelefono.setText(listaPersonas.get(pos).getTelefono());

            bSiguiente.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        pos=pos+1;
                        if(pos > listaPersonas.size()-1){
                            JOptionPane.showMessageDialog(null, "No hay mas registros");
                        }
                        else{
                            tfNombre.setText(listaPersonas.get(pos).getNombre());
                            tfEdad.setText(String.valueOf(listaPersonas.get(pos).getEdad()));
                            tfProfesion.setText(listaPersonas.get(pos).getProfesion());
                            tfTelefono.setText(listaPersonas.get(pos).getTelefono());
                        }
                }
            });

            bAnterior.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(pos == 0){
                        JOptionPane.showMessageDialog(null, "Este es el primer registro");
                    }
                    else{
                        pos=pos-1;
                        tfNombre.setText(listaPersonas.get(pos).getNombre());
                        tfEdad.setText(String.valueOf(listaPersonas.get(pos).getEdad()));
                        tfProfesion.setText(listaPersonas.get(pos).getProfesion());
                        tfTelefono.setText(listaPersonas.get(pos).getTelefono());
                    }
                }
            });

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }

    public boolean validarDatos(){
        boolean datosValidos=false;
        try{
            /*validar NOMBRE. En una funcion a parte para poder llamarla*/
            if(validarNombre()){
                datosValidos=true;
            }
            else{
                System.out.println("El nombre no es correcto.");
                tfNombre.setText("");
                throw new Exception();
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
            System.out.println("datosValidos= "+ datosValidos);

        }catch (Exception s){
            datosValidos=false;
            System.out.println(s.getClass());
        }
        return datosValidos;

    }
    public boolean validarNombre(){
        boolean nombreValido = false;
        try{
            if(!tfNombre.getText().isEmpty()){
                Pattern patronNombre = Pattern.compile("^[A-Z][a-z]+$");
                Matcher mat = patronNombre.matcher(tfNombre.getText());
                if(mat.matches()){
                    nombreValido=true;
                }else {
                    nombreValido=false;
                }
            }else{
                nombreValido=false;
            }
            System.out.println("estoy validando el nombre. nombreValido = "+ nombreValido);
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return nombreValido;
    }


    public VentanaDatos() {



    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaDatos");
        frame.setContentPane(new VentanaDatos().jpPrincipal);
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

    public JPanel getJpTitutlo() {
        return jpTitutlo;
    }

    public void setJpTitutlo(JPanel jpTitutlo) {
        this.jpTitutlo = jpTitutlo;
    }

    public JLabel getlTitulo() {
        return lTitulo;
    }

    public void setlTitulo(JLabel lTitulo) {
        this.lTitulo = lTitulo;
    }

    public JPanel getJpDatos() {
        return jpDatos;
    }

    public void setJpDatos(JPanel jpDatos) {
        this.jpDatos = jpDatos;
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

    public JPanel getJpBotones() {
        return jpBotones;
    }

    public void setJpBotones(JPanel jpBotones) {
        this.jpBotones = jpBotones;
    }

    public JButton getbAnterior() {
        return bAnterior;
    }

    public void setbAnterior(JButton bAnterior) {
        this.bAnterior = bAnterior;
    }

    public JButton getbSiguiente() {
        return bSiguiente;
    }

    public void setbSiguiente(JButton bSiguiente) {
        this.bSiguiente = bSiguiente;
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


}
