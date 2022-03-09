package VISTA;

import EXCEPCIONES.DatoNoValido;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Main.mostrarVentanaPersonas;

public class VentanaOpciones {
    private JPanel jpPrincipal;
    private JPanel jpTitulo;
    private JLabel lTitulo;
    private JPanel jpOpciones;
    private JLabel lOpcion1;
    private JLabel lOpcion2;
    private JLabel lOpcion3;
    private JLabel lOpcion4;
    private JLabel lOpcionElegida;
    private JTextField tfOpcion;
    private JButton bAceptar;
    private int opcion;

    public VentanaOpciones() {
        try{
            bAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        if(validarOpcion()){
                            try {
                                Main.mostrarVentanaPersonas(opcion);
                            } catch (Exception y) {
                                System.out.println(y.getClass());
                            }
                        }
                        else{

                        }
                }
            });
        }catch (Exception e){
            System.out.println(e.getClass());
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaOpciones");
        frame.setContentPane(new VentanaOpciones().jpPrincipal);
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

    public JPanel getJpTitulo() {
        return jpTitulo;
    }

    public void setJpTitulo(JPanel jpTitulo) {
        this.jpTitulo = jpTitulo;
    }

    public JLabel getlTitulo() {
        return lTitulo;
    }

    public void setlTitulo(JLabel lTitulo) {
        this.lTitulo = lTitulo;
    }

    public JPanel getJpOpciones() {
        return jpOpciones;
    }

    public void setJpOpciones(JPanel jpOpciones) {
        this.jpOpciones = jpOpciones;
    }

    public JLabel getlOpcion1() {
        return lOpcion1;
    }

    public void setlOpcion1(JLabel lOpcion1) {
        this.lOpcion1 = lOpcion1;
    }

    public JLabel getlOpcion2() {
        return lOpcion2;
    }

    public void setlOpcion2(JLabel lOpcion2) {
        this.lOpcion2 = lOpcion2;
    }

    public JLabel getlOpcion3() {
        return lOpcion3;
    }

    public void setlOpcion3(JLabel lOpcion3) {
        this.lOpcion3 = lOpcion3;
    }

    public JLabel getlOpcion4() {
        return lOpcion4;
    }

    public void setlOpcion4(JLabel lOpcion4) {
        this.lOpcion4 = lOpcion4;
    }

    public JLabel getlOpcionElegida() {
        return lOpcionElegida;
    }

    public void setlOpcionElegida(JLabel lOpcionElegida) {
        this.lOpcionElegida = lOpcionElegida;
    }

    public JTextField getTfOpcion() {
        return tfOpcion;
    }

    public void setTfOpcion(JTextField tfOpcion) {
        this.tfOpcion = tfOpcion;
    }

    public JButton getbAceptar() {
        return bAceptar;
    }

    public void setbAceptar(JButton bAceptar) {
        this.bAceptar = bAceptar;
    }

    public boolean validarOpcion() {
        boolean opcionValida=false;
        if (!tfOpcion.getText().isEmpty()) {
            if (Integer.parseInt(tfOpcion.getText()) <= 4 && Integer.parseInt(tfOpcion.getText()) >= 1) {
                opcion = Integer.parseInt(tfOpcion.getText());
                opcionValida=true;
                System.out.println("Estoy validando la opcion. La variable booleana es: " + opcion);
            }
        }
        return opcionValida;
    }
}
