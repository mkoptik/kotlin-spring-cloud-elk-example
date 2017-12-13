package eu.koptik.demo.recipe.dto

import java.util.*


data class HomeRecipesResponseDto(
    val recommended: Array<RecipeDto> = emptyArray(),
    val featured: Array<RecipeDto> = emptyArray()) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HomeRecipesResponseDto

        if (!Arrays.equals(recommended, other.recommended)) return false
        if (!Arrays.equals(featured, other.featured)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Arrays.hashCode(recommended)
        result = 31 * result + Arrays.hashCode(featured)
        return result
    }
}