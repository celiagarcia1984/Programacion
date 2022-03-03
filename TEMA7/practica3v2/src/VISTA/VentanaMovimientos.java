package VISTA;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
    private JPanel jpCuentas;
    private JPanel jpMovimientos;
    private JPanel jpPrincipal;
    private JLabel Lfecha1;
    private JLabel lFecha2;
    private JLabel lFecha3;
    private JLabel lFecha4;
    private JLabel lFecha5;
    private JLabel lDescripcion1;
    private JLabel lDescripcion2;
    private JLabel lDescripcion3;
    private JLabel lDescripcion4;
    private JLabel lDescripcion5;
    private JLabel lImporte1;
    private JLabel lImporte2;
    private JLabel lImporte3;
    private JLabel lImporte4;
    private JLabel lImporte5;
    private JButton bAceptar;
    private JButton bCancelar;
    private JRadioButton rbCuenta1;
    private JRadioButton rbCuenta2;

    public VentanaMovimientos() {
        ArrayList<String> cuentasParaCargar =new ArrayList<>();
        cuentasParaCargar = Main.cargarCuentas();
        System.out.println("VentanaMovimiento. El contenido del array CuentasParaCargar "+ cuentasParaCargar.toString());

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
