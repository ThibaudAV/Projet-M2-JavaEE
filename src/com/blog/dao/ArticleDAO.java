package com.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blog.model.Categorie;
import com.blog.model.Utilisateur;

import com.blog.model.Article;

public class ArticleDAO {
private EntityManagerFactory factory = null;
	
	public ArticleDAO(){
		factory = Persistence.createEntityManagerFactory("blog");
	}
	
	// Fonction de cr�ation d'un article en le faisant persister dans notre base
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
	
	// Fonction de lecture d'un article en le r�cup�rant depuis notre base
	public Article readArticle(int id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			Article art = em.find(Article.class, id);
			return art;
		} finally {
			if (em != null) {
				em.close();
			}
		}	   
}
	
	// Fonction de mise-�-jour d'un article existant dans notre base
	public void updateArticle(Article art) {
		EntityManager em = null;
		int id_art = art.getId();
		try {
			em = factory.createEntityManager();
			Article article = em.find(Article.class, id_art);
			em.getTransaction().begin();
			article.setCategorie(art.getCategorie());
			article.setCorps(art.getCorps());
			article.setTitre(art.getTitre());
			article.setImage(art.getImage());
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}	
	}
	
	// Fonction de suppression d'un article pr�sent dans notre base
	public void removeArticle(int id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			Article article = em.find(Article.class, id);
			em.getTransaction().begin();
			em.remove(article);
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}	
	}
	
	// Fonction qui r�cup�re la liste de tous les articles
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
	
	// Fonction qui r�cup�re la liste des articles par cat�gorie
	public List<Article> findArticlesByCategorie(int id_cat) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			Categorie cat = em.find(Categorie.class, id_cat); // r�cup�ration de la cat�gorie
			em.getTransaction().begin();
			// utilisation de l'EntityManager
			TypedQuery<Article> q = em.createQuery("SELECT a FROM Article a WHERE a.categorie = ?1", Article.class);
			q.setParameter(1, cat) ;
			return q.getResultList();
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}
	}
	
	// Fonction qui r�cup�re la liste des articles par auteur
	public List<Article> findArticlesByAuteur(int id_auteur) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			Utilisateur auteur = em.find(Utilisateur.class, id_auteur); // r�cup�ration de l'utilisateur qui est l'auteur
			em.getTransaction().begin();
			// utilisation de l'EntityManager
			TypedQuery<Article> q = em.createQuery("SELECT a FROM Article a WHERE a.auteur = ?1", Article.class);
			q.setParameter(1, auteur) ;
			return q.getResultList();
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}
	}
}
