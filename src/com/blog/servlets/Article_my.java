package com.blog.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.model.Article;
import com.blog.model.Utilisateur;
import com.blog.dao.ArticleDAO;
import com.blog.dao.UtilisateurDAO;

/**
 * Servlet implementation class Artcle_my
 */
public class Article_my extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE   = "/views/Article_my.jsp"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article_my() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleDAO daoArt = new ArticleDAO();
		UtilisateurDAO daoUt = new UtilisateurDAO();
		
		// récupère l'utilisateur
		HttpSession session = request.getSession();
	    Utilisateur user = (Utilisateur) session.getAttribute("user");
	    Utilisateur auteur;
	    if (user != null){
	    	auteur = user;
	    	System.out.println("UserY : "+auteur.getPseudo());
	    } else{
	    	auteur = daoUt.readUtilisateur(1);
	    	System.out.println("UserN : "+auteur.getPseudo());
	    }

		List<Article> list = daoArt.findArticlesByAuteur(auteur.getId());
		for(Article a : list){
			System.out.println("Article n°"+a.getId()+", titre : "+a.getTitre());
			
		}
		
		
		// Set des paramètres
		request.setAttribute("list_article", list);
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
