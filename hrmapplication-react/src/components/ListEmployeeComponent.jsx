import React, { Component } from "react";
import EmployeeService from "../services/EmployeeService";

export default class ListEmployeeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: [],
    };
    this.signUp = this.signUp.bind(this);
    this.editEmployee = this.editEmployee.bind(this);
  }

  editEmployee(id) {
    this.props.history.push(`/update/${id}`);
  }

  deleteEmployee(id) {
    this.props.history.push(`/delete/${id}`);
  }

  componentDidMount() {
    EmployeeService.getAllData().then((response) => {
      this.setState({ employees: response.data });
    });
  }

  signUp() {
    this.props.history.push("/signUp");
  }
  render() {
    return (
      <div>
        <h2 className="text-center">Employee List</h2>
        <div className="row">
          <button className="btn btn-primary" onClick={this.signUp}>
            Sign Up
          </button>
        </div>
        <div className="row">
          <table className="empTable table table-striped table-bordered">
            <thead classname="table-header">
              <tr className="column">
                <th>Employee Name</th>
                <th>Employee Code</th>
                <th>Employee Email Id</th>
                <th>Employee Contact No</th>
                <th>Actions</th>
              </tr>
            </thead>

            <tbody>
              {this.state.employees.map((employee) => (
                <tr key={employee.id}>
                  <td>{employee.employeeName}</td>
                  <td>{employee.employeeCode}</td>
                  <td>{employee.employeeEmailId}</td>
                  <td>{employee.employeeContactNumber}</td>
                  <td>
                    <button
                      onClick={() => this.editEmployee(employee.id)}
                      className="btn btn-info"
                    >
                      Update
                    </button>
                    <button
                      onClick={() => this.deleteEmployee(employee.id)}
                      className="btn btn-info"
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}
