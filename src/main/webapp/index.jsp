<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Laboratorium 4</title>
</head>
<body>
<h2>Dodaj pracownika:</h2>
<form action="EmployeeServlet" method="post">
  ID: <input type="number" name="id"><br>
  Imię: <input type="text" name="firstName"><br>
  Nazwisko: <input type="text" name="lastName"><br>
  Stanowisko: <input type="text" name="position"><br>
  <input type="hidden" name="action" value="add">
  <input type="submit" value="Dodaj pracownika">
</form>

<hr>

<h2>Zaktualizuj pracownika:</h2>
<form action="EmployeeServlet" method="post">
  ID pracownika do aktualizacji: <input type="number" name="idToUpdate"><br>
  Nowe imię: <input type="text" name="newFirstName"><br>
  Nowe nazwisko: <input type="text" name="newLastName"><br>
  Nowe stanowisko: <input type="text" name="newPosition"><br>
  <input type="hidden" name="action" value="update">
  <input type="submit" value="Aktualizuj pracownika">
</form>
<hr>

<h2>Znajdź pracownika po ID:</h2>
<form action="EmployeeServlet" method="get">
  ID pracownika: <input type="number" name="idToFind"><br>
  <input type="hidden" name="action" value="getById">
  <input type="submit" value="Znajdź pracownika">
</form>

<hr>

<h2>Wyświetl wszystkich pracowników:</h2>
<form action="EmployeeServlet" method="get">
  <input type="hidden" name="action" value="getAll">
  <input type="submit" value="Wyświetl wszystkich pracowników">
</form>
</body>
</html>