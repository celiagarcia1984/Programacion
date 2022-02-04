package VISTA;

import MODELO.Productos;
import MisExcepciones.DatoNoValido;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaVenta {
    private JPanel panelPrincipal;
    private JLabel lProducto;
    private JTextField tProducto;
    private JLabel lUnidades;
    private JTextField tUnidades;
    private JTextField tPrecio;
    private JLabel lPrecio;
    private JButton bAceptar;
    private JButton bCancelar;
    static Productos prodcutoSeleccionado;/*Esta variable la uso en la f(x) comprobar producto para guardar el producto
    que se ha elegido en la ventana VENTA*/
     /*Ahora que ya tengo el producto guardado, quiero cargar en el textfield tPrecio el precio que tiene ese producto*/
    public JPanel getPanelPrincipal() { /*Para llamar desde el MAIN*/
        return panelPrincipal;
    }

        public static void main(String[] args) { /*Copia Pega en el MAIN*/
        JFrame frame = new JFrame("VentanaVenta");
        frame.setContentPane(new VentanaVenta().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
        public VentanaVenta() {
        tProducto.addFocusListener(new FocusAdapter() { /*Cuando pierde el foco que compruebe si el producto es valido.
        Que no esté vacio y que exista en el array*/
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                /*funcion ValidarProducto*/
                validarProducto();
            }
        });

        bAceptar.addActionListener(new ActionListener() { /*Cuando se acepta o Cancela tiene que volver la pantalla opciones*/
            @Override
            public void actionPerformed(ActionEvent e) {
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
            }
        });
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.mostrarVentanaOpciones();
            }
        });
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
            if(tUnidades.getText().length()>3){
                throw new Exception();
            }
            else if(Integer.parseInt(tUnidades.getText())>prodcutoSeleccionado.getUnidades()){
                JOptionPane.showMessageDialog(null, "No disponemos de tantas " + tProducto.getText()+
                        "Lo maximo que puedes vender es: " + prodcutoSeleccionado.getUnidades());
                tUnidades.setText("");
            }
            else{
                validado =true;
            }
        }catch (DatoNoValido a){
            System.out.println("El dato no es valido");
        }
        catch (Exception e){
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
    }

