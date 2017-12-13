package eu.koptik.demo.recipe.controller

import eu.koptik.demo.recipe.dto.HomeRecipesResponseDto
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun home(): HomeRecipesResponseDto {
        return HomeRecipesResponseDto()
    }

}