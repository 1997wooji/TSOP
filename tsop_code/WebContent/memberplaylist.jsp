<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="./vendor/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<link rel="stylesheet" href="./tsop/css/tsop.css">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="./vendor/js/popper.min.js"></script>
<script src="./vendor/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 상단 네비게이션 -->                                                   
<c:import url="./navBar.jsp"></c:import>


<div class="container p-0 content border-right border-left border-bottom">
	<!-- 상단 프로필 -->
	<div class="header p-0">
		<div class="jumbotron rounded-0 bg-image text-white">
			<h1 class="nickname display-4">닉네임</h1>
			<input type="hidden" value="회원 아이디" id="memberId"/>
			<p class="lead">자기 소개</p>
			<div class="text-right">
				<button type="button" class="btn btn-primary float-right">프로필 변경</button>
				<button type="button" class="btn btn-primary float-right">follow</button>
			</div>
		</div>
	</div>
	<!-- 컨텐츠 네비게이션 -->
	<div class="container">
		<nav class="nav border-bottom"> 
		  <a class="nav-link" href="./memberinfo.do?memberId=${member.memberId }">Tracks</a>
		  <a class="nav-link active" href="./memberplaylist.do?memberId=${member.memberId }">Playlist</a>
		  <a class="nav-link" href="./memberfollows.do?memberId=${member.memberId }">Follows</a>
		  <a class="nav-link" href="./memberfollowers.do?memberId=${member.memberId }">Followers</a>
		</nav>
		
		<div class="container">
			<div class="playlist-list">
				<!-- 여기 플레이리스트 목록이 옴 forEach 써서 가즈아 -->
				<div class="playlist playlist-list-item d-flex">
					<div class="playlist-image image">
						<img src="./tsop/image/test.png" class="img-big">
					</div>
					<div class="playlist-info card flex-fill">
						<div class="card-header">
							<div class="playlist-artist">
								닉네임
							</div>
							<div class="playlist-title">
								제목
							</div>
							<div class="playlist-genre">
								genre
							</div>
							<div class="playlist-tag">
								<span class="mr-3">
									tag
								</span>
								<span>
									#데자와
								</span>
							</div>
						</div>
						<div class="card-body">
							<table class="track-table table border">
								<!-- if 돌리자 -->
								<tbody>
									<!-- forEach 돌리자 -->
									<tr>
										<td style="width:30px">
											<img src="./tsop/image/test.png">
										</td>
										<td>
											노래 제목
										</td>
										<td style="width:200px;">
											노래 주인
										</td>
									</tr>
									<tr>
										<td style="width:30px">
											<img src="./tsop/image/test.png">
										</td>
										<td>
											노래 제목
										</td>
										<td style="width:200px;">
											노래 주인
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="card-footer">
							<div class="playlist-menu">
								<div class="float-left">
									좋아요 수
								</div>
								<button type="button" class="btn float-left fa fa-heart"></button>
								<button type="button" class="btn float-left fa fa-list"></button>
							</div>
						</div>
					</div>
				</div>
				<!-- 플레이리스트 목록 종료 -->
			</div>
		</div>
	</div>
</div>
<c:import url="./player.jsp"></c:import>



${playlist.playlistId}<br>
${playlist.playlistTitle}<br>
<img src=<c:out value="${playlist.imagePath}"/>><br>
${playlist.memberId}<br>
${playlist.memberNickName}<br>
${playlist.tagName}<br>
${playlist.playlistIntro}<br>
${playlist.playlistDate}<br>

<c:forEach var="music" items="${musiclist}">
	${music.musicId}<br>
	${music.likeCnt}<br>
	<img src=<c:out value="${music.imagePath}"/>><br>
</c:forEach>

</body>
</html>