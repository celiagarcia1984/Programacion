package VISTA;

import MODELO.Movimiento;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JRadioButton rb4;
    private JRadioButton rb5;
    private JRadioButton rb6;
    private JRadioButton rb7;
    private JRadioButton rb8;
    private JRadioButton rb9;
    private JRadioButton rb10;
    private JLabel lSaldoTotal;
    private JLabel lSaldo;
    static boolean cuentasCargadas=false;

    public VentanaMovimientos() {

        bConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!cuentasCargadas){
                    mostrarCuentas();
                }
            }
        });
        miConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!cuentasCargadas){
                    mostrarCuentas();
                }
            }
        });
        rb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Movimiento>movimientosCuentaSeleccionada = new ArrayList<>();
               movimientosCuentaSeleccionada = Main.cargarMovimientos(rb1.getText());
            }
        });
    }

    public void mostrarCuentas(){
    try{
        ArrayList<String> cuentasParaCargar =new ArrayList<>();
        cuentasParaCargar = Main.cargarCuentas();
        System.out.println("VentanaMovimiento. El contenido del array CuentasParaCargar "+ cuentasParaCargar.toString());
        ArrayList<JRadioButton>listaBotones = new ArrayList<>();
        listaBotones.add(rb1);
        listaBotones.add(rb2);
        listaBotones.add(rb3);
        listaBotones.add(rb4);
        listaBotones.add(rb5);
        listaBotones.add(rb6);
        listaBotones.add(rb7);
        listaBotones.add(rb8);
        listaBotones.add(rb9);
        listaBotones.add(rb10);
        for(int i=0;i<cuentasParaCargar.size();i++){
            listaBotones.get(i).setText(cuentasParaCargar.get(i));
            listaBotones.get(i).setVisible(true);
        }
        cuentasCargadas =true;
    }catch (Exception s){
        System.out.println(s.getClass());
    }

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


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
