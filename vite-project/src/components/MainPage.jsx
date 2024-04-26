import PropTypes from "prop-types";
import "@style/MainPage.css";
import WeatherWidget from "@components/WeatherSearch";
import NewsFeed from "@components/NewsFeed";
import logo from "../assets/logo.png";

const MainPage = ({ onLogout }) => {
  const username = localStorage.getItem("userName") || "Usuário";

  return (
    <body id="main-page">
      <section id="header">
        <div className="header-content">
          <img src={logo} alt="Logo" className="logo" />
          <div className="header-user-info">
            <span className="username">{username}</span>
            <a href="/login" onClick={onLogout} className="logout-link">
              Logout
            </a>
          </div>
        </div>
      </section>

      <section id="principal">
        <div className="personal-feed">
          <NewsFeed className="news-feed" />
          <div className="vertical-divider">
            <WeatherWidget className="weather-widget" />
          </div>
        </div>
      </section>
    </body>
  );
};

MainPage.propTypes = {
  onLogout: PropTypes.func.isRequired,
};

export default MainPage;
