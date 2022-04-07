package VISTA;

import CONTROLADOR.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JPanel jpPrincipal;
    private JButton bInsertarEvento;
    private JButton bCancelar;

    public VentanaPrincipal(JPanel jpPrincipal) {
        this.jpPrincipal = jpPrincipal;
    }

    public VentanaPrincipal() {
        bInsertarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.mostrarInsertar();
            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nombreEventoBorrar="";
                try{
                   nombreEventoBorrar = JOptionPane.showInputDialog(null,"Escribe el nombre del evento que deseas eliminar");
                   if(validarNombreEvento(nombreEventoBorrar)){
                       Main.cancelarEvento(nombreEventoBorrar);
                   }

                }catch (Exception e){System.out.println(e.getClass());}

            }
        });
    }
    public boolean validarNombreEvento(String nombreEventoBorrar){
        boolean nombreValido=false;
        try{
                if (nombreEventoBorrar.isEmpty()){
                    throw new Exception("El nombre es un dato obligatorio");
                }
                nombreValido=true;

        }catch (Exception e){System.out.println(e.getClass());}
        return nombreValido;
    }
    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public void setJpPrincipal(JPanel jpPrincipal) {
        this.jpPrincipal = jpPrincipal;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
