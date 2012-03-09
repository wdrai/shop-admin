package com.wineshop.admin.entities;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Embeddable
public class Adresse {

	private static final long serialVersionUID = 1L;
	

    @Basic
    @NotNull
    @Size(min=5, max=100, message="L'adresse doit contenir entre {min} et {max} car.")
    private String adresse;
    

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
