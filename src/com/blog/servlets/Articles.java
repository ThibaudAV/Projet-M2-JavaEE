package com.blog.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.ArticleDAO;
import com.blog.model.Article;

/**
 * Servlet implementation class Articles
 */
@WebServlet("/Articles")
public class Articles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		        
		        List<Article> list = daoArt.findAllArticles();
		        
		        for(Article a : list){
		            System.out.println("Article n°"+a.getId()+", titre : "+a.getTitre());
		            
		        }
		        // Set des paramètres
		        request.setAttribute("list_article", list);
		        
		        this.getServletContext().getRequestDispatcher("/Articles.jsp").forward( request, response );
		   }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}