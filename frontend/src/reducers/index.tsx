import { combineReducers, Reducer } from 'redux';
import {loginReducer, LoginState} from "./login-reducers";

export interface RootState {
    login: LoginState
}

export default combineReducers<RootState>({
    login: loginReducer
});