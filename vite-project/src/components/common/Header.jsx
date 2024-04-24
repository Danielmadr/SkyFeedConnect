import { useNavigate } from "react-router-dom";
import "@style/common/Header.css";

const Header = ({ username, onLogout }) => {
  const navigate = useNavigate();

  const handleLogoutClick = () => {
    // Lógica de limpeza do estado de autenticação
    onLogout();
    navigate("/login");
  };

  return (
    <header className="header">
      <h1>Welcome to Sky Feed Connect</h1>
      <p>Por sua vida conosco é mais conectada</p>
      <nav>
        <span>{username}</span>
        <button onClick={handleLogoutClick}>Logout</button>
      </nav>
    </header>
  );
};

export default Header;
