package com.company;

import EXCEPCIONES.datoNoValido;
import MODELO.Cliente;
import MODELO.Cuenta;
import MODELO.Movimiento;
import VISTA.VentanaPrincipal;
import VISTA.ventanaAceeso;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
     static Cuenta[] listaCuentas ;
     static ArrayList<Cliente> listaClientes;
     static ArrayList<Movimiento> listaMovimientos;
     static String[] numerosAleatorio;
     static int posicionCliente;


    public static void main(String[] args) {
	/*Esta creado el modelo.*/
        try{
            System.out.println("llamo a la funcion crearyLlenarDatos en el Main");
            crearYllenarDatos();
            System.out.println("Ahora llamo a la ventana Principal");
            ventanaPrincipal();


        }catch (datoNoValido e){
            JOptionPane.showMessageDialog(null, "La longitud del campo no es correcta");
        }
        catch (Exception e ){
            System.out.println(e.getClass());
        }

    }
    /*Creo una lista de clientes con los clientes y sus cuentas*/
    public static boolean comprobarCliente(String nif)throws Exception{
        System.out.println("ESTOY EN LA FUNCION COMPROBARCLIENTE");
       boolean clienteEncontrado =false;
       int i=0;
       for(i=0; i<listaClientes.size()&& !listaClientes.get(i).getDni().equalsIgnoreCase(nif);i++){}
       if(i==listaClientes.size()){
           JOptionPane.showMessageDialog(null, "Cliente no encontrado");
       }
       else{
           clienteEncontrado=true;
           System.out.println("El cliente se ha encontrado "+ listaClientes.get(i).getNombre());
           posicionCliente = i;
           System.out.println("la posicion del cliente es: "+ posicionCliente);
       }
       System.out.println("TERMINA LA FUNCION COMPROBARCLIENTE");
       return clienteEncontrado;
    }
    public static boolean validarNIF(String nif)throws Exception{
        boolean nifValido=false;
        /*Validar que el dni introducido cumple con el formato*/
        Pattern patronDni = Pattern.compile("^[0-9]{8}[A-Z]{1}$"); /*8 numeros entre 0 y 9, seguido
        de una letra entre la A-Z*/
        Matcher mat = patronDni.matcher(nif) ;
        if(mat.matches()){
            /*Validar que la letra del dni introducido es correcto*/
            nifValido = comprobarLetraDNI(nif);




            nifValido =true;
        }
        else {
            JOptionPane.showMessageDialog(null, "El formato de DNI no es correcto");
        }

        return nifValido;
    }
    public static boolean comprobarLetraDNI(String nif)throws Exception{
        boolean letraCorrecta=false;
        String letrasDni[] = {"t","r","w","a","g","m","y","f","p","d","x","b","n","j","z","s","q","v","h","l","c","k","e"};
        /*Creo un array para guardar la cadena de letras donde comprobar la
            letra introducida*/
         String sDniSinLetra = nif.substring(0,8);
         System.out.println(sDniSinLetra);
         int iDni = Integer.parseInt(sDniSinLetra);
         System.out.println(iDni);



        return letraCorrecta;
    }
    public static boolean validarClave(String clave) throws datoNoValido {
        System.out.println("Estoy en la funcion validar clave");
       boolean claveValida=false;
        System.out.println(clave+ "funcion validarClave. ESTA ES LA CLAVE QUE HAN INTRODUCIDO EN STRING");
        if(clave.length()!=6){
            throw new datoNoValido();
        }
        String claveIntroducidaSinEncriptar= clave;
        String claveIntroducidaEncriptada = DigestUtils.md5Hex(clave);
        if(listaClientes.get(posicionCliente).getClave().equalsIgnoreCase(claveIntroducidaEncriptada)){
            claveValida=true;
            System.out.println("La clave es correcta");
        }
        else{
            JOptionPane.showMessageDialog(null, "La clave es incorrecta","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("Aqui termina la funcion ValidarClave");
       return claveValida;

    }
    public static void crearYllenarDatos()throws Exception{
        System.out.println("Estoy en la funcion crearyLLenarDatos. Y estos son los datos de las cuentas y los clientes");
        /*Cliente 1*/

        /*Movimientos Cuenta 1*/
        listaMovimientos=new ArrayList<>();
        Movimiento mov;
        mov = new Movimiento(LocalDate.now(), 15000f,"Ingreso");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), -150f,"Retirada");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), -15.2f,"Recibo Luz");
        listaMovimientos.add(mov);

        /*Movimientos Cuenta2*/
        listaMovimientos=new ArrayList<>();/*Se vuelve a crear la lista de movimientos*/
        mov = new Movimiento(LocalDate.now(), 35000f,"Ingreso");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), -1350f,"Retirada");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), -12.2f,"Recibo Agua");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), 120f,"Ingreso");
        listaMovimientos.add(mov);

        /*Cuentas Cliente 1*/
        listaCuentas = new Cuenta[2];
        listaCuentas[0]= new Cuenta("0101010101",listaMovimientos);
        listaCuentas[1] = new Cuenta("0202020202",listaMovimientos);
        System.out.println(listaCuentas);

        listaClientes=new ArrayList<>();
        /*Encriptar la clave:*/
        String claveSinEncriptar = "123456";
        String claveEncriptada = DigestUtils.md5Hex(claveSinEncriptar);
        System.out.println("Clave encriptada: " + claveEncriptada);
        listaClientes.add(new Cliente("Fran", "48961088E", claveEncriptada, listaCuentas));
        System.out.println(listaClientes.toString());


        /*Cliente 2*/

        /*Movimientos Cuenta 1*/
        listaMovimientos=new ArrayList<>();
        mov = new Movimiento(LocalDate.now(), 12000f,"Ingreso");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), -120f,"Retirada");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), -17.2f,"Recibo Luz");
        listaMovimientos.add(mov);

        /*Movimientos Cuenta2*/
        listaMovimientos=new ArrayList<>();/*Se vuelve a crear la lista de movimientos*/
        mov = new Movimiento(LocalDate.now(), 135000f,"Ingreso");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), -13450f,"Retirada");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), -124.2f,"Recibo Agua");
        listaMovimientos.add(mov);

        mov = new Movimiento(LocalDate.now(), 1208f,"Ingreso");
        listaMovimientos.add(mov);

        /*Cuentas Cliente 2*/
        listaCuentas = new Cuenta[2];
        listaCuentas[0]= new Cuenta("0101010103",listaMovimientos);
        listaCuentas[1] = new Cuenta("0202020203",listaMovimientos);
        System.out.println(listaCuentas);

        claveSinEncriptar = "987321";
        claveEncriptada = DigestUtils.md5Hex(claveSinEncriptar);
        listaClientes.add(new Cliente("Celia", "72738006T", claveEncriptada, listaCuentas));

        System.out.println(listaClientes.toString());
        System.out.println("Aqui termina la funcion de llenarDatos.");
    }
    public static void ventanaPrincipal()throws Exception{
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getJpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void ventanaAcceso()throws Exception{
        ventanaAceeso dialog = new ventanaAceeso();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
        dialog.getLocationOnScreen();
        dialog.setLocationRelativeTo(null);
    }
    public static void ventanaOperaciones()throws Exception{
        /*AQUI EL MAIN DE LA VENTANA*/
    }
    /*FUNCION PARA GENERAR UN N?? ALEATORIO.*/
    public static String[] generarNumeroAleatorio()throws Exception {
        numerosAleatorio = new String[10];
        numerosAleatorio[0]="";
        numerosAleatorio[1]="";
        numerosAleatorio[2]="";
        numerosAleatorio[3]="";
        numerosAleatorio[4]="";
        numerosAleatorio[5]="";
        numerosAleatorio[6]="";
        numerosAleatorio[7]="";
        numerosAleatorio[8]="";
        numerosAleatorio[9]="";

        String sNumeroAleatorio="";

        boolean bArrayCompleto=false;
        boolean bNumeroAleatorioValido=false;

        while (!bArrayCompleto){
            int numeroAleatorio = (int)(Math. random()*10);
            sNumeroAleatorio= String.valueOf(numeroAleatorio);
            System.out.println("EL NUMERO GENERADO "+ numeroAleatorio);

            int x=0;
            for(x=0;!numerosAleatorio[x].isEmpty() && !numerosAleatorio[x].equalsIgnoreCase(sNumeroAleatorio)&& x<numerosAleatorio.length ;x=x+1){}

           if(numerosAleatorio[x].isEmpty()){
               numerosAleatorio[x]= sNumeroAleatorio;
           }
           if(x==numerosAleatorio.length-1){
               bArrayCompleto=true;
           }
        }
        for(int i=0; i<numerosAleatorio.length;i++){
            System.out.println(numerosAleatorio[i]);
        }
        return numerosAleatorio;
    }
}
