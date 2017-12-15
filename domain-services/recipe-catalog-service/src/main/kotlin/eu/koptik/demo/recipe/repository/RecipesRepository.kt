package eu.koptik.demo.recipe.repository

import eu.koptik.demo.recipe.dto.RecipeDto

interface RecipesRepository {

    fun getFeaturedRecipes(): Collection<RecipeDto>

}