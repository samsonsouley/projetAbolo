/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soulsoft.projetabolo.entite;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MARIUS
 */
@Entity
public class Produits implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_produit")
    private int idProduit;
    
    @Column(name = "nom_produit")
    private String nomProduit;
    
    @Column(name = "prix_produit")
    private double prixProduit;
   
    @Column(name = "date_peremption")   
    @Temporal(TemporalType.DATE)
    private Date datePeremption;

    public Produits() {
    }

    public Produits(String nomProduit, double prixProduit, Date datePeremption) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.datePeremption = datePeremption;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idProduit;
        hash = 59 * hash + Objects.hashCode(this.nomProduit);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.prixProduit) ^ (Double.doubleToLongBits(this.prixProduit) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.datePeremption);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produits other = (Produits) obj;
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produits{" + "idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit + ", datePeremption=" + datePeremption + '}';
    }
    
    
    
}
