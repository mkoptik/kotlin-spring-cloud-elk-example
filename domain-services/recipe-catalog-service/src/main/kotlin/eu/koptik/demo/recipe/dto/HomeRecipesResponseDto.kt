package eu.koptik.demo.recipe.dto

data class HomeRecipesResponseDto(
        val recommended: Collection<RecipeDto> = emptyList(),
        val featured: Collection<RecipeDto> = emptyList())