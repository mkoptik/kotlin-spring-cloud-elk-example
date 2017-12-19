package eu.koptik.demo.recipe.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.context.SecurityContextHolder
import feign.RequestInterceptor
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails


@Configuration
class FeignConfig {

    @Bean
    fun requestTokenBearerInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate ->
            val authentication = SecurityContextHolder.getContext().authentication
            val details = authentication.details as? OAuth2AuthenticationDetails
            if (details != null)
                requestTemplate.header("Authorization", "Bearer " + details.tokenValue)
        }
    }

}