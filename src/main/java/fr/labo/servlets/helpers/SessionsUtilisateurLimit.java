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
			
			//System.out.println(lastAction);
			//System.out.println(currentTime);
			//System.out.println(difference);
			
			if (difference >= 1) {
				 throw new RuntimeException("L'utilisateur est inactif depuis plus d'une minute");
			}else {
				session.setAttribute("actionPerformed", currentTime);
			}
		}
		
		
	}
}
