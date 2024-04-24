import { useNavigate } from "react-router-dom";
import React from "react";
import "../../style/common/Header.css"; // Verifique se o caminho do estilo está correto

// Importe a imagem do logotipo usando um caminho relativo correto
import logo from "../../assets/logo.png";

const Header = ({ username, onLogout }) => {
  const navigate = useNavigate();

  const handleLogoutClick = () => {
    // Lógica de limpeza do estado de autenticação
    onLogout();
    navigate("/login");
  };

  return (
    <header
      className="header"
      style={{
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        padding: "20px",
      }}
    >
      <div className="site-title">
        <div>
          <img src={logo} style={{ height: "80px" }} alt="Logo" />
        </div>
        <div className="Title">
          <h1>Welcome to Sky Feed Connect</h1>
          <p>Porque sua vida conosco é mais conectada</p>
        </div>
      </div>
      <div className="logout">
        <span className="username">{username}</span>
        <button onClick={handleLogoutClick}>Logout</button>
      </div>
    </header>
  );
};

export default Header;
