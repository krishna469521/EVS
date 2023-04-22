import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./Home.css";
import { useNavigate } from "react-router-dom";

function Home() {
  const [userID, setUserID] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("Admin");
  let cb = {};
  const [error, setError] = useState("");

  const nav = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    const data = { userID, password };
    console.log(JSON.stringify(data));

    axios
      .get(
        `http://localhost:8057/admin/selectUser/${userID}/${password}`
      )
      .then((res) => {
        console.log(JSON.stringify(res.data));
        if (res.data === true) {
          if (role === "Admin") {
            if (userID === "AD-001" && password === "AD-001") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/addelection");
            } else if (userID === "AD-002" && password === "AD-002") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/selectelection1");
            } else if (userID === "AD-003" && password === "AD-003") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/selectelection");
            } else if (userID === "AD-004" && password === "AD-004") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/addparty");
            } else if (userID === "AD-005" && password === "AD-005") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/selectparty");
            } else if (userID === "AD-007" && password === "AD-007") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/candidateelection");
            } else if (userID === "AD-008" && password === "AD-008") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/selectapplication2");
            } else if (userID === "AD-009" && password === "AD-009") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/candidateparty");
            } else {
              setError("Invalid credentials");
            }
          } else if (role === "EO") {
            if (userID === "EO-001" && password === "EO-001") {
              alert("Logged In Successfully! Welcome Electoral Officer");
              nav("/selectapplication");
            } else if (userID === "EO-002" && password === "EO-002") {
              alert("Logged In Successfully! Welcome Electoral Officer");
              nav("/generatevoterid");
            } else {
              setError("Invalid credentials");
            }
          } else if (role === "Voter") {
            if (userID === "US-001" && password === "US-001") {
              alert("Logged In Successfully! Welcome Voter");
              nav("/register");
            } else if (userID === "US-002" && password === "US-002") {
              alert("Logged In Successfully! Welcome Voter");
              nav("/addapplication");
            } else if (userID === "US-003" && password === "US-003") {
              alert("Logged In Successfully! Welcome Voter");
              nav("/selectapplication1");
            } else if (userID === "US-004" && password === "US-004") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/selectelection1");
            } else if (userID === "US-005" && password === "US-005") {
              alert("Logged In Successfully! Welcome Administrator");
              nav("/candidateelection");
            } else {
              setError("Invalid credentials");
            }
          } else {
            setError("Invalid credentials");
          }
        }
      })
      .catch((err) => {
        console.error(err);
        setError("Error occurred while authenticating");
      });
  };

  return (
    <div>
      <div className="cont">
        <div className="image-container">
          <img
            src="data:image/jpeg;base64,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"
            alt="Image"
            className="image1"
            width="500"
            height="300"
          />
          <p>
          Online voting tools and online election voting systems help you make important decisions by gathering the input of your group in a way that’s systematic and verifiable.


          </p>
        </div>
        <div className="con">
          <h1>Login</h1>
          <form className="form-cont" onSubmit={handleSubmit}>
            Select Your Role :{" "}
            <select
              className="select-option"
              value={role}
              onChange={(e) => {
                setRole(e.target.value);
              }}
            >
              <option value="Admin">Admin</option>
              <option value="EO">EO</option>
              <option value="Voter">Voter</option>
            </select>
            <br />
            <br />
            Enter UserID :{" "}
            <input
              type="text"
              value={userID}
              onChange={(e) => {
                setUserID(e.target.value);
              }}
            />
            <br />
            Enter Password :{" "}
            <input
              type="text"
              value={password}
              onChange={(e) => {
                setPassword(e.target.value);
              }}
            />
            <button type="submit" className="bt1">
              Login
            </button>
            <br />
            <Link to="/register">
              <button className="bt2">Sign Up</button>
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Home;
