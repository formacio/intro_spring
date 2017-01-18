package org.formacio.mvc;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@RequestMapping(path="/public.txt")
	public String infoGeneral() {
		return "Aixo es un exemple de pagina publica";
	}
	
	@RequestMapping(path="/admin/info.txt")
	public String infoAdmin() {
		return "Aixo nomes ho ha de veure un administrador";
	}
	
	/**
	 * Declarant un parametre anotat amb @AuthenticationPrincipal podem tenir acces
	 * a les dades de l'usuari que fa la peticio.
	 * 
	 * Serviria, per exemple, per poder fer una accio o una altra en funcio de les caracteristiques
	 * d'aquest usuari.
	 */
	@RequestMapping(path="/gestio/user.txt")
	public String infoGestors(@AuthenticationPrincipal User user) {
		
		// Un cas tipic seria retornar les dades de l'usuari que s'ha conectat
		// servei.consultaDades(user.getUsername());
		
		return "Hola " + user.getUsername() + ", estas a la part de gestio";
	}
	
}
