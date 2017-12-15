package eu.koptik.demo.recipe.controller

import eu.koptik.demo.recipe.dto.HomeRecipesResponseDto
import eu.koptik.demo.recipe.repository.RecipesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/home")
class HomeController {

    @Autowired
    private lateinit var recipesRepository: RecipesRepository

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun home(): HomeRecipesResponseDto {
        return HomeRecipesResponseDto(
            featured = recipesRepository.getFeaturedRecipes()
        )
    }

}