/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soulsoft.projetabolo.Dao;

import com.soulsoft.projetabolo.entite.Produits;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author MARIUS
 */
public class ProduitDAO {

//    @PersistenceContext(name = "produitPU")
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("produitPU");
//    private  EntityManager em = emf.createEntityManager();
    private static EntityManager entityManager;

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("produitPU").createEntityManager();
        }
        return entityManager;
    }

    public ProduitDAO() {
    }

    public void saveOne(Produits produit) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(produit);
        getEntityManager().getTransaction().commit();
    }

    public List<Produits> findAll() {
        Query requette = getEntityManager().createQuery("SELECT p FROM Produits p ");
        List<Produits> resultList = requette.getResultList();
        return resultList;
    }

    public Produits findById(int id) {
        Query requette = getEntityManager().createQuery("SELECT p FROM Produits p WHERE p.idProduit= :idRech");
        requette.setParameter("idRech", id);
        Produits singleResult = (Produits) requette.getSingleResult();
        return singleResult;
    }

    public Produits updateOne(Produits produits) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(produits);
        getEntityManager().getTransaction().commit();
        return produits;
    }

    public void deleteOne(Produits produits) {
        getEntityManager().getTransaction().begin();
        produits= getEntityManager().merge(produits);
        getEntityManager().remove(produits);
        getEntityManager().getTransaction().commit();
    }

}
