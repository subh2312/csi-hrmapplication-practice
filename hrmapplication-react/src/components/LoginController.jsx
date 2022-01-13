import React, { Component } from "react";
import EmployeeService from "../services/EmployeeService";

export default class LoginController extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employee: [],
      employeeEmailId: "",
      employeePassword: "",
    };

    this.signInEmployeeEmailIdHandler =
      this.signInEmployeeEmailIdHandler.bind(this);
    this.signInEmployeePasswordHandler =
      this.signInEmployeePasswordHandler.bind(this);
    this.signIn = this.signIn.bind(this);
    this.requestAccess = this.requestAccess.bind(this);
  }

  signInEmployeeEmailIdHandler = (event) => {
    this.setState({ employeeEmailId: event.target.value });
  };
  signInEmployeePasswordHandler = (event) => {
    this.setState({ employeePassword: event.target.value });
  };
  signIn = (e) => {
    e.preventDefault();
    EmployeeService.signIn(
      this.state.employeeEmailId,
      this.state.employeePassword
    )
      .then((res) => {
        console.log("res value--->>" + res);
        this.props.history.push("/welcome");
      })
      .catch((error) => {
        console.log("Invalid credentials");
      });
  };
  requestAccess = (event) => {
    this.props.history.push("/");
  };

  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              <h3 className="text-center">Sign Up</h3>
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label>Email ID:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeEmailId}
                      onChange={this.signInEmployeeEmailIdHandler}
                    />
                    <label>Password</label>
                    <input
                      className="form-control"
                      value={this.state.employeePassword}
                      onChange={this.signInEmployeePasswordHandler}
                    />

                    <button className="btn btn-success" onClick={this.signIn}>
                      Sign In
                    </button>
                    <button
                      className="btn btn-danger"
                      onClick={this.requestAccess}
                    >
                      Forgot Password/Request Access
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
