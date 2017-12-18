package eu.koptik.demo.recipe.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("recipe-recommendation")
interface RecipeRecommendationFeignClient {

    @RequestMapping("/recommended-recipe-ids", method = arrayOf(RequestMethod.GET))
    fun getRecommendedRecipes(): Array<Int>

}