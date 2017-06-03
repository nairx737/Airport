<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
      <link href="styleAddFlight.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <div class="container">
    <form method="post" action="result">
      <input type="text" name="FlyFrom" placeholder="Flying from">
      <input type="text" name="FlyTo" placeholder="Fly to">
      <input type="date" name="Departing" placeholder="Departing day">
      <input type="text" name="Price" placeholder="Price in USD">
      <input type="submit" value="submit">


    </form>
  </div>

  </body>
</html>