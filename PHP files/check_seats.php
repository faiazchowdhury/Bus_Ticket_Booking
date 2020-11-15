
<?php  
	session_start();
	$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
	$email=$_POST['email'];		
	$route=$_POST['route'];
	$date=$_POST['date'];
	$time=$_POST['time'];
	$coach=$_POST['coach'];
	$seats=$_POST['seats'];
	$pieces=explode(",", $seats);
	$flag= true;

	$_SESSION['email']=$email;
	$_SESSION['route']=$route;
	$_SESSION['time']=$time;
	$_SESSION['coach']=$coach;
	$_SESSION['date']=$date;

	foreach ($pieces as $value) {
  		if(booked($value)){}
  		else{
  			$flag=false;
  			echo "run again";
  			break;
  		}
	}

	if($flag){
		foreach ($pieces as $value) {
  			update($value);
		}
		echo "updated";
	}
	function update($id){
		$db=new mysqli('localhost','root','','bus_ticket_booking') or die("Unable to Connect to Database");
		$email=$_SESSION['email'];
		$route=$_SESSION['route'];
		$time=$_SESSION['time'];
		$date=$_SESSION['date'];
		$coach=$_SESSION['coach'];
		$sql="Update seat set $id='$email' where date='$date' and time='$time' and coach='$coach' and route='$route';";
		mysqli_query($db,$sql);
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
		return true;
	}
	else {
		return false;
	}
	}
?>