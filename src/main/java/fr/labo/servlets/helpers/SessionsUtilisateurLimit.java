package fr.labo.servlets.helpers;

import java.io.IOException;


import jakarta.servlet.http.HttpSession;

public class SessionsUtilisateurLimit {
	
	public static void checkLastAction(HttpSession session)throws IOException {
		
		Object lastActionObject = session.getAttribute("actionPerformed");
		
		if(lastActionObject instanceof Long) {
			
			Long lastAction = (long) lastActionObject;
			long currentTime = System.currentTimeMillis();
			long difference = (currentTime -lastAction) / (1000 * 60);
		
	
			if (difference >= 5) {
				 throw new RuntimeException("L'utilisateur est inactif depuis plus de 5 minutes");
			}else {
				session.setAttribute("actionPerformed", currentTime);
			}
		}
		
		
	}
}
