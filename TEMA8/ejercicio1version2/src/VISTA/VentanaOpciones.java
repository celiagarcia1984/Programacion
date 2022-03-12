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
                try{
                    if(validarOpcion()){
                        Main.abrirVentanaDatos(opcion);
                    }

                }catch (Exception a){
                    System.out.println(a.getClass());
                }
            }
        });
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public void setJpPrincipal(JPanel jpPrincipal) {
        this.jpPrincipal = jpPrincipal;
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

    public JLabel getlSalir() {
        return lSalir;
    }

    public void setlSalir(JLabel lSalir) {
        this.lSalir = lSalir;
    }

    public JTextField getTextField1() {
        return tfOpcion;
    }

    public void setTextField1(JTextField textField1) {
        this.tfOpcion = textField1;
    }

    public JLabel getlOpcionElegida() {
        return lOpcionElegida;
    }

    public void setlOpcionElegida(JLabel lOpcionElegida) {
        this.lOpcionElegida = lOpcionElegida;
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaOpciones");
        frame.setContentPane(new VentanaOpciones().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public boolean validarOpcion(){
        boolean opcionValida=false;
        try{
            if(tfOpcion.getText().isEmpty()){
                throw new Exception();
            }
            else{
                opcion =Integer.parseInt(tfOpcion.getText());
                if(opcion > 4 ){

                    tfOpcion.setText(" ");
                    throw new Exception();
                }
                else{
                    opcionValida=true;
                }
            }
        }catch (Exception s){
            System.out.println(s.getClass());
            JOptionPane.showMessageDialog(null,"La opcion no es correcta");
        }

        return opcionValida;
    }
}
