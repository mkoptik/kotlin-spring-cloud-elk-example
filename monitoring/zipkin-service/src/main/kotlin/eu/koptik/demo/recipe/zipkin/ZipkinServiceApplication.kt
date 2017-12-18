package eu.koptik.demo.recipe.zipkin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import zipkin.server.EnableZipkinServer

@SpringBootApplication
@EnableZipkinServer
class ZipkinServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(ZipkinServiceApplication::class.java)
}