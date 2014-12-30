package com.blog.forms;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.blog.dao.UtilisateurDAO;
import com.blog.model.Utilisateur;


public final class InscriptionUtilisateurForm {
    private static final String CHAMP_PSEUDO       = "pseudoUser";
    private static final String CHAMP_PASSWORD   = "passwordUser";
    private static final String CHAMP_PASSWORD_CONFIRM   = "passwordUser_confirmation";
    private static final String CHAMP_EMAIL   = "emailUser";
    private static final String T_AND_C   = "t_and_c";
    private static final String CHAMP_SIGNATURE   = "signatureUser";

    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();

    private UtilisateurDAO utilisateurDAO;
    
    public InscriptionUtilisateurForm(UtilisateurDAO utilisateurDAO) {
    	this.utilisateurDAO = utilisateurDAO;
    }
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Utilisateur creerUtilisateur( HttpServletRequest request ) {
        String pseudo = getValeurChamp( request, CHAMP_PSEUDO );
        String password = getValeurChamp( request, CHAMP_PASSWORD );
        String passwordConfirm = getValeurChamp( request, CHAMP_PASSWORD_CONFIRM );
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String t_and_c = getValeurChamp( request, T_AND_C );
        String signature = getValeurChamp( request, CHAMP_SIGNATURE );

        Utilisateur utilisateur = new Utilisateur();

        try {
            validationPseudo( pseudo );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        utilisateur.setPseudo( pseudo );

        try {
            validationPassword( password ,passwordConfirm);
        } catch ( Exception e ) {
            setErreur( CHAMP_PASSWORD, e.getMessage() );
        }
        if(password != null || passwordConfirm != null){
            utilisateur.setPassword( password );
            
        }
//
//        utilisateur.setSignature(signature);

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );
        
        try {
            validationT_and_c( t_and_c );
        } catch ( Exception e ) {
            setErreur( T_AND_C, e.getMessage() );
        }
        utilisateur.setEmail( email );

        if ( erreurs.isEmpty() ) {
        	/* On créé l'utilisateur */
        	utilisateurDAO.createUtilisateur(utilisateur);
            resultat = "Succès de la création du client.";
        } else {
            resultat = "Échec de la création du client.";
        }

        return utilisateur;
    }

    private void validationPseudo( String pseudo ) throws Exception {
        if ( pseudo != null ) {
            if ( pseudo.length() < 2 ) {
                throw new Exception( "Le pseudo doit contenir au moins 2 caractères." );
            }
            /* Si le pseudo n'existe pas deja*/
            if (utilisateurDAO.isPseudoExist(pseudo) == true) {
            	throw new Exception( "Le pseudo est deja utilisé par un utilisateur" );
            }
        } else {
            throw new Exception( "Merci d'entrer un pseudo d'utilisateur." );
        }
    }

    private void validationPassword( String password , String passwordConfirm) throws Exception {
        if ( password == null || password.length() < 2 || passwordConfirm == null) {
            throw new Exception( "Le mot de passe d'utilisateur doit contenir au moins 2 caractères." );
        } else {
        	if(!password.equals(passwordConfirm)) {
                throw new Exception( passwordConfirm+"Le mot de passe de confirmation est différent du mot de passe saisi."+password );
        	}
        }
    }
    

    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    private void validationT_and_c( String t_and_c ) throws Exception {
        if ( t_and_c == null ) {
            throw new Exception( "Merci de lire et d'accepter les conditions d'utilisation." );
        }
    }
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
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