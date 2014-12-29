package com.blog.servlets;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.blog.dao.ArticleDAO;
import com.blog.model.Categorie;
import com.blog.model.Utilisateur;

/**
 * Servlet implementation class Article
 */
@WebServlet("/Article")
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		// Code pour ajouter un article � partir de la classe ArticleDAO qui g�re la persistance en BDD
//		// ici � partir d'un example pidon -> retravailler pour r�cup�rer les vrais donn�es depuis un formulaire !
//		ArticleDAO dao = new ArticleDAO();
//		Date d = new Date();
//		com.blog.model.Article article = new com.blog.model.Article("Mon titre trop bien", "un contenu de l'article", 3, "pseudo/url", 2, d);
//		// O�  on suppose 3 = id_categorie (3 : sciences) par exemple
//		// & 2 = id_user (2 : Isa Boulet) par exemple
//		dao.createArticle(article);
//		
//		// V�rifiacation de la fonction pour obtenir tous les articles
//		List<com.blog.model.Article> la = dao.findAllArticles();
//		for(com.blog.model.Article a : la){
//			System.out.println("Article n�"+a.getId()+", titre : "+a.getTitre());
//		}
	}

}
