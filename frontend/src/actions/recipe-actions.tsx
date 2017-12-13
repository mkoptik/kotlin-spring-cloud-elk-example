import Axios, {AxiosRequestConfig} from "axios";
import {Recipe} from "../model/Recipe";
import {HomeRecipesResponse} from "../model/HomeRecipesResponse";
import {ThunkAction} from "redux-thunk";
import {RootState} from "../reducers/index";

export const FETCH_HOMEPAGE_RECIPES = "FETCH_HOMEPAGE_RECIPES";

export interface FetchHomePageRecipesAction {
    type: typeof FETCH_HOMEPAGE_RECIPES
    recommended: Recipe[],
    featured: Recipe[]
}

export const fetchHomePageRecipes = (): ThunkAction<void, RootState, void> => dispatch => {
    Axios.get<HomeRecipesResponse>("/recipe-catalog/home").then(response => {
        dispatch({
            type: FETCH_HOMEPAGE_RECIPES,
            recommended: response.data.recommended,
            featured: response.data.featured
        } as FetchHomePageRecipesAction)
    }).catch(error => {
        alert(error)
    })
};