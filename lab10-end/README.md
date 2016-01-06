## Lab 10 - custom direktive, custom servisi, modularizacija

----

### Pravljenje custom direktiva

Skoro sve što se koristi prilikom razvijanja AngularJS aplikacije su direktive - one čine AngularJS tako moćnim.
Iako sam AngularJS dolazi sa velikim brojem direktiva, često će se stvoriti potreba za pravljenjem "custom" funkcionalnosti.
Pravljenjem custom direktiva moguće je izmeniti ili izgraditi potpuno novo ponašanje unutar HTML.

Primer pravljenja custom direktive:

```javascript
app.directive('myDirective', function() {
	return {
		restrict: 'A', 							// moguće vrednosti: 'A' (attribute), 'E' (element), 'C' (class), 'M' (comment)
		template: '<span>My span</span>', 		// HTML koji će biti renderovan (koristi se ovo ILI templateUrl, ne oba)
		templateUrl: 'url/to/template.html',	// putanja ka fajlu koji sadrži HTML (koristi se ovo ILI template, ne oba)
		controller: 'MyController'				// kontroler
	}
});
```

Primeri korišćenja custom direktive:

```html
<div my-directive></div> 						<!-- ako je restrict: 'A' -->

<my-directive></my-directive>					<!-- ako je restrict: 'E' -->

<div class="my-directive"></div>				<!-- ako je restrict: 'C' -->
```

Obratiti pažnju da se ime direktive definiše u camel notaciji (nova reč počinje velikim slovom), ali kada se koristi unutar HTML-a
piše se u "dash" notaciji (reči razdvojene crticom, bez velikih slova), npr. myDirective -> my-directive.


Za više informacija o direktivama pogledati AngularJS dokumentaciju [https://docs.angularjs.org/guide/directive](https://docs.angularjs.org/guide/directive)

* Definisati custom direktivu "activitiesTable" koja sadrži tabelu sa svim aktivnostima.

----

### Pravljenje custom servisa

U AngularJS, servis predstavlja objekat koji obavlja specifičan zadatak (npr. $log za logovanje, $http za komunikaciju preko HTTP protokola),
a povezuje se sa ostatkom aplikacije pomoćuje injekcije (dependency injection). Servisi enkapsuliraju kod koji se koristi u direktivama i kontrolerima.

AngularJS nudi ima veliki broj servisa, ali često bude potrebno praviti novi, svoj, custom servis. 
Pravljenjem custom servisa izbegava se dupliciranje koda i smanjuje se složenost programa.

Primer pravljenja custom servisa:

```javascript
app.service('myService', function() {
	
	this.myServiceFunction = function() {
		return 'some text';
	};
});
```

Primer injektovanja i pozivanja custom servisa:

```javascript
app.controller('MyControler', function($scope, myService) {
	
	$scope.myControllerFunction = function() {
		$scope.text = myService.myServiceFunction();
	};
});
```

Obratiti pažnju da se servis OBAVEZNO injektuje u kontroler u kojem se koristi kao parametar funkcije (function($scope, myService) { ... }).
Takođe, custom servisi nemaju $ na početku imena, za razliku od AngularJS ugrađenih servisa.


* Definisati custom servis "activityRestService" koji će enkapsulirati čitavu funkcionalnost vezanu za dobavljanje, brisanje i čuvanje aktivnosti preko REST servera.

----

### Modularizacija komponenti AngularJS aplikacije u zasebne fajlove

* Razdvojiti aplikaciju u više modula, gde će svaki modul biti zasebni JavaScript fajl.

* Napraviti fajlove app.controllers.js, app.directives.js i app.services.js. U ove fajlove prebaciti odgovarajuće funkcionalnosti. OBAVEZNO dodati učitavanje ovih fajlova u index.html.