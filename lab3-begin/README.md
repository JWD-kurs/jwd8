## Lab 3 - Bootstrap, Forme


### Bootstrap

Bootstrap predstavlja biblioteku CSS (CSS3) klasa, kao i pomoćnih JavaScript funkcija.
Kompatibilan je isključivo sa HTML5 dokumentima. Baziran je na tzv. "responsive design" principu,
i omogućava lako prilagođavanje web aplikacije mobilnim uređajima (tablet, smartphone, ...).

Veoma je dobro dokumentovan, sa velikim brojem primera korišćenja. Bootstrap se može preuzeti na ovom [linku](http://getbootstrap.com/).

----

#### Statički resursi (CSS, jS) u Spring MVC

* U projekat je uključen folder `src/main/webapp/static`, u kom se nalaze datoteke potrebne za Bootstrap

* Spring Boot automatski omogućava da datoteke iz foldera sa takvom putanjom budu na raspolaganju browser-u. 

### Header i footer

Uvešćemo datoteke za gornje i donje zaglavlje, koje će biti identične na celoj web aplikaciji. 

* Kreirati foldere src/main/webapp/WEB-INF/jsp/layout i src/main/webapp/WEB-INF/jsp/common
* U common folderu kreirati tagLibs.jsp sa sledećim sadržajem:
 
```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

```

* u `layout` folderu kreirati `header.jsp`


```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>WAFEPA</title>

        <!-- Bootstrap -->
        <link href="/static/css/bootstrap.css" rel="stylesheet">
        <link href="/static/css/bootstrap-theme.css" rel="stylesheet">
		
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="/static/js/jquery-2.1.1.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="/static/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">Home</a>
                </div>
            </div>
        </div>
        <div class="jumbotron">
            <div class="container text-center">
                <h1>WAFEPA</h1>
                <p>Web Application For Evaluating Physical Activities</p>
            </div>
        </div>

```
* Obratiti pažnju na korišćene Boostrap CSS klase, kao i na obavezno navođenje DOCTYPE pre html taga (ovo za HTML5 stranice mora biti navedeno).

* Kreiramo i `footer.jsp` u `layout` folderu

```html
    </body>
</html>

```




* Izmeniti `activities.jsp` i `home.jsp` tako da se na početku stranice uključi `header.jsp`, a na kraju `footer.jsp`
* Izmeniti telo `home.jsp` tako da se korise bootstrap CSS klase 

```html
<div class="container text-center">
	<!-- Example row of columns -->
	<h1>WAFEPA - Home</h1>
	<div class="row">
		<div class="col-md-6">
			<h2>Activities</h2>
			<p>CRUD operations on activities</p>
			<p><a class="btn btn-default" href="activities">Go to activities</a>
			</p>
		</div>
		<div class="col-md-6">
			<h2>Users</h2>
			<p>CRUD operations on users</p>
			<p><a class="btn btn-default" href="users">Go to users</a>
			</p>
		</div>
	</div>
	<hr>
</div>

```

* Na stranici `activities.jsp` dodati linkove za /edit/{id} i /add

### Forme za dotavanje i izmenu

* u `jsp` folderu kreirati stranicu `addEditActivity.jsp`

```html
<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<h1>WAFEPA - Add/edit activity</h1>

<form:form action="/activities" method="post" modelAttribute="activity" class="form-horizontal">

    <form:hidden path="id" />

    <div class="form-group">
        <form:label path="name" cssClass="col-sm-2">Name </form:label>
        <div class="col-sm-6">
            <form:input path="name" cssClass="form-control" />
        </div>
    </div>      

    <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
  </div>
</form:form>

<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>

```

* u `ActivityController` klasi dodati metode koje će obrađivati `GET` zahteve za odlazak na stranicu za izmenu/dodavanje i `POST` zahtev koji dolazi sa te stranice


----

### Domaći zadatak

1. Dodati Bootstrap stilove na stranice activities.jsp i addEditActivity.jsp
2. Eksperimentisati sa Bootstrap CSS i komponentama
3. Po uzoru na stranice za aktivnosti, kreirati stranice za dodavanje i izmenu korisnika