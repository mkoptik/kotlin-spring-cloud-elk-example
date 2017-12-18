package eu.koptik.demo.recipe.controller

import eu.koptik.demo.recipe.client.RecipeRecommendationFeignClient
import eu.koptik.demo.recipe.dto.HomeRecipesResponseDto
import eu.koptik.demo.recipe.repository.RecipesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/home")
class HomeController {

    @Autowired
    private lateinit var recipesRepository: RecipesRepository

    @Autowired
    private lateinit var recipeRecommendationFeignClient: RecipeRecommendationFeignClient

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun home(principal: Principal?): HomeRecipesResponseDto {
        if (principal != null) {
            val recommendedRecipeIds = recipeRecommendationFeignClient.getRecommendedRecipes()
            val recommendedRecipes = recipesRepository.getByIds(recommendedRecipeIds.asList())
        }
        return HomeRecipesResponseDto(
            featured = recipesRepository.getFeaturedRecipes()
        )
    }

}