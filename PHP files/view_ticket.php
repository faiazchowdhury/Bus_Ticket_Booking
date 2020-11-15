<?php 
	session_start();
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$email=$_POST['email'];
	$query=" SELECT * from ticket where customer_id_fk='$email';";
	$result=mysqli_query($db,$query);
	if($result->num_rows > 0){
		while($row = $result->fetch_assoc()){		
			echo $row['ticket_id']." - "; 
			echo $row['route']." - "; 
			echo $row['coach']." - "; 
			echo $row['date']." - "; 
			echo $row['time']." - "; 
			echo $row['price']." - ";
			echo $row['seats']."<br>"; 
		}
	}
			 
?>