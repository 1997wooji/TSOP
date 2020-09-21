<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src=<c:out value="${member.imagePath}"/>>
<br>
<h1>${member.memberNickName}님의 페이지</h1>
<form action="./FollowMember.do" method="post"><input type="button" name="followBtn" value="Follow"><input type="hidden" name="followId" value=<c:out value="${member.memberId}"/>></form>
<br><br>
<h3>Reposts</h3>
---------------------------------------------
<form action="./MemberInfo.do" method="post"><input type="submit" value="Tracks"><input type="hidden" name="memberId" value=<c:out value="${member.memberId}"/>></form>
<form action="./MemberPlaylists.do" method="post"><input type="submit" value="Playlists"><input type="hidden"name="memberId" value=<c:out value="${member.memberId}"/>></form>
<form action="./MemberLikes.do" method="post"><input type="submit" value="Likes"><input type="hidden" name="memberId" value=<c:out value="${member.memberId}"/>></form>
<form action="./MemberReposts.do" method="post"><input type="submit" value="Reposts"><input type="hidden" name="memberId" value=<c:out value="${member.memberId}"/>></form>
<form action="./MemberFollows.do" method="post"><input type="submit" value="Follows"><input type="hidden" name="memberId" value=<c:out value="${member.memberId}"/>></form>
<form action="./MemberFollowers.do" method="post"><input type="submit" value="Followers"><input type="hidden" name="memberId" value=<c:out value="${member.memberId}"/>></form>
<br>
---------------------------------------------
<br>
<br>

${member.memberId}님이 Repost한 Playlist입니다.<br><br>

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