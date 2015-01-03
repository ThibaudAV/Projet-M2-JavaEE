package com.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.blog.dao.ArticleDAO;
import com.blog.dao.CategorieDAO;
import com.blog.model.Article;
import com.blog.model.Categorie;
import com.blog.model.Utilisateur;

/**
 * Servlet implementation class Article_create
 */
public class Article_create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String UPLOAD_DIRECTORY = "static"+File.separator+"img"+File.separator+"articles";
	
	public static final String VUE_SUCCES   = "/Article_my"; 
    public static final String VUE_FORM     = "/views/Article_create.jsp";
    
    public static final String CHAMP_TITRE = "title";
    public static final String CHAMP_CATEGORIE = "categorie";
    public static final String CHAMP_CORPS = "corps";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article_create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategorieDAO daoCat = new CategorieDAO();
		
		List<Categorie> list = daoCat.findAllCategories();
		request.setAttribute("list_cat", list);
		
		this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleDAO daoArt = new ArticleDAO();
	    
	    String titre = "";
	    String categorie = "";
	    String corps = "";
	    
	    // get Auteur
	    HttpSession session = request.getSession();
	    Utilisateur user = (Utilisateur) session.getAttribute("user");
	    Utilisateur auteur = null;
	    if (user != null){
	    	auteur = user;
	    	System.out.println("User : "+auteur.getPseudo());
	    } else{
	    	System.out.println("Pas d'utilisateur connecté...");
	    }
	    
	    // get image
	    String fileName = null;
	    
	    // récupération du fichier
	    if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);


            	FileItem item; 
            	for(int i = 0; i < multiparts.size(); i++){
            		item = multiparts.get(i);
            		if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        System.out.println("Name : "+name);
                        
                        if ( name != null && !name.isEmpty() ) { 
	                        // new file name
	                        fileName = auteur.getPseudo() + "_" + name;
	                        System.out.println("fileName : "+fileName);
	                        // le chemin du serveur + dossier articles + nouveau nom du fichier
	                        item.write( new File(getServletContext().getRealPath(File.separator)+ UPLOAD_DIRECTORY + File.separator + fileName));
                        }
            		} else {
            			System.out.println("FieldName : "+item.getFieldName());
            			if(item.getFieldName().equals(CHAMP_TITRE)){
            				// Récupération du contenu du champ titre de l'article 
                			titre = item.getString();
                			
            			}
            			if(item.getFieldName().equals(CHAMP_CATEGORIE)){
            				// Récupération du contenu du champ catégorie
            				categorie = item.getString();
                		    System.out.println("Cat : "+categorie);
            			}
            			if(item.getFieldName().equals(CHAMP_CORPS)){
            				// Récupération du contenu du champ corps 
            				corps = item.getString();
                		    System.out.println("Corps : "+corps);
            			}
            			
            		}
                }
            } catch (Exception ex) {
            	System.out.println("File Upload Failed due to " + ex);
            }          
        }else{
        	System.out.println("Sorry this Servlet only handles file upload request");
        }
	    
	    // get categorie
	    CategorieDAO daoCat = new CategorieDAO();
	    Categorie selectCat = daoCat.readCategorie(Integer.parseInt(categorie));
	    System.out.println("Objet Cat : "+selectCat.getNom());
	    
	    // get current date
	    Date d = new Date();
	    
	    // construction de notre nouvel article et ajout à notre base
	    Article article = new Article(titre, corps, selectCat, fileName, auteur, d);
	    daoArt.createArticle(article);
	   
	    this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	    
	}

}
