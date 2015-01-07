package com.blog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.UtilisateurDAO;
import com.blog.forms.InscriptionUtilisateurForm;
import com.blog.model.Utilisateur;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public static final String ATT_UTILISATEUR = "utilisateur";
    public static final String ATT_FORM   = "form";
    
    public static final String VUE_SUCCES   = "/";
    public static final String VUE_FORM     = "/views/Inscription.jsp";
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    	
		/* Préparation de l'objet formulaire */
		InscriptionUtilisateurForm form = new InscriptionUtilisateurForm(utilisateurDAO);

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.creerUtilisateur( request );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_UTILISATEUR, utilisateur );
        request.setAttribute( ATT_FORM, form );

        /* Si le formulaire est valide et que l'utilisateur est créé */
        if ( form.getErreurs().isEmpty() ) {
        	
        	/* Connexion de l'utilisateur */
        	HttpSession session = request.getSession();
        	String password=request.getParameter("passwordUser");  
            Utilisateur user = utilisateurDAO.getUtilisateurByPseudo(utilisateur.getPseudo(),password);
    		session.setAttribute("user",user);
            String contextPath = request.getContextPath();
    		response.sendRedirect(contextPath + VUE_SUCCES);
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
        } else {
        	
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
            
            
        }
		

        
		
		
	}

}
