
import {Recipe} from "../model/Recipe";
import {FetchHomePageRecipesAction} from "../actions/recipe-actions";

export interface RecipesState {
    featured: Recipe[],
    recommended: Recipe[]
}

const recipesStateInitial: RecipesState = {
    featured: [],
    recommended: []
};

type RecipeActions = FetchHomePageRecipesAction;

export function recipesReducer(state: RecipesState = recipesStateInitial, action: RecipeActions) {
    switch (action.type) {
        default:
            return state;
    }
}