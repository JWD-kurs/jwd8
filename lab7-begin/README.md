## Lab 7 - SPA, AngularJS

----

### $http servis

$http servis služi za komunikaciju sa HTTP serverom, u ovom slučaju REST serverom. Podržana je većina HTTP metoda, ali najčešće su get, put, post, delete.
Primeri korišćenja:

```javascript
$http.get('route') 									// poziva se GET route (route je putanja resursa ili kolekcije na REST servisu)
		.success(function(data, status) {			// ako je status 2xx (npr. 200 OK), u data se nalaze trazeni podaci
			// do something
		})
		.error(function(data, status) { 			// ako se dogodila greska, tj. ako status nije 2xx
			// handle error
		});
		
		
$http.post('route', { attrName : 'attrValue'})		// route je putanja kolekcije, drugi parametar je objekat koji se dodaje u kolekciju
		.success(...)
		.error(...)
		
$http.put('route', { attrName : 'attrValue'})		// route je putanja resursa, drugi parametar je objekat predstavlja izmenjen resurs
		.success(...)
		.error(...)
		
$http.delete('route')								// route je putanja resursa koji se briše
		.success(...)
		.error(...)
		
```

Za više informacija o $http servisu pogledati AngularJS dokumentaciju [https://docs.angularjs.org/api/ng/service/$http](https://docs.angularjs.org/api/ng/service/$http)

----

* Proširenje trenutnog rešenja tako da se na stranici za prikaz svih aktivnosti prikaže poruka greške ukoliko se ona dogodila tokom učitavanja aktivnosti sa servera.

* Ubacivanje "loading spinner"-a koji se prikazuje dok se aktivnosti učitavaju sa servera.
Potreban CSS kod:

```css
.glyphicon-refresh-animate {
    -animation: spin .7s infinite linear;
    -ms-animation: spin .7s infinite linear;
    -webkit-animation: spinw .7s infinite linear;
    -moz-animation: spinm .7s infinite linear;
}
 
@keyframes spin {
    from { transform: scale(1) rotate(0deg);}
    to { transform: scale(1) rotate(360deg);}
}
  
@-webkit-keyframes spinw {
    from { -webkit-transform: rotate(0deg);}
    to { -webkit-transform: rotate(360deg);}
}
 
@-moz-keyframes spinm {
    from { -moz-transform: rotate(0deg);}
    to { -moz-transform: rotate(360deg);}
}
```

U HTML-u loading spinner prikazati ispod tabele korišćenjem:

```html
<div class="col-md-12 text-center">
	<span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>
</div>
```

* Implementacija brisanja jedne aktivnosti - dodati crveno dugme Delete za svaku aktivnost u koloni Actions u tabeli za prikaz svih aktivnosti.
Dodati metodu **deleteActivity** u **ActivitiesController** koja se poziva klikom na dugme Delete upotrebom direktive **ng-click**.

----

### $location servis

$location servis služi za programsko čitanje i menjanje URL adrese u address baru browsera.
Primer korišćenja:

```javascript
$location.path('/route'); 		// redirekcija korisnika na route stranicu
```

Za više informacija o $location servisu pogledati AngularJS dokumentaciju [https://docs.angularjs.org/api/ng/service/$location](https://docs.angularjs.org/api/ng/service/$location)

----

* Implementacija dodavanje nove aktivnosti - napraviti odgovarajući parcijalni view i dodati rutu /#/activities/add kojom se odlazi na ovu stranicu.
Svu logiku za dodavanje (a kasnije i izmenu) pojedinačne aktivnosti implementirati u **ActivitiesController**.

* Kada se nova aktivnost uspešno doda u kolekciju, korisnika poslati na stranicu sa svim aktivnostima korišćenjem $location servisa

----

* Implementacija izmene aktivnosti - dodati novo dugme Edit za svaku aktivnost u koloni Actions u tabeli za prikaz svih aktivnosti.
Klikom na ovo dugme korisnik se usmerava na stranicu /#/activities/edit/:id (:id predstavlja id aktivnosti). Dodati potrebnu rutu za izmenu aktivnosti.

* Koristiti $routeParams servis u **ActivitiesController** za dobavljanje parametara rute - u ovom slučaju id aktivnosti.
Iskoristiti id aktivnosti za učitavanje aktivnosti sa servera i popunjavanje forme za izmenu aktivnosti.

----