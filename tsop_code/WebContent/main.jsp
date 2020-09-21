<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./vendor/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<link rel="stylesheet" href="./tsop/css/tsop-nav.css">
<link rel="stylesheet" href="./tsop/css/tsop-layout.css">
<link rel="stylesheet" href="./tsop/css/tsop-color.css">
<link rel="stylesheet" href="./tsop/css/tsop-button.css">

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="./vendor/js/popper.min.js"></script>
<script src="./vendor/js/bootstrap.min.js"></script>
<script src="./tsop/js/player.js"></script>
</head>
<body>
	<c:import url="./navBar.jsp"></c:import>
	
<div class="content">
	<div class="container-fluid py-5">
	
		<!-- 차트 목록 -->
		<div class="">
		
		<div class="card-deck">
			<!-- 곡 목록 -->
		  <div class="card chart-all border m-5"> 
		    <img class="card-img-top" src="./tsop/image/music.png" alt="Card image cap">
		    <div class="card-body">
		      <h4 class="card-title text-main"><a href="./chart.do?job=track" class="text-link">Track</a></h4>
		      <table class="table table-hover bg-white">
		      	<tbody>
		      		<c:forEach items="${musics}" var="music" varStatus="rank">
						<c:if test="${rank.index lt 5 }">
						<tr class="music">
							<td class="align-middle">${rank.index+1}</td>
							<td class="align-middle">
								<img class="img" src='${music.musicImagePath}'>
							</td>
							<td class="align-middle">
								<a class="text-link" href="./musicinfo.do?musicId=${music.musicId}&memberId=${music.memberId}">${music.musicTitle}</a>
							</td>
							<td class="align-middle">
								<a class="text-link" href="./memberinfo.do?memberId=${music.memberId}">${music.memberNickName}</a>
							</td>
							<td class="align-middle">
								<button type="button" class="btn-tsop btn-play-music fa fa-play" name="play"></button>
							</td>
							<td class="hidden"> <input type="hidden" name="musicId" value="${music.musicId }"></td>
							<td class="hidden"> <input type="hidden" name="musicFilePath" value="${music }"></td>
						</c:if>
						</c:forEach>
		      	</tbody>
		      </table>
		    </div>
		  </div>
		  
		  <!-- 플레이리스트 목록 -->
		  <div class="card chart-all border m-5">
		    <img class="card-img-top" src="./tsop/image/playlist.png" alt="Card image cap">
		    <div class="card-body">
		      <h4 class="card-title text-main"><a href="./chart.do?job=playlist" class="text-link">Playlist</a></h4>
		      <table class="table table-hover bg-white">
		      	<tbody>
		      		<c:forEach items="${playlists}" var="playlist" varStatus="rank">
						<c:if test="${rank.index lt 5 }">
							<tr class="playlist">
								<td class="align-middle">
									${rank.index+1}
								</td>
								<td class="align-middle">
									<img class="img" src='${playlist.imagePath }'>
								</td>
								<td class="align-middle">
									<a class="text-link" href="./playlistinfo.do?playlistId=${playlist.playlistId}&memberId=${playlist.memberId}">${playlist.playlistTitle}</a>
								</td>
								<td class="align-middle">
									<a  class="text-link" href="./memberinfo.do?memberId=${playlist.memberId}">${playlist.memberNickName}</a>
								</td>
								<td class="align-middle">
									<button type="button" class="btn-tsop btn-play-playlist fa fa-play" name="play"></button>
								</td>
								<td class="hidden">
									<input type="hidden" name="playlistId" value="${requestScope.playlist.playlistId }">
								</td>
							</tr>
						</c:if>
						</c:forEach>
		      	</tbody>
		      </table>
		    </div>
		  </div>
		  <div class="card chart-all border m-5">
		    <img class="card-img-top" src="./tsop/image/artist.png" alt="Card image cap">
		    <div class="card-body">
		      <h4 class="card-title text-main"><a href="./chart.do?job=artist" class="text-link">Artist</a></h4>
		      <table class="table table-hover bg-white">
		      	<tbody>
		      		<c:forEach items="${members}" var="member" varStatus="rank">
						<c:if test="${rank.index lt 5 }">
							<tr class="music">
								<td class="align-middle">
									${rank.index+1}
								</td>
								<td class="align-middle">
									<img class="img" src='${member.imagePath}'>
								</td>
								<td class="align-middle">
									<a class="text-link" href="./memberinfo.do?memberId=${member.memberId}">${member.memberNickName}</a>
								</td>
								<td class="hidden">
									<input type="hidden" name="memberId" value="${member.memberId }">
								</td>
							</tr>
						</c:if>
					</c:forEach>
		      	</tbody>
		      </table>
		    </div>
		  </div>
		</div>
	</div>
</div>
</div>

	
	<jsp:include page="/player.jsp"></jsp:include>
	
</body>
</html>