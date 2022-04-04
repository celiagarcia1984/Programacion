package CONTROLADOR;

import MODELO.EventoDAO;
import MODELO.EventoEntity;
import VISTA.DInsertar;
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
/*INSERTAR ACONTENCIMIENTO*/
    public static void getDatosEvento(String n, String l, LocalDate f, LocalTime hi, LocalTime hf, int af){
        evento = new EventoEntity(n,l,java.sql.Date.valueOf(f),java.sql.Time.valueOf(hi),java.sql.Time.valueOf(hf),af);
        String mensaje = EventoDAO.altaEvento(evento);
    }
    /*ABRIR VENTANAS************************************************************************************************/
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

}

