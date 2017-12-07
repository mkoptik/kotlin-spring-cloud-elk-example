package eu.koptik.demo.recipe

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.feign.EnableFeignClients

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
class RecipeRecommendationService

fun main(args: Array<String>) {
    SpringApplication.run(RecipeRecommendationService::class.java)
}