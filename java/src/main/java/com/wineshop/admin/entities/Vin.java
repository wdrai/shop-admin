package com.wineshop.admin.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Vin extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	public static enum Type {
		ROUGE,
		BLANC,
		ROSE
	}

	@ManyToOne
    @NotNull
    private Domaine domaine;
	
    @Basic
    @Size(min=5, max=100, message="Le nom doit contenir entre {min} et {max} car.")
    private String nom;

    @Basic
    @Min(value=1900, message="L'annee doit être supérieure a {value}")
    @Max(value=2050, message="L'annee doit être inférieure a {value}")
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
