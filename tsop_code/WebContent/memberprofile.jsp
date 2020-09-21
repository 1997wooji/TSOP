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
<!-- 상단 프로필 -->
		<div class="profile">
			<div class="jumbotron rounded-0 text-white<c:choose>
			<c:when test="${sessionScope.loginId eq member.memberId }">
			bg-image-jiwoo
			</c:when>
			<c:otherwise>
			bg-image
			</c:otherwise>
			</c:choose>">
				<div class="row d-flex p-3">
					<div class="float-left">
						<img src="${member.imagePath }" class="img-jumbo img-circle">
					</div>
					<div class="float-left ml-3">
						<h1 class="nickname display-4">${member.memberNickName }</h1>
						<input type="hidden" value="${member.memberId }" name="memberId" id="name"/>
						<p class="lead">${member.memberIntro }</p>
					</div>
				</div>
				
				
				<div class="text-right">
					<c:if test="${member.memberId eq sessionScope.loginId }">
					<button type="button" class="btn btn-primary float-right">프로필 변경</button>
					</c:if>
					<input type="hidden" id="isFollow" value="${sessionScope.isFollow eq true }" name="isFollow">
					<c:if test="${member.memberId ne sessionScope.loginId }">
					
					<button type="button" class="btn btn-primary float-right follow mr-2">
					
					<c:choose>
					<c:when test="${sessionScope.isFollow eq true}">
					팔로우 취소						
					</c:when>
					<c:otherwise>
					팔로우
					</c:otherwise>
					</c:choose>
					</button>
					</c:if>
				</div>
			</div>
		</div>
</body>
<script>
	$(document).ready(function(e) {
		$(".follow").click(function(e) {
			$.ajax({
				url:"./follow.do",
				data: {
					memberId: $(".profile").find("[name=memberId]").val(),
					isFollow: $(".profile").find("[name=isFollow]").val()
				},
				type: "POST",
				success: function(data, status) {
					if (data.trim() == "true") {
						$(".profile").find(".follow").text("팔로우 취소");
						$(".profile").find("[name=isFollow]").val(data);
					} else {
						$(".profile").find(".follow").text("팔로우");
						$(".profile").find("[name=isFollow]").val(data);
					}
				}
			});
		});
	});
</script>
</html>