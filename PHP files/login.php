<?php
	session_start();
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$email=$_POST['email'];
	$pass=$_POST['pass'];
	$check="SELECT * FROM customer where email='$email' and pass='$pass';";
	$res=mysqli_query($db,$check);
	if(mysqli_num_rows($res)==0){
		echo "false";
	}
	else{
		echo "true";
	}
?>