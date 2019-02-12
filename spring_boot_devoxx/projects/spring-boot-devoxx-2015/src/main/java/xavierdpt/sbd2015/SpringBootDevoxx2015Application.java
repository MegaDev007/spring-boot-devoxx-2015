package xavierdpt.sbd2015;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class SpringBootDevoxx2015Application {

	@Configuration
	static class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

		@Override
		@SuppressWarnings("deprecation")
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").roles("USER")
					.build();
			UserDetails hero = User.withDefaultPasswordEncoder().username("hero").password("hero").roles("USER", "HERO", "ADMIN")
					.build();
			auth.inMemoryAuthentication().withUser(user).withUser(hero);

		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDevoxx2015Application.class, args);
	}

}
