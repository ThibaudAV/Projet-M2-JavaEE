package com.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.blog.dao.UtilisateurDAO;
import com.blog.forms.InscriptionUtilisateurForm;
import com.blog.model.Utilisateur;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE_PROFIL     = "/views/Profil.jsp";
    public static final String VUE_SUCCES   = "/views/Articles.jsp";
    private final String UPLOAD_DIRECTORY = "static"+File.separator+"img"+File.separator+"avatar";

    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
        String contextPath = request.getContextPath();
		
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		
		if(user == null) {
            response.sendRedirect(response.encodeRedirectURL(contextPath + "/Connexion") );
            
		} else {

			request.setAttribute("user", user);
			
			
	        this.getServletContext().getRequestDispatcher( VUE_PROFIL ).forward( request, response );
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
        String contextPath = request.getContextPath();
		
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		// si l'utilisateur n'est pas connecté 
		if(user == null) {
            response.sendRedirect(response.encodeRedirectURL(contextPath + "/Connexion") );
		}

		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		
		String nameFrom = getValeurChamp( request, "nameFrom" );
		System.out.println(nameFrom);
		
		if(nameFrom.equals("editProfil") ){

			InscriptionUtilisateurForm form = new InscriptionUtilisateurForm(utilisateurDAO);
			
			Utilisateur utilisateur = form.updateUtilisateur(user, request);
			

	        /* Ajout du bean et de l'objet métier à l'objet requête */
	        request.setAttribute( "user", utilisateur );
	        request.setAttribute( "form", form );
			
//			String pseudo = getValeurChamp( request, CHAMP_PSEUDO );
//	        String password = getValeurChamp( request, CHAMP_PASSWORD );
//	        String passwordConfirm = getValeurChamp( request, CHAMP_PASSWORD_CONFIRM );
////	        String email = getValeurChamp( request, CHAMP_EMAIL );
//	        int idUser = user.getId();
//	        
//	        user.setPseudo(pseudo);
//	        user.setEmail(email);
//	        user.setPassword(passwordConfirm);
//	        
//	        utilisateurDAO.updateUtilisateur(idUser, email, pseudo, passwordConfirm, signature);
			
		} else {
			
			if(ServletFileUpload.isMultipartContent(request)){
	            try {
	                List<FileItem> multiparts = new ServletFileUpload(
	                                         new DiskFileItemFactory()).parseRequest(request);

	                	FileItem itesm = multiparts.get(0);
	                	for(FileItem item : multiparts)
	                	{
		                    if(!item.isFormField()){
		                        String name = new File(item.getName()).getName();
		                        // new file name
		                        String fileName = user.getPseudo() + "_" + name;
		                        // le cheùin du serveur + mon dossier avatar + nouveau nom du fichier 
		                        item.write( new File(getServletContext().getRealPath(File.separator)+ UPLOAD_DIRECTORY + File.separator + fileName));
		            			
		                        // on met a jour la le profil de l'utilisateur
		            			user.setAvatar(fileName );
		
		                        // on envoie l'update de l'user au DAO
		                		utilisateurDAO.updateAvatarUtilisateur(user);
		                    }
	                	}
	           
	               //File uploaded successfully
	               request.setAttribute("message", "File Uploaded Successfully");
	            } catch (Exception ex) {
	               request.setAttribute("message", "File Upload Failed due to " + ex);
	            }          
	        }else{
	            request.setAttribute("message",
	                                 "Sorry this Servlet only handles file upload request");
	        }
			
		}
		
        this.getServletContext().getRequestDispatcher( VUE_PROFIL ).forward( request, response );
		
	}
	/*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

}
