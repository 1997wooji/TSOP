<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<script>
	$(document).ready(function(){
		$("[name=listTitle]").click(function(){
			$("#listInfo").attr("method", "post");
			$("#listInfo").attr("action", "PlaylistInfo.do");
			$("#listInfo").submit();
		});
		
		$("[name=nickName]").click(function(){
			$("#listInfo").attr("method", "post");
			$("#listInfo").attr("action", "MemberInfo.do");
			$("#listInfo").submit();
		});
		
		$("[name=musicTitle]").click(function(){
			$("#musicInfo").attr("method", "post");
			$("#musicInfo").attr("action", "MusicInfo.do");
			$("#musicInfo").submit();
		});
		
	});
</script>
</head>
<body>
	<c:import url="./navBar.jsp"></c:import>
	<div class="container py-5">
		<div class="container content border bg-white">
		
			<!-- 차트 네비게이션 -->
			<ul class="nav mt-5">
				<li class="nav-item">
					<a class="nav-link active" href="./chart.do?job=track"><h5>TRACK</h5></a>
				</li>
				<li class="nav-item">
					<a class="nav-link " href="./chart.do?job=playlist"><h5>PLAYLIST</h5></a>
				</li>
				<li class="nav-item">
					<a class="nav-link " href="./chart.do?job=artist"><h5>ARTIST</h5></a>
				</li>
			</ul>
			
			<h3 class="chart-caption p-5">
				Playlist Chart
			</h3>
			
			<table class="table table-hover border table-playlist">
				<thead>
					<tr>
						<th scope="col" class="col-index text-center">순위</th>
						<th scope="col" class="col-img" aria-label="이미지"></th>
						<th scope="col" class="col-title">제목</th>
						<th scope="col" class="col-name">닉네임</th>
						<th scope="col" class="col-btn" aria-label="좋아요 버튼"></th>
						<th scope="col" class="col-btn" aria-label="플레이 리스트 듣기"></th>
						<th class="hidden" aria-label="memberId"></th>
						<th class="hidden" aria-label="playlistId"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${playlists}" var="playlist" varStatus="rank">
				<c:if test="${rank.index lt 10 }">
					<tr class="playlist" data-toggle="collapse" data-target=".multi-collapse-${playlist.playlistId }">
						<th scope="row" class="col-index">${rank.index+1}</th>
						<!-- 이미지 경로 수정해야함 -->
						<td class="col-img"><img class="img" src="${playlist.imagePath }"></td>
						<td class="col-title"><a class="text-link" href="./playlistinfo.do?playlistId=${playlist.playlistId}&memberId=${playlist.memberId}">${playlist.playlistTitle }</a></td>
						<td class="col-name"><a class="text-link" href="./memberinfo.do?memberId=${playlist.memberId}">${playlist.memberNickName }</a></td>
						<!-- 좋아요 버튼 토글 추가해야됨 -->
						<td class="col-btn align-middle">
							<button type="button" class="btn-tsop btn-play-music fa fa-play"></button>
						</td>
						<td class="col-btn align-middle">
							<button type="button" class="btn-tsop btn-like fa fa-heart"></button>
						</td> 
						<td class="hidden" name="memberId">${playlist.memberId}</td>
						<td class="hidden" name="playlistId">${playlist.playlistId}</td>
					</tr>
				</c:if>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/player.jsp"></jsp:include>
</body>
</html>