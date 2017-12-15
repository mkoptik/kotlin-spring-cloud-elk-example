package eu.koptik.demo.recipe.repository.impl

import eu.koptik.demo.recipe.dto.RecipeDto
import eu.koptik.demo.recipe.repository.RecipesRepository
import org.springframework.stereotype.Component

@Component
class RecipesRepositoryImpl: RecipesRepository {
    override fun getFeaturedRecipes(): Collection<RecipeDto> = listOf(
        RecipeDto(id = 1, title = "Recipe 1", imageUrl = "imageUrl"),
        RecipeDto(id = 2, title = "Recipe 2", imageUrl = "imageUrl"),
        RecipeDto(id = 3, title = "Recipe 3", imageUrl = "imageUrl"),
        RecipeDto(id = 4, title = "Recipe 4", imageUrl = "imageUrl"),
        RecipeDto(id = 5, title = "Recipe 5", imageUrl = "imageUrl"),
        RecipeDto(id = 6, title = "Recipe 6", imageUrl = "imageUrl"),
        RecipeDto(id = 7, title = "Recipe 7", imageUrl = "imageUrl"),
        RecipeDto(id = 8, title = "Recipe 8", imageUrl = "imageUrl")
    )
}