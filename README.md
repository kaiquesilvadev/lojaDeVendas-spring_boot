# Loja de Vendas Online - Spring Boot

![Java](https://img.shields.io/badge/Java-11-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![H2](https://img.shields.io/badge/H2-Database-lightgrey.svg)

Este repositório contém um projeto de uma Loja de Vendas Online desenvolvida com Spring Boot. O objetivo principal deste projeto é aprimorar as habilidades em Spring Boot, uma estrutura poderosa para o desenvolvimento de aplicativos Java. O sistema é projetado para gerenciar categorias de produtos, produtos, clientes, pedidos e pagamentos.

## Diagrama de Classes

- O diagrama de classes apresenta a estrutura do projeto e as relações entre as diferentes classes e entidades. Ele fornece uma visão visual do design da aplicação e ajuda a entender como as partes do sistema interagem entre si , O diagrama de classes do projeto da Loja de Vendas Online ilustra as principais entidades e suas relações.

![Diagrama de Classes](https://github.com/kaiquesilvadev/lojaDeVendas-spring_boot/blob/main/Captura%20de%20tela%202023-09-28%20210330.png)

## Padrão de Camadas

- No projeto da Loja de Vendas Online, segui um padrão de camadas bem estruturadas, típico de um aplicativo Spring Boot. Essa abordagem é fundamental para manter a organização, escalabilidade e facilidade de manutenção do código. As principais camadas do projeto são as seguintes.

![Padrão de Camadas](https://github.com/kaiquesilvadev/lojaDeVendas-spring_boot/blob/main/Captura%20de%20tela%202023-09-21%20185426.png)

No projeto, segui um padrão de camadas típico em um aplicativo Spring Boot com MySQL e H2 para testes. As principais camadas incluem:

- **Camada de Controle (Controller):** Responsável por receber solicitações HTTP, interagir com o usuário e chamar os serviços apropriados.

- **Camada de Serviço (Service):** Contém a lógica de negócios do aplicativo. Os serviços são chamados pelos controladores e interagem com os repositórios.

- **Camada de Repositório (Repository):** Responsável pela comunicação com o banco de dados MySQL e H2. Ela fornece métodos para acessar e manipular os dados armazenados no banco de dados.

- **Camada de Modelo (Model):** Representa as entidades do domínio do aplicativo.

## Diagrama de Objetos

- O diagrama de objetos é uma representação visual poderosa que nos permite compreender como as instâncias de classes interagem em tempo de execução dentro de nosso sistema. Ele oferece uma visão detalhada das relações entre objetos e suas características durante a execução do programa.

- No contexto deste projeto da Loja de Vendas Online desenvolvido com Spring Boot, o diagrama de objetos nos ajuda a visualizar como as entidades, como produtos, clientes, pedidos e pagamentos, são instanciados e conectados durante as diferentes operações do sistema.

![Diagrama de Objetos](https://github.com/kaiquesilvadev/lojaDeVendas-spring_boot/blob/main/Captura%20de%20tela%202023-09-28%20210357.png)

## Começando

Siga as instruções abaixo para configurar e executar o projeto em sua máquina local.

### Pré-requisitos

- Java Development Kit (JDK)
- MySQL instalado e em execução
- IDE de sua escolha (recomendado: IntelliJ IDEA ou Spring Tool Suite)

### Instalação

1. Clone este repositório para o seu ambiente de desenvolvimento local:

```bash
git clone https://github.com/kaiquesilvadev/workshop-spring-boot-mongodb.git

````

2. Navegue até o diretório do projeto:

```bash
cd workshop-springboot3-jpa

```

3. Execute o aplicativo Spring Boot:

```bash
./mvnw spring-boot:run

```

## Implementações Futuras

Este projeto já representa um passo significativo no desenvolvimento de um sistema eficiente e funcional. No entanto, estau comprometido em continuar aprimorando e expandindo suas funcionalidades. Algumas das implementações futuras que planejamos explorar incluem:

### 1. Testes Unitários

A qualidade do código é essencial para garantir a confiabilidade e o desempenho do sistema. Para alcançar isso, planejo implementar um conjunto abrangente de testes unitários. Isso envolverá a criação de casos de teste para cada componente do aplicativo, incluindo controladores, serviços e repositórios.

### 2. Melhorias na Segurança

A segurança dos dados do cliente e do sistema é uma prioridade máxima. Planejo implementar medidas adicionais, como autenticação e autorização, proteção contra vulnerabilidades conhecidas, criptografia de dados, monitoramento de segurança e auditorias regulares de segurança.

Estas são apenas algumas das melhorias planejadas para garantir que nosso sistema da Loja de Vendas Online permaneça seguro e confiável à medida que continuo a expandir suas funcionalidades.


## Contribuições

Se você deseja contribuir para este projeto, siga estas etapas:

1. Fork o projeto
2. Crie uma branch para a sua feature (`git checkout -b feature/sua-feature`)
3. Commit suas mudanças (`git commit -m 'Adicione sua feature'`)
4. Push para a branch (`git push origin feature/sua-feature`)
5. Abra um Pull Request

Por favor, certifique-se de seguir as diretrizes de contribuição.

## Contato

Se você tiver alguma dúvida, sugestões ou precisar de suporte, não hesite em entrar em contato:

- **LinkedIn:** [João Kaique](https://www.linkedin.com/in/joaokaique/)
