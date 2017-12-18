package eu.koptik.demo.recipe.repository

import eu.koptik.demo.recipe.dto.RecipeDto

interface RecipesRepository {

    fun getFeaturedRecipes(): Collection<RecipeDto>

    fun getAllRecipes(): Collection<RecipeDto>

    fun getByIds(ids: Collection<Int>): Collection<RecipeDto>

}