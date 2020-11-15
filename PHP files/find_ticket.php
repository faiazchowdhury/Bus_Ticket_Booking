<?php 
	session_start();
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$ticket_no=$_POST['ticket'];
	$ticket_no_int=intval($ticket_no);
	$query=" SELECT * from ticket where ticket_id='$ticket_no_int';";
	$result=mysqli_query($db,$query);
	if($result->num_rows > 0){
		while($row = $result->fetch_assoc()){		 
			echo $row['route']." - "; 
			echo $row['coach']." - "; 
			echo $row['date']." - "; 
			echo $row['time']." - "; 
			echo $row['price']." - ";
			echo $row['bkash_no']." - ";
			echo $row['seats']; 
		}
	}
			 
?>