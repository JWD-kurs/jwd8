## Lab 2 - Spring MVC, Dependency injection

### Spring Boot

[Spring Boot](http://projects.spring.io/spring-boot/) se koristi kako bi se pojednostavila konfiguracija Spring projekata. Umesto XML konfiguracionih fajlova, koriste se anotacije u Java klasama. Takođe, na osnovu biblioteka raspoloživih na class path-u, Spring Boot automatski postavlja podrazumevanu konfiguraciju za svaku od njih. Ova konfiguracija se po potrebi može menjati. 

* Obratiti pažnju na izmenjen sadržaj `pom.xml`
* Napraviti klasu WafepaApplication u kojoj će se nalaziti početna Spring Boot konfiguracija. Klasa treba da nasledi `SpringBootServletInitializer`
* Anotirati klasu kao `@SpringBootApplication`
* Dodati ovoj kalsi main metodu
```java
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Wafepa.class, args);
	}
```
* **Pokrenuti klasu kao običnu Java aplikaciju**

* Napraviti datoteku `src/main/resources/application.properties` u kom se nalaze podešavanja za prefiks i sufiks, na osnovu kojih se od imena view-a dolazi do datoteke u kojoj se nalazi njegov šablon.  

```xml
spring.view.prefix: /WEB-INF/jsp/
spring.view.suffix: .jsp
```

### Spring MVC
![Spring MVC](https://gitlab.com/jocicmarko/jwts/raw/master/img/dispatcher.png)

### JSP

JavaServer Pages je template engine namenjen generisanju HTML, XML i drugog tekstualnog sadržaja. Kada se koristi kao view komponenta web aplikacije, svrha JSP-a je da na osnovu šablona i prosleđenog objektnog modela podataka generiše sadržaj koji je moguće prikazati u browser-u. U okviru šablona se za to predviđenim direktivama mogu navesti mesta gde treba umetnuti prikaz određenih podataka. 

![JSP arhitektura](https://upload.wikimedia.org/wikipedia/commons/7/72/JSP_Model_2.svg)

Izvor: Libertyernie2 (Own work) [CC BY-SA 3.0](http://creativecommons.org/licenses/by-sa/3.0), via Wikimedia Commons

* Napraviti JSP home stranicu (u `src/main/webapp/WEB-INF/jsp` folderu).
* Dodati view-ove: view za pregled svih aktivnosti i brisanje aktivnosti iz te liste.
* Kako bi mogli koristiti JSP i JSTL tagove, na početku JSP stranica importovati ove tagove:

```xml
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

### Servisi i kontroleri

* Napraviti WelcomeController klasu u paketu `jwd.wafepa.web.controller`
* kom će root putanja (`/`) biti mapirana na view sa imenom `home`. Koristiti [@RequestMapping](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestMapping.html) anotaciju. 

* [Dependency Injection](http://igordejanovic.net/courses/tech/DependencyInjection.html#/) je softverski obrazac koji se koristi kako bi se olakšalo instanciranje objekata. Postoje mnoge implementacije koje se mogu koristiti nezavisno od Spring-a. U okviru Spring Framework-a, DI se koristi kako bi se dobila referenca na neku komponentu

* Da bi Spring Dependency Injecion radio, potrebno je uključiti component-scan mehanizam. U Spring Boot, ovo podešavanje je deo anotacije `@SpringBootApplication` koju smo već primenili. 


* Anotirati `InMemoryActivityService` kao `@Service`

* Napraviti `ActivityController` klasu u paketu `jwts.wafepa.web.controller`
* Injektovati `ActivityService` u `ActivityController` korišćenjem `@Autowired` anotacije
* Definisati mapiranja za HTTP zahteve (`@RequestMapping`)


### Domaći zadatak
Po uzoru na aktivnosti, dodati mogućnost evidencije korisnika:

1. Dodati model klasu User (id, email, password, first name, last name)
2. Dodati servisni sloj za korisnike (interfejs i in-memory implementacija), kao i testove za servisni sloj
3. Dodati zaseban kontroler za korisnike
4. Napraviti zasebne view-ove za evidenciju korisnika