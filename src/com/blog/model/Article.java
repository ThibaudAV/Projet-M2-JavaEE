package com.blog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(length=100)
	private String titre;
	
	@Column(length=65535)
	private String corps;
	
	@ManyToOne
	@Column( name = "categorie" )
	private Categorie categorie;
	
	@Column(length=100)
	private String image;
	
	@ManyToOne
	@Column( name = "auteur" )
	private Utilisateur auteur;
	
	private Date date_creation;
	
	
	public Article(){
		super();
	}
	
	public Article(String t, String co ,Categorie cat ,String img, Utilisateur aut, Date dc){
		titre = t;
		corps = co;
		categorie = cat;
		image = img;
		auteur = aut;
		date_creation = dc;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int newId){
		id = newId;
	}
	
	public String getTitre(){
		return titre;
	}
	
	public void setTitre(String newTitre){
		titre = newTitre;
	}
	
	public String getCorps(){
		return corps;
	}
	
	public void setCorps(String newCorps){
		corps = newCorps;
	}
	
	public Categorie getCategorie(){
		return categorie;
	}
	
	public void setCategorie(Categorie newCategorie){
		categorie = newCategorie;
	}
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String newImage){
		image = newImage;
	}
	
	public Utilisateur getAuteur(){
		return auteur;
	}
	
	public void setAuteur(Utilisateur newAuteur){
		auteur = newAuteur;
	}
	
	public Date getDateCreation(){
		return date_creation;
	}
	
	public void setDateCreation(Date newDateCreation){
		date_creation = newDateCreation;
	}

}
