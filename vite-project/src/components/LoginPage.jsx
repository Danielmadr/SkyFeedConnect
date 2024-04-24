import "@style/LoginPage.css";

import { useNavigate } from "react-router-dom";

const LoginPage = () => {
  const handleForgotPassword = () => {
    console.log("Forgot Password Clicked");
  };

  const navigate = useNavigate();

  const handleSignIn = (e) => {
    console.log("Sign in with email and password");
    if (isAuthenticated) {
      e.preventDefault();
      localStorage.setItem("userToken", "tokenAqui");
      navigate("/main");
    } else {
      // Tratar o erro de autenticação
      console.error("Falha no login");
    }
  };

  const isAuthenticated = true;

  const handleSignUpClick = () => {
    navigate("/signup");
  };

  return (
    <div className="auth-container sign-in-container">
      <h1>Sign In</h1>
      <p className="subtitle">Welcome to Sky Feed Connect!</p>
      <form onSubmit={handleSignIn} className="sign-in-form">
        <input type="email" placeholder="Email" required />
        <input type="password" placeholder="Password" required />
        <button type="submit" className="sign-in-button">
          Sign In
        </button>
        <button
          type="button"
          onClick={handleForgotPassword}
          className="forgot-password-link"
        >
          Forgot Password?
        </button>
      </form>
      <p className="sign-in-redirect">
        Not a Member yet?{" "}
        <span className="sign-up-link" onClick={handleSignUpClick}>
          Sign up
        </span>
      </p>
    </div>
  );
};

export default LoginPage;
