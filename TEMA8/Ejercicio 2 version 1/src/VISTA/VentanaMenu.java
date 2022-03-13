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

    public VentanaMenu() {

        jmiAnadirEv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Cuando selecciona Añadir evento se abre una ventana nueva*/
                Main.ventanaAñadirEvento();
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
