import "./SignUpPage.css";

import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const SignUpPage = () => {
  const [userDetails, setUserDetails] = useState({
    username: "",
    email: "",
    password: "",
    confirmPassword: "",
    status: "A", // Definindo o status como "A" por padrão
  });
  const [error, setError] = useState("");
  const [isSubmitting, setIsSubmitting] = useState(false); // Estado para controle de envio

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUserDetails((prevState) => ({ ...prevState, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (userDetails.password !== userDetails.confirmPassword) {
      setError("Passwords do not match.");
      return;
    }

    setIsSubmitting(true); // Inicia o indicador de envio

    try {
      const response = await axios.post("http://localhost:8080/users/save", {
        username: userDetails.username,
        email: userDetails.email,
        password: userDetails.password,
        status: userDetails.status,
      });

      await axios.post("http://localhost:3333/newUser", {
        username: userDetails.username,
      });

      console.log("User registered successfully:", response.data);
      navigate("/login");
    } catch (error) {
      setError(error.response.data.message);
      console.error("Failed to register user:", error);
    } finally {
      setIsSubmitting(false);
    }
  };

  const handleSignInClick = () => {
    navigate("/login");
  };

  return (
    <div id="sign-page">
      <div className="sign-up-container">
        <h1>Sign Up</h1>
        <p>Welcome to Sky Feed Connect!</p>
        <form onSubmit={handleSubmit} className="sign-up-form">
          <input
            type="text"
            name="username"
            placeholder="Full Name"
            required
            value={userDetails.username}
            onChange={handleChange}
          />
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
          <button
            type="submit"
            className="sign-up-button"
            disabled={isSubmitting}
          >
            {isSubmitting ? "Submitting..." : "Sign Up"}
          </button>
          {error && (
            <p className="error-message" style={{ color: "red" }}>
              {error}
            </p>
          )}
        </form>
        {error && (
          <p className="error-message" style={{ color: "red" }}>
            {error}
          </p>
        )}
        <p className="sign-in-redirect">
          Already have an Account?{" "}
          <span className="sign-in-link" onClick={handleSignInClick}>
            Sign in
          </span>
        </p>
      </div>
    </div>
  );
};

export default SignUpPage;
