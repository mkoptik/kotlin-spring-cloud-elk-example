import * as React from 'react';
import * as style from './style.css';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router';
import { RootState } from '../../reducers';
import {AppBar, Dialog, FlatButton, TextField} from "material-ui";
import {login, openLoginDialog} from "../../actions/login-actions";
import LoginDialog from "../../components/LoginDialog/index";

interface AppProps {
    onOpenLoginDialog: { (open: boolean): void }
    onSubmitLoginDialog: { (username: string, password: string): void }
    loginDialogOpened: boolean
}

@connect(mapStateToProps, mapDispatchToProps)
export class App extends React.Component<AppProps, {}> {

  render() {

    const loginButton = <FlatButton label="Login" onClick={e => this.props.onOpenLoginDialog(true)} />;

    return (
      <div className={style.normal}>
        <AppBar title="Spring Cloud Example Project | Perfect  Recipes" iconElementRight={loginButton} />
        <LoginDialog opened={this.props.loginDialogOpened}
                     onCancel={() => this.props.onOpenLoginDialog(false)}
                     onSubmit={this.props.onSubmitLoginDialog} />
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
      },
      onSubmitLoginDialog: function(username: string, password: string) {
          dispatch(login(username, password));
      }
    };
}
