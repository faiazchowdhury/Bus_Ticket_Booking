<?php 
	session_start();
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$email=$_POST['email'];		
	$pass=$_POST['pass'];
	$num=$_POST['num'];
	$name=$_POST['name'];
	$insert=" INSERT INTO customer (pass,email,mobile_number,name) VALUES ('$pass','$email','$num','$name'); ";
	$result=mysqli_query($db,$insert);
?>