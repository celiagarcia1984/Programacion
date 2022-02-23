package VISTA;

import EXCEPCIONES.datoNoValido;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ventanaAceeso extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpDatos;
    private JPanel jpAceptarCancelar;
    private JLabel lNif;
    private JTextField tNif;
    private JLabel lClave;
    private JLabel linformacion;
    private JPasswordField tClave;
    private JPanel jpBotones;
    private JButton b1;
    private JButton b3;
    private JButton b2;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b9;
    private JButton b8;
    private JButton b7;
    private JButton b0;
    private String[] numerosAleatorios;
    private boolean clienteEncontrado;
    private boolean claveValida;
    private String claveMarcada="";


    public ventanaAceeso() throws Exception {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        etiquetarBotones();
        /*TENGO QUE HACER QUE LA CLAVE SOLO SE PUEDA MARCAR DESDE LA BOTONERA*/

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b1.getText();
                tClave.setText(claveMarcada);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b2.getText();
                tClave.setText(claveMarcada);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b3.getText();
                tClave.setText(claveMarcada);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b4.getText();
                tClave.setText(claveMarcada);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b5.getText();
                tClave.setText(claveMarcada);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b6.getText();
                tClave.setText(claveMarcada);
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b7.getText();
                tClave.setText(claveMarcada);
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b8.getText();
                tClave.setText(claveMarcada);
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b9.getText();
                tClave.setText(claveMarcada);
            }
        });
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claveMarcada = claveMarcada + b0.getText();
                tClave.setText(claveMarcada);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(validarNif()){
                        clienteEncontrado = Main.comprobarCliente(tNif.getText());
                        if(clienteEncontrado){
                            claveValida = validarClave();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El formato de DNI no es correcto");
                    }

                    if(claveValida){
                        Main.ventanaMovimientos();

                    }
                    if(!claveValida){
                        claveMarcada="";
                        tClave.setText("");
                        JOptionPane.showMessageDialog(null, "La clave es incorrecta",
                                "ERROR",JOptionPane.ERROR_MESSAGE);
                    }

                }catch (datoNoValido z){
                    System.out.println( "El campo no es correcto");
                    tClave.setText("");
                }
                catch (Exception ex) {
                    System.out.println (ex.getClass());
                }
            }
        });
    }

    private void onOK() {
       dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws Exception {
        ventanaAceeso dialog = new ventanaAceeso();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }

    private void etiquetarBotones()throws Exception{
        numerosAleatorios = new String[10];
        numerosAleatorios = Main.generarNumeroAleatorio();
        b0.setText(numerosAleatorios[0]);
        b1.setText(numerosAleatorios[1]);
        b2.setText(numerosAleatorios[2]);
        b3.setText(numerosAleatorios[3]);
        b4.setText(numerosAleatorios[4]);
        b5.setText(numerosAleatorios[5]);
        b6.setText(numerosAleatorios[6]);
        b7.setText(numerosAleatorios[7]);
        b8.setText(numerosAleatorios[8]);
        b9.setText(numerosAleatorios[9]);
        /*Esto me lo tengo que llevar al Main*/
    }
    private boolean validarNif()throws Exception{
        boolean nifValido=false;
        nifValido= Main.validarNIF(tNif.getText());
        if(!nifValido){
            tNif.setText("");
        }
        return nifValido;
    }
   private boolean validarClave()throws Exception{
        boolean claveValida=false;
        String sClave= String.valueOf(tClave.getPassword());
        claveValida =Main.validarClave(sClave);
        if(!claveValida){
            tClave.setText("");
        }
        return claveValida;
    }
}
