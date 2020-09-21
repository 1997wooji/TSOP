<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="./tsop/js/navSearch.js"></script>


<title>Insert title here</title>
</head>
<body>

<!-- 상단 네비게이션 -->                                                   
<c:import url="./navBar.jsp"></c:import>

<div class="container">
	<div class="container content p-0 border bg-white">
		<!-- 상단 프로필 -->
		<c:import url="./memberprofile.jsp"></c:import>
		
		<!-- 개인 페이지 네비게이션 -->
		<nav class="nav border-bottom"> 
		  <a class="nav-link " href="./memberinfo.do?memberId=${member.memberId }">Tracks</a>
		  <a class="nav-link " href="./memberplaylist.do?memberId=${member.memberId }">Playlist</a>
		  <a class="nav-link " href="./memberfollows.do?memberId=${member.memberId }">Follows</a>
		  <a class="nav-link " href="./memberfollowers.do?memberId=${member.memberId }">Followers</a>
		</nav>
			
		<div class="container">
			
			<c:import url="./musicdetail.jsp"></c:import>
			
			<div class="hidden">
			<div class="myPlaylist" name="myPlaylist">
			<button name="cancelBtn">X</button>
				<div class="playlistTitle" name="playlistTitle" >
				</div>
			</div>
			</div>
			<form id="submitForm">
				<input type="hidden" name="mId" value="">
				<input type="hidden" name="lId" value="">
			</form>
			
			
			<form id="updateForm">
				<div name="updateForm">
					<input type="hidden" id="1" name="musicId" value="${music.musicId }">
					<input type="hidden" id="2" name="imagePath" value="${music.imagePath}">
					<input type="hidden" id="3" name="updateTitle" value="">
					<input type="hidden" id="4" name="updateTag" value="">
					<input type="hidden" id="5" name="updateGenre" value="">
					<input type="hidden" id="6" name="updateIntro" value="">
					<input type="hidden" id="7" name="updateVisibility" value="">
					<input type="hidden" id="8" name="updateDownAccept" value="">
					<input type="hidden" id="9" name="memberId" value="${music.memberId }">
				</div>
			</form>
			
		</div>
	</div>	
</div>

<!-- 플레이어 -->
<jsp:include page="/player.jsp"></jsp:include>
</body>
<script src="./tsop/js/musicinfo.js"></script>

</html>