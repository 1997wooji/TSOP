<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="./tsop/css/tsop-player.css"> 

<title>Insert title here</title>
</head>
<body>
	<!-- 플레이어 -->
	<div class="container-fluid player fixed-bottom">
		<div class="float-left btn fa fa-step-backward" aria-label="이전곡" id="prev"></div>
		<div class="float-left btn fa fa-play" aria-label="재생 " id="play"></div>
		<div class="float-left btn fa fa-pause" aria-label="일시정지" id="pause" style="display:none;"></div>
		<div class="float-left btn fa fa-step-forward" aria-label="다음곡" id="next"></div>
		<div class="float-left btn fa fa-random" aria-label="셔플" id="shuffle"></div>
		<div class="float-left btn fas fa-redo" aria-label="반복" id="repeat"></div>
		
		<div class="float-right btn fa fa-th-list" aria-label="재생목록" data-toggle="dropdown"></div>
		<div id="playlistDropDown">
		<div class="dropdown-menu">
			
		</div>
		</div>
		<div class="float-right btn fa fa-heart" aria-label="좋아요" id="likeMusicBtn"></div>
		<div class="float-right player-info">
			<div class="player-text" id="memName"></div>
			<div class="player-text " id="musicTitle"></div>
			<input type="hidden" id="playingMem" value="">
			<input type="hidden" id="playingMusic" value="">
		</div>
		<img class="float-right img" src="./tsop/image/Empty.png" id="musicCover">
		
		<div class="slidecontainer float-right"> 
		  <input type="range" min="1" max="100" value="50" class="slider" id="volume">
		</div>
		<div class="float-right btn fa fa-volume-up" data-toggle="collapse" data-target="#volumeBar" aria-label="볼륨"></div>
		
		<div class="float-none mx-auto d-flex ustify-content-center" style="width:500px;">
			<div class="play-time play-time-start" id="playingTime">0:00</div>
			<div class="progress" style="width:400px;" id="progressbar">
				<div class="progress-bar"></div>
			</div>
			<div class="play-time play-time-end" id="endTime">0:00</div>
		</div>
	</div>
</body>

</html>
