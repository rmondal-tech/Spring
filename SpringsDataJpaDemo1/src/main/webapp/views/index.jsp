<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sprimg Mvc demo 2- ModelAndView, Prefix and Suffix ,Model,ModelMap</title>
</head>
<body>

// @PostMapping, Person to be stored in table through postMapping method and then using JpaReository interface method save(S)
<br> 	
 	<form action="addPerson" method="post"> 
 		Enter Person Id : <input type="text" name="pid"><br>
 		Enter Person Name   : <input type="text" name="pname"><br>
 		<input type="submit">
 	</form>
 
 <br><br>
 
 //get details of one person by id
 <br> 	
 	<form action="getDetailsOfOnePerson" method="get"> 
 		Show Details of Person Id : <input type="text" name="pid"><br>
 		
 		<input type="submit">
 	</form>


 //get details of one person by name
 <br> 	
 	<form action="getDetailsByName" method="get"> 
 		Show Details of Person by Name : <input type="text" name="pname"><br>
 		
 		<input type="submit">
 	</form>

</body>
</html>