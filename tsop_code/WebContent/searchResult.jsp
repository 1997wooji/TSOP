<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Insert title here</title>
<style>
p:hover{
color: red;
}
</style>
</head>
<body>

<form id="form1" action="SearchMusic.do" method="get">
<p id="p1">music</p>

<input type="hidden" name="job" value="1"></input>

</form>

<form id="form2" action="SearchMusic.do" method="get">
<p id="p2">musiclist</p>
<input type="hidden" name="job" value="2"></input>
</form>


<form id="form3" action="SearchMusic.do" method="get">
<p id="p3">artist</p>
<input type="hidden" name="job" value="3"></input>
</form>


<c:if test="${job == 1 }">
<c:forEach items="${list}" var="music" begin="0" end="${listSize }" varStatus="st1">
<form id="musicInfo" style="border: 1px solid black">
	<div>${st1.index+1}</div>
	<img src="${music.img}" style="width:50px; height:50px"></img>
	<div id="musicKey" value="${music.musicId }" name="musicId">${music.musicId }</div>
	<div id="musicTitle">${music.musicTitle }</div>
	<div id="memberId" name="memberId">${music.memberId }</div>
	<div id="memberNickName">${music.memberNickName }</div>
</form>
</c:forEach>
</c:if>

<c:if test="${job == 2 }">
<c:forEach items="${list}" var="playlist" begin="0" end="${listSize }" varStatus="st2">
<div style="border: 1px solid black">
	<div>${st2.index+1}</div>
	<div id="playlistImg">${playlist.imagePath }</div>
	<form id="playlistInfo" action="PlaylistInfo.do" method="get">
	<div id="playlistKey" value="${playlist.playlistId }" name="playlistKey">${playlist.playlistId }</div>
	<div id="playlistTitle">${playlist.playlistTitle }</div>
	</form>
	
		<div id="memberId" name="memberId">${playlist.memberId }</div>
	<form id="nickName" action="MemberInfo.do" method="get">
	<div id="memberNickName">${playlist.memberNickName }</div>
	</form>
</div>
</c:forEach>
</c:if>

<c:if test="${job == 3 }">
<c:forEach items="${list }" var="member" begin="0" end="${listSize }" varStatus="st3">
<form style="border: 1px solid black">
	<div>${st3.index+1}</div>
	<div>${member.imagePath }</div>
	<div>${member.memberId }</div>
	<div>${member.memberNickName }</div>
</form>
</c:forEach>
</c:if>

</body>

<script src="./vendor/js/jquery-slim.min.js"></script>
<script src="./js/searchResult.js"></script>
<script>
$(document).ready(function(){
		$('#playlistTitle').click(function(e){
			$('#title').submit();
		});
	});

</script>

</html>
