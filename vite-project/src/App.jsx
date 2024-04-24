import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import LoginPage from "@components/LoginPage";
import SignUpPage from "@components/SignUpPage";
import MainPage from "@components/MainPage";

const App = () => {
  const isAuthenticated = () => {
    return localStorage.getItem("userToken") != null;
  };

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate replace to="/login" />} />
        <Route
          path="/login"
          element={
            !isAuthenticated() ? <LoginPage /> : <Navigate replace to="/main" />
          }
        />
        <Route
          path="/signup"
          element={
            !isAuthenticated() ? (
              <SignUpPage />
            ) : (
              <Navigate replace to="/main" />
            )
          }
        />
        <Route
          path="/main"
          element={
            isAuthenticated() ? <MainPage /> : <Navigate replace to="/login" />
          }
        />
      </Routes>
    </Router>
  );
};

export default App;
