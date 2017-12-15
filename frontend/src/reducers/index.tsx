import { combineReducers, Reducer } from 'redux';
import {loginReducer, LoginState} from "./login-reducers";
import {HomeRecipesState, recipesReducer} from "./recipes-reducers";

export interface RootState {
    login: LoginState,
    homeRecipes: HomeRecipesState
}

export default combineReducers<RootState>({
    login: loginReducer,
    homeRecipes: recipesReducer
});