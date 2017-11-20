package eu.koptik.demo.recipe.discovery

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class DiscoveryServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(DiscoveryServiceApplication::class.java)
}