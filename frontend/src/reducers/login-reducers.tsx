
import {
    OPEN_LOGIN_DIALOG, OpenLoginDialogAction, USER_LOGGED_IN, USER_LOGGED_OUT,
    UserLoggedInAction, UserLoggedOutAction
} from "../actions/login-actions";

export interface LoginState {
    loginDialogOpened: boolean
    loggedUsername: string
}

const loginStateInitial: LoginState = {
    loginDialogOpened: false,
    loggedUsername: null
};

type LoginActions = OpenLoginDialogAction | UserLoggedInAction | UserLoggedOutAction
export function loginReducer(state: LoginState = loginStateInitial, action: LoginActions): LoginState {
    switch (action.type) {
        case OPEN_LOGIN_DIALOG:
            return Object.assign({}, state, { loginDialogOpened: action.open });
        case USER_LOGGED_IN:
            return Object.assign({}, state, { loggedUsername: action.username, loginDialogOpened: false });
        case USER_LOGGED_OUT:
            return Object.assign({}, state, { loggedUsername: null });
        default:
            return state;
    }
}