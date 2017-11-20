package eu.koptik.demo.recipe.config

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class ConfigServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(ConfigServiceApplication::class.java)
}