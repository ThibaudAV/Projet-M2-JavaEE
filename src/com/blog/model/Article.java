package com.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	private String titre;
	
	private String corps;

	private String toto;
	
	private int categorie;
	
	private String image;
	
	private int auteur;
	
	private Date date_creation;
	
	
	public Article(){
		super();
	}
	
	public Article(String t, String co ,int cat ,String img, int aut, Date dc){
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
	
	public int getCategorie(){
		return categorie;
	}
	
	public void setCategorie(int newCategorie){
		categorie = newCategorie;
	}
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String newImage){
		image = newImage;
	}
	
	public int getAuteur(){
		return auteur;
	}
	
	public void setAuteur(int newAuteur){
		auteur = newAuteur;
	}
	
	public Date getDateCreation(){
		return date_creation;
	}
	
	public void setDateCreation(Date newDateCreation){
		date_creation = newDateCreation;
	}

	public String getToto() {
		return toto;
	}

	public void setToto(String toto) {
		this.toto = toto;
	}

}