import "./styles.css"; // Importa o arquivo de estilos CSS

const Grid = () => {
  return (
    <div className="grid-container">
      <div className="header">
        <h1>Header</h1>
      </div>
      <div className="main">
        <h2>Main Content</h2>
        <p>Conteúdo principal aqui...</p>
      </div>
      <div className="side">
        <h2>Side Content</h2>
        <p>Conteúdo lateral aqui...</p>
      </div>
    </div>
  );
};

export default Grid;
