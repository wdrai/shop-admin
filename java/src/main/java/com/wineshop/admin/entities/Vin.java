package com.wineshop.admin.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Vin extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	public static enum Type {
		ROUGE,
		BLANC,
		ROSE
	}

	@ManyToOne
	private Domaine domaine;
	
    @Basic
    private String nom;

    @Basic
    private Integer annee;
    
    @Enumerated(EnumType.STRING)
    private Type type;

    
	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
    
}
