package com.blog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.UtilisateurDAO;
import com.blog.model.Utilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public static final String VUE_CONNEXION     = "/views/Connexion.jsp";
    public static final String VUE_ACCUEIL     = "/";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("deconnexion".equalsIgnoreCase(request.getParameter("query"))){
			   
		      HttpSession session = request.getSession();
		      session.removeAttribute("user");
		      session.invalidate();
		  }
        this.getServletContext().getRequestDispatcher( VUE_CONNEXION ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    	HttpSession session = request.getSession();
		

        String pseudoUser=request.getParameter("pseudoUser");    
        String password=request.getParameter("password");  
    	
        Utilisateur user = utilisateurDAO.getUtilisateurByPseudo(pseudoUser,password);
		System.out.println("user= "+user);
		
    	if(user != null) {
    		
    		session.setAttribute("user",user);
            String contextPath = request.getContextPath();
    		response.sendRedirect(contextPath + VUE_ACCUEIL);
    	} else {
    		session.setAttribute( "user", null );
            request.setAttribute("error", "Invalid pseudo or password" );
            
            this.getServletContext().getRequestDispatcher( VUE_CONNEXION ).forward( request, response );
    	}
		
	}

}
