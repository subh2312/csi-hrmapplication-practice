import React, { Component } from "react";
import LoginController from "./LoginController";

export default class HeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  render() {
    return (
      <header className="Header">
        <h1 className="align-text-cennter">HRM APP</h1>
        <div>
          <nav className="navbar navbar-expand-md navbar-dark bg-dark">
            <div>
              <a
                href="https://github.com/subh2312/hrmapplication"
                className="navbar-brand"
              >
                Github
              </a>
              <a
                href="http://localhost:8080/swagger-ui.html"
                className="navbar-brand"
              >
                Swagger-Playground
              </a>
            </div>
            <div>
              <a href="http://localhost:3000/" className="navbar-brand">
                Log out
              </a>
            </div>
          </nav>
        </div>
      </header>
    );
  }
}
