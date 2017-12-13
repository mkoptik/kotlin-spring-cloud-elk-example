package eu.koptik.demo.recipe.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore

@Configuration
@EnableResourceServer
class ConfigResourceServer: ResourceServerConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/**").authenticated()
                .and()
                .csrf().disable()

    }

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.resourceId("COOKING-APP").tokenStore(tokenStore)
    }

    @Autowired
    lateinit var tokenStore: TokenStore

}