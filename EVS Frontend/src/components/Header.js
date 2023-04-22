import React from "react";
import "../App.css";

export default function Header() {
  return (
    <div className="head">
      <div className="my-head-flex">
        <a href="http://localhost:3000/">
          <img className="image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrYLJXn19x14Avt6M6EzrJDovHac189ldbRX673keFTw&s" alt="logo" />
        </a>
        <a href="http://localhost:3000/" className="my-head">
           Election Management System
        </a>
      </div>
    </div>
  );
}
