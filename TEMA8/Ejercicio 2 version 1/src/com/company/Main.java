package com.company;

import MODELO.BASEDEDATOS.*;
import MODELO.UML.Empresa;
import MODELO.UML.Evento;
import MODELO.UML.Persona;
import VISTA.*;

import javax.swing.*;
import java.awt.*;
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
    private static Persona pers;
    static boolean eventoEncontrado = false;

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
        abrirVentanaMenu();

    }
    /*Estas son las funciones de operacion de la bbdd*/
    public static Evento getDatos(String nombre, String lugar, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
                                  int aforo, int aforoDisponible){
        boolean filaInsertada;
        try{
            System.out.println("f(x)MainGetDatos. Con los datos que recibe crea un objeto evento y se lo pasa a " +
                    "EVENTODAO para hacer el insert");
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
    } /*funcion para hacer el insert de eventos nuevos*/

    public static String buscaNombre(String tfnombre){
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
    } /*funcion para buscar el nombre de un evento */
    public static boolean deleteEvento(Evento evento){
        boolean borrado =false;
        try{
           borrado =  evenDao.deleteEvento(evento);
        }catch (Exception e){
            System.out.println(e.getClass());
        }

        return borrado;
    } /*Dentro de la ventana Confirmacion. Al dar OK*/

    public static boolean HacerUpdate(){
        boolean updateHecho=false;
        try{
            updateHecho= evenDao.updateEvento(evento);
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return updateHecho;
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
    public static void abrirVentanaMenu(){
        try{

            System.out.println("FUNCION MAIN.VENTANAMENU: Abro la ventana Principal. Esta funcion esta en el Main");
            JFrame vp = new JFrame("VentanaMenu");
            vp.setContentPane(new VentanaMenu().getJpPrincipal());
            vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vp.pack();
            vp.setVisible(true);
            vp.setLocationRelativeTo(null);

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    } /* 1. Primera ventana que se abre. VentanaMenu*/
    public static void ventanaAñadirEvento(){
        try{
            /*Main de la ventana Añadir Evento*/
            System.out.println("F(X) MAINventanaAñadirEvento. Me voy a la ventanaNuevoEvento");
            VentanaNuevoEvento dialog = new VentanaNuevoEvento();
            dialog.pack();
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(null);
            vp.dispose();

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    } /*2. OPCION AÑADIR EVENTO*/
    public static void abrirVentanaEliminarEvento(){
        dgEl = new VentanaEliminarEvento();
        dgEl.pack();
        dgEl.setVisible(true);
    }/*3. OPCION ELIMINAR EVENTO*/
    public static void abrirVentanaConfirmacion(){
        try{
            dgEl.dispose();
            VentanaConfirmacion dialog = new VentanaConfirmacion();
            dialog.pack();
            dialog.setVisible(true);
        }catch (Exception  e){
            System.out.println(e.getClass());
        }
    } /*4. OPCION MUESTRA LOS DATOS DEL EVENTO QUE SE VA A BORRAR Y
    CONFIRMA EL DELETE*/


    public static void ventanaModificar(){
        System.out.println("abro ventana modificar");
        VentanaModificar dialog = new VentanaModificar();
        dialog.pack();
        dialog.setVisible(true);
    }
    public static void ventanaAsistentes(){
        JFrame frame = new JFrame("VentanaAsistentes");
        frame.setContentPane(new VentanaAsistentes().getJpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

/* ************************************CARGAR DATOS EN LAS VENTANAS******************************************** */
    /*DATOS PERSONA*/
    public static String getNombre(){
        System.out.println("F(X): MAIN.GETNOMBRE: Devuelve un String que uso en las ventanas para cargar el " +
                "nombre de la persona");
        String nombre="";
        try{
            nombre = pers.getNombre();

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return nombre;
    }
    public static String getApellido(){
        System.out.println("F(X): MAIN.GETAPELLIDO: Devuelve un String que uso en las ventanas para cargar el " +
                "apellido de la persona");
        String apellido="";
        try{
        apellido = pers.getApellido();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return apellido;
    }
    public static String getNombreEmpresa(){
        System.out.println("F(X): MAIN.GETAPELLIDO: Devuelve un String que uso en las ventanas para cargar el " +
                "apellido de la persona");
        String nombreEmpresa="";
        try{
            nombreEmpresa = pers.getEmpresa().getNombre();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return nombreEmpresa;
    }
    public static String getDireccionEmpresa(){
        System.out.println("F(X): MAIN.GETAPELLIDO: Devuelve un String que uso en las ventanas para cargar el " +
                "apellido de la persona");
        String direccionEmpresa="";
        try{
            direccionEmpresa = pers.getEmpresa().getDireccion();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return direccionEmpresa;
    }
    public static String getTelefonoEmpresa(){
        System.out.println("F(X): MAIN.GETAPELLIDO: Devuelve un String que uso en las ventanas para cargar el " +
                "apellido de la persona");
        String telefonoEmpresa="";
        try{
            telefonoEmpresa = pers.getEmpresa().getTelefono();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return telefonoEmpresa;
    }
    public static boolean compruebaDni(String dni){
    System.out.println("f(x) Main.CompruebaDni: devuelve booleano para confirmar si se ha encontrado o no." +
            "llena el objeto pers con los datos de exa persona. Se llama en la ventana asistentes");
        boolean dniEncontrado=false;
        try{
            pers = persDao.buscaPersona(dni);

            if(pers.getNombre()!= null){
                dniEncontrado=true;
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return dniEncontrado;
    }
    /*DATOS EVENTOS*/
    /*Estos metodos get guardan en una variable String el dato para darselos a la vista y que los saque en los tf.
     * De esta forma evito pasarle el objeto a la vista directamente*/
    public static String getLugar(){
        System.out.println("F(X): MAIN.GETLUGAR: Devuelve un String que uso en las ventanas para cargar el " +
                "nlugar del evento");
        String lugar="";
        try{
            lugar = evento.getLugar();
        }catch (Exception e){System.out.println(e.getClass());}

        return lugar;
    }
    public static String getFecha(){
        System.out.println("F(X): MAIN.GETfecha: Devuelve un String que uso en las ventanas para cargar el " +
                "fecha del evento");
        String fecha ="";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            LocalDate ldFecha = evento.getFecha();

        }catch (Exception e){System.out.println(e.getClass());}
        return evento.getFecha().format(formato);
    }
    public static String getHoraInicio(){
        System.out.println("F(X): MAIN.GETHoraInicio: Devuelve un String que uso en las ventanas para cargar la " +
                "horaI del evento");
        String horaInicio ="";
        try{
            horaInicio = evento.getHoraInicio().toString();
        }catch (Exception e){System.out.println(e.getClass());}
        return horaInicio;
    }
    public static String getHoraFin(){
        System.out.println("F(X): MAIN.GETHoraFin: Devuelve un String que uso en las ventanas para cargar la " +
                "horaF del evento");
        String horaFin ="";
        try{
            horaFin = evento.getHoraFin().toString();
        }catch (Exception e){System.out.println(e.getClass());}
        return horaFin;
    }
    public static String getAforo(){
        System.out.println("F(X): MAIN.GETaforo: Devuelve un String que uso en las ventanas para cargar el " +
                "aforo del evento");
        String aforo ="";
        try{
            aforo = String.valueOf(evento.getAforo());
        }catch (Exception e){System.out.println(e.getClass());}
        return aforo;
    }
    public static String getAforoDisponible(){
        System.out.println("F(X): MAIN.GETaforodisponible: Devuelve un String que uso en las ventanas para cargar el " +
                "aforo disponible del evento");
        String aforoDisponible ="";
        try{
            aforoDisponible = String.valueOf(evento.getAforoDisponible());
        }catch (Exception e){System.out.println(e.getClass());}
        return aforoDisponible;
    }
    /*PARA LLENAR EL COMBOX DE EVENTOS*/
    public static void obtenerDatosEventos(){
        System.out.println("F(X):MAIN.OBTENERDATOSEVENTOS: consulta en eventoDAO los eventos y los guarda en un array" +
                "de eventos para llenar el combobox de eventos, ventana evento");
        try{
            listaEventos = evenDao.selectEventosLibres();
            System.out.println("Ya tengo el array con la lista de eventos");
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static ArrayList<String> llenarComboInscripcion(){
        ArrayList<String>listaNombres= new ArrayList<>();
        String nombre="";
        try{
            obtenerDatosEventos();
            System.out.println("Esoy en la funcion llenaCombo en el main");
            for (Evento listaEvento : listaEventos) {
                listaNombres.add(listaEvento.getNombre());
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return listaNombres;
    }

    /* **************************************PERSONA******************************************************************/
    /*Metodos para añadir persona. Primero creo una empresa, luego una persona*/
    public static boolean comprobarEmpresa(String nombreEmpresa){
        boolean empresaEncontrada = false;
        try{
            emp = empDao.buscarEmpresa(nombreEmpresa);
            if(emp.getNombre()!=null){
                empresaEncontrada=true;
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return empresaEncontrada;
    }
    public static String tenDireccionEmpresa(){
        String direccionEmpresa="";
        try{
            direccionEmpresa = emp.getDireccion();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return direccionEmpresa;
    }
    public static String tenTelefonoEmpresa(){
        String telefonoEmpresa="";
        try{
            telefonoEmpresa = emp.getTelefono();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return telefonoEmpresa;
    }
    public static boolean creaNuevaEmpresa(String nombreEmpresa,String direccion, String telefono){
        boolean empresaInsertada=false;
        try{
            emp = new Empresa(nombreEmpresa,direccion,telefono);
        }catch (Exception e){System.out.println(e.getClass());}
        return empresaInsertada;
    }
    public static boolean creaNuevaPersona(String dni, String nombre, String apellido,boolean dniEncontrado, int posicionEvento){
        boolean personaInsertada=false;
        try{
            pers = new Persona(dni,nombre,apellido,emp);
            System.out.println("He creado un objeto persona");
            if(dniEncontrado){

              personaInsertada = insertAsistente(posicionEvento);
            }

        }catch (Exception e){System.out.println(e.getClass());}
        return personaInsertada;
    }
    public static boolean insertEmpresa(){
        boolean insertHecho=false;
        try{
            insertHecho = empDao.insertEmpresa(emp);
        }catch (Exception e){
            System.out.println(e.getClass());}
        return insertHecho;
    }
    public static boolean insertPersona(){
        boolean insertHecho=false;
        try{
            insertHecho = persDao.insertPersona(pers);
        }catch (Exception e){
            System.out.println(e.getClass());}
        return insertHecho;
    }
    /* *************************************EVENTOS*************************************************************/
    /*Recoge el evento que se ha seleccionado*/
    public static void eventoElegidoEnElCombo(int posicion){
        evento = listaEventos.get(posicion);
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
    /* **************************************ASISTENTES********************************************************/
    public static boolean insertAsistente(int posicionEvento){
        boolean insertOk=false;
        try{
            Evento evento = listaEventos.get(posicionEvento);
            pers.getListaEventos().add(evento); /*Añado a la persona el evento al que va a asistir*/
            String nombreEvento = listaEventos.get(posicionEvento).getNombre();
            String dni = pers.getDni();

           insertOk = AsistenteDAO.insertAsistente(dni, nombreEvento);

        }catch (Exception e){System.out.println(e.getClass());}
        return insertOk;
    }

    public static void cerrarConexion(){
        bd.cerrarConexion();
    }
}
