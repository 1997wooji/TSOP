<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="./vendor/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
	<link rel="stylesheet" href="./tsop/css/tsop.css">
	<link rel="stylesheet" href="./tsop/css/player.css"> 
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="./vendor/js/popper.min.js"></script>
	<script src="./vendor/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(e) {
			$("#test").click( function(e) {
				if ($(this).hasClass("fa-play")) {
					$(this).removeClass("fa-play");
					$(this).addClass("fa-pause");
				} else {
					$(this).removeClass("fa-pause");
					$(this).addClass("fa-play");
				};
			});
		});
	</script>
<title>Insert title here</title>
</head>
<body>
	
	
	
	<!-- 플레이어 -->
	<div class="container-fluid player fixed-bottom">
		<div class="float-left btn fa fa-step-backward" aria-label="이전곡"></div>
		<div class="float-left btn fa fa-play" id="test" aria-label="재생 및 일시정지"></div>
		<div class="float-left btn fa fa-step-forward" aria-label="다음곡"></div>
		<div class="float-left btn fa fa-random" aria-label="셔플"></div>
		<div class="float-left btn fas fa-redo" aria-label="반복"></div>
		
		<div class="float-right btn fa fa-th-list" aria-label="재생목록" data-toggle="dropdown"></div>
		<div class="dropdown-menu" id="">
			<div class="dropdown-header">PlayList</div>
			<div class="dropdown-item">
			  	<img name="playMusic" src="img/img1.jpg" style="width:50px;height:50px;">
				<span name="musicTitle">곡명1</span>
				<input type="hidden" name="memberName" value="멤버명1">
				<input type="hidden" name="title" value="곡명1">
				<input type="hidden" name="mId" value="1">
				<input type="hidden" name="memId" value="1">
			</div>
		</div>
		
		<div class="float-right btn fa fa-heart" aria-label="좋아요"></div>
		<div class="float-right player-info">
			<div class="player-text">멤버명</div>
			<div class="player-text ">곡명</div>
		</div>
		<img class="float-right img" src="./tsop/image/test.png">
		
		<div class="slidecontainer float-right">
		  <input type="range" min="1" max="100" value="50" class="slider" id="myRange">
		</div>
		<div class="float-right btn fa fa-volume-up" data-toggle="collapse" data-target="#volumeBar" aria-label="볼륨"></div>
		
		<div class="float-none mx-auto d-flex ustify-content-center" style="width:500px;">
			<div class="play-time play-time-start">1:30</div>
			<div class="progress" style="width:400px;">
				<div class="progress-bar" style="width:200px;">
				</div>
			</div>
			<div class="play-time play-time-end">3:00</div>
			
		</div>
	</div>
	
</body>

</html>
