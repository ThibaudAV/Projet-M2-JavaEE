package com.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int id;
	
	private String titre;
	
	private String corps;
	
	private String categorie;
	
	private String image;
	
	private String auteur;
	
	private Date date_creation;
	
	
	public Article(){
		super();
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
	
	public String getCategorie(){
		return categorie;
	}
	
	public void setCategorie(String newCategorie){
		categorie = newCategorie;
	}
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String newImage){
		image = newImage;
	}
	
	public String getAuteur(){
		return auteur;
	}
	
	public void setAuteur(String newAuteur){
		auteur = newAuteur;
	}
	
	public Date getDateCreation(){
		return date_creation;
	}
	
	public void setDateCreation(Date newDateCreation){
		date_creation = newDateCreation;
	}

}
