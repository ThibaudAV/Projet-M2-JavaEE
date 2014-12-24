package com.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blog.model.Article;

public class ArticleDAO {
private EntityManagerFactory factory = null;
	
	public ArticleDAO(){
		factory = Persistence.createEntityManagerFactory("articles");
	}
	
	// Fonction de création d'un article en le faisant persister dans notre base
	public void createArticle(Article art) {
	   EntityManager em = null;
	   try {
	      em = factory.createEntityManager();
	      em.getTransaction().begin();
	      // utilisation de l'EntityManager
	      em.persist(art);
	      em.getTransaction().commit();
	   } finally {
	      if (em != null) {
	         em.close();
	      }
	   }
	}
	
	// Fonction de lecture d'un article en le récupérant depuis notre base
	public void readArticle(int id) {
	   
	}
	
	// Fonction de mise-à-jour d'un article existant dans notre base
	public void updateArticle(Article art) {
	   
	}
	
	// Fonction de suppression d'un article présent dans notre base
	public void removeArticle(int id) {
	   
	}
	
	// Fonction qui récupère la liste de tous les articles
	public List<Article> findAllArticles() {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			// utilisation de l'EntityManager
			TypedQuery<Article> q = em.createQuery("SELECT a FROM Article a", Article.class);
			return q.getResultList();
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}
	}
	
	// Fonction qui récupère la liste des articles par catégorie
	public List<Article> findArticlesByCategorie(int id_cat) {
	   return null;
	}
	
	// Fonction qui récupère la liste des articles par auteur
	public List<Article> findArticlesByAuteur(int id_aut) {
	   return null;
	}
}
