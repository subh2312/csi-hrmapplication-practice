import axios from "axios";

const getAllDataURL = "http://localhost:8080/api/getAllData";

class EmployeeService {
  getAllData() {
    return axios.get(getAllDataURL);
  }
  signUp(employee) {
    return axios.post("http://localhost:8080/api/signUp", employee);
  }
  signIn(employeeEmailId, employeePassword) {
    return axios
      .get(
        `http://localhost:8080/api/signIn/`,

        {
          params: { employeeEmailId, employeePassword },
        }
      )
      .then(function (response) {
        console.log(response.status);
        sessionStorage.setItem(employeeEmailId);
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  getEmployeeById(employeeId) {
    return axios.get("http://localhost:8080/api/getDataById/" + employeeId);
  }

  update(employee, employeeId) {
    return axios.put(
      "http://localhost:8080/api/updateData/" + employeeId,
      employee
    );
  }

  delete(employeeId) {
    return axios.delete("http://localhost:8080/api/deleteData/" + employeeId);
  }
}

export default new EmployeeService();
