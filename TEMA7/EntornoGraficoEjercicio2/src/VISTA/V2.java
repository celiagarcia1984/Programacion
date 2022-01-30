package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V2 {
    private JPanel panelPrincipal;
    private JLabel ltitulo;
    private JLabel ltitulo2;
    private JLabel ltitulo3;
    private JTextField topcion;
    private JButton bAceptar;
    private JButton bsalir;



    public V2() {
        try{
            bAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getPanelPrincipal().setVisible(false);
                    Main.opcion(topcion.getText());
                }
            } );
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("V2");
        frame.setContentPane(new V2().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
