import * as React from 'react';
import * as style from './style.css';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router';
import { RootState } from '../../reducers';
import {AppBar, Dialog, FlatButton, TextField} from "material-ui";

interface AppProps {

}

@connect(mapStateToProps, mapDispatchToProps)
export class App extends React.Component<AppProps, {}> {



  render() {
    const { children } = this.props;

    const loginButton = <FlatButton label="Login" onClick={e => alert("xxx")} />;

    const loginDialogActions = [
        <FlatButton label="Cancel" />,
        <FlatButton label="OK" primary={true} />
    ];

    return (
      <div className={style.normal}>
        <AppBar title="Spring Cloud Example Project | Perfect  Recipes" iconElementRight={loginButton} />
        <Dialog title="Login to Perfect Recipes" modal={true} open={true} contentStyle={{maxWidth: "400px"}} actions={loginDialogActions}>
            <TextField hintText="Your e-mail" fullWidth={true} value="" />
            <TextField hintText="Password" fullWidth={true} type="password" value="" />
        </Dialog>
      </div>
    );
  }
}

function mapStateToProps(state: RootState) {
  return {

  };
}

function mapDispatchToProps(dispatch) {
  return {

  };
}
