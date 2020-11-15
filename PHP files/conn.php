<?php 
$username="root";
$db_name="bus_ticket_booking";
$pass="";
$servername="localhost";
$conn=mysqli_connect($servername,$username,$pass,$db_name);
if ($conn) {
	echo("Connected Successfully");
}
else{
	echo("foff");
}
?>