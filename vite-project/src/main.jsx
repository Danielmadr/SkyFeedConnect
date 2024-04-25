import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "@style/index.css";
<link href="https://fonts.googleapis.com/css2?family=Encode+Sans:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet"></link>

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
