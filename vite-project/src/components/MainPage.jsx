import "@style/MainPage.css";
import { useNavigate } from "react-router-dom";
import Header from "@commoncomponents/Header";
//import Footer from "@commoncomponents/Footer";
import WeatherWidget from "@components/WeatherSearch";
import NewsFeed from "@components/NewsFeed";

const MainPage = () => {
  const username = "Daniel";

  const navigate = useNavigate();

  const handleLogout = () => {
    // Tem que limpar o estado de autenticação, tokens, etc.
    navigate("/login");
  };

  return (
    <div id="page">
      <div className="header-container">
        <Header username={username} onLogout={handleLogout} />
      </div>
      <div id="main-page" className="wrapper">
        <div className="news-section">
          <NewsFeed />
        </div>
      </div>
      <div className="side">
        <div className="weather-section">
          <WeatherWidget />
        </div>
      </div>
      {/* <hr className="bottom-hr" />
      <Footer /> */}
    </div>

    // <div id="page">
    //   <div className="logo">{/* Logotipo e cabeçalho aqui */}</div>
    //   <Header username={username} onLogout={handleLogout} />
    //   <div id="main-page" className="wrapper">
    //     <div className="news-section">
    //       <NewsFeed />
    //     </div>
    //     <div className="weather-section">
    //       <WeatherWidget />
    //     </div>
    //   </div>
    //   <hr className="bottom-hr" />
    //   <Footer />
    // </div>
  );
};

export default MainPage;
