
import * as React from "react";
import {Recipe} from "../../model/Recipe";
import {Paper} from "material-ui";

interface RecipeBoxProps {
    recipe: Recipe
}

export default class RecipeBox extends React.Component<RecipeBoxProps, {}> {

    render() {
        return <div key={this.props.recipe.id} style={{display: "inline-box", width: 150, height: 150, float: "left", margin: 15}}>
            <Paper style={{width: "100%", height: "100%"}}>
                {this.props.recipe.title}
            </Paper>
        </div>
    }

}