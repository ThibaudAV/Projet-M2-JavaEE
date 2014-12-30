package com.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name="categorie")
public class Categorie {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(length=50)
	private String nom;
	
	public Categorie() {
		super();
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id_c){
		id = id_c;
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String n){
		nom = n;
	}
}
