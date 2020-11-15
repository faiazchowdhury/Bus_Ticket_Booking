<?php  
	session_start();
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$email=$_POST['email'];		
	$route=$_POST['route'];
	$date=$_POST['date'];
	$time=$_POST['time'];
	$coach=$_POST['coach'];

	$_SESSION['route']=$route;
	$_SESSION['time']=$time;
	$_SESSION['coach']=$coach;
	$_SESSION['date']=$date;
	$quey="SELECT * FROM seat where date='$date' and time='$time' and coach='$coach' and route='$route';";
	$result=mysqli_query($db,$quey);
	if(mysqli_num_rows($result)==0){
		$query=" INSERT INTO seat (date,time,route,coach)VALUES ('$date','$time','$route','$coach'); ";
		$result=mysqli_query($db,$query);
	}
	else{
		if(booked("A1")){
			echo "A1,";
		}
		if(booked("A2")){
			echo "A2,";
		}
		if(booked("A3")){
			echo "A3,";
		}
		if(booked("A4")){
			echo "A4,";
		}
		if(booked("B1")){
			echo "B1,";
		}
		if(booked("B2")){
			echo "B2,";
		}
		if(booked("B3")){
			echo "B3,";
		}
		if(booked("B4")){
			echo "B4,";
		}
		if(booked("C1")){
			echo "C1,";
		}
		if(booked("C2")){
			echo "C2,";
		}
		if(booked("C3")){
			echo "C3,";
		}
		if(booked("C4")){
			echo "C4,";
		}
		if(booked("D1")){
			echo "D1,";
		}
		if(booked("D2")){
			echo "D2,";
		}
		if(booked("D3")){
			echo "D3,";
		}
		if(booked("D4")){
			echo "D4,";
		}
		if(booked("E1")){
			echo "E1,";
		}
		if(booked("E2")){
			echo "E2,";
		}
		if(booked("E3")){
			echo "E3,";
		}
		if(booked("E4")){
			echo "E4,";
		}
		if(booked("F1")){
			echo "F1,";
		}
		if(booked("F2")){
			echo "F2,";
		}
		if(booked("F3")){
			echo "F3,";
		}
		if(booked("F4")){
			echo "F4,";
		}
		if(booked("G1")){
			echo "G1,";
		}
		if(booked("G2")){
			echo "G2,";
		}
		if(booked("G3")){
			echo "G3,";
		}
		if(booked("G4")){
			echo "G4,";
		}
		if(booked("H1")){
			echo "H1,";
		}
		if(booked("H2")){
			echo "H2,";
		}
		if(booked("H3")){
			echo "H3,";
		}
		if(booked("H4")){
			echo "H4,";
		}
		if(booked("H5")){
			echo "H5,";
		}
	}
	function booked($id){
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$route=$_SESSION['route'];
	$time=$_SESSION['time'];
	$date=$_SESSION['date'];
	$coach=$_SESSION['coach'];
	$quey="SELECT * FROM seat where date='$date' and time='$time' and coach='$coach' and route='$route' and $id='0';";
	$result=mysqli_query($db,$quey);
	if(mysqli_num_rows($result)==1){
		return false;
	}
	else {
		return true;
	}
	}
?>