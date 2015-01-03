package com.blog.dao;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.blog.model.Utilisateur;

public class UtilisateurDAO {
	private EntityManagerFactory factory = null;
	public UtilisateurDAO(){
		factory = Persistence.createEntityManagerFactory("blog");
	}
	
	// Fonction de création d'un Utilisateur en le faisant persister dans notre base
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
	
	// Fonction de lecture d'un Utilisateur en le récupérant depuis notre base
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
	
	// Fonction de mise-à-jour d'un Utilisateur existant dans notre base
	public void updateUtilisateur(int idUser,String email,String signature) {
		EntityManager em = null;
		int id_ut = idUser;
		try {
			em = factory.createEntityManager();
			Utilisateur ut = em.find(Utilisateur.class, id_ut);
			em.getTransaction().begin();
			ut.setEmail(email);
			ut.setSignature(signature);
//			ut.setAvatar(util.getAvatar());
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}
	}
	
	// Fonction de mise-à-jour de l'avatar d'un Utilisateur existant dans notre base
		public void updateAvatarUtilisateur(Utilisateur util) {
			EntityManager em = null;
			int id_ut = util.getId();
			try {
				em = factory.createEntityManager();
				Utilisateur ut = em.find(Utilisateur.class, id_ut);
				em.getTransaction().begin();
				ut.setAvatar(util.getAvatar());
			} finally {
				if (em != null) {
					em.getTransaction().commit();
					em.close();
				}
			}
		}
	
	// Fonction de suppression d'un Utilisateur présent dans notre base
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
	
	// Fonction qui récupère la liste de tous les Utilisateurs
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
	
	/* retourne true si le pseudo existe */
	public boolean isPseudoExist(String pseudoUser) {
		boolean userExist = false;
		Utilisateur user = null;
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();

			 TypedQuery<Utilisateur> query = em.createQuery(
				        "SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo", Utilisateur.class);
				
			user =  query.setParameter("pseudo", pseudoUser).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			user = null;
			userExist = false;
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
			if (user != null) {
				userExist = true;
			}
		}
		
		return userExist;
	}
	
	
	
	/* Retourne l'utilisateur en fonction de son pseudo et de son mot de passe , null sinon  */
	public Utilisateur getUtilisateurByPseudo(String pseudoUser, String password) {
		Utilisateur user = null;
		EntityManager em = null;
		System.out.println("pseudoUser= "+pseudoUser+" password: "+password);
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			 TypedQuery<Utilisateur> query = em.createQuery(
				        "SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo AND u.password = :password", Utilisateur.class);
				
			user =  query.setParameter("pseudo", pseudoUser).setParameter("password", hashPassword(password.toCharArray()) ).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			user = null;
		} finally {
			if (em != null) {
				em.getTransaction().commit();
				em.close();
			}
		}
		
		return user;
		
	}
	
	private char[] hashPassword(char[] password) {
		char[] encoded = null;
        try {
            ByteBuffer passwdBuffer = 
              Charset.defaultCharset().encode(CharBuffer.wrap(password));
            byte[] passwdBytes = passwdBuffer.array();
            MessageDigest mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(passwdBytes, 0, password.length);
            encoded = new BigInteger(1, mdEnc.digest()).toString(16).toCharArray();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encoded;
	}
	
}
