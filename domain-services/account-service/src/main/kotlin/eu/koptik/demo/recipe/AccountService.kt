package eu.koptik.demo.recipe

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class AccountService

fun main(args: Array<String>) {
    SpringApplication.run(AccountService::class.java)
}