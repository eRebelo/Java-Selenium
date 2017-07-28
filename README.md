# Selenium - Web Browser Automation
 Aplicação que automotiza o preenchimento automático de um formulário e seus eventos utilizando as bibliotecas HtmlUnit ou WebDriver do pacote Selenium - Web Browser Automation
 
## Ambiente de Desenvolvimento
- Eclipse
- Java 1.8
- Bibliteca HtmlUnit
- Bliblioteca WebDriver

----------
## Bibliotecas para importação 
- Build Path: bibliotecas se encontram compactadas dentro dos respectivos projetos
- Maven:
<br>
`<dependency>
	<groupId>org.seleniumhq.selenium</groupId>
	<artifactId>selenium-java</artifactId>
	<version>2.28.0</version>
	<exclusions>
		<exclusion>
			<groupId>net.sourceforge.htmlunit</groupId>
			<artifactId>htmlunit</artifactId>
		</exclusion>
		<exclusion>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpcore</artifactId>
		</exclusion>
	</exclusions>
</dependency>
<dependency>
	<groupId>net.sourceforge.htmlunit</groupId>
	<artifactId>htmlunit</artifactId>
	<version>2.15</version>
</dependency>
<dependency>
	<groupId>org.apache.httpcomponents</groupId>
	<artifactId>httpcore</artifactId>
	<version>4.3.2</version>
</dependency>`