## Lab 9 - Veze između entiteta: one-to-many, many-to-one...

----

### Hibernate relacije

Hibernate omogućava modelovanje kompleksnijih relacija između entiteta kroz anotacije:

* @OneToMany - modelovanje relacije jedan-na-više (npr. jedan student polaže više predmeta)
* @ManyToOne - modelovanje relacije više-na-jedan (npr. nekoliko proizvoda se nalazi u korpi proizvoda)
* @OneToOne - modelovanje relacije jedan-na-jedan (npr. jedan čovek živi u na jednoj adresi)
* @ManyToMany - modelovanje relacije više-na-više (npr. više programera može raditi na više različitih projekata)

----

### Novi entitet - Log

* Napraviti novi entitet Log, koji predstavlja belešku/log određene aktivnosti za određenog korisnika (npr. korisnik XY je određenog datuma vršio aktivnost trčanje 10 minuta).
* Više logova može biti vezano za tačno jednu aktivnost (@ManyToOne), tj. jedna aktivnost može imati više logova (@OneToMany). Svaki log sadrži polja **date (tipa java.util.Date)** (datum kada je izvršena aktivnost) i polje **duration (tipa Integer)** (trajanje aktivnosti u minutima).

* Na stranici za prikaz aktivnosti, u tabeli dodati kolonu Logs, a vrednost te kolone je broj zabeleženih logova za aktivnost.
* Omogućiti prikaz svih logova na zasebnoj stranici.
* Omogućiti dodavanje novog loga. Na stranici za dodavanje u select kontroli ponuditi sve aktivnosti. **Napomena:** datum unositi u formatu "yyyy-MM-dd" (za sad).
* Na stranici za prikaz aktivnosti, u tabeli, u koloni Logs, klikom na broj aktivnosti na zasebnoj stranici prikazati sve logove za izabranu aktivnost (ova stranica treba da izgleda isto kao stranica za prikaz svih logova).

----

### Domaći zadatak

* Proširiti entitet Log tako da je vezan i za korisnika.
* Više logova može biti vezano za tačno jednog korisnika, tj. jedan korisnik može imati više logova.
* Na stranici za prikaz korisnika, u tabeli dodati kolonu Logs, a vrednost te kolone je broj zabeleženih logova za korisnika.
* Na stranici za dodavanje loga u select kontroli ponuditi sve korisnike.
* Na stranici za prikaz korisnika, u tabeli, u koloni Logs, klikom na broj aktivnosti na zasebnoj stranici prikazati sve logove za izabranog korisnika (ova stranica treba da izgleda isto kao stranica za prikaz svih logova).

----
