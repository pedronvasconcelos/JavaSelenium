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
### [LoginTests](https://github.com/pedronvasconcelos/desafioSelenium/blob/master/src/test/java/com/javaseleniumtemplate/tests/LoginTests.java)<br />
1- Login Successfully; <br />
2- Login with JavaScript; <br />
3- Login without Username; <br />
4- Login without Password; <br />
5- Login with wrong Password; <br />
6- Login with non-existent user; <br />
7- Logout successfully; <br />
8- Validate UserViewer restrictions; <br />
9- Validade UserDeveloper restrictions; <br />
10- Recovery password with wrong email; <br />
### [ManageFieldTests](https://github.com/pedronvasconcelos/desafioSelenium/blob/master/src/test/java/com/javaseleniumtemplate/tests/ManageFieldTests.java)<br />
11- Create new custom field; <br />
12- Edit custom field; <br />
13- Delete custom field; <br />
14- Validate required name custom field; <br />
### [ManageProfilesTests](https://github.com/pedronvasconcelos/desafioSelenium/blob/master/src/test/java/com/javaseleniumtemplate/tests/ManageProfilesTests.java)<br />
15- Create global profile; <br />
16- Check 'OS Version' field required; <br />
17-Check 'Os' field required; <br />
18- Check 'Platform' field required; <br />
### [ManageProjectTests](https://github.com/pedronvasconcelos/desafioSelenium/blob/master/src/test/java/com/javaseleniumtemplate/tests/ManageProjectTests.java)<br />
19- Create new project; <br />
20- Create with project with a query; <br />
21- Delete a project; <br />
22- Update project name; <br />
23- Create new private project; <br />
24- Create new sub project; <br />
25- Create new version; <br />
26- Create new category; <br />
### [ManageTagTests](https://github.com/pedronvasconcelos/desafioSelenium/blob/master/src/test/java/com/javaseleniumtemplate/tests/ManageTagTests.java)<br />
27- Create new tag; <br />
28- Update tag; <br />
29- Delete tag; <br />
### [ManageUserTests](https://github.com/pedronvasconcelos/desafioSelenium/blob/master/src/test/java/com/javaseleniumtemplate/tests/ManageUserTests.java)<br />
30- Create new reporter user; <br />
31- Create new developer user; <br />
32- Create new manager user; <br />
33- Create new viewer user; <br />
34- Create new administrator user; <br />
35- Create new updater user; <br />
36- Delete a user; <br />
37- Change user email; <br />
38- Create a user without a username; <br />
39- Create a user with duplicated email; <br />
40- Create duplicate user; <br />
41- Filter a user; <br />
### [MyAccountTests](https://github.com/pedronvasconcelos/desafioSelenium/blob/master/src/test/java/com/javaseleniumtemplate/tests/MyAccountTests.java)<br />
42- Update realname; <br />
43- Create API Token Successfully; <br />
44- Validate required token name; <br />
### [ReportIssueTests](https://github.com/pedronvasconcelos/desafioSelenium/blob/master/src/test/java/com/javaseleniumtemplate/tests/ReportIssueTests.java)<br />
45- Register new issue with Data-Driven; <br />
46- Register new issue successfully; <br />
47- Check 'Summary' field required; <br />
48- Register new issue urgent priority; <br />
49- Register new issue with file evidence; <br />
50- Upload evidence larger than max size; <br />
51- Upload evidence In Existing Issue; <br />
52- Delete a Issue; <br />


