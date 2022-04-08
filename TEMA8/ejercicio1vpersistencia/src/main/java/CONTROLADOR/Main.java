package CONTROLADOR;

import MODELO.EventoDAO;
import MODELO.EventoEntity;
import VISTA.DInsertar;
import VISTA.DModificar;
import VISTA.VentanaPrincipal;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    private static JFrame vp;
    private static EventoEntity evento;

    private static EventoDAO adao;

    public static void main(String[] args) {
        mostrarVentanaPrincipal();

    }
/* *************************MODIFICAR ACONTECIMIENTOS**************************************************************/

    public static void llenarCombo(){
        try{

        }catch (Exception e){System.out.println(e.getClass());}
    }

/* ****************************INSERTAR ACONTENCIMIENTO***********************************************************/
    public static String getDatosEvento(String n, String l, LocalDate f, LocalTime hi, LocalTime hf, int af){

        evento = new EventoEntity(n,l,java.sql.Date.valueOf(f),java.sql.Time.valueOf(hi),java.sql.Time.valueOf(hf),af);
        String mensaje = EventoDAO.altaEvento(evento);
        return mensaje;
    }

/* *****************************ELIMINAR EVENTO*******************************************************************/
    public static String cancelarEvento(String  nombreEventoBorrar){
        try{

            evento = EventoDAO.consultar(nombreEventoBorrar);

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return evento.toString();
    }
    public static String borrarEvento(){
        String confirmacion="";
        try{

            confirmacion =  EventoDAO.borrar();

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return confirmacion;
    }

/* *********************************ABRIR VENTANAS***************************************************************/
    public static void mostrarVentanaPrincipal()
    {
        vp = new JFrame("VentanaPrincipal");
        vp.setContentPane(new VentanaPrincipal().getJpPrincipal());
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vp.pack();
        vp.setVisible(true);
    }
    public static void mostrarInsertar(){
        DInsertar dialog = new DInsertar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    public static void mostrarVentanaModificar(){
        DModificar dialog = new DModificar();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

