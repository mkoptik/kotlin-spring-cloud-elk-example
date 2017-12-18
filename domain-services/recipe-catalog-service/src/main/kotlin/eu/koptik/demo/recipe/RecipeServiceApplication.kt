package eu.koptik.demo.recipe

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableResourceServer
class RecipeServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(RecipeServiceApplication::class.java)
}