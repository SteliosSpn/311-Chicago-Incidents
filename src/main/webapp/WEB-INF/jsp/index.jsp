<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Chicago</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Chicago</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">

	<c:choose>
		<c:when test="${mode == 'BOOK_VIEW' }">
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>id</th>
			        <th>book_name</th>
			        <th>author</th>
			        <th>Edit</th>
			      </tr>
			    </thead>
			    <tbody>
			     	<c:forEach var="book" items="${books}">
			     		<tr>
			     			<td>${book.id}</td>
			     			<td>${book.book_name}</td>
			     			<td>${book.author}</td>
			     			<td><a href="updateBook?id=${book.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
			     		</tr>
			     	</c:forEach>
			    </tbody>
  </table>
		</c:when>
		
		<c:when test="${mode == 'BOOK_EDIT' }">
				<form>
				<input type="hidden" class="form-control" value="${books.id}" name="id" id="id">
			  <div class="form-group">
			    <label for="book_name">Book Name:</label>
			    <input type="text" class="form-control" value="${book.book_name}" name="book_name" id="book_name">
			  </div>
			  <div class="form-group">
			    <label for="author">Author:</label>
			    <input type="text" class="form-control" value="${book.author}" name="author" id="author">
			  </div>
			  <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</c:when>
		
		<c:when test="${mode == 'P2' }">
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>count</th>
			      </tr>
			    </thead>
			    <tbody>
			     	<c:forEach var="p" items="${procedure2}">
			     		<tr>
			     			<td>${p.}</td>
			     		</tr>
			     	</c:forEach>
			    </tbody>
  </table>
		</c:when>
	</c:choose>
</div>

</body>
</html>
