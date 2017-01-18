package org.formacio.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utilitat {
	
	@Autowired
	private RepositoriAlumnes repositori;

	@PostConstruct
	public void init() {
		System.out.println("inialitzat amb repositori " + repositori);
	}

	public String infoCurs( String curs ) {
		return curs +  ": Hi ha  " + repositori.getAlumnesPercurs(curs).size() + " alumnes";
	}
}
