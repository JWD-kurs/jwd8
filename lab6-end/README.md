## Lab 6 - SPA, AngularJS

### SPA (Single Page Application)

U SPA, potreban kod - HTML, JavaScript i CSS se ne učitavaju odjednom, već se parcijalno dovlače AJAX pozivima kada su potrebni.
Reload stranica se ne radi ni u kom trenutku, kao ni prebacivanje na neku drugu stranicu ununtar aplikacije - stvara se samo privid
reload-ovanja stranica i navigacije kao ostalim stranicama. Odnosno, dešava se samo logička promena stranica, iako je korisnik sve vreme zapravo na istoj stranici
(otuda naziv Single Page Application).
Interakcija sa SPA uključuje stalnu komunikaciju aplikacije sa (REST) web servisom u pozadini.

1. (SPA and the Single Page Myth)[http://www.johnpapa.net/pageinspa/]
2. (SPA-wiki)[http://en.wikipedia.org/wiki/Single-page_application]

Glavna ideja SPA je da se renderuju i menjaju samo oni elementi korisničkog interfejsa za koje je to potrebno.
Menjanje elemenata korisničkog interfejsa uglavnom podrazumeva intenzivnu manipulaciju HTML-om i DOM-om unutar stranice.

Postoji veliki broj JavaScript biblioteka koje služe za pravljenje SPA (AngularJS, Backbone.js, Ember.js...). Na ovom kursu
će biti korišćen AngularJS (verzija 1.3.15).

### AngularJS

AngularJS je JavaScript framework za pravljenje klijentskih aplikacija (JS, HTML, CSS). Nastao je u Google, ali je sada open-source projekat.
AngularJS se koristi za pravljenje SPA, pritom se oslanjajući na REST web servise za obavljanje CRUD operacija nad podacima.

----

* U src/main/webapp/static/js dodati JavaScript fajlove angular.js i angular-route.js.

* U src/main/webapp/static/js napraviti novi fajl - app.js - ovde će biti pisan sav Angular kod koji se koristi u klijentskoj SPA aplikaciji.

* U src/main/webapp/static napraviti novi folder "html" - ovde će biti sav HTML za SPA frontend aplikaciju.

* U src/main/webapp/static/html dodati fajl - index.html.

* U index.html premestiti sve iz header.jsp i footer.js i dodati import angular.js, angular-route.js i app.js. Takođe, obrisati sve korišćene JSP tagove i elemente.

```html
<script src="static/js/angular.js"></script>
<script src="static/js/angular-route.js"></script>
<script src="static/js/app.js"></script>
```

* U WelcomeController fajlu izmeniti 

```java
return "home";
```

da bude

```java
return "static/html/index.html" />
```

Takođe, obrisati sledeći deo koda iz application.properties:

```code
spring.view.prefix: /WEB-INF/jsp/
spring.view.suffix: .jsp
```

----

* Prebaciti sadržaj home.jsp stranice u home.html. Izmeniti da se ne koriste JSP, već obični HTML tagovi. Takođe sva href polja izmeniti da na početku sadrže tarabu - hashtag(#).

----

### AngularJS aplikacija

* U app.js inicijalizovati AngularJS aplikaciju, nazvaćemo je wafepaApp:

```javascript
var wafepaApp = angular.module('wafepaApp', []);
```

* Takođe, u index.html postaviti direktivu ng-app na nivou korenskog HTML elementa:

```html
<html ng-app="wafepaApp">
...
</html>
```

----

### Controller, scope, view

Kontroleri su zaduženi za manipulaciju modelom (podacima sa kojim radimo). Model se prikazuje pomoću HTML-a, odnosno unutar nekog view-a.
Kontroler može primiti parametar $scope, gde $scope predstavlja vezu sa modelom - svi objekti koje se dodaju u $scope predstavljaju model i mogu se prikazati unutar view-a.

![AngularJS controller scope view](http://devgirl.org/wp-content/uploads/2013/03/concepts-controller.png)

* Definisati MyController kontroler u app.js (ovaj kontroler ćemo koristiti samo privremeno):

```javascript
wafepaApp.controller('MyController', function($scope) {

});
```

* U index.html postaviti direktivu ng-controller na div element:

```html
<div id="container" class="container" ng-controller="MyController">

</div>
```

----

### Rutiranje

Rutiranje predstavlja menjanje stranica kroz interakciju sa aplikacijom (npr. klik na link). U SPA, menjanje stranica se ne događa fizički, jer je korisnik uvek na istoj stranici.
U AngularJS, rutiranje je omogućeno kroz servis $routeProvider, koji se nalazi u modulu ngRoute. Ovaj modul se uključuje u aplikaciju sa angular-route.js.

* U app.js dodati ngRoute modul u aplikaciju:

```javascript
var wafepaApp = angular.module('wafepaApp', ['ngRoute']);
```

* Konfigurisanje $routeProvider servisa se vrši pobrajanjem svih ruta - when('/ruta'), kao i koja stranica se prikazuje na odgovarajućoj ruti - templateUrl : 'page.html'.

```javascript
wafepaApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : 'static/html/home.html'
		})
		.when('/activities', {
			templateUrl : 'static/html/activities.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);
```

* Stranica definisana unutar templateUrl parametra se prikazuje ununtar HTML elementa koji je označen sa ng-view direktivom:

```html
<div id="container" class="container" ng-view>

</div>
```
