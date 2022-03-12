package MODELO.BD;

import MODELO.UML.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*En esta clase estarán los metodos relacionados con la tabla persona*/
public class PersonaDao {
    /*Necesito un atributo Connection*/
    private Connection conexion;
    private int n;
    private Persona persona = null;
    private ArrayList<Persona> listaPersonas;

    public PersonaDao(Connection conexion) {
        this.conexion = conexion;
    }
    public ArrayList<Persona>selectDeTodo(){
        listaPersonas = new ArrayList<>(); /*Aqui voy a guardar todos los datos que me devuelve la selct*/
        try{
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from personas");
            /*Para llenar el ArrayList uso un mientras haya siguiente en resultado*/
            while (resultado.next()){
                persona = new Persona(resultado.getString("nombre"), resultado.getInt("edad"),
                        resultado.getString("profesion"),resultado.getString("telefono"));
                listaPersonas.add(persona);
            }
            System.out.println(listaPersonas.get(0).getProfesion().toString()+ "Estoy en SelectDeTodo y este es el array lista persoonas");
        }catch (Exception e){
            System.out.println(e.getClass());
        }






        return listaPersonas;
    }
    public Persona buscarPersona(String nombre){
        try {
            String plantilla = "select * from personas where nombre = ?";
            PreparedStatement ps =conexion.prepareStatement(plantilla);
            ps.setString(1,nombre); //Sustituyo la interrogacion por el parametro
            /*Recojo el resultado*/
            ResultSet resultado = ps.executeQuery();
            if(resultado.next()){
                persona= new Persona();
                persona.setNombre(resultado.getString("nombre"));
                persona.setEdad(resultado.getInt("edad"));
                persona.setProfesion(resultado.getString("profesion"));
                persona.setTelefono(resultado.getString("telefono"));
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return persona;
    }
    public void registrarPersona(Persona pers){
        try{
            String plantilla = "insert into personas values (?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(plantilla);
            ps.setString(1,pers.getNombre());
            ps.setInt(2,pers.getEdad());
            ps.setString(3,pers.getProfesion());
            ps.setString(4,pers.getTelefono());

            /*Ejecuto el insert*/
            n= ps.executeUpdate();
            /*El executeUpdate me devuelve el numero de filas que se han insertado. Lo voy
            * a utilizar para comprobar que se ha hecho bien el insert*/
            /*En este caso se que n solo puede ser 1*/
            if(n!=1){
                resultado();
                System.out.println("ha ocurrido un error al insertar");
                throw new Exception();
            }
            else{
                if(n==1){
                    resultado();
                }

            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public boolean resultado(){
        boolean personaInsertada = false;
        if(n==1){
            personaInsertada=true;
        }

        return personaInsertada;
    }


}
