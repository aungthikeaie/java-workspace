<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<style>
	.my-custom-scrollbar {
position: relative;
height: 200px;
overflow: auto;
}
.table-wrapper-scroll-y {
display: block;
}
</style>

</head>
<body>
<div class="container">
	
		
<nav class="navbar navbar-dark bg-info">
  <a class="navbar-brand" href="#">
    <i class="fa fa-user-circle-o" aria-hidden="true"></i>
    SE Home
  </a>
</nav>
Semester<select>
  <option value="volvo">first</option>
  <option value="saab">second</option>
</select><sub>  </sub>


   Year  <select>
  <option value="volvo">first</option>
  <option value="saab">second</option>
  <option value="mercedes">third</option>
  <option value="audi">fourth</option>
</select>


Major<select>
  <option value="volvo">CEIT</option>
  <option value="saab">ME</option>
  <option value="mercedes">Civil</option>
  <option value="audi">Mining</option>
</select>
<div class="table-wrapper-scroll-y my-custom-scrollbar">

  <table class="table table-bordered table-striped mb-0">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
        <th scope="col">Attendance</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td><input type="checkbox">P</td>
      </tr>
      <tr>
        <th scope="row">2</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
         <td><input type="checkbox">P</td>
      </tr>
      <tr>
        <th scope="row">3</th>
        <td>Larry</td>
        <td>the Bird</td>
        <td>@twitter</td>
         <td><input type="checkbox">P</td>
      </tr>
      <tr>
        <th scope="row">4</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
         <td><input type="checkbox">P</td>
      </tr>
      
      <tr>
        <th scope="row">5</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
         <td><input type="checkbox">P</td>
      </tr>
      <tr>
        <th scope="row">6</th>
        <td>Larry</td>
        <td>the Bird</td>
        <td>@twitter</td>
         <td><input type="checkbox">P</td>
      </tr>
    </tbody>
  </table>

</div>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>