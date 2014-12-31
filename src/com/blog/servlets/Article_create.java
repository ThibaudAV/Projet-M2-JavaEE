package com.blog.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.blog.dao.ArticleDAO;
import com.blog.dao.CategorieDAO;
import com.blog.dao.UtilisateurDAO;
import com.blog.model.Categorie;
import com.blog.model.Utilisateur;
import com.blog.model.Article;

/**
 * Servlet implementation class Article_create
 */
public class Article_create extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String path;
	
	public static final String VUE_SUCCES   = "/views/Article_my.jsp"; 
    public static final String VUE_FORM     = "/views/Article_create.jsp";
    
    public static final String CHAMP_TITRE = "title";
    public static final String CHAMP_CATEGORIE = "categorie";
    public static final String CHAMP_CORPS = "corps";
    public static final String CHAMP_IMAGE     = "image";
    
    public static final int TAILLE_TAMPON = 10240; // 10 ko
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Article_create() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig conf) throws ServletException {  
    	super.init(conf);
    	/* GET the real path of the application*/
    	path = conf.getServletContext().getRealPath("");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleDAO daoArt = new ArticleDAO();
	    
		// Récupération du contenu du champ titre de l'article 
	    String titre = request.getParameter( CHAMP_TITRE );
	    // Récupération du contenu du champ catégorie
	    String categorie = request.getParameter( CHAMP_CATEGORIE );
	    // Récupération du contenu du champ corps
	    String corps = request.getParameter( CHAMP_CORPS );
	    

	    // Les données reçues sont multipart, on doit donc utiliser la méthode
	    // getPart() pour traiter le champ d'envoi de fichiers.
	    Part part = request.getPart( CHAMP_IMAGE );
	        
	    /*
	     * Il faut déterminer s'il s'agit d'un champ classique 
	     * ou d'un champ de type fichier : on délègue cette opération 
	     * à la méthode utilitaire getNomFichier().
	     */
	    String nomFichier = getNomFichier( part );
	    
	    // Si le nom du fichier est bien spécifié...
	    if ( nomFichier != null && !nomFichier.isEmpty() ) { 
	        // Écriture du fichier sur le disque
	        String chemin = path+"\\static\\img\\articles\\";
	        ecrireFichier( part, nomFichier, chemin );
	    }
	    
	    // get current date
	    Date d = new Date();
	    
	    // set path for image
	    String img = "/static/img/articles/"+nomFichier;
	    
	    
	    
	    
	    // get categorie
	    CategorieDAO daoCat = new CategorieDAO();
	    Categorie selectCat = daoCat.readArticle(Integer.parseInt(categorie));
	    
	 // get Auteur
	    HttpSession session = request.getSession();
	    Utilisateur user = (Utilisateur) session.getAttribute("user");
	    Utilisateur auteur;
	    if (user != null){
	    	auteur = user;
	    	System.out.println("UserY : "+auteur.getPseudo());
	    } else{
	    	UtilisateurDAO daoUt = new UtilisateurDAO();
	    	auteur = daoUt.readUtilisateur(1);
	    	System.out.println("UserN : "+auteur.getPseudo());
	    }
	    
	    // construction de notre nouvel article et ajout à notre base
	    Article article = new Article(titre, corps, selectCat, img, auteur, d);
	    daoArt.createArticle(article);
	   
	    this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
	}
	    
	/* 
	 * Méthode utilitaire qui a pour unique but d'analyser l'en-tête "content-disposition",
	 * et de vérifier si le paramètre "filename"  y est présent. Si oui, alors le champ traité
	 * est de type File et la méthode retourne son nom, sinon il s'agit d'un champ de formulaire 
	 * classique et la méthode retourne null. 
	 */
	private static String getNomFichier( Part part ) {
	    /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
	    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	        /* Recherche de l'éventuelle présence du paramètre "filename". */
	        if ( contentDisposition.trim().startsWith("filename") ) {
	            /* Si "filename" est présent, alors renvoi de sa valeur, c'est-à-dire du nom de fichier (en enlevant les guillemets). */
	            return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	        }
	    }
	    /* Et pour terminer, si rien n'a été trouvé... */
	    return null;
	}
	
	/*
	 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
	 * sur le disque, dans le répertoire donné et avec le nom donné.
	 */
	private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	    /* Prépare les flux. */
	    BufferedInputStream entree = null;
	    BufferedOutputStream sortie = null;
	    try {
	        /* Ouvre les flux. */
	        entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
	        sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ),
	                TAILLE_TAMPON );
	        
	        //Lit le fichier reçu et écrit son contenu dans un fichier sur le disque.
	        byte[] tampon = new byte[TAILLE_TAMPON];
	        int longueur;
	        while ( ( longueur = entree.read( tampon ) ) > 0 ) {
	            sortie.write( tampon, 0, longueur );
	        }
	    } finally {
	        try {
	            sortie.close();
	        } catch ( IOException ignore ) {
	        }
	        try {
	            entree.close();
	        } catch ( IOException ignore ) {
	        }
	    }
	}

}
