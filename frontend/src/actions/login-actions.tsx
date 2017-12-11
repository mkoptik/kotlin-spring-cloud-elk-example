export const OPEN_LOGIN_DIALOG = "OPEN_LOGIN_DIALOG";

export interface OpenLoginDialogAction {
    type: typeof OPEN_LOGIN_DIALOG,
    open: boolean
}

export function openLoginDialog(open: boolean): OpenLoginDialogAction {
    return {
        type: OPEN_LOGIN_DIALOG,
        open
    }
}