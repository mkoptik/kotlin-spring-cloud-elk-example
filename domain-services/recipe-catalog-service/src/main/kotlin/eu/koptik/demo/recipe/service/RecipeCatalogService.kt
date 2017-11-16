package eu.koptik.demo.recipe.service

import eu.koptik.demo.recipe.entity.Recipe
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RecipeCatalogService {

    @RequestMapping("/catalog/list")
    fun list(): Collection<Recipe> = listOf(
        Recipe("Pho Bo"),
        Recipe("Chicken Kung-Pao"),
        Recipe("Beef burger")
    )

}