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
<input type="hidden" name="key" value="">
<c:import url="./navBar.jsp"></c:import>
	<div class="container py-5">
		<div class="container content border bg-white">
		
			<!-- 서치 네비게이션 -->
			<ul class="nav mt-2">
				<li class="nav-item">
					<a class="nav-link active" href="./search.do?key=${key }&job=music">TRACK</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./search.do?key=${key }&job=playlist">PLAYLIST</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="./search.do?key=${key }&job=artist">ARTIST</a>
				</li>
			</ul>
			
			<h3 class="chart-caption p-5">
				곡 검색결과
			</h3>
			
			<table class="table table-hover border table-music bg-white">
				<thead>
					<tr>
						<th scope="col" class="col-index text-center">#</th>
						<th scope="col" class="col-img" aria-label="이미지"></th>
						<th scope="col" class="col-title">제목</th>
						<th scope="col" class="col-name">닉네임</th>
						<th scope="col" class="col-btn"aria-label="듣기"></th>
						<th scope="col" class="col-btn"aria-label="좋아요"></th>
						<th class="hidden" aria-label="memberId"></th>
						<th class="hidden" aria-label="musicId"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="music" varStatus="rank">
					<c:if test="${rank.index lt 10 }">
					<tr class="music">
						<th scope="row" class="col-index">${rank.index+1}</th>
						<td class="col-img"><img class="img" src="${music.musicImagePath }" alt="./tsop/image/test.png"></td>
						<td class="col-title"><a class="text-link" href="./musicinfo.do?musicId=${music.musicId}&memberId=${music.memberId}">${music.musicTitle }</a></td>
						<td class="col-name"><a class="text-link" href="./memberinfo.do?memberId=${music.memberId}">${music.memberNickName}</a></td>
						<td class="col-btn align-middle">
							<button type="button" class="btn-tsop btn-play-music fa fa-play"></button>
						</td>
						<td class="col-btn align-middle">
							<button type="button" class="btn-tsop btn-like fa fa-heart"></button>
						</td>
						<td class="hidden" name="memberId">${music.memberId}</td>
						<td class="hidden"><input type="hidden" name="musicId" value="${music.musicId}"></td>	
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