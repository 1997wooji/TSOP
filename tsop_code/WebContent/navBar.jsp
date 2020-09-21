<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="./tsop/css/tsop-login.css">
</head>
<body>


<nav class="navbar navbar-main topbar navbar-tsop shadow-lg fixed-top row">
	<input type="hidden" id="currentId" value="${currentId }">
	<div class="col">
		<div class="float-left tsop-logo">
			<a class="navbar-brand" href="./chart.do?job=all">Home</a>
		</div>
		<div class="float-left">
			<a class="nav-link" href="./chart.do?job=track">Chart</a>
		</div>
		<div class="float-left">
			<a class="nav-link" href="./cloud.do">Cloud</a>
		</div>
	</div>
	<div class="col">
		<div class='flex-fill'>
			<form action="./search.do" method="GET">
				<div class="input-group">
					<input type="text" name="key" class="form-control" placeholder="곡 찾기..." aria-label="Username" aria-describedby="basic-addon1">
					<input type="hidden" name="job" value="music">
					<div class="input-group-append bg-indigo">
						<button type="submit" class="btn btn-form fa fa-search" id="basic-addon1"></button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="navbar-right col">
			<c:choose>
			<c:when test="${sessionScope.loginId eq null }">
			<div class="float-right">
			<a href="#login-modal"class="nav-link" data-toggle="modal" >로그인</a>
			</div>
			</c:when>
			<c:otherwise>
			<div class="float-right">
			<a class="nav-link" href="./loginout.do?memberId=${sessionScope.loginId }&job=logout">로그아웃</a>
			</div>
			<div class="float-right">
			<a class="nav-link" href="./memberinfo.do?memberId=${sessionScope.loginId }">${sessionScope.loginNickname }</a>
			</div>
			</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>
<!-- Modal -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
     <div class="modal-dialog">
     	<div class="modal-content modal-login-content">
				<div class="loginmodal-container">
					<h1>로그인</h1><br>
				  <form action="./loginout.do" method="post">
					<input type="text" name="loginId" placeholder="아이디">
					<input type="hidden" name="job" value="login">
					<input type="password" name="loginPassword" placeholder="비밀번호">
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </form>
					
				  <div class="login-help">
					<a href="#">회원가입</a> - <a href="#">아이디/비밀번호 찾기</a>
				  </div>
				</div>
			</div>
		</div>
  </div>
</div>
</body>
</html>