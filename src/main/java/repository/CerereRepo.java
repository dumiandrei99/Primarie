package repository;

import entity.Cerere;
import entity.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CerereRepo {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primarie");

    public void insertNewCerere(Cerere cerere){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(cerere);
        em.getTransaction().commit();
        em.close();
    }

    public List<Cerere> getCerere(){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT new Cerere(c.idCerere,c.tipCerere,c.adresa,c.aprobare) FROM Cerere c ORDER BY c.idCerere ASC" );
        List <Cerere>results = query.getResultList();
        em.close();

        return results;
    }

    public void deleteCerere(int id){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Cerere c WHERE c.idCerere = :id_cerere");
        query.setParameter("id_cerere",id);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void updateOnAccept(int id){

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Cerere c SET c.aprobare = 'acceptat' WHERE c.idCerere = :id_cerere" );
        query.setParameter("id_cerere",id);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }

    public boolean isCerereInDB(int id){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Cerere c WHERE c.idCerere = :id_cerere");
        query.setParameter("id_cerere",id);
        List <Document>results = query.getResultList();
        em.close();

        return !results.isEmpty();
    }

    public boolean isCerereInDB(int id, String userId){
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Cerere c WHERE c.idCerere = :id_cerere AND c.userId = :user_id");
        query.setParameter("id_cerere",id);
        query.setParameter("user_id",userId);
        List <Document>results = query.getResultList();
        em.close();

        return !results.isEmpty();
    }

    public boolean isCerereInDB(String id, String adresa,String tipCerere){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Cerere c WHERE c.userId = :id_propietar AND UPPER(c.adresa) = :adresa and UPPER(c.tipCerere) = :tip_cerere");
        query.setParameter("tip_cerere",tipCerere);
        query.setParameter("id_propietar",id);
        query.setParameter("adresa",adresa);
        List <Document>results = query.getResultList();
        em.close();

        return !results.isEmpty();
    }


    public List<Cerere> getCerereByID(String id){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT new Cerere(c.idCerere, c.tipCerere,c.data,c.adresa,c.numarCereri,c.aprobare ) FROM Cerere c WHERE c.userId = :id_user" );
        query.setParameter("id_user",id);
        List <Cerere>results = query.getResultList();
        em.close();

        return results;
    }

    public void updateNumarCereri(String userId, String adresa, int numarCereri){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Cerere c SET c.numarCereri = :numar_cereri WHERE c.userId = :user_id AND UPPER(c.adresa) = :adresa" );
        query.setParameter("numar_cereri",numarCereri);
        query.setParameter("user_id",userId);
        query.setParameter("adresa",adresa);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public int getNumarCereri(String userId, String adresa){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT c.numarCereri FROM Cerere c WHERE c.userId = :user_id AND UPPER(c.adresa) = :adresa");
        query.setParameter("user_id",userId);
        query.setParameter("adresa",adresa);
        String id = query.getResultList().get(0).toString();
        em.close();

       return Integer.parseInt(id);

    }


}
