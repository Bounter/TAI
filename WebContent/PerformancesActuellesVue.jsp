<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
	integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
	integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
	crossorigin="anonymous"></script>



<title>Performances Actuelles</title>
</head>
<body>
	<div class="btn-group" role="group"
		aria-label="Basic radio toggle button group">
		<input type="radio" class="btn-check" name="btnradio" id="btnradio1"
			autocomplete="off" checked> <label
			class="btn btn-outline-primary" for="btnradio1">Pointage</label> <input
			type="radio" class="btn-check" name="btnradio" id="btnradio2"
			autocomplete="off"> <label class="btn btn-outline-primary"
			for="btnradio2">Performances Actuelles</label> <input type="radio"
			class="btn-check" name="btnradio" id="btnradio3" autocomplete="off">
		<label class="btn btn-outline-primary" for="btnradio3">Etat
			machine</label>
	</div>

	<table class="table align-middle">

		<thead>
			<tr>
				<th>Performances Personelles</th>

			</tr>

		</thead>
		<tbody>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Objectif</th>
				<th scope="col">Heures travaillées</th>
				<th scope="col">Nombre OF</th>
				<th scope="col">Performance</th>

			</tr>

			<td><c:out value="${utilisateur.donneestravail.date }" /></td>
			<td><c:out value="${utilisateur.donneestravail.objectifPeso}" /></td>
			<td><c:out value="${utilisateur.donneestravail.hTravail}" /></td>
			<td><c:out value="${utilisateur.donneestravail.nbrOF}" /></td>
			<td><c:out value="${utilisateur.donneestravail.performance}" /></td>
			</tr>

		</tbody>


	</table>


</body>
</html>