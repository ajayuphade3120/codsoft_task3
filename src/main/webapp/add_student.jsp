<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="/css/Style.css" rel="stylesheet" type="text/css">
    <!-- Add any CSS styles if n
    eeded -->
    <style>
body {
    background-image: url("image/image.jpg");
     
}

</style>

</head>
<body>
   <nav class="navbar navbar-expand-lg navbar-white  bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">SRSystem</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add_student.jsp">Add Student</a>
        </li>
    
      </ul>
      <form class="d-flex">
      
      
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<section class="vh-100 bg-image">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5"> New Student Registration</h2>
                     
      
        <form action="AddStudent" method="post" >

            <label class="form-label" for="form1Example1">Student Name</label>        
         <input type="text" id="form1Example1" class="form-control" name="name" value="" />

        <label for="rollNumber" class="form-label">Roll Number</label>
        <input type="text" id="rollnumber" id="form3Example3cg" class="form-control" name="rollnumber" value="">

		  <label for="grade">Grade</label>
		 <input type="text"  id="grade" id="form3Example3cg" class="form-control" name="grade" value=""><br><br>
      
        <!-- Add other relevant details as needed -->

             <input type="submit" value="Add Students"  class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">
    </form>
    <!-- Display any success or error messages here, if applicable -->

</body>
</html>
