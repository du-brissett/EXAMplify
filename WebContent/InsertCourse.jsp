<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Course</title>
<link rel="stylesheet" type="text/css" href="css/style2.css">
</head>
<body >


<div class="insert">Add Course into Course Bank</div>
 <div class="container" style="background-image: url(img/picoo.jpg) ;background-size: contain;background-attachment:fixed;" >
 
  <form action="CourseController" method="post">

    <label for="fname">CourseCode</label>
    <input type="text"  name="courseCode" placeholder="Enter Course-code..">

    <label for="lname">Title</label>
    <input type="text"  name="title" placeholder="Enter Course-Title">

   

    <label for="subject">CourseDescription</label>
    <textarea id="subject" name="courseDes" placeholder="Write something.." style="height:200px"></textarea>

    <input type="submit" value="Submit">

  </form>

</div>
</body>
</html>