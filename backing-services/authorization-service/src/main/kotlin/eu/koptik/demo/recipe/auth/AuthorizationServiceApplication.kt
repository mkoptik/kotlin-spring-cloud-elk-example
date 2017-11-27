package eu.koptik.demo.recipe.auth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer

@SpringBootApplication
@EnableAuthorizationServer
class AuthorizationServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(AuthorizationServiceApplication::class.java)
}