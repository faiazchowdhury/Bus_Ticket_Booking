<?php 
	session_start();
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$email=$_POST['email'];		
	$route=$_POST['route'];
	$date=$_POST['date'];
	$time=$_POST['time'];
	$coach=$_POST['coach'];
	$seats=$_POST['seats'];
	$number=$_POST['number'];
	$price=$_POST['price'];
	$insert=" INSERT INTO ticket (customer_id_fk,route,coach,date,time,seats,bkash_no,price) VALUES ('$email','$route','$coach','$date','$time','$seats','$number','$price'); ";
	$result=mysqli_query($db,$insert);
	$query=" SELECT * from ticket where customer_id_fk='$email' and route='$route' and coach='$coach' and date='$date' and time='$time' and seats='$seats' and bkash_no='$number' and price='$price';";
	$result=mysqli_query($db,$query);
	if($result->num_rows > 0){
		while($row = $result->fetch_assoc()){		
			echo $row['ticket_id']; 
		}
	}
?>