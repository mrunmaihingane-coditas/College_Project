<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>

	<!-- Adding Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<!-- Adding custom CSS -->
	<style>
		header {
			background-color: #007bff;
			color: #fff;
			padding: 10px;
			margin-bottom: 20px;
		}

		h1 {
			font-size: 40px;
			margin-bottom: 0;
		}

		label {
			font-size: 18px;
			font-weight: bold;
			margin-bottom: 10px;
			display: block;
		}

		#image-display img {
			max-width: 100%;
			margin-bottom: 10px;
		}

		#image-buttons button {
			margin-right: 10px;
		}
	</style>
</head>
<body>

	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>

	<!-- Adding Bootstrap container -->
	<div class="container">
		<header>
			<h1 class="text-center">Image Loader</h1>
		</header>

		<div id="image-loader">
			<label for="file-input">Choose an image</label>
			<input type="file" id="file-input">
			<div id="image-display"></div>
			<div id="image-buttons">

				<form action="hello" method="post" enctype="multipart/form-data" >
				<label for="profile-image">Profile Image:</label>
                  <input type="file" id="profile-image" name="profile-image"><br><br>
                  <input type="submit" value="Submit">
                   <input type="reset" value="Reset">

                </form>

			</div>
		</div>
	</div>

	<!-- Adding college image -->
	<div class="container mt-5">
		<img src="https://picsum.photos/id/237/600/400" class="img-fluid rounded">
	</div>

	<!-- Adding Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAy
