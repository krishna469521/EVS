import React, { useState } from "react";
import axios from "axios";
import "./SelectElection.css";

function SelectElection() {
  const [data, setData] = useState([]);

  axios.get("http://localhost:8057/admin/selectAll").then((res) => {
    setData(res.data);
  });

  console.log(data);

  return (
    <div>
      <div className="c">
        <div className="s">
          <table border="4">
            <thead>
              <tr>
                <th>ElectionId</th>
                <th>Name</th>
                <th>ElectionDate</th>
                <th>District</th>
                <th>Constituency</th>
                <th>CountingDate</th>
              </tr>
            </thead>
            <tbody>
              {data.map((item) => (
                <tr key={item.electionId}>
                  <td>{item.electionID}</td>
                  <td>{item.name}</td>
                  <td>{item.electionDate}</td>
                  <td>{item.district}</td>
                  <td>{item.constituency}</td>
                  <td>{item.countingDate}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default SelectElection;
