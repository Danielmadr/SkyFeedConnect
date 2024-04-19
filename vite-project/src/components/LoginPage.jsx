import "@style/LoginPage.css";

import { useNavigate } from "react-router-dom";

const LoginPage = () => {
  const handleGoogleLogin = () => {
    console.log("Sign In with Google");
  };

  const handleForgotPassword = () => {
    console.log("Forgot Password Clicked");
  };

  const handleSignIn = (e) => {
    e.preventDefault();
    console.log("Sign in with email and password");
  };

  const navigate = useNavigate();

  const handleSignUpClick = () => {
    navigate("/signup");
  };

  return (
    <div className="auth-container sign-in-container">
      <h1>Sign In</h1>
      <p className="subtitle">Welcome to Sky Feed Connect!</p>
      <button onClick={handleGoogleLogin} className="social-login google">
        Sign in with Google
      </button>
      <div className="divider">
        <span>Or with email</span>
      </div>
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
