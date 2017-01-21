package org.formacio.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalcController {

	@RequestMapping(path="info")
	@ResponseBody
	public String info() {
		return "Calculadora online";
	}
}
