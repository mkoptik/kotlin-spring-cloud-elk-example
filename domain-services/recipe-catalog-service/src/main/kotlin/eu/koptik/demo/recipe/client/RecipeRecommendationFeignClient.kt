package eu.koptik.demo.recipe.client

import eu.koptik.demo.recipe.config.FeignConfig
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("recipe-recommendation", configuration = arrayOf(FeignConfig::class))
interface RecipeRecommendationFeignClient {

    @RequestMapping("/recommended-recipe-ids", method = arrayOf(RequestMethod.GET))
    fun getRecommendedRecipes(): Array<Int>

}