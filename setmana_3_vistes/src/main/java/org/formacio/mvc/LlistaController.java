package org.formacio.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LlistaController {

	@RequestMapping(path="/llista")
	public String estat (Model model) {
		model.addAttribute("nom", "Llista de noms");
		return "llista";
	}
}
