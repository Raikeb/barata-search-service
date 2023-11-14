# Projeto BarataSearch

## Resumo
O projeto BarataSearch é um serviço de busca de voos que utiliza web scraping para obter informações de voos do Google Flights. Ele fornece uma maneira eficiente e automatizada de coletar dados sobre voos, incluindo a data de partida, a data de retorno, o aeroporto de partida, o aeroporto de destino, o logo da companhia aérea, a companhia aérea, o status do voo, as escalas do voo, os horários de partida e chegada, a duração do voo, a emissão de carbono e o preço. Esses dados são então persistidos em um banco de dados para posterior recuperação e análise.

## Tecnologias Usadas
- **Spring Boot**: É um framework Java que simplifica o desenvolvimento de aplicações stand-alone baseadas em Spring. Ele é usado para criar o serviço web RESTful.

- **JPA/Hibernate**: São usados para persistir os dados no banco de dados. JPA (Java Persistence API) é uma especificação Java para mapeamento objeto-relacional e Hibernate é uma das implementações mais populares da JPA.

- **H2 Database**: É um banco de dados em memória escrito em Java. Ele é leve e ideal para testes ou como um banco de dados embutido em aplicações Java.

- **Playwright**: É uma biblioteca Node.js para automação de navegadores que é usada para fazer web scraping no Google Flights.

- **ModelMapper**: É uma biblioteca inteligente e orientada a objetos que mapeia automaticamente objetos de um tipo para outro.

## Endpoints
O projeto expõe vários endpoints RESTful para interagir com os dados:

1. `GET /voos`: Este endpoint retorna uma lista com todos os voos disponíveis no banco de dados.

2. `GET /voos/{id}`: Este endpoint retorna os detalhes de um voo específico com base no ID fornecido.

3. `POST /voos`: Este endpoint permite inserir um novo voo no banco de dados. Os detalhes do voo devem ser fornecidos no corpo da solicitação.

4. `PUT /voos/{id}`: Este endpoint permite atualizar os detalhes de um voo existente com base no ID fornecido. Os novos detalhes do voo devem ser fornecidos no corpo da solicitação.

5. `GET /GoogleFlights`: Este endpoint inicia o processo de web scraping para obter informações dos voos do Google Flights e persisti-las no banco de dados.

6. `GET /aeroportos`: Este endpoint retorna uma lista com todos os aeroportos disponíveis no banco de dados.

7. `GET /aeroportos/{id}`: Este endpoint retorna os detalhes de um aeroporto específico com base no ID fornecido.

8. `POST /aeroportos`: Este endpoint permite inserir um novo aeroporto no banco de dados. Os detalhes do aeroporto devem ser fornecidos no corpo da solicitação.

9. `PUT /aeroportos/{id}`: Este endpoint permite atualizar os detalhes de um aeroporto existente com base no ID fornecido. Os novos detalhes do aeroporto devem ser fornecidos no corpo da solicitação.

10. `GET /brasileiros`: Este endpoint retorna uma lista com todos os aeroportos brasileiros disponíveis no banco de dados.



Cada endpoint foi projetado para ser simples e intuitivo, tornando fácil para os usuários interagirem com os dados.