package com.company;

import MODELO.BASEDEDATOS.*;
import MODELO.UML.Asistente;
import MODELO.UML.Empresa;
import MODELO.UML.Evento;
import MODELO.UML.Persona;
import VISTA.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    /*Lo que necesito para establecer la conexion*/
    private static BD bd;
    private static EventoDAO evenDao;
    /*Para la parte 5 y 6 del ejercicio. Creo dos clases DAO mas*/
    private static PersonaDAO persDao;
    private static EmpresaDAO empDao;
    private static AsistenteDAO asisDao;
    /**/
    static JFrame vp;
    static Evento evento;
    static Dialog dgEl;
    static Dialog dgAAs;

    private static ArrayList<Evento>listaEventos = new ArrayList<>();
    private static ArrayList<Empresa> listaEmpresas = new ArrayList<>();
    private static ArrayList<Persona> listaPersonas = new ArrayList<>();
    private static Persona pers;
    static boolean eventoEncontrado =false;
    private static int posicionPersona;
    private static Empresa empresaEncontrada;
    private static Empresa emp;


    public static void main(String[] args) {
    /*Abro la conexion iniciando los dos objetos de la conexion*/
        bd = new BD();
        bd.abrirConexion();
    /*Objeto eventoDao*/
        evenDao = new EventoDAO(bd.getCon()); /*No entiendo muy bien el porque de esto*/
        persDao = new PersonaDAO(bd.getCon());
        empDao = new EmpresaDAO(bd.getCon());
        asisDao = new AsistenteDAO(bd.getCon());
    /*Ahora tengo que abrir la ventanaMenu*/
        abrirVentanaPrincipal();

    }
    /*Estas son las funciones de operacion de la bbdd*/
    public static Evento getDatos(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                                  int aforo, int aforoDisponible){
        boolean filaInsertada;
        try{
            System.out.println("Estoy en el Main en la funcion getDatos");
            evento = new Evento(nombre, lugar, fecha, horaInicio,horaFin,aforo,aforoDisponible);
            System.out.println(evento + " Estos son los datos que se han guardado en evento" );
            System.out.println("Llamo a la funcion evenDao.insertEvento. Me voy a EventoDAO");
           filaInsertada =  evenDao.insertEvento(evento);
           if(filaInsertada){
               System.out.println("Estoy en el Main.Recibo la confirmacion de fila insertada. Llamo a la funcion getConfirmacion de esta clase");
               getConfirmacion();
           }
            System.out.println("Me voy a la ventanaNuevo evento pasandole la confirmacion del insert");
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return evento;
    }
    public static String getNombre(String tfnombre){
        String nombre="";
        try{
            System.out.println("Estoy en get nombre. Le doy el nombre de un evento para que me saque datos. Me voy a la funcion eventodao.selectnOMBRE");
            nombre = tfnombre;
            evento = evenDao.selectNombre(nombre);
            System.out.println("Estoy en get nombre. selectNombre me a devuelto este objeto "+ evento.toString());
            System.out.println("dE AQUI VOY A LA FUNCION EVENTO SELECCIONADO. EN LA VENTANA MODIFICAR");
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return nombre;
    }
    public static boolean deleteEvento(Evento evento){
        boolean borrado =false;
        try{
           borrado =  evenDao.deleteEvento(evento);
        }catch (Exception e){
            System.out.println(e.getClass());
        }

        return borrado;
    }
    public static boolean HacerUpdate(){
        boolean updateHecho=false;
        try{
            updateHecho= evenDao.updateEvento(evento);
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return updateHecho;
    }
    public static boolean insertEmpresa(String idEmpresa,String nombre, String direccion, String telefono){
        boolean empresaInsertada = false;
        try{
            emp=new Empresa(idEmpresa,nombre,direccion,telefono);
            empresaInsertada = empDao.insertEmpresa(emp);
        }catch (Exception e){System.out.println(e.getClass());}
        return empresaInsertada;
    }
    public static boolean insertAsistente(String dni, String evento){
        boolean insertHecho=false;
        try{
            insertHecho = asisDao.insertAsistente(dni,evento);
        }catch (Exception e){System.out.println(e.getClass());}
        return insertHecho;
    }

    /*Estas funciones las utilizo para confirmar las transacciones de la bbdd*/
    public static Evento eventoSeleccionado(){
        if(!evenDao.confirmarSelect()){
            eventoEncontrado =false;
        }
        return evento;
    }
    public static boolean eventoNoEncontrado(){
        return eventoEncontrado;
    }
    public static boolean getConfirmacion(){
        boolean insertado = false;
        try{
            System.out.println("MAIN. funcion getConfirmacion. Devuelvo confirmacion");
            insertado =true;
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return insertado;
    }

    /*Estas funciones abren las diferentes ventanas*/
    public static void abrirVentanaConfirmacion(){
        try{
            dgEl.dispose();
            VentanaConfirmacion dialog = new VentanaConfirmacion();
            dialog.pack();
            dialog.setVisible(true);
        }catch (Exception  e){
            System.out.println(e.getClass());
        }
    }
    public static void abrirVentanaPrincipal(){
        try{

            System.out.println("Abro la ventana Principal. Esta funcion esta en el Main");
            JFrame vp = new JFrame("VentanaMenu");
            vp.setContentPane(new VentanaMenu().getJpPrincipal());
            vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vp.pack();
            vp.setVisible(true);
            vp.setLocationRelativeTo(null);

        }catch (Exception e){
             System.out.println(e.getClass());
        }
    }
    public static void ventanaAñadirEvento(){
        try{
            /*Main de la ventana Añadir Evento*/
            System.out.println("Estoy en la funcion ventanaAñadir Evento. En el Main. Me voy a la ventanaNuevoEvento");
            VentanaNuevoEvento dialog = new VentanaNuevoEvento();
            dialog.pack();
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(null);
            vp.dispose();

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static void abrirVentanaEliminarEvento(){
        dgEl = new VentanaEliminarEvento();
        dgEl.pack();
        dgEl.setVisible(true);
    }
    public static void ventanaModificar(){
        System.out.println("abro ventana modificar");
        VentanaModificar dialog = new VentanaModificar();
        dialog.pack();
        dialog.setVisible(true);
    }
    public static void abrirVentanaAltaPersona(){
        dgAAs = new VentanaAltaPersona();
        dgAAs.pack();
        dgAAs.setVisible(true);

    }
    public static void abrirVentanaNuevaEmpresa(){
        try{
            VentanaNuevaEmpresa dialog = new VentanaNuevaEmpresa();
            dialog.pack();
            dialog.setVisible(true);
        }catch (Exception e){System.out.println(e.getClass());}
    }

    /*Esta funcion hace el select * de la tabla eventos*/
    public static void obtenerDatosEventos(){
        try{
            listaEventos = evenDao.selectTodos();
            System.out.println("Ya tengo el array con la lista de eventos");
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static void obtenerDatosEmpresas(){
        try{
            listaEmpresas = empDao.selectTodos();
        }catch (Exception e){System.out.println(e.getClass());}
    }
    public static ArrayList<String> obtenerNombreEmpresas(){
        ArrayList<String>listaNombresEmpresas = new ArrayList<>();
        try{
        for(int i=0;i<listaEmpresas.size();i++){
            listaNombresEmpresas.add(listaEmpresas.get(i).getNombre());
        }
        }catch (Exception e){System.out.println(e.getClass());}
        return listaNombresEmpresas;
    }
    public static ArrayList<String> llenaCombo(){
        ArrayList<String>listaNombres= new ArrayList<>();
        String nombre="";
        try{
            System.out.println("Esoy en la funcion llenaCombo en el main");
            for (int i=0;i<listaEventos.size();i++){
               listaNombres.add(listaEventos.get(i).getNombre());
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return listaNombres;
    }
    public static boolean buscarDni(String dni){
        boolean dniExiste=false;
        pers = new Persona();
        try{
            pers = persDao.getDatosPersona(dni);
            if(pers.getNombre()!=null){
                dniExiste = true;
            }

            System.out.println(pers.toString()+ "Estoy imprimiendo la lista de personas");
        }catch (Exception e){System.out.println(e.getClass());}

        return dniExiste;
    }
    public static String getNombre(){
        String nombre="";
        try{
            nombre = pers.getNombre();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return nombre;
    }
    public static String getApellido(){
        String apellido="";
        try{
        apellido = pers.getApellido();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return apellido;
    }
    /*Para la ventana de nueva Empresa*/
    public static boolean comprobarIdEmpresa(String idEmpresa){

        boolean idValido=false;
        try{
            idValido = empDao.comprobarId(idEmpresa);
            if(idValido){
                idValido=true;
            }
            else{
                empresaEncontrada = empDao.getEmpresaEncontrada();
            }
        }catch (Exception e){System.out.println(e.getClass());}
       return idValido;
    }
    public static String getNombreEmpresa(){
        String nombreEmpresa="";
        try{
            nombreEmpresa = empresaEncontrada.getNombre();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return nombreEmpresa;
    }
    public static String getDireccionEmpresa(){
        String direccionEmpresa ="";
        try{
            direccionEmpresa= empresaEncontrada.getDireccion();
        }catch (Exception e){System.out.println(e.getClass());}
        return direccionEmpresa;
    }
    public static String getIdEmpresa(){
        String idEmpresa="";
        try{
            idEmpresa=empresaEncontrada.getIdEmpresa();
        }catch (Exception e){System.out.println(e.getClass());}
        return idEmpresa;
    }
    public static String getTelefonoEmpresa(){
        String telefonoEmpresa="";
            telefonoEmpresa=empresaEncontrada.getTelefono();
        return telefonoEmpresa;
    }

    /*Recoge el evento que se ha seleccionado*/
    public static void eventoElegidoEnElCombo(int posicion){
        evento = listaEventos.get(posicion);
    }
    /*Estos metodos get guardan en una variable String el dato para darselos a la vista y que los saque en los tf.
    * De esta forma evito pasarle el objeto a la vista directamente*/
    public static String getLugar(){
        String lugar="";
        try{
           lugar = evento.getLugar();
        }catch (Exception e){System.out.println(e.getClass());}

        return lugar;
    }
    public static String getFecha(){
        String fecha ="";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            LocalDate ldFecha = evento.getFecha();

        }catch (Exception e){System.out.println(e.getClass());}
        return evento.getFecha().format(formato);
    }
    public static String getHoraInicio(){
        String horaInicio ="";
        try{
            horaInicio = evento.getHoraInicio().toString();
        }catch (Exception e){System.out.println(e.getClass());}
        return horaInicio;
    }
    public static String getHoraFin(){
        String horaFin ="";
        try{
            horaFin = evento.getHoraFin().toString();
        }catch (Exception e){System.out.println(e.getClass());}
        return horaFin;
    }
    public static String getAforo(){
        String aforo ="";
        try{
            aforo = String.valueOf(evento.getAforo());
        }catch (Exception e){System.out.println(e.getClass());}
        return aforo;
    }
    public static String getAforoDisponible(){
        String aforoDisponible ="";
        try{
            aforoDisponible = String.valueOf(evento.getAforoDisponible());
        }catch (Exception e){System.out.println(e.getClass());}
        return aforoDisponible;
    }
    public static boolean tenNuevoEvento(String sNombre, String lugar, LocalDate fecha, LocalTime horaInicio,
                                         LocalTime horaFin, int aforo, int aforoDisponible){
        /*Recibe los datos que necesita para crear un objeto con los datos modificados*/
        boolean updateHecho =false;
        try{

            System.out.println("Estoy creando un nuevo objeto para modificar la base de datos. el nombre es: " +sNombre);

            evento = new Evento(sNombre,lugar,fecha,horaInicio,horaFin,aforo,aforoDisponible);
            updateHecho= evenDao.updateEvento(evento);
        }catch (Exception e){System.out.println(e.getClass());}
        return updateHecho;
    }


}
