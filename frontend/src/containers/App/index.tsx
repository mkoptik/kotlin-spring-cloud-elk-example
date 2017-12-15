import * as React from 'react';
import * as style from './style.css';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router';
import { RootState } from '../../reducers';
import {AppBar, Dialog, FlatButton, IconMenu, MenuItem, TextField} from "material-ui";
import {login, openLoginDialog} from "../../actions/login-actions";
import LoginDialog from "../../components/LoginDialog/index";
import {fetchHomePageRecipes} from "../../actions/recipe-actions";
import {Recipe} from "../../model/Recipe";
import RecipeBox from "../../components/RecipeBox/index";

interface AppProps {
    onOpenLoginDialog: { (open: boolean): void }
    onSubmitLoginDialog: { (username: string, password: string): void }
    onFetchRecipes: { (): void }
    loginDialogOpened: boolean,
    loggedUsername: string,
    featuredRecipes: Recipe[],
    recommendedRecipes: Recipe[]
}

@connect(mapStateToProps, mapDispatchToProps)
export class App extends React.Component<AppProps, {}> {

    componentDidMount() {
        this.props.onFetchRecipes();
    }

    render() {

        let appBarRightElement = null;
        if (this.props.loggedUsername) {
            appBarRightElement = <FlatButton label={this.props.loggedUsername} />
        } else {
            appBarRightElement = <FlatButton label="Login" onClick={e => this.props.onOpenLoginDialog(true)}/>
        }

        return (
            <div className={style.normal}>
                <AppBar title="Spring Cloud Example Project | Perfect  Recipes" iconElementRight={appBarRightElement}/>
                <LoginDialog opened={this.props.loginDialogOpened}
                             onCancel={() => this.props.onOpenLoginDialog(false)}
                             onSubmit={this.props.onSubmitLoginDialog} />
                <div>{this.props.featuredRecipes.map(r => <RecipeBox key={r.id} recipe={r} />)}</div>
            </div>
        );
    }
}

function mapStateToProps(state: RootState) {
    return {
        loginDialogOpened: state.login.loginDialogOpened,
        loggedUsername: state.login.loggedUsername,
        featuredRecipes: state.homeRecipes.featured,
        recommendedRecipes: state.homeRecipes.recommended
    };
}

function mapDispatchToProps(dispatch) {
  return {
      onOpenLoginDialog: function(open: boolean) {
          dispatch(openLoginDialog(open));
      },
      onSubmitLoginDialog: function(username: string, password: string) {
          dispatch(login(username, password));
      },
      onFetchRecipes: function() {
          dispatch(fetchHomePageRecipes())
      }
    };
}
