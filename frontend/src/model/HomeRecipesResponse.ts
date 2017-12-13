import {Recipe} from "./Recipe";

export interface HomeRecipesResponse {
    recommended: Recipe[],
    featured: Recipe[]
}