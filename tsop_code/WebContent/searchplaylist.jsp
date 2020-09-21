<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<c:import url="./navBar.jsp"></c:import>
	<div class="content">
		<div class="container py-5">
		
			<!-- 차트 네비게이션 -->
			<ul class="nav mt-2">
				<li class="nav-item">
					<a class="nav-link" href="./musicchart.do">TRACK</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./playlistchart.do">PLAYLIST</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="./artistchart.do">ARTIST</a>
				</li>
			</ul>
			
			<h3 class="chart-caption p-5">
				재생 목록 검색 결과
			</h3>
			
			<table class="table table-hover border table-playlist">
				<thead>
					<tr>
						<th scope="col" class="col-index text-center">#</th>
						<th scope="col" class="col-img" aria-label="이미지"></th>
						<th scope="col" class="col-title">제목</th>
						<th scope="col" class="col-name">닉네임</th>
						<th scope="col" class="col-like" aria-label="좋아요 수"></th>
						<th scope="col" class="col-btn" aria-label="좋아요 버튼"></th>
						<th scope="col" class="col-btn" aria-label="플레이 리스트 듣기"></th>
						<th class="hidden" aria-label="memberId"></th>
						<th class="hidden" aria-label="playlistId"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="playlist" varStatus="rank">
					<tr class="playlist" data-toggle="collapse" data-target=".multi-collapse-${playlist.playlistId }">
						<th scope="row" class="col-index">${rank.index+1}</th>
						<!-- 이미지 경로 수정해야함 -->
						<td class="col-img"><img class="img" src="./tsop/image/test.png"></td>
						<td class="col-title"><a href="./playlistinfo.do?playlistId=${playlist.playlistId}">${playlist.playlistTitle }</a></td>
						<td class="col-name"><a href="./memberinfo.do?memberId=${playlist.memberId}">${playlist.memberNickName }</a></td>
						<td class="col-like">
							<!-- 좋아요 수 링크해야함 -->
							10
						</td>
						<!-- 좋아요 버튼 토글 추가해야됨 -->
						<td class="col-btn align-middle">
							<button type="button" class="btn btn-follow fas fa-heart"></button>
						</td>
						<td class="col-btn align-middle">
							<button type="button" class="btn btn-follow fas fa-play"></button>
						</td> 
						<td class="hidden" name="memberId">${playlist.memberId}</td>
						<td class="hidden" name="playlistId">${playlist.playlistId}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/player.jsp"></jsp:include>
</body>
</html>