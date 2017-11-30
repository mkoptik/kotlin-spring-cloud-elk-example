package eu.koptik.demo.recipe.auth.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class LoginController {

    @RequestMapping("/login", method = arrayOf(RequestMethod.GET))
    fun login() = "templates/login.html"

}