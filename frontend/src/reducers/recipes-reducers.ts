
import {Recipe} from "../model/Recipe";
import {FETCH_HOMEPAGE_RECIPES, FetchHomePageRecipesAction} from "../actions/recipe-actions";

export interface HomeRecipesState {
    featured: Recipe[],
    recommended: Recipe[]
}

const homeRecipesStateInitial: HomeRecipesState = {
    featured: [],
    recommended: []
};

type RecipeActions = FetchHomePageRecipesAction;

export function recipesReducer(state: HomeRecipesState = homeRecipesStateInitial, action: RecipeActions) {
    switch (action.type) {
        case FETCH_HOMEPAGE_RECIPES:
            return Object.assign({}, state, {
                featured: action.featured,
                recommended: action.recommended
            });
        default:
            return state;
    }
}