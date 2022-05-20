package jmaster.io.demospringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
http.authorizeRequests().antMatchers("/department/**").hasRole("ADMIN").antMatchers("/ticket/**").authenticated().anyRequest().permitAll().and().formLogin();
//hasRole da bao ham authenticated nen no khong can authen, o vidu tren hasRole = authen + quyen admin moi vao dc
}
}
