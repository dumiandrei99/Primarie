package repository;

import entity.Document;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DocumentRepo {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primarie");


    public void deleteDocument(String numeDocument){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Document d WHERE UPPER(d.tipDocument) = :tip_doc");
        query.setParameter("tip_doc",numeDocument);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    public void insertNewDocument(Document document){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(document);
        em.getTransaction().commit();
        em.close();
    }

    public List<Document> getDocumente(){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT new Document(d.tipDocument) FROM Document d" );
        List <Document>results = query.getResultList();
        em.close();

        return results;
    }

    public boolean isDocumentInDB(String numeDocument){

        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT d FROM Document d WHERE UPPER(d.tipDocument) = :tip_doc ");
        query.setParameter("tip_doc",numeDocument);
        List <Document>results = query.getResultList();
        em.close();

        return !results.isEmpty();
    }


}
