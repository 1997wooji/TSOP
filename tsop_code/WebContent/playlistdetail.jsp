<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="playlist playlist-info">
	<div class="d-flex">
		<div class="playlist-image my-auto">
			<!-- 이미지 연동해야함 -->
			<img src="${playlist.imagePath }" class="img-jumbo border">
		</div>
		
		<!-- 플레이 리스트 정보 -->
		<div class="card flex-fill pl-5 border-0">
			<div class="card-header border-0 bg-white">
				<div>
					<div class="float-right ">${playlist.playlistDate }</div>
					<h3 class="float-none">${playlist.playlistTitle }</h3>
					<div>${playlist.memberNickName }</div>
					<div>태그</div>
					<div>${playlist.tagName }</div>
					<div></div>
				</div>
			</div>
			<div class="card-body border-0 bg-white">								
				<div>${playlist.playlistIntro }</div>
			</div>
			<div class="card-footer border-0 bg-white">
				<button type="button" class="btn-tsop btn-play-playlist fa fa-play"></button>
				<button type="button" class="btn-tsop btn-like fa fa-heart"></button>
				<button type="button" class="hidden btn-tsop btn-edit-playlist fa fa-edit"></button>
				<button type="button" class="hidden btn-tsop btn-edit-playlist fa fa-trash"></button>	
			</div>
		</div>
	</div>
	<input type="hidden" name="playlistId" value="${playlist.playlistId }">
</div>

<h3 class="chart-caption p-5">
	수록곡
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
		<tr class="music">
			<th scope="row" class="col-index">${rank.index+1}</th>
			<td class="col-img"><img class="img" src="${music.musicImagePath }"></td>
			<input type="hidden" value="${music.musicId}" name="playMusic">
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
	</c:forEach>
	</tbody>
</table>
</body>
</html>