package com.blog.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.blog.dao.ArticleDAO;
import com.blog.model.Categorie;
import com.blog.model.Article;

/**
 * Servlet implementation class Article
 */
@WebServlet("/Article")
public class ArticleUn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE   = "/views/Article.jsp";
	
    public static final String CHAMP_ID     = "id";
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleUn() {
        super();
        // TODO Auto-generated constructor stub
    }

		    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		    {
		    	System.out.println(request.getParameter(CHAMP_ID));
		    	
		    	// récupération de l'id de l'article dans le parametre de l'url de la requete		    	
				int id_art = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("id", id_art);
				
				// Récupération de l'article et de ses donnés
				ArticleDAO daoArt = new ArticleDAO();
				Article article = daoArt.readArticle(id_art);
				

				System.out.println(id_art);
				
				request.setAttribute("titre", article.getTitre());
				request.setAttribute("corps", article.getCorps());
				
				Categorie cat = article.getCategorie();
				request.setAttribute("categorie", cat.getId());
				
				DateTime datetime = new DateTime(article.getDateCreation());
				int day = datetime.getDayOfWeek();
				int month = datetime.getMonthOfYear();
				int year = datetime.getYear();
				
				request.setAttribute("day", day);
				request.setAttribute("month", month);
				request.setAttribute("year", year);
				
				
				System.out.println("Article n�"+article.getId()+", titre : "+ article.getTitre() + ", date : " +day + month + year);
				
				String image = article.getImage();
				String message_img = "";
				if(image != null){
//					message_img = "<fmt:message key='article.helpnewimage' />.";
					message_img = "helpnewimage";
					request.setAttribute("image", image);
				} else {
//					message_img = "<fmt:message key='article.helpimage' />.";
					message_img = "helpimage";
				}
				request.setAttribute("msg_img", message_img);
		    	
		    	this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
		    }
		    
		    
		    
	    /**
	    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	    */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
	    }
	    
}

