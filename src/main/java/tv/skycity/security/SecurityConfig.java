package tv.skycity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                    .password(new BCryptPasswordEncoder().encode("admin"))
                    .roles("Staff");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()// disable this because login modal is ajax post
            .authorizeRequests()
                .antMatchers("/backend/data")
                    .hasRole("Staff")
                .antMatchers("/","/**").permitAll()

            .and()
                .formLogin()
                .loginPage("/backend")
                .loginProcessingUrl("/backend")
                .defaultSuccessUrl("/backend/data")

            .and()
                .logout()
                    .logoutSuccessUrl("/index");
    }
}
