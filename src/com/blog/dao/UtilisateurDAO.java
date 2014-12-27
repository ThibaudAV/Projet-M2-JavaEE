package com.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blog.model.Utilisateur;

public class UtilisateurDAO {
	private EntityManagerFactory factory = null;
	public UtilisateurDAO(){
		factory = Persistence.createEntityManagerFactory("articles");
	}
	
	// Fonction de cr�ation d'un Utilisateur en le faisant persister dans notre base
	public void createUtilisateur(Utilisateur util) {
	   EntityManager em = null;
	   try {
	      em = factory.createEntityManager();
	      em.getTransaction().begin();
	      // utilisation de l'EntityManager
	      em.persist(util);
	      em.getTransaction().commit();
	   } finally {
	      if (em != null) {
	         em.close();
	      }
	   }
	}
	
	// Fonction de lecture d'un Utilisateur en le r�cup�rant depuis notre base
	public Utilisateur readUtilisateur(int id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			Utilisateur ut = em.find(Utilisateur.class, id);
			return ut;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
	
	// Fonction de mise-�-jour d'un Utilisateur existant dans notre base
	public void updateUtilisateur(Utilisateur util) {
		EntityManager em = null;
		int id_ut = util.getId();
		try {
			em = factory.createEntityManager();
			Utilisateur ut = em.find(Utilisateur.class, id_ut);
			em.getTransaction().begin();
			ut.setEmail(util.getEmail());
			//ut.setPassword(util.getPassword()); je ne vois pas trop comment faire...
			ut.setSignature(util.getSignature());
			ut.setAvatar(util.getAvatar());
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}
	}
	
	// Fonction de suppression d'un Utilisateur pr�sent dans notre base
	public void removeUtilisateur(int id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			Utilisateur ut = em.find(Utilisateur.class, id);
			em.getTransaction().begin();
			em.remove(ut);
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}
	}
	
	// Fonction qui r�cup�re la liste de tous les Utilisateurs
	public List<Utilisateur> findAllUtilisateurs() {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			// utilisation de l'EntityManager
			TypedQuery<Utilisateur> q = em.createQuery("SELECT a FROM Utilisateur a", Utilisateur.class);
			return q.getResultList();
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}
	}
	
}
