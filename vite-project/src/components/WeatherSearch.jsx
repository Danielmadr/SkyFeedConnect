import "@style/WeatherSearch.css";

const WeatherWidget = () => {
  // Lógica para chamar a API do clima e renderizar os dados
  return (
    <div id="weather">
      <h1>Condiçoes do Tempo</h1>
      <section id="search-form">
        <form>
          <input
            className="inputWidget"
            type="text"
            id="input-local"
            placeholder="Insira a Localização..."
          />
          <button id="button-local">Pesquisar</button>
        </form>
      </section>
      <section id="tempo-info"></section>
    </div>
  );
};

export default WeatherWidget;
