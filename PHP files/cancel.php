<?php 
	session_start();
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$email=$_POST['email'];
	$number=$_POST['number'];
	$refund=$_POST['refund'];
	$ticket_no=$_POST['ticket_no'];
	$ticket_no_int=intval($ticket_no);
	$query=" DELETE from ticket where ticket_id='$ticket_no_int'; ";
	$result=mysqli_query($db,$query);

	$query=" INSERT INTO refund (customer_id_fk,refund_value,bkash_no)VALUES ('$email','$refund','$number'); ";
	$result=mysqli_query($db,$query);
?>