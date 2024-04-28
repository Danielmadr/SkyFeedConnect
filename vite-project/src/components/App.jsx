import { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import LoginPage from "@pages/LoginPage/LoginPage";
import SignUpPage from "@pages/SignUpPage/SignUpPage";
import MainPage from "@pages/MainPage/MainPage";

const App = () => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const userToken = localStorage.getItem("userToken");
    setIsAuthenticated(!!userToken);
  }, []);

  const handleLogin = (token) => {
    localStorage.setItem("userToken", token);
    setIsAuthenticated(true);
  };

  const handleLogout = () => {
    localStorage.removeItem("userToken");
    localStorage.removeItem("userName");
    setIsAuthenticated(false);
  };

  return (
    <Router>
      <Routes>
        <Route
          path="/"
          element={
            <Navigate replace to={isAuthenticated ? "/main" : "/login"} />
          }
        />
        <Route path="/login" element={<LoginPage onLogin={handleLogin} />} />
        <Route path="/signup" element={<SignUpPage />} />
        <Route
          path="/main"
          element={
            // isAuthenticated ? (
            <MainPage onLogout={handleLogout} />
            // ) : (
            //   <Navigate replace to="/login" />
            // )
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
