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

    }catch (Exception e){
        System.out.println(e.getClass());
    }
    return mensaje;
}

}
