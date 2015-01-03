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

/**
 * Servlet implementation class Articles_byDate
 */
@WebServlet("/Articles_byDate")
public class Articles_byDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String VUE   = "/views/Articles_byDate.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Articles_byDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mois = request.getParameter("mois");
		String annee = request.getParameter("annee");
		
		ArticleDAO daoArt = new ArticleDAO();
		List<Article> list = null;
		
		CategorieDAO daoCat = new CategorieDAO();
		List<Categorie> catlist = daoCat.findAllCategories();
		request.setAttribute("list_cat", catlist);
		
		if(mois != null){
			System.out.println("ok mois : "+mois);
			int month = Integer.parseInt(mois);
			
			list = daoArt.findArticlesByMonth(month);
			request.setAttribute("month", month);
			request.setAttribute("year", 2015);
			
		} else if (annee != null){
			System.out.println("ok annee : "+annee);
			int year = Integer.parseInt(annee);
			
			list = daoArt.findArticlesByYear(year);
			request.setAttribute("year", year);
		}
		
		request.setAttribute("liste_by", list);
		
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
