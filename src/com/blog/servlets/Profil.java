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
		
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		
		if(user == null) {
	        this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
		}
		
		request.setAttribute("user", user);
		
		
        this.getServletContext().getRequestDispatcher( VUE_PROFIL ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		// si l'utilisateur est connecté 
		if(user == null) {
	        this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
		}

		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		
		if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);


                	FileItem item = multiparts.get(0);
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
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        this.getServletContext().getRequestDispatcher( VUE_PROFIL ).forward( request, response );
		
	}

}
