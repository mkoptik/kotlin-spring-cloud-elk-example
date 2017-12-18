import {ThunkAction} from "redux-thunk";
import {RootState} from "../reducers/index";
import Axios, {AxiosRequestConfig} from "axios";
import {AccessTokenResponse} from "../model/AccessTokenResponse";
import {UserInfo} from "../model/UserInfo";
import {fetchHomePageRecipes} from "./recipe-actions";

export const OPEN_LOGIN_DIALOG = "OPEN_LOGIN_DIALOG";
export const USER_LOGGED_IN = "USER_LOGGED_IN";
export const USER_LOGGED_OUT = "USER_LOGGED_OUT";

export interface OpenLoginDialogAction {
    type: typeof OPEN_LOGIN_DIALOG,
    open: boolean
}

export interface UserLoggedInAction {
    type: typeof USER_LOGGED_IN
    username: string
}

export interface UserLoggedOutAction {
    type: typeof USER_LOGGED_OUT
}

export const openLoginDialog = (open: boolean): OpenLoginDialogAction => ({
    type: OPEN_LOGIN_DIALOG,
    open
});

export const login = (username: string, password: string): ThunkAction<void, RootState, void> => dispatch => {
    const config: AxiosRequestConfig = {
        headers: {
            'content-type': 'application/x-www-form-urlencoded'
        },
        params: {
            grant_type: "password",
            client_id: "chiezoaTouT2quoo",
            client_secret: "bai4voroo5cahboVa0haeyenaxaexero",
            username,
            password
        }
    };

    Axios.post<AccessTokenResponse>("/uaa/oauth/token",  {}, config).then(response => {
        Axios.defaults.headers.common['Authorization'] = `Bearer ${response.data.access_token}`;
        return Axios.get<UserInfo>("/account/me")
    }).then(response => {
        const action: UserLoggedInAction = {
            type: USER_LOGGED_IN,
            username: response.data.username
        };
        dispatch(action)
        dispatch(fetchHomePageRecipes())
    }).catch(error => {
        alert(error)
    })
};