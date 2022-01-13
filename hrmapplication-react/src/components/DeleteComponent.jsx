import React, { Component } from "react";
import EmployeeService from "../services/EmployeeService";

export default class DeleteComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeId: this.props.match.params.id,
    };

    this.delete = this.delete.bind(this);
    this.cancel = this.cancel.bind(this);
  }

  delete = (e) => {
    e.preventDefault();
    EmployeeService.delete(this.state.employeeId)
      .then((res) => {
        console.log("res value--->>" + res);
        this.props.history.push("/welcome");
      })
      .catch((error) => {
        console.log("error");
      });
  };
  cancel = (event) => {
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
                <h2> Would you like to Delete this Employee??</h2>
                <br />
                <button className="btn btn-success" onClick={this.delete}>
                  Delete
                </button>
                <button className="btn btn-danger" onClick={this.cancel}>
                  Cancel
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
