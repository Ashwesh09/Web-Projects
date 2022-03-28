<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Addition in Spring MVC</title>
	</head>
	<body>
		<form action="add">
  		<label for="num1">First number:</label><br>
  			<input type="text" id="num1" name="num1"><br>
  		<label for="num2">Second number:</label><br>
  			<input type="text" id="num2" name="num2"><br><br>
  		<input type="submit" value="Submit">
	</form>
			
		<h2>${message}</h2>
	</body>
</html>