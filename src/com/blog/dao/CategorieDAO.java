package com.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blog.model.Article;
import com.blog.model.Categorie;

public class CategorieDAO {
	private EntityManagerFactory factory = null;
	
	public CategorieDAO(){
		factory = Persistence.createEntityManagerFactory("blog");
	}
	
	// Fonction de création d'un article en le faisant persister dans notre base
	public void createCategorie(Categorie cat) {
	   EntityManager em = null;
	   try {
	      em = factory.createEntityManager();
	      em.getTransaction().begin();
	      // utilisation de l'EntityManager
	      em.persist(cat);
	      em.getTransaction().commit();
	   } finally {
	      if (em != null) {
	         em.close();
	      }
	   }
		}
	
	// Fonction de lecture d'un article en le récupérant depuis notre base
	public Categorie readCategorie(int id) {
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
	
	// Fonction de mise-à-jour d'un article existant dans notre base
	public void updateCategorie(Categorie cat) {
		EntityManager em = null;
		int id_cat = cat.getId();
		try {
			em = factory.createEntityManager();
			Categorie categorie = em.find(Categorie.class, id_cat);
			em.getTransaction().begin();
			categorie.setNom(cat.getNom());
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}	
	}
	
	// Fonction de suppression d'un article présent dans notre base
	public void removeCategorie(int id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			Categorie categorie = em.find(Categorie.class, id);
			em.getTransaction().begin();
			em.remove(categorie);
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}	
	}
	
	// Fonction qui récupère la liste de tous les articles
	public List<Categorie> findAllCategories() {
	   EntityManager em = null;
	   try {
	      em = factory.createEntityManager();
	      em.getTransaction().begin();
	      // utilisation de l'EntityManager
	      TypedQuery<Categorie> q = em.createQuery("SELECT c FROM Categorie c", Categorie.class);
	      return q.getResultList();
	   } finally {
	      if (em != null) {
	    	 em.getTransaction().commit();
	         em.close();
	      }
	   }
	}

}
