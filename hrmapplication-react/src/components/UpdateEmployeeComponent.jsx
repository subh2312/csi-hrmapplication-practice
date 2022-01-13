import React, { Component } from "react";
import { findRenderedDOMComponentWithClass } from "react-dom/test-utils";
import EmployeeService from "../services/EmployeeService";
// import EmployeeService from "../services/EmployeeService";

export default class UpdateEmployeeComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employeeId: this.props.match.params.id,
      employeeCode: 0,
      employeeName: "",
      employeeContactNumber: 0,
      employeeCurrentAddress: "",
      employeePostalAddress: "",
      employeeUID: 0,
      employeePanCardNumber: "",
      employeeDOB: 12 - 12 - 1992,
      employeeJoiningDate: 12 - 12 - 1992,
      employeeLastWorkingDate: "",
      employeeGender: "",
      employeeEducationInstitueName: "",
      employeeHighestEducation: "",
      employeeEducationPassoutYear: 0,
      employeeHighestEducationMarks: 0.0,
      employeeParentName: "",
      employeeParentContactNumber: 0,
      employeeLastWithdrawnSalary: 0.0,
      employeeEmailId: "",
      employeePassword: "",
    };
    this.changeEmployeeCodeHandler = this.changeEmployeeCodeHandler.bind(this);
    this.changeEmployeeNameHandler = this.changeEmployeeNameHandler.bind(this);
    this.changeEmployeeContactNumberHandler =
      this.changeEmployeeContactNumberHandler.bind(this);
    this.changeEmployeeCurrentAddressHandler =
      this.changeEmployeeCurrentAddressHandler.bind(this);
    this.changeEmployeePostalAddressHandler =
      this.changeEmployeePostalAddressHandler.bind(this);
    this.changeEmployeeUIDHandler = this.changeEmployeeUIDHandler.bind(this);
    this.changeEmployeePanCardNumberHandler =
      this.changeEmployeePanCardNumberHandler.bind(this);
    this.changeEmployeeDOBHandler = this.changeEmployeeDOBHandler.bind(this);
    this.changeEmployeeJoiningDateHandler =
      this.changeEmployeeJoiningDateHandler.bind(this);
    this.changeEmployeeLastWorkingDateHandler =
      this.changeEmployeeLastWorkingDateHandler.bind(this);
    this.changeEmployeeGenderHandler =
      this.changeEmployeeGenderHandler.bind(this);
    this.changeEmployeeEducationInstitueNameHandler =
      this.changeEmployeeEducationInstitueNameHandler.bind(this);
    this.changeEmployeeHighestEducationHandler =
      this.changeEmployeeHighestEducationHandler.bind(this);
    this.changeEmployeeEducationPassoutYearHandler =
      this.changeEmployeeEducationPassoutYearHandler.bind(this);
    this.changeEmployeeHighestEducationMarksHandler =
      this.changeEmployeeHighestEducationMarksHandler.bind(this);
    this.changeEmployeeParentNameHandler =
      this.changeEmployeeParentNameHandler.bind(this);
    this.changeEmployeeParentContactNumberHandler =
      this.changeEmployeeParentContactNumberHandler.bind(this);
    this.changeEmployeeLastWithdrawnSalaryHandler =
      this.changeEmployeeLastWithdrawnSalaryHandler.bind(this);
    this.changeEmployeeEmailIdhandler =
      this.changeEmployeeEmailIdhandler.bind(this);
    this.changeEmployeePasswordHandler =
      this.changeEmployeePasswordHandler.bind(this);
    this.cancel = this.cancel.bind(this);
    this.update = this.update.bind(this);
  }

  changeEmployeeCodeHandler = (event) => {
    this.setState({ employeeCode: event.target.value });
  };
  changeEmployeeNameHandler = (event) => {
    this.setState({ employeeName: event.target.value });
  };
  changeEmployeeContactNumberHandler = (event) => {
    this.setState({ employeeContactNumber: event.target.value });
  };
  changeEmployeeCurrentAddressHandler = (event) => {
    this.setState({ employeeCurrentAddress: event.target.value });
  };
  changeEmployeePostalAddressHandler = (event) => {
    this.setState({ employeePostalAddress: event.target.value });
  };
  changeEmployeeUIDHandler = (event) => {
    this.setState({ employeeUID: event.target.value });
  };
  changeEmployeePanCardNumberHandler = (event) => {
    this.setState({ employeePanCardNumber: event.target.value });
  };
  changeEmployeeDOBHandler = (event) => {
    this.setState({ employeeDOB: event.target.value });
  };
  changeEmployeeJoiningDateHandler = (event) => {
    this.setState({ employeeJoiningDate: event.target.value });
  };
  changeEmployeeLastWorkingDateHandler = (event) => {
    this.setState({ employeeLastWorkingDate: event.target.value });
  };
  changeEmployeeGenderHandler = (event) => {
    this.setState({ employeeGender: event.target.value });
  };
  changeEmployeeEducationInstitueNameHandler = (event) => {
    this.setState({ employeeEducationInstitueName: event.target.value });
  };
  changeEmployeeHighestEducationHandler = (event) => {
    this.setState({ employeeHighestEducation: event.target.value });
  };
  changeEmployeeEducationPassoutYearHandler = (event) => {
    this.setState({ employeeEducationPassoutYear: event.target.value });
  };
  changeEmployeeHighestEducationMarksHandler = (event) => {
    this.setState({ employeeHighestEducationMarks: event.target.value });
  };
  changeEmployeeParentNameHandler = (event) => {
    this.setState({ employeeParentName: event.target.value });
  };
  changeEmployeeParentContactNumberHandler = (event) => {
    this.setState({ employeeParentContactNumber: event.target.value });
  };
  changeEmployeeLastWithdrawnSalaryHandler = (event) => {
    this.setState({ employeeLastWithdrawnSalary: event.target.value });
  };
  changeEmployeeEmailIdhandler = (event) => {
    this.setState({ employeeEmailId: event.target.value });
  };
  changeEmployeePasswordHandler = (event) => {
    this.setState({ employeePassword: event.target.value });
  };

  componentDidMount() {
    EmployeeService.getEmployeeById(this.state.employeeId).then((res) => {
      let employee = res.data;
      this.setState({
        employeeCode: employee.employeeCode,
        employeeName: employee.employeeName,
        employeeContactNumber: employee.employeeContactNumber,
        employeeCurrentAddress: employee.employeeCurrentAddress,
        employeePostalAddress: employee.employeePostalAddress,
        employeeUID: employee.employeeUID,
        employeePanCardNumber: employee.employeePanCardNumber,
        employeeDOB: employee.employeeDOB,
        employeeJoiningDate: employee.employeeJoiningDate,
        employeeLastWorkingDate: employee.employeeLastWorkingDate,
        employeeGender: employee.employeeGender,
        employeeEducationInstitueName: employee.employeeEducationInstitueName,
        employeeHighestEducation: employee.employeeHighestEducation,
        employeeEducationPassoutYear: employee.employeeEducationPassoutYear,
        employeeHighestEducationMarks: employee.employeeHighestEducationMarks,
        employeeParentName: employee.employeeParentName,
        employeeParentContactNumber: employee.employeeParentContactNumber,
        employeeLastWithdrawnSalary: employee.employeeLastWithdrawnSalary,
        employeeEmailId: employee.employeeEmailId,
        employeePassword: employee.employeePassword,
      });
    });
  }

  update = (e) => {
    e.preventDefault();
    let employee = {
      employeeCode: this.state.employeeCode,
      employeeName: this.state.employeeName,
      employeeContactNumber: this.state.employeeContactNumber,
      employeeCurrentAddress: this.state.employeeCurrentAddress,
      employeePostalAddress: this.state.employeePostalAddress,
      employeeUID: this.state.employeeUID,
      employeePanCardNumber: this.state.employeePanCardNumber,
      employeeDOB: this.state.employeeDOB,
      employeeJoiningDate: this.state.employeeJoiningDate,
      employeeLastWorkingDate: this.state.employeeLastWorkingDate,
      employeeGender: this.state.employeeGender,
      employeeEducationInstitueName: this.state.employeeEducationInstitueName,
      employeeHighestEducation: this.state.employeeHighestEducation,
      employeeEducationPassoutYear: this.state.employeeEducationPassoutYear,
      employeeHighestEducationMarks: this.state.employeeHighestEducationMarks,
      employeeParentName: this.state.employeeParentName,
      employeeParentContactNumber: this.state.employeeParentContactNumber,
      employeeLastWithdrawnSalary: this.state.employeeLastWithdrawnSalary,
      employeeEmailId: this.state.employeeEmailId,
      employeePassword: this.state.employeePassword,
    };
    console.log("employee =>" + JSON.stringify(employee));
    EmployeeService.update(employee, this.state.employeeId).then((res) => {
      this.props.history.push("/welcome");
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
                <form>
                  <div className="form-group">
                    <label>Code</label>
                    <input
                      className="form-control"
                      value={this.state.employeeCode}
                      onChange={this.changeEmployeeCodeHandler}
                    />
                    <label>Name:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeName}
                      onChange={this.changeEmployeeNameHandler}
                    />
                    <label> Contact Number:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeContactNumber}
                      onChange={this.changeEmployeeContactNumberHandler}
                    />
                    <label>Current Address:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeCurrentAddress}
                      onChange={this.changeEmployeeCurrentAddressHandler}
                    />
                    <label>Postal Addresss:</label>
                    <input
                      className="form-control"
                      value={this.state.employeePostalAddress}
                      onChange={this.changeEmployeePostalAddressHandler}
                    />
                    <label>UID:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeUID}
                      onChange={this.changeEmployeeUIDHandler}
                    />
                    <label>PAN:</label>
                    <input
                      className="form-control"
                      value={this.state.employeePanCardNumber}
                      onChange={this.changeEmployeePanCardNumberHandler}
                    />
                    <label>DOB(DD-MM-YYYY):</label>
                    <input
                      className="form-control"
                      value={this.state.employeeDOB}
                      onChange={this.changeEmployeeDOBHandler}
                    />
                    <label>Joining Date(DD-MM-YYYY):</label>
                    <input
                      className="form-control"
                      value={this.state.employeeJoiningDate}
                      onChange={this.changeEmployeeJoiningDateHandler}
                    />
                    <label>LWD(DD-MM-YYYY):</label>
                    <input
                      className="form-control"
                      value={this.state.employeeLastWorkingDate}
                      onChange={this.changeEmployeeLastWorkingDateHandler}
                    />
                    <label>Gender:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeGender}
                      onChange={this.changeEmployeeGenderHandler}
                    />
                    <label>Education Institute:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeEducationInstitueName}
                      onChange={this.changeEmployeeEducationInstitueNameHandler}
                    />
                    <label>Qualification:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeHighestEducation}
                      onChange={this.changeEmployeeHighestEducationHandler}
                    />
                    <label>Passout Year:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeEducationPassoutYear}
                      onChange={this.changeEmployeeEducationPassoutYearHandler}
                    />
                    <label>Marks:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeHighestEducationMarks}
                      onChange={this.changeEmployeeHighestEducationMarksHandler}
                    />
                    <label>Parent Name:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeParentName}
                      onChange={this.changeEmployeeParentNameHandler}
                    />
                    <label>Parent Contact Number:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeParentContactNumber}
                      onChange={this.changeEmployeeParentContactNumberHandler}
                    />
                    <label>Last Salary:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeLastWithdrawnSalary}
                      onChange={this.changeEmployeeLastWithdrawnSalaryHandler}
                    />
                    <label>Email ID:</label>
                    <input
                      className="form-control"
                      value={this.state.employeeEmailId}
                      onChange={this.changeEmployeeEmailIdhandler}
                    />
                    <label>Password</label>
                    <input
                      className="form-control"
                      value={this.state.employeePassword}
                      onChange={this.changeEmployeePasswordHandler}
                    />
                    <button className="btn btn-success" onClick={this.update}>
                      Save
                    </button>
                    <button className="btn btn-danger" onClick={this.cancel}>
                      Cancel
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
