import "@style/NewsFeed.css";

const NewsFeed = () => {
  // Colocar a lógica para chamar a API de notícias e renderizar os dados

  const newsItens = [
    {
      title:
        "Vacinados entrarão nos EUA sem quarentena a partir de 8 de novembro",
      summary:
        "Ministros ‘lavam as mãos’ sobre Bolsonaro não se vacinar, relata blog Bandeiras em frente ao Congresso lembram 600 mil brasileiros mortos",
    },
    { title: "Notícia", summary: "Resumo da notícia" },
    //... mais notícias
  ];

  return (
    <div className="news-feed">
      {newsItens.slice(0, 1).map((news, index) => (
        <div key={index} className="main-new">
          <h1>{news.title}</h1>
          <p>{news.summary}</p>
        </div>
      ))}
      <div className="under-notice">
        <div className="top-notice">
          {newsItens.slice(1).map((news, index) => (
            <div key={index} className="news-item">
              <h3>{news.title}</h3>
              {news.imageUrl && <img src={news.imageUrl} alt={news.title} />}
              {news.summary && <p>{news.summary}</p>}
            </div>
          ))}
          {newsItens.slice(1).map((news, index) => (
            <div key={index} className="news-item">
              <h3>{news.title}</h3>
              {news.imageUrl && <img src={news.imageUrl} alt={news.title} />}
              {news.summary && <p>{news.summary}</p>}
            </div>
          ))}
          {newsItens.slice(1).map((news, index) => (
            <div key={index} className="news-item">
              <h3>{news.title}</h3>
              {news.imageUrl && <img src={news.imageUrl} alt={news.title} />}
              {news.summary && <p>{news.summary}</p>}
            </div>
          ))}
        </div>
        <div className="bot-notice">
          {newsItens.slice(1).map((news, index) => (
            <div key={index} className="news-item">
              <h3>{news.title}</h3>
              <p>{news.summary}</p>
            </div>
          ))}
          {newsItens.slice(1).map((news, index) => (
            <div key={index} className="news-item">
              <h3>{news.title}</h3>
              <p>{news.summary}</p>
            </div>
          ))}
          {newsItens.slice(1).map((news, index) => (
            <div key={index} className="news-item">
              <h3>{news.title}</h3>
              <p>{news.summary}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default NewsFeed;
