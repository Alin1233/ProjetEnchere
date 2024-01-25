package fr.labo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import fr.labo.bo.Utilisateur;

@WebServlet("/ServletUploadImage")
@MultipartConfig
public class ServletUploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Repertoire de sauvegarde de l'image
	public static final String IMAGES_FOLDER = "/images";
	public String uploadPath;

	//Création du dossier image s'il n'existe pas 
	 @Override
    public void init() throws ServletException {
	        uploadPath = getServletContext().getRealPath(IMAGES_FOLDER);
	        
	        File uploadDir = new File( uploadPath );
	        if ( ! uploadDir.exists() ) {
	        	uploadDir.mkdir();
	        }
	        
	    }
	
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("nouvelleVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
	   
	    	Part part = request.getPart("image");
	    	if(part.getSize() == 0) {
	    		request.setAttribute("error", "Veuillez inserer une image");
	    		request.getRequestDispatcher("nouvelleVente.jsp").forward(request, response);
	    	}
            String fileName = utilisateur.getPseudo() + "_" + part.getSubmittedFileName();
            String fullPath = uploadPath + File.separator + fileName;
            part.write( fullPath );
            

            request.setAttribute("imageName", fileName);
            session.setAttribute("imagePath", fullPath);
            request.getRequestDispatcher("ServletAccesNouvelleVente").forward(request, response);
        
	}

}
