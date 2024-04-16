# SkyFeedConnect

SkyFeed é uma aplicação web que combina notícias atualizadas e informações meteorológicas em uma plataforma centralizada. Os usuários podem se cadastrar, fazer login e desfrutar de uma experiência personalizada de notícias e clima.

## Funcionalidades

- **Registro e Login**: Os usuários podem se cadastrar e fazer login para acessar a plataforma.

- **Notícias Atualizadas**: Exibe notícias recentes de várias fontes.

- **Previsão Meteorológica**: Fornece informações meteorológicas em tempo real e previsões para os próximos dias.

- **Personalização**: Os usuários podem personalizar suas preferências, como localização para a previsão do tempo e categorias de notícias favoritas.

- **Conta Administrativa**:
  - A conta administrativa tem privilégios para gerenciar outras contas de usuário.
  - Pode visualizar e editar informações de usuários.
  - Pode gerenciar categorias de notícias e outras configurações da aplicação.

## Regras de Negócio

- **Autenticação Segura**:
  - Todas as operações na plataforma requerem autenticação via token JWT.
  - Apenas usuários autenticados podem acessar as funcionalidades principais da aplicação.

- **Gerenciamento de Contas**:
  - Apenas a conta administrativa pode realizar operações de gerenciamento de contas de usuário, como bloqueio ou exclusão.

- **Privacidade dos Dados**:
  - Os dados dos usuários (como informações de login, preferências e dados meteorológicos personalizados) são armazenados de forma segura e protegidos contra acesso não autorizado.

## Requisitos Funcionais

- Registro de Usuário
- Login de Usuário
- Exibição de Notícias Atualizadas
- Exibição de Informações Meteorológicas
- Personalização de Preferências do Usuário
- Gerenciamento de Contas de Usuário pela Conta Administrativa

## Requisitos Não Funcionais

- Segurança: Implementação de autenticação segura com tokens JWT.
- Desempenho: Respostas rápidas para solicitações de notícias e informações meteorológicas.
- Usabilidade: Interface amigável e intuitiva para os usuários.

## Tecnologias Utilizadas

- **Spring Boot**: Para o desenvolvimento do backend da aplicação.
- **Thymeleaf (ou Angular/React/Vue.js)**: Para o frontend interativo.
- **Spring Security com JWT**: Para autenticação e segurança.
- **APIs Utilizadas**:
  - News API (https://newsapi.org/): Para obter notícias atualizadas.
  - OpenWeather API (https://openweathermap.org/api): Para informações meteorológicas.

## Como Executar

1. **Configuração do Ambiente**:
   - Certifique-se de ter o Java e o Maven instalados.

2. **Clonar o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/skyfeed.git
   ```

3. **Configuração das Chaves da API**:
   - Obtenha as chaves de API necessárias para o News API e OpenWeather API e configure-as no arquivo `application.properties`.

4. **Executar a Aplicação**:
   - Navegue até o diretório do projeto e execute:
     ```bash
     mvn spring-boot:run
     ```
   - Acesse a aplicação em `http://localhost:8080`.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir um pull request com melhorias ou correções.

## Autor

Desenvolvido por [Daniel Martins de Andrade](https://github.com/Danielmadr).
