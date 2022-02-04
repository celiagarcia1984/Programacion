package VISTA.CUADROS;

import MODELO.Productos;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;

public class CVentas extends JDialog {
    private JPanel panelPrincipal;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lVentas;
    private JLabel lProducto;
    private JTextField tProducto;
    private JLabel lUnidades;
    private JTextField tUnidades;
    private JLabel lPrecioUnitario;
    private JTextField tPrecio;
    static Productos prodcutoSeleccionado;

    public CVentas() {
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
                validarProducto();
            }
        });
        tUnidades.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
    }

    private void onOK() {
        /*Cuando hemos puesto el precio y damos a aceptar: Mostrar el importe de la venta.*/
        calcularImporteVenta();
        if (validarUnidades()){
            Main.ajustarStock(Integer.parseInt(tUnidades.getText()));
            /*Mostrar la ventanaOpciones va a ser lo ultimo que se haga*/
            tUnidades.setText("");
            tProducto.setText("");
            tPrecio.setText("");
            Main.mostrarVentanaOpciones();
        }
        // add your code here
        dispose();
    }
    public void calcularImporteVenta(){
        try{
            if(validarUnidades()){
                float importeVenta = 0f;
                importeVenta = Float.parseFloat(tUnidades.getText())*Float.parseFloat(tPrecio.getText());
                JOptionPane.showMessageDialog(null,"El importe de la venta es: " + importeVenta);
            }

        }catch (Exception e){
            System.out.println(e.getClass());;
        }
    }
    public boolean validarUnidades(){
        boolean validado =false;
        try{
            if(tUnidades.getText().isEmpty()){
                System.out.println("El campo unidades esta vacio");
                throw new Exception("El campo esta vacio");
            }
            else if(Integer.parseInt(tUnidades.getText())>prodcutoSeleccionado.getUnidades()){
                JOptionPane.showMessageDialog(null, "No disponemos de tantas " + tProducto.getText()+
                        "Lo maximo que puedes vender es: " + prodcutoSeleccionado.getUnidades());
                tUnidades.setText("");
            }
            else{
                validado =true;
            }
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return validado;
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

            prodcutoSeleccionado = Main.getProduto(); /*En ProductoSeleccionado estoy guardando el producto que se ha
            elegido en la ventana VENTA para poder cargar el importeUnitario en la ventana*/
            System.out.println("FUNCION GETPRODUCTO EN VENTANAVenta." + prodcutoSeleccionado.toString());
            tPrecio.setText(Float.toString(prodcutoSeleccionado.getPrecioUnitario()));
            tPrecio.setEditable(false);
            /*Ahora me carga el precio y pone no editable los campos de precio y producto*/

        }catch (Exception e){
            System.out.println(e.getClass()+ "Es un campo obligatorio");
        }

    }/*A esta funcion la llamo en el listener focus lost de producto*/
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CVentas dialog = new CVentas();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


}
