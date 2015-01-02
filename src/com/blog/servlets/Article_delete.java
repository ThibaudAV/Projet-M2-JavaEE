package com.blog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.model.Article;
import com.blog.model.Utilisateur;
import com.blog.dao.ArticleDAO;

/**
 * Servlet implementation class Article_delete
 */
public class Article_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_FORM     = "/views/Article_delete.jsp";
	public static final String VUE_SUCCES   = "/Article_my"; 

    public static final String VUE_CONNEXION    = "/Connexion";
	public static final String CHAMP_ID     = "id";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		if(user == null) {
			this.getServletContext().getRequestDispatcher( VUE_CONNEXION ).forward( request, response );
            
		} else {
			// récupération de l'id de l'article dans le parametre de l'url de la requete
			int id_art = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("id", id_art);
			
			// Récupération de l'article et de ses donnés
			ArticleDAO daoArt = new ArticleDAO();
			Article article = daoArt.readArticle(id_art);
			
			request.setAttribute("titre", article.getTitre());
			
			this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleDAO daoArt = new ArticleDAO();
	    
		// Récupération du contenu du champ titre de l'article 
	    String id = request.getParameter( CHAMP_ID );
	    System.out.println("delete article : "+id);
	    
	    daoArt.removeArticle(Integer.parseInt(id));
	    
	    this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}

}
