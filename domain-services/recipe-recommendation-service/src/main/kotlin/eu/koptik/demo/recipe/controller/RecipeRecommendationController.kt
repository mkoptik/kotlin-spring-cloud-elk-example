package eu.koptik.demo.recipe.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RecipeRecommendationController {

    @RequestMapping("/recommended-recipe-ids", method = arrayOf(RequestMethod.GET))
    fun getRecommendedRecipes(): Array<Int> = arrayOf(500, 6547, 4512, 7845, 6523)

}