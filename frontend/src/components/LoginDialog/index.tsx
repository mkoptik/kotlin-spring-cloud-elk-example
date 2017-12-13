
import * as React from "react";
import {Dialog, FlatButton, TextField} from "material-ui";

interface LoginDialogProperties {
    opened: boolean,
    onCancel: { (): void },
    onSubmit: { (username: string, password: string): void }
}

export default class LoginDialog extends React.Component<LoginDialogProperties, {}> {

    private loginEmail: string = "";
    private loginPassword: string = "";

    onSubmit() {
        if (!this.loginPassword || !this.loginEmail)
            return;
        else
            this.props.onSubmit(this.loginEmail, this.loginPassword);
    }

    render() {

        const loginDialogActions = [
            <FlatButton label="Cancel" onClick={e => this.props.onCancel()} />,
            <FlatButton label="OK" primary={true} onClick={e => this.onSubmit()} />
        ];

        return <Dialog title="Login to Perfect Recipes" modal={true} open={this.props.opened} contentStyle={{maxWidth: "400px"}} actions={loginDialogActions}>
            <TextField hintText="Your e-mail" fullWidth={true} onChange={e => this.loginEmail = (e.target as HTMLInputElement).value} />
            <TextField hintText="Password" fullWidth={true} type="password" onChange={e => this.loginPassword = (e.target as HTMLInputElement).value} />
        </Dialog>
    }

}