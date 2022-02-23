package VISTA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMovimientos {
    private JMenuBar jmbMenu;
    private JMenu jmResumenes;
    private JMenu jmTarjetas;
    private JMenu jmInversiones;
    private JMenu jmMercados;
    private JMenu jmPrestamos;
    private JMenu jmSeguros;
    private JMenu jmServicios;
    private JMenu jmCuentas;
    private JMenuItem miConsulta;
    private JMenuItem miMovimiento;
    private JButton bConsulta;
    private JButton bMovimientos;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JRadioButton rbCuenta1;
    private JRadioButton rbCuenta2;
    private JPanel jpCuentas;
    private JPanel jpMovimientos;
    private JTextField tfMovimiento1;
    private JTextField tfMovimiento2;
    private JTextField tfMovimiento3;
    private JTextField tfMovimiento4;
    private JTextField tfMovimiento5;
    private JTextField tfSaldoTotal;
    private JPanel jpPrincipal;

    public VentanaMovimientos() {
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaMovimientos");
        frame.setContentPane(new VentanaMovimientos().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
