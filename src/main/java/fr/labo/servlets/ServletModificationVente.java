package fr.labo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletModificationVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletModificationVente() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		//Qd le user clique sur le boutton "modifier" depsui la JSP enchere
		
	}

}
