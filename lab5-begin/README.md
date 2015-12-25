## Lab 5 - REST web service, DTO

----

> ### Nova podešavanja za bazu
> Od sada, umesto `jwtsX` koristite `jwd7_X` za konektovanje na bazu (korisničko ime, lozinka, naziv šeme).




----


Classical web - server side generated HTML:
![Server side generated HTML](https://gitlab.levi9.com/d.gajic/code9/raw/master/img/web-centric.png)


Data centric approach - server side generated data:
![Data Centric](https://gitlab.levi9.com/d.gajic/code9/raw/master/img/data-centric.png)


### REST

----

REST web servis (često nazivan i REST Web API) je web servis implementiran korišćenjem HTTP protokola i REST (*Representation State Transfer*) principa - [What is REST](http://martinfowler.com/articles/richardsonMaturityModel.html).
REST web servis predstavlja kolekciju **resursa**, sa sledećim aspektima:

1. bazna URL adresa web servisa
2. tipovi podataka koji se primaju/šalju od strane web servisa su JSON i/ili XML
3. skup operacija podržanih od strane web servisa korišćenjem HTTP (npr. GET, PUT, POST, DELETE)

HTTP protokol ima bogat vokabular [metoda](http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html):

- GET
- POST
- PUT
- DELETE

Korišćenjem ovog vokabulara API (web servis) se dizajnira tako da je za svaki entitet (resurs)
potreban samo njegov URL za vršenje CRUD operacija preko različitih HTTP metoda:
- ako se traži kolekcija resursa: /activities
- ako se traži konkretan resurs: /activities/{id}, gde id predstavlja identifikator resursa

| Resurs                                      | GET                                                                           | PUT                                                                | POST                                                                                                      | DELETE                 |
|---------------------------------------------|-------------------------------------------------------------------------------|--------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|------------------------|
| Kolekcija http://example.com/resources      | Listaj URI-je i eventualno druge detalja o svim članovima kolekcije.          | Zameni celu kolekciju drugom kolekcijom.                           | Dodaj novog člana kolekcije. URI ovog člana se obično generiše automatski i vraća kao rezultat operacije. | Obriši celu kolekciju. |
| Element http://example.com/resources/item17 | Dobavi traženi element kolekcije u obliku koji je naveden u header-u zahteva. | Zameni navedeni član kolekcije, a ukoliko ne postoji kreiraj novi. | Obično se ne koristi.                                                                                     |Obriši element         |

----

#### Spring MVC i REST

1. [Building a RESTful Web Service](http://spring.io/guides/gs/rest-service/)
2. [Spring REST support](http://docs.spring.io/spring/docs/4.0.3.RELEASE/spring-framework-reference/htmlsingle/#mvc-ann-restcontroller)
3. [HTTP Status Codes] (http://www.restapitutorial.com/httpstatuscodes.html)

----

* Napraviti `ApiActivityController` u paketu `jwd.wafepa.web.controller`. Staviti da se ovaj kontroler mapira na URL `api/activities` i anotirati ga sa `@RestController`.

* Implementirati CRUD operacije za aktivnosti prateći REST princip.

* Kako bi se podaci (objekti) koje vraća/prihvata REST web servis serijalizovali u JSON objekte,
potrebno je dodati dependency za Jackson mapper (koji mapira Java objekte na JSON, i obrnuto):

```xml
<!-- JSON -->
<dependency>
	<groupId>org.codehaus.jackson</groupId>
	<artifactId>jackson-mapper-asl</artifactId>
	<version>1.9.13</version>
</dependency>
<dependency>
	<groupId>org.codehaus.jackson</groupId>
	<artifactId>jackson-core-asl</artifactId>
	<version>1.9.13</version>
</dependency>
<dependency>
	<groupId>org.codehaus.jackson</groupId>
	<artifactId>jackson-jaxrs</artifactId>
	<version>1.9.13</version>
</dependency>
```

* Testirati napravljeni REST web servis u web browseru.

----

### DTO (Data Transfer Object)

Data Transfer Object je objekat koji se koristi za enkapsulaciju podataka, 
i za njihovo slanje/prijem od strane jednog podsistema aplikacije ka drugom podsistemu.

DTO se najčešće koriste u višeslojnoj aplikaciji za transfer podataka između same aplikacije i UI sloja.
Takođe se veoma dobro uklapaju u MVC šablon.

----

* Napraviti paket `jwd.wafepa.web.dto`

* Napraviti klasu `ActivityDTO` u paketu `jwd.wafepa.web.dto`. Polja klase `ActivityDTO` treba da budu ista kao polja klase `Activity` (`Long id`, `String name`).

* Prebaciti sve anotacije koje se koriste za validaciju podataka iz `Activity` u `ActivityDTO`.

* Izmeniti `ApiActivityController` da ne koristi `Activity` za prenos podataka između UI sloja i aplikacije, već `ActivityDTO`.

* Testirati napravljeni REST web servis u web browseru.

----

### Domaći zadatak

1. Po uzoru na aktivitnosti, napraviti REST web servis za korisnike
2. Napraviti UserDTO klasu i izmeniti REST web servis za korisnike da koristi UserDTO, a ne User klasu.
3. Testirati napravljeni REST web servis u web browseru.
4. **Ponoviti jQuery i JavaScript**