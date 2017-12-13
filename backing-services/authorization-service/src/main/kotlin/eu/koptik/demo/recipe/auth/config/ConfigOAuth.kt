package eu.koptik.demo.recipe.auth.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.ClassPathResource
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory


@Configuration
class ConfigOAuth : AuthorizationServerConfigurerAdapter() {

    override fun configure(server: AuthorizationServerSecurityConfigurer) {
        server.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()")
    }

    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.inMemory()
                .withClient("chiezoaTouT2quoo")
                .secret("bai4voroo5cahboVa0haeyenaxaexero")
                .scopes("COOKING-APP")
                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code")
                .autoApprove(true)
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer()).authenticationManager(authenticationManager)
    }

    @Autowired
    @Qualifier("authenticationManagerBean")
    private lateinit var authenticationManager: AuthenticationManager

    @Bean
    fun tokenStore(): TokenStore {
        return JwtTokenStore(jwtTokenEnhancer())
    }

    @Bean
    protected fun jwtTokenEnhancer(): JwtAccessTokenConverter {
        val keyStoreKeyFactory = KeyStoreKeyFactory(ClassPathResource("jwt.jks"), "changeMe".toCharArray())
        return JwtAccessTokenConverter().apply {
            setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"))
        }
    }

}