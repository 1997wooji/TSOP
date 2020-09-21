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
<script>
	$(document).ready(function(){
		$("[name=nickName]").click(function(){
			$("#memberInfo").attr("method", "post");
			$("#memberInfo").attr("action", "MemberInfo.do");
			$("#memberInfo").submit();
		});
	});
</script>
<title>Insert title here</title>
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
				Artist Chart
			</h3>
			
			<table class="table table-hover border table-artist">
				<thead>
					<tr>
						<th scope="col" class="col-index text-center">순위</th>
						<th scope="col" class="col-img" aria-label="이미지"></th>
						<th scope="col" class="col-name">아티스트 명</th>
						<th scope="col" class="col-btn" aria-label="팔로우 버튼"></th>
						<th class="hidden" aria-label="memberId"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${members}" var="member" varStatus="rank">
				<c:if test="${rank.index lt 10 }">
					<tr class="music">
						<th scope="row" class="col-index">${rank.index+1}</th>
						<!-- 이미지 경로 수정해야함 -->
						<td class="col-img"><img class="img img-circle" src="${member.imagePath }"></td>
						<td class="col-name"><a class="text-link" href="./memberinfo.do?memberId=${member.memberId}">${member.memberNickName }</a></td>
						<!-- 팔로우 버튼 토글 추가해야됨 -->
						<td class="col-btn align-middle">
							<button type="button" class="btn btn-follow fas fa-kiss-wink-heart"></button>
						</td> 
						<td class="hidden" name="memberId">${member.memberId}</td>
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