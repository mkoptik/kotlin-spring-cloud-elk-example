package eu.koptik.demo.recipe.controller

import eu.koptik.demo.recipe.dto.UserInfoDto
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/me")
class MeController {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun me(principal: Principal) = UserInfoDto(username = principal.name)

}