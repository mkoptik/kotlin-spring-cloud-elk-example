package eu.koptik.demo.recipe.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.util.FileCopyUtils

@Configuration
class ConfigJwt {

    @Autowired
    lateinit var jwtAccessTokenConverter: JwtAccessTokenConverter

    @Bean
    @Qualifier("tokenStore")
    fun tokenStore(): TokenStore {
        return JwtTokenStore(jwtAccessTokenConverter)
    }

    @Bean
    protected fun jwtTokenEnhancer(): JwtAccessTokenConverter {
        val resource = ClassPathResource("jwt-public.cert")
        val publicKey = String(FileCopyUtils.copyToByteArray(resource.inputStream))
        return JwtAccessTokenConverter().apply {
            setVerifierKey(publicKey)
        }
    }

}