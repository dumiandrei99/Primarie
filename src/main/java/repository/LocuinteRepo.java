package repository;

import entity.Document;
import entity.Locuinte;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LocuinteRepo {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primarie");

    public void insertNewLocuinta(Locuinte locuinta) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(locuinta);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteLocuinta(String adresa){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Locuinte l WHERE UPPER(l.adresa) = :adresa");
        query.setParameter("adresa",adresa);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }


    public List<Locuinte> getLocuinteByID(String id){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT new Locuinte(l.idLocuinta, l.adresa) FROM Locuinte l WHERE l.idPropietar = :id_propietar" );
        query.setParameter("id_propietar",id);
        List <Locuinte>results = query.getResultList();
        em.close();

        return results;
    }

    public boolean isLocuintaInDB(String id, String adresa){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT l FROM Locuinte l WHERE l.idPropietar = :id_propietar AND UPPER(l.adresa) = :adr_adresa");
        query.setParameter("id_propietar",id);
        query.setParameter("adr_adresa",adresa);
        List <Locuinte> results = query.getResultList();
        em.close();

        return !results.isEmpty();
    }
}
