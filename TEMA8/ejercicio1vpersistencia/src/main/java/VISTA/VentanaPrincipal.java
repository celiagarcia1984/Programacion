package VISTA;

import CONTROLADOR.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JPanel jpPrincipal;
    private JButton bInsertarEvento;
    private JButton bCancelar;
    private JButton bModificar;

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
                String datosEvento="";
                int confirmacion=0;
                String mensaje = "";
                try{
                   nombreEventoBorrar = JOptionPane.showInputDialog(null,"Escribe el nombre del evento que deseas eliminar");
                   if(validarNombreEvento(nombreEventoBorrar)){
                     datosEvento =  Main.cancelarEvento(nombreEventoBorrar);
                    confirmacion = JOptionPane.showConfirmDialog(null, "Esta es la informacion del evento que va a eliminar: "+datosEvento);
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "El evento no existe");
                       throw new Exception("El evento no existe");
                   }
                   if(confirmacion==0){
                     mensaje =  Main.borrarEvento();
                   }
                   if(mensaje.equalsIgnoreCase("ok")){
                       mensaje = "El evento se ha borrado";
                       JOptionPane.showMessageDialog(null, mensaje);
                   }

                }catch (Exception e){System.out.println(e.getClass());}

            }
        });
        bModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.mostrarVentanaModificar();
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
