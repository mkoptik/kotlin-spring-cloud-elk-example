import * as React from 'react';
import * as style from './style.css';
import { connect } from 'react-redux';
import { RouteComponentProps } from 'react-router';
import { RootState } from '../../reducers';

export namespace App {
  export interface Props extends RouteComponentProps<void> {

  }

  export interface State {

  }
}

@connect(mapStateToProps, mapDispatchToProps)
export class App extends React.Component<App.Props, App.State> {

  render() {
    const { children } = this.props;
    return (
      <div className={style.normal}>Hello from App</div>
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
