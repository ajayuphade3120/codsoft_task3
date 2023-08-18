<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Student Information</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="/css/Style.css" rel="stylesheet" type="text/css">
    <!-- Add any CSS styles if needed -->
</head>
<style>
body {
    background-image: url("image/image.jpg");
     
}

</style>
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
        
        
      </ul>
      <form class="d-flex">
      <form action="AddServlet" method="post">
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
    <h1 class="text-uppercase text-center mb-5">Student Information</h1>
        <form action="DisplayStudentServlet" method="post">
        
        <%
        String name=(String)session.getAttribute("name");
        String Rolln=(String)session.getAttribute("rollnumber");
        String grade=(String)session.getAttribute("grade");
        %>
    
    <p><strong>Name:</strong> <%= name %></p>
    <p><strong>Roll Number:</strong> <%= Rolln %></p>
    <p><strong>Grade:</strong> <%= grade %></p>
    <!-- Add other relevant student attributes as needed -->

    <!-- Display a message if the student is not found -->
    <% if (request.getAttribute("studentNotFound") != null) { %>
        <p><strong>Student not found.</strong></p>
    <% } %>

</body>
</html>

