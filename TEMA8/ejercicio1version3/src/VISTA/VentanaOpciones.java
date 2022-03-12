package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOpciones {
    private JPanel jpPrincipal;
    private JLabel lOpcion1;
    private JLabel lOpcion2;
    private JLabel lOpcion3;
    private JLabel lSalir;
    private JTextField tfOpcion;
    private JLabel lOpcionElegida;
    private int opcion;

    public VentanaOpciones() {
        tfOpcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(validarOpcion()) {
                   opcion = Integer.parseInt(tfOpcion.getText());
                   Main.getOpcion(opcion);
               }

            }
        });
    }
    public boolean validarOpcion(){
        boolean opcionValida=false;
        try {
            if(tfOpcion.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Tienes que elegir una opcion");
                throw new Exception();
            }
            else {
                if (Integer.parseInt(tfOpcion.getText()) > 4) {
                    JOptionPane.showMessageDialog(null, "La opcion tiene que estar entre 1 y 4");
                } else {
                    opcionValida = true;
                }
            }
        }catch (NumberFormatException y){
            JOptionPane.showMessageDialog(null,"La opcion tiene que ser un numero");
        }
        catch (Exception a){
            System.out.println("La opcion no es correcta. A saltado la excepcion");
            System.out.println(a.getClass());
        }
        return opcionValida;
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public void setJpPrincipal(JPanel jpPrincipal) {
        this.jpPrincipal = jpPrincipal;
    }

    public JTextField getTfOpcion() {
        return tfOpcion;
    }

    public void setTfOpcion(JTextField tfOpcion) {
        this.tfOpcion = tfOpcion;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaOpciones");
        frame.setContentPane(new VentanaOpciones().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
