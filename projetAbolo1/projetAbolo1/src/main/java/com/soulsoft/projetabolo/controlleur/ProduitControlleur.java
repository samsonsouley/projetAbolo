/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soulsoft.projetabolo.controlleur;

import com.soulsoft.projetabolo.Dao.ProduitDAO;
import com.soulsoft.projetabolo.entite.Produits;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author MARIUS
 */
@ManagedBean
@RequestScoped
public class ProduitControlleur {

    private ProduitDAO produitDAO;
    private List<Produits> findAll;
    private Produits findProduits;
    private Produits updateProduits;
    private Produits produits;

    public void saveOne(Produits produit) {
        produitDAO.saveOne(produit);
    }

    public List<Produits> findAll() {
        findAll = produitDAO.findAll();
        return findAll;
    }

    public Produits findById(int id) {
        findProduits = produitDAO.findById(id);
        return findProduits;
    }

    public Produits updateOne(Produits produits) {
        updateProduits = produitDAO.updateOne(produits);
        return updateProduits;
    }

    public void deleteOne(Produits produits) {
        produitDAO.deleteOne(produits);
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }    
}
