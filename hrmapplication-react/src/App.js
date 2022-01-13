import "./App.css";
import HeaderComponent from "./components/HeaderComponent";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import FooterComponent from "./components/FooterComponent";
import SignUpComponent from "./components/SignUpComponent";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import LoginController from "./components/LoginController";
import UpdateEmployeeComponent from "./components/UpdateEmployeeComponent";
import DeleteComponent from "./components/DeleteComponent";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" exact component={LoginController}></Route>
            <Route
              path="/welcome"
              exact
              component={ListEmployeeComponent}
            ></Route>
            <Route path="/signUp" component={SignUpComponent}></Route>
            <Route
              path="/update/:id"
              component={UpdateEmployeeComponent}
            ></Route>
            <Route path="/delete/:id" component={DeleteComponent}></Route>
          </Switch>
        </div>
        <FooterComponent />
      </BrowserRouter>
    </div>
  );
}

export default App;
