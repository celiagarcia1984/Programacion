package VISTA.CUADROS;

import MODELO.Productos;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

public class CCompras extends JDialog {
    private JPanel panelPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lTitulo;
    private JLabel lProducto;
    private JTextField tProducto;
    private JTextField tUnidades;
    private JLabel lUnidades;
    private JLabel lImporte;
    private JTextField tImporte;
    static Productos prodcutoSeleccionado;
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public CCompras() {
        setContentPane(panelPrincipal);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
                Main.mostrarVentanaOpciones();
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
        panelPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        tProducto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                super.focusLost(e);
                validarProducto();
                Main.comprobarProducto(tProducto.getText());
            }
        });
    }

    private void onOK() {
        // add your code here
        Main.actualizarStock (Integer.parseInt(tUnidades.getText()),Float.parseFloat (tImporte.getText()));
        Main.mostrarStockActualizado(Integer.parseInt(tUnidades.getText()),Float.parseFloat(tImporte.getText()));
        Main.mostrarVentanaOpciones();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CCompras dialog = new CCompras();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    public void validarProducto(){
        try{
            if(tProducto.getText().isEmpty()){
                throw new Exception();
            }
            Main.comprobarProducto(tProducto.getText());
            System.out.println("funcion validarProducto: El producto es: " + tProducto.getText());
            /*Aqui tengo que llamar a una funcion que me va a dar la informacion del importe para cargarlo en la ventana
             * importe*/
            tProducto.setEditable(false);
            /*Me quedo con el producto*/
            prodcutoSeleccionado = Main.getProduto(); /*En ProductoSeleccionado estoy guardando el producto que se ha
            elegido en la ventana VENTA para poder cargar el importeUnitario en la ventana*/
            System.out.println("ValidarProducto en Compra." + prodcutoSeleccionado.toString());

        }catch (Exception e){
            System.out.println(e.getClass()+ "Es un campo obligatorio");
        }
    }
}
