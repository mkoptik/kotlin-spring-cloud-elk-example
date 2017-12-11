import * as React from 'react';
import * as style from './style.css';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router';
import { RootState } from '../../reducers';
import {AppBar, Dialog, FlatButton, TextField} from "material-ui";
import {openLoginDialog} from "../../actions/login-actions";

interface AppProps {
    onOpenLoginDialog: { (open: boolean): void }
    loginDialogOpened: boolean
}

@connect(mapStateToProps, mapDispatchToProps)
export class App extends React.Component<AppProps, {}> {

  render() {

    const loginButton = <FlatButton label="Login" onClick={e => this.props.onOpenLoginDialog(true)} />;

    const loginDialogActions = [
        <FlatButton label="Cancel" onClick={e => this.props.onOpenLoginDialog(false)} />,
        <FlatButton label="OK" primary={true} />
    ];

    return (
      <div className={style.normal}>
        <AppBar title="Spring Cloud Example Project | Perfect  Recipes" iconElementRight={loginButton} />
        <Dialog title="Login to Perfect Recipes" modal={true} open={this.props.loginDialogOpened} contentStyle={{maxWidth: "400px"}} actions={loginDialogActions}>
            <TextField hintText="Your e-mail" fullWidth={true} value="" />
            <TextField hintText="Password" fullWidth={true} type="password" value="" />
        </Dialog>
      </div>
    );
  }
}

function mapStateToProps(state: RootState) {
  return {
    loginDialogOpened: state.login.loginDialogOpened
  };
}

function mapDispatchToProps(dispatch) {
  return {
      onOpenLoginDialog: function(open: boolean) {
          dispatch(openLoginDialog(open));
      }
    };
}
