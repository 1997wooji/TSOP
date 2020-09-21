<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		  <a class="nav-link" href="./memberinfo.do?memberId=${member.memberId }">Tracks</a>
		  <a class="nav-link " href="./memberplaylist.do?memberId=${member.memberId }">Playlist</a>
		  <a class="nav-link " href="./memberfollows.do?memberId=${member.memberId }">Follows</a>
		  <a class="nav-link active" href="./memberfollowers.do?memberId=${member.memberId }">Followers</a>
		</nav>
			
		<div class="container">
			
			<div class="card-columns p-5">
				<c:forEach items="${followers }" var="follower">
				  <div class="card follower shadow">
				  	<input type="hidden" value="${follower.memberId }" name="memberId">
				  	<img class="card-img-top p-2" src="${follower.imagePath }" alt="Card image cap">
				    <div class="card-body text-center">
				      <h5 class="card-title">${follower.memberNickName }</h5>
				    </div>
				  </div> 
				 </c:forEach>
			</div>
		</div>
		
	</div>	
</div>

<!-- 플레이어 -->
<jsp:include page="/player.jsp"></jsp:include>

</body>
</html>