import { useState } from "react";
import "@style/WeatherSearch.css";
import axios from "axios";

const WeatherWidget = () => {
  const [local, setLocal] = useState("");
  const [weatherInfo, setWeatherInfo] = useState(null);
  const JWT_TOKEN =
    "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb2dlcmlvbmpAZ21haWwuY29tIiwiaWF0IjoxNzE0MDg2Mzg2LCJleHAiOjE3MTQwODcyODZ9.jk3657plTSVJwIlrvshFQhuYNVSsZHrdd3VSxe4TFbJAZE4YkJcxmkgWZkMN7UgRNUR332TwQoT0g4Ffj4sFVQ";
  // localStorage.getItem("userToken");

  const handleFormSubmit = async (event) => {
    event.preventDefault();

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

      //const data = await response.json();
      console.log(response.data);

      const weatherData = {
        temp: Math.round(response.data.temp),
        local: response.data.name,
        icon: `https://openweathermap.org/img/wn/${response.data.icon}@2x.png`,
      };

      setWeatherInfo(weatherData);
    } catch (err) {
      console.log("Aconteceu um erro inesperado na API.", err);
    }
  };
  return (
    <div id="weather-widget">
      <div id="weather-content">
        <h1 className="title">Condiçoes do Tempo</h1>
        <section id="search-form">
          <form>
            <input
              className="inputWidget"
              type="text"
              id="input-local"
              value={local}
              placeholder="Insira o local..."
              onChange={(event) => setLocal(event.target.value)}
            />
            <button id="button-local" onClick={handleFormSubmit}>
              Buscar Clima
            </button>
          </form>
        </section>
        <section id="tempo-info">
          {weatherInfo && (
            <div className="tempo-data">
              <h2>{weatherInfo.local}</h2>
              <div className="tempo-data-info">
                <span>{weatherInfo.temp} ºC</span>
                <img src={weatherInfo.icon} alt="" />
              </div>
            </div>
          )}
        </section>
      </div>
    </div>
  );
};

export default WeatherWidget;
