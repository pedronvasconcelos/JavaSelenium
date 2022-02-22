# Desafio Automação Web - Selenium

## Créditos
  
Desafio - Base2 Automação Web

O que foi feito:

- 52 Scripts de teste;
- Utilizado Data-Driven no CT registerNewIssueDDT;
- Testes executados em 3 navegadores (Chrome, Edge e Firefox);
- Screenshots automáticas a cada passo com ExtendReports;
- Restore do Banco de Dados por linha de comando executando arquivo .sql através da JenkinsFile;
- Inserção de dados no Banco utilizando query com Insert;
- JavaScript Executor utilizado para interagir com alguns elementos;
- Testes agendados utilizando Jenkins; 
- Criado uma Pipeline no Jenkinss para CD-CI;
- Criado um Agent local para rodar os testes utilizando Jenkins;
- Projeto configurado para rodar utilizando SeleniumHub;
- WebDriver Manager;

## Setup

- Versão 1.8 do Java JDK instalada no computador (https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- Versão community do IntelliJ IDEA instalada no computador (https://www.jetbrains.com/pt-br/idea/download/#section=windows)
- Versão do Jenkins instalada no computador: Versão 2.319.1 (https://www.jenkins.io/download/)

## Arquitetura

- Linguagem Java
- Java Kit Development versão 8
- Gestão de dependências: Maven
- Framework de Testes automatizass web: Selenium WebDriver
- Orquestrador de testes: TestNG
- Relatório de testes automatizados: ExtentReports

## Cenários:
1- Login Successfully;
2- Login with JavaScript;
3- Login without Username;
4- Login without Password;
5- Login with wrong Password;
6- Login with non-existent user;
7- Logout successfully;
8- Validate UserViewer restrictions;
9- Validade UserDeveloper restrictions;
10- Recovery password with wrong email;
11- Create new custom field;
12- Edit custom field;
13- Delete custom field;
14- Validate required name custom field;
15- Create global profile;
16- Check 'OS Version' field required;
17-Check 'Os' field required;
18- Check 'Platform' field required;
19- Create new project;
20- Create with project with a query;
21- Delete a project;
22- Update project name;
23- Create new private project;
24- Create new sub project;
25- Create new version;
26- Create new category;
27- Create new tag;
28- Update tag;
29- Delete tag;
30- Create new reporter user;
31- Create new developer user;
32- Create new manager user;
33- Create new viewer user;
34- Create new administrator user;
35- Create new updater user;
36- Delete a user;
37- Change user email;
38- Create a user without a username;
39- Create a user with duplicated email;
40- Create duplicate user;
41- Filter a user;
42- Update realname;
43- Create API Token Successfully;
44- Validate required token name;
45- Register new issue with Data-Driven;
46- Register new issue successfully;
47- Check 'Summary' field required;
48- Register new issue urgent priority;
49- Register new issue with file evidence;
50- Upload evidence larger than max size;
51- Upload evidence In Existing Issue;
52- Delete a Issue;


