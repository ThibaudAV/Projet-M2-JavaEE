package com.blog.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.ArticleDAO;
import com.blog.dao.CategorieDAO;
import com.blog.model.Article;
import com.blog.model.Categorie;

import org.joda.time.DateTime;

/**
 * Servlet implementation class Articles
 */
@WebServlet("/Articles")
public class Articles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE   = "/views/Articles.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Articles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		        
		        ArticleDAO daoArt = new ArticleDAO();
		        CategorieDAO daoCat = new CategorieDAO();
				
				List<Categorie> catlist = daoCat.findAllCategories();
		        List<Article> list = daoArt.findAllArticles();
		        
		       
		        
		        for(Article a : list){
		        	DateTime d = new DateTime(a.getDateCreation());
		        	
		         	System.out.println("Article n°"+a.getId()+", titre : "+a.getTitre()+ ", mois : " + d.getMonthOfYear());
		            
		        }
		        // Set des paramètres
		        request.setAttribute("list_article", list);
		        request.setAttribute("list_cat", catlist);
		        
		        this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
		   }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}