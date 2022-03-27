package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu {

    private JPanel jpPrincipal;
    private JPanel jpMenu;
    private JMenuBar jmbMenu;
    private JMenu jmEventos;
    private JMenuItem jmiAnadirEv;
    private JMenuItem jmiCancelarEv;
    private JMenuItem jmiModificarEv;
    private JMenu jmAsistentes;
    private JButton bAnadirEv;
    private JButton bCancelarEv;
    private JButton bModificarEv;
    private JButton bAñadirAsis;
    private JButton bBajaAsistente;
    private JMenuItem miAñadirAsistente;
    private JMenuItem miBajaAsistente;


    public VentanaMenu() {
/* ***************************************INSERT EVENTO*************************************************************/
        jmiAnadirEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Cuando selecciona Añadir evento se abre una ventana nueva*/
                System.out.println("Estoy en la ventanaMenu y se a pulsado añadir");
                Main.ventanaAñadirEvento();
            }
        });
        bAnadirEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaAñadirEvento();
            }
        });
/* *******************************************DELETE EVENTO**********************************************************/
        bCancelarEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirVentanaEliminarEvento();
            }
        });
        jmiCancelarEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Cuando selecciona Añadir evento se abre una ventana nueva*/
                System.out.println("Estoy en la ventanaMenu y se a pulsado añadir");
                Main.abrirVentanaEliminarEvento();
            }
        });
 /* ***************************************UPDATE EVENTO**************************************************************/
        jmiModificarEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Cuando selecciona Añadir evento se abre una ventana nueva*/
                System.out.println("Estoy en la ventanaMenu y se a pulsado añadir");
                Main.ventanaModificar();
            }
        });

        bModificarEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaModificar();
            }
        });
/* *************************************INSERT ASISTENTE*************************************************************/

        bAñadirAsis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaAsistentes();
            }
        });
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public void setJpPrincipal(JPanel jpPrincipal) {
        this.jpPrincipal = jpPrincipal;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaMenu");
        frame.setContentPane(new VentanaMenu().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
