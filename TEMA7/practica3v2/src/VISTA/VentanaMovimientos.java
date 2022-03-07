package VISTA;

import MODELO.Movimiento;
import com.company.Main;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


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
    private JLabel lSaldoTotal;
    private JLabel lSaldo;
    static boolean cuentasCargadas=false;
    static ArrayList<String> cuentasParaCargar = new ArrayList<>();
    ArrayList<JRadioButton>listaBotones = new ArrayList<>();

    public VentanaMovimientos() {

        bConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCuentas();
            }
        });
    }

    public void mostrarCuentas(){
    try{
        /*Primero vaciar el panel Cuentas*/
       jpCuentas.removeAll();
        cuentasParaCargar = Main.cargarCuentas();
        /*Se inicia el arraylist de botones y se crea un buttonGroup para meter tambien ahi los botones*/

        ButtonGroup grupoBotones = new ButtonGroup();
        for (int s=0; s<cuentasParaCargar.size();s++) {
            JRadioButton rb = new JRadioButton(cuentasParaCargar.get(s));
            listaBotones.add(rb);
            grupoBotones.add(rb);
            /*En este mismo for, se añade el listener de cada boton*/
            rb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /*Cuando se  marca tiene que mostrar los movimientos*/
                }
            });
            jpCuentas.add(rb);

        }
        cuentasCargadas = true;
        jpCuentas.updateUI();


       /* System.out.println("VentanaMovimiento. El contenido del array CuentasParaCargar "+ cuentasParaCargar.toString());
        ArrayList<JRadioButton>listaBotones = new ArrayList<>(Arrays.asList(rb1,rb2,rb3,rb4,rb4,rb6,rb7,rb8,rb9,rb10));
       
        for(int i=0;i<cuentasParaCargar.size();i++){
            listaBotones.get(i).setText(cuentasParaCargar.get(i));
            listaBotones.get(i).setVisible(true);
        }
        cuentasCargadas =true;*/
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
