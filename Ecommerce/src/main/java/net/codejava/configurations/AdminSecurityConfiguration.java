package net.codejava.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

import net.codejava.services.AccountService;

@Configuration
@EnableWebSecurity
@Order(2)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private AccountService accountService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.antMatcher("/admin/**")
			.authorizeRequests()
			.antMatchers("/admin/**")
			.access("hasRole('ROLE_ADMIN')")
			.and()
			.formLogin()
			.loginPage("/admin-panel")
			.loginProcessingUrl("/admin/process-login")
			.defaultSuccessUrl("/admin-panel/welcome")
			.failureUrl("/admin-panel/login?error")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout()
			.logoutUrl("/admin-panel/logout")
			.logoutSuccessUrl("/admin-panel/login?logout")
			.deleteCookies("JSESSIONID")
			.and()
			.exceptionHandling()
			.accessDeniedPage("/admin-panel/accessDenied");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(accountService);
	}

	@Bean
	public BCryptPasswordEncoder encoder(){
		
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityContextHolderAwareRequestFilter awareRequestFilter() {
		return new SecurityContextHolderAwareRequestFilter();
	}

	@Bean
	public SecurityContextPersistenceFilter persistenceFilter() {
		return new SecurityContextPersistenceFilter();
	}

}
