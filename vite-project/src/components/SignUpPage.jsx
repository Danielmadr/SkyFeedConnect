import "@style/SignUpPage.css";

import { useState } from "react";
import { useNavigate } from "react-router-dom";

const SignUpPage = () => {
  const [userDetails, setUserDetails] = useState({
    email: "",
    password: "",
    confirmPassword: "",
  });

  const handleGoogleLogin = () => {
    console.log("Sign up with Google");
  };

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserDetails((prevState) => ({ ...prevState, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (userDetails.password !== userDetails.confirmPassword) {
      console.log("Passwords do not match.");
      return;
    }
    console.log("Form submitted", userDetails);
  };

  const handleSignInClick = () => {
    navigate("/login");
  };

  return (
    <div className="auth-container sign-up-container">
      <h1>Sign Up</h1>
      <p className="subtitle">Welcome to Sky Feed Connect!</p>
      <button onClick={handleGoogleLogin} className="social-login google">
        Sign up with Google
      </button>
      <div className="divider">
        <span>Or with email</span>
      </div>
      <form onSubmit={handleSubmit} className="sign-up-form">
        <input
          type="email"
          name="email"
          placeholder="Email"
          required
          value={userDetails.email}
          onChange={handleChange}
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          required
          value={userDetails.password}
          onChange={handleChange}
        />
        <input
          type="password"
          name="confirmPassword"
          placeholder="Repeat Password"
          required
          value={userDetails.confirmPassword}
          onChange={handleChange}
        />
        <button type="submit" className="sign-up-button">
          Sign Up
        </button>
      </form>
      <p className="sign-in-redirect">
        Already have an Account?{" "}
        <span className="sign-in-link" onClick={handleSignInClick}>
          Sign in
        </span>
      </p>
    </div>
  );
};

export default SignUpPage;
