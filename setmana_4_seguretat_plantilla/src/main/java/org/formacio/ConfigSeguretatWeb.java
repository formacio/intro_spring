package org.formacio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Classe de configuracio especifica per els aspectes de seguretat.
 * 
 * @EnableWebSecurity fa que Spring afegeixi la configuracio de seguretat en el moment de crear l'aplicacio web
 * 
 * Extendre WebSecurityConfigurerAdapter ens, per exemple, permet actuar sobre l'objecte HttpSecurity (parametre del metode
 * configure), definint quines URLs volem protegir i de quina manera.
 */
@Configuration
@EnableWebSecurity
public class ConfigSeguretatWeb extends WebSecurityConfigurerAdapter {

	/**
	 * Configura la seguretat HTTP en dos aspectes:
	 *  - quin rol exigim per accedir a cada URL
	 *  - quin mecanisme d'autanticacio emprem. Es a dir, com recollim les credencials de l'usuari
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()  // passam a detallar quines urls protegirem i com
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/gestio/**").hasAnyRole("ADMIN","GESTOR")
                .and()
            .httpBasic()  // autanticacio via BASIC (pop up del navegador). Podria ser una altra, p.e. plana de login.
            .and()
               // Per defecte, el logout nomes es fa amb peticions POST. Si volem que tambe accepti peticions
               // GET hem d'afegir el logoutRequestMatcher.
               // En fer el logout, anira a la pagina /public.txt
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/public.txt")
               .deleteCookies("JSESSIONID")
               .invalidateHttpSession(true)
            ;
    }
	
    @Autowired
    public void configuracioGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("gestor").password("gestor").roles("GESTOR").and()
                .withUser("admin").password("admin").roles("ADMIN");
    }

}
