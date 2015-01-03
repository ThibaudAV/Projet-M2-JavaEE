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
import com.blog.dao.UtilisateurDAO;
import com.blog.model.Article;
import com.blog.model.Categorie;

/**
 * Servlet implementation class Articles_by
 */
@WebServlet("/Articles_by")
public class Articles_by extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE   = "/views/Articles_by.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Articles_by() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_cat = Integer.parseInt(request.getParameter("cat"));
		
		ArticleDAO daoArt = new ArticleDAO();
		CategorieDAO daoCat = new CategorieDAO();
		
		Categorie cat = daoCat.readCategorie(id_cat);
		String catname = cat.getNom();
		
		List<Categorie> catlist = daoCat.findAllCategories();
		List<Article> list = daoArt.findArticlesByCategorie(id_cat);
		List<Article> list2 = daoArt.findArticlesByMonth(12);
		for(Article a : list2)
		{
			System.out.println(a.getTitre() + a.getCategorie());
		}

		request.setAttribute("catname", catname);
		
		request.setAttribute("list_cat", catlist);
		request.setAttribute("liste_bycat", list);
		
		 this.getServletContext().getRequestDispatcher(VUE).forward( request, response );

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
