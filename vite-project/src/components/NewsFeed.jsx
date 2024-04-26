import "@style/NewsFeed.css";
import img1 from "../assets/alem-do-presidente.jpeg";

const newsItems = [
  {
    id: 1,
    subtitle:
      "Vacinados entrarão nos EUA sem quarentena a partir de 8 de novembro",
    summary:
      "Ministros ‘lavam as mãos’ sobre Bolsonaro não se vacinar, relata blog Bandeiras em frente ao Congresso lembram 600 mil brasileiros mortos",
    link: "https://link-para-noticia-principal.com",
  },
  {
    id: 2,
    title: "Além do presidente",
    subtitle:
      "Vacinados entrarão nos EUA sem quarentena a partir de 8 de novembro",
    summary:
      "Ministros 'lavam as mãos' sobre Bolsonaro não se vacinar, relata blog",
    imageUrl: img1,
    link: "https://link-para-noticia-principal.com",
  },
  {
    id: 3,
    title: "Além do presidente",
    subtitle:
      "Vacinados entrarão nos EUA sem quarentena a partir de 8 de novembro",
    summary:
      "Ministros 'lavam as mãos' sobre Bolsonaro não se vacinar, relata blog",
    imageUrl: img1,
    link: "https://link-para-noticia-principal.com",
  },
  {
    id: 4,
    title: "Além do presidente",
    subtitle:
      "Vacinados entrarão nos EUA sem quarentena a partir de 8 de novembro",
    summary:
      "Ministros 'lavam as mãos' sobre Bolsonaro não se vacinar, relata blog",
    imageUrl: img1,
    link: "https://link-para-noticia-principal.com",
  },
  {
    id: 5,
    title: "Além do presidente",
    subtitle:
      "Vacinados entrarão nos EUA sem quarentena a partir de 8 de novembro",
    summary:
      "Ministros 'lavam as mãos' sobre Bolsonaro não se vacinar, relata blog",
    link: "https://link-para-noticia-principal.com",
  },
  {
    id: 6,
    title: "Além do presidente",
    subtitle:
      "Vacinados entrarão nos EUA sem quarentena a partir de 8 de novembro",
    summary:
      "Ministros 'lavam as mãos' sobre Bolsonaro não se vacinar, relata blog",
    link: "https://link-para-noticia-principal.com",
  },
  {
    id: 7,
    title: "Além do presidente",
    subtitle:
      "Vacinados entrarão nos EUA sem quarentena a partir de 8 de novembro",
    summary:
      "Ministros 'lavam as mãos' sobre Bolsonaro não se vacinar, relata blog",
    link: "https://link-para-noticia-principal.com",
  },
];

const NewsFeed = () => {
  return (
    <div className="news-feed">

      <div className="main-news-item">
        <h1 className="main-news-subtitle">{newsItems[0].subtitle}</h1>
        <p className="main-news-summary">{newsItems[0].summary}</p>
      </div>

      <div className="secondary-news-container">
        {newsItems.slice(1, 4).map((news) => (
          <div key={news.id} className="secondary-news-item">
            {news.imageUrl && (
              <img src={news.imageUrl} alt={news.title} className="secondary-news-image" />
            )}
            <div className="secondary-news-text">
              <h2 className="secondary-news-title">{news.title}</h2>
              <h3 className="secondary-news-subtitle">{news.subtitle}</h3>
              <p className="secondary-news-summary">{news.summary}</p>
            </div>
          </div>
        ))}
      </div>

      <div className="additional-news-container">
        {newsItems.slice(4).map((news) => (
          <div key={news.id} className="additional-news-item">
            <div className="additional-news-text">
              <h2 className="additional-news-title">{news.title}</h2>
              <h3 className="additional-news-subtitle">{news.subtitle}</h3>
              <p className="additional-news-summary">{news.summary}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default NewsFeed;
