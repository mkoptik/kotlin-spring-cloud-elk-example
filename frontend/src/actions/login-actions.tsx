import {ThunkAction} from "redux-thunk";
import {RootState} from "../reducers/index";
import Axios, {AxiosRequestConfig} from "axios";
import {AccessTokenResponse} from "../model/AccessTokenResponse";

export const OPEN_LOGIN_DIALOG = "OPEN_LOGIN_DIALOG";

export interface OpenLoginDialogAction {
    type: typeof OPEN_LOGIN_DIALOG,
    open: boolean
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
        alert(response.data.access_token);
        // TODO: GET USER INFO HERE
    }).catch(error => {
        alert(error)
    })
};