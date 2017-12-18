package eu.koptik.demo.recipe.repository.impl

import eu.koptik.demo.recipe.dto.RecipeDto
import eu.koptik.demo.recipe.repository.RecipesRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class RecipesRepositoryImpl: RecipesRepository {

    override fun getAllRecipes(): Collection<RecipeDto> = 1.rangeTo(200).map { RecipeDto(it, "Recipe " + it) }

    override fun getFeaturedRecipes(): Collection<RecipeDto> {
        val random = Random()
        return 1.rangeTo(10).map { getAllRecipes().elementAt(random.nextInt(200))  }
    }

    override fun getByIds(ids: Collection<Int>): Collection<RecipeDto> {
        return getFeaturedRecipes()
    }
}

