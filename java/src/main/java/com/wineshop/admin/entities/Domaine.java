package com.wineshop.admin.entities;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Domaine extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	

    @Basic
    private String nom;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="domaine", orphanRemoval=true)
    private Set<Vin> vins;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Vin> getVins() {
		return vins;
	}

	public void setVins(Set<Vin> vins) {
		this.vins = vins;
	}
}
