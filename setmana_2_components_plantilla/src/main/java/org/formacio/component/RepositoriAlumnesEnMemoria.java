package org.formacio.component;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoriAlumnesEnMemoria implements RepositoriAlumnes {

	@Override
	public List<String> getAlumnesPercurs(String curs) {
		return Arrays.asList("Antonia","Joan","Aina");
	}

	@Override
	public String toString() {
		return "Repositori d'alumnes que empra dades fitxes en memoria";
	}

	
	
}
