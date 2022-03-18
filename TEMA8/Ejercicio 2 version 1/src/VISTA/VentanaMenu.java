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
    private JMenu jmEmpresas;
    private JMenuItem jmiAnadirEv;
    private JMenuItem jmiCancelarEv;
    private JMenuItem jmiModificarEv;
    private JMenuItem jmiAnadirEmp;
    private JMenuItem jmiBorrarEmp;
    private JMenuItem jmiModificarEmp;
    private JMenu jmLugares;
    private JMenu jmPresupuestos;
    private JMenu jmCalendario;
    private JMenu jmPersonal;
    private JMenu jmClientes;
    private JButton bAnadirEv;
    private JButton bCancelarEv;
    private JButton bModificarEv;
    private JButton button4;
    private JButton button5;
    private JButton button6;


    public VentanaMenu() {
        /*PARTE DEL INSERT*/
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
        /*PARTE DEL DELETE*/
        bCancelarEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirVentanaEliminarEvento();
            }
        });


        bModificarEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaModificar();
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
