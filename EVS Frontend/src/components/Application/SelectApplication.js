import React, { useState } from "react";
import axios from "axios";
import "./SelectApplication.css";

function SelectApplication() {
  const [data, setData] = useState([]);

  axios.get("http://localhost:8057/admin/viewApplications").then((res) => {
    setData(res.data);
  });

  console.log(data);

  return (
    <div>
      <div className="s1">
        <div className="s2">
          <table border="4">
            <thead>
              <tr>
                <th>User ID</th>
                <th>Passed Status</th>
                <th>Approved Status</th>
                <th>Constituency</th>
                <th>Voter ID</th>
              </tr>
            </thead>
            <tbody>
              {data.map((item) => (
                <tr key={item.userId}>
                  <td>{item.userID}</td>
                  <td>{item.passedstatus}</td>
                  <td>{item.approvedstatus}</td>
                  <td>{item.constituency}</td>
                  <td>{item.voterID}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default SelectApplication;
