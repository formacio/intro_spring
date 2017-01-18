package org.formacio;

import org.formacio.component.Utilitat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ComponentsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ComponentsApplication.class, args);
		
		Utilitat util = ctx.getBean(Utilitat.class);
		
		System.out.println(util.infoCurs("Introducció a Spring"));
		
		ctx.close();
	}
}
