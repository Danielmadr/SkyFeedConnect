import { useState } from "react";
import axios from "axios";
import "../style/WeatherSearch.css";

const WeatherWidget = () => {
  const [local, setLocal] = useState("");
  const [weatherInfo, setWeatherInfo] = useState(null);
  const [error, setError] = useState("");
  const JWT_TOKEN = localStorage.getItem("userToken");
  /*"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb2dlcmlvbmpAZ21haWwuY29tIiwiaWF0IjoxNzE0MDkzNTgwLCJleHAiOjE3MTQwOTQ0ODB9.lPCHmqD07RykTw4QRkU58o1HFDSq0t1QCxzzX9xE_Qwy2HcqL3D0dBe2tOemPx6vuDXxk9-Wa_vW1UnX0NTxZQ";*/

  const handleFormSubmit = async (event) => {
    event.preventDefault();
    setError(null);

    if (local.length < 3) {
      alert("O local precisa ter, pelo menos, três letras");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:3333/weather/${local}`,

        {
          headers: {
            Authorization: `Bearer ${JWT_TOKEN}`,
          },
        }
      );

      const weatherData = {
        temp: Math.round(response.data.temp),
        local: response.data.name,
        description: response.data.description,
        icon: `https://openweathermap.org/img/wn/${response.data.icon}@2x.png`,
      };

      setWeatherInfo(weatherData);
    } catch (erro) {
      const imageUrl = `https://http.cat/${erro.response.data.status}`;
      setError(imageUrl);
      console.log("Aconteceu um erro inesperado na API.", erro);
    }
  };
  return (
    <div id="weather-widget">
      <div id="weather-content">
        <h1 className="title">Condiçoes do Tempo</h1>
        <section id="search-form">
          <form onSubmit={handleFormSubmit}>
            <input
              className="inputWidget"
              type="text"
              id="input-local"
              value={local}
              placeholder="Insira o local..."
              onChange={(event) => setLocal(event.target.value)}
            />
            <button id="button-local" type="submit">
              Buscar Clima
            </button>
          </form>
          {error && <img src={error} alt="Erro" style={{ width: "100%" }} />}
        </section>
        <section id="tempo-info">
          {weatherInfo && (
            <div className="tempo-data">
              <h2>{weatherInfo.local}</h2>
              <div className="tempo-data-info">
                <img
                  src={weatherInfo.icon}
                  alt="tempo"
                  style={{ width: "100px" }}
                />
                <div className="tempo-data-info-text">
                  <span className="description">
                    {weatherInfo.description},{" "}
                  </span>
                  <span>{weatherInfo.temp} ºC</span>
                </div>
              </div>
            </div>
          )}
        </section>
      </div>
    </div>
  );
};

export default WeatherWidget;
