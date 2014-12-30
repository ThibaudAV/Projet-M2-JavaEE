package com.blog.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.blog.model.Categorie;

public class CategorieDAO {
	private EntityManagerFactory factory = null;
	
	public CategorieDAO(){
		factory = Persistence.createEntityManagerFactory("blog");
	}
	
	// Fonction de lecture d'un article en le récupérant depuis notre base
	public Categorie readArticle(int id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			Categorie cat = em.find(Categorie.class, id);
			return cat;
		} finally {
			if (em != null) {
				em.close();
			}
		}	   
	}

}
