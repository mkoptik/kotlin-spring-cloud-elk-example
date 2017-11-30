package eu.koptik.demo.recipe.auth.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class ConfigSecurity : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication().withUser("chef@cookmasters").password("cooking").roles("USER")
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/css/**").permitAll()
                .and()
                .formLogin().loginPage("/login").usernameParameter("email").passwordParameter("password") .permitAll()
                .and()
                .logout().permitAll()
                .and().csrf().disable()
    }

}