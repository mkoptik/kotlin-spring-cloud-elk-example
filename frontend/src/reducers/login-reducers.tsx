
import {OPEN_LOGIN_DIALOG} from "../actions/login-actions";

export interface LoginState {
    loginDialogOpened: boolean
}

const loginStateInitial: LoginState = {
    loginDialogOpened: false
};

export function loginReducer(state: LoginState = loginStateInitial, action: any): LoginState {
    switch (action.type) {
        case OPEN_LOGIN_DIALOG:
            return Object.assign({}, state, { loginDialogOpened: action.open });
        default:
            return state;
    }
}