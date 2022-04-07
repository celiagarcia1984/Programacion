package MODELO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EventoDAO {
    /*Declaro las ENTITY*/
   private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction transaccion;

public static String altaEvento(EventoEntity evento){
    String mensaje = "";
    try{
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaccion = em.getTransaction();
        transaccion.begin();
        /*Ejecuto el insert*/
        em.persist(evento);
        System.out.println("ejecuto el insert");
        /*Para que aparezca en la bbdd, tengo que hacer commit*/

        transaccion.commit();
        /*devuelvo un String con ok para tratarlo en el main*/
        mensaje = "ok";

    }catch (Exception e){
        mensaje = e.getMessage();
        System.out.println(mensaje);
    }
    finally{ /*Esto se pone para que en caso de que haya un error (el que sea), compruebe si la transacion está activa
    y haga un rollback*/
        if(transaccion.isActive()){
            transaccion.rollback();
        }
    }
    return mensaje;
}
public static EventoEntity consultar(String nombre){
    EventoEntity evento = null;
    try{
        emf =Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaccion = em.getTransaction();
        transaccion.begin();

        evento = em.find(EventoEntity.class, nombre);

    }catch (Exception e){
        System.out.println(e.getClass());
    }

    return evento;
}

}
