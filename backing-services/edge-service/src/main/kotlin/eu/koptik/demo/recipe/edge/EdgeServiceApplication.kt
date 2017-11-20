package eu.koptik.demo.recipe.edge

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
class EdgeServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(EdgeServiceApplication::class.java)
}