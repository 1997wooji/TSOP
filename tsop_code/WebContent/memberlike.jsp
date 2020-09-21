<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js">
</script>
<script>

	var followFunc = function(){
		
		$.ajax({
	        url:'./FollowMember.do',
	        method:'POST',
	        data:{'id':'${member.memberId}'},
	        success:function(){
	            alert('follow 성공!');
	            $('#followBtn').val('followed');
	            $('#followBtn').unbind('click',followFunc);
	        }
	    });
				
	}
	
	$(document).ready(function(e){
		var ifrm = parent.document.getElementById('player');
		var win = ifrm.contentWindow;
		var doc = ifrm.contentDocumnet? ifrm.contentDocument : ifrm.contentWindow.document;
		var audioPlayer = doc.getElementsByTagName('audio').item(0);
		var audioSource = $('audio > source:last-child');
		$('#followBtn').bind('click',followFunc);
		
		 $(".musicInfo").click(function(e) {
				var target = $(e.target);
				
				if (target.hasClass("musicTitle")) {
					$(this).attr("action", "MusicInfo.do");
					$(this).attr("method", "post");
					$(this).submit();
				}
				
				if (target.hasClass("playMusic")) {
					
					$.ajax({
						url : 'PlayMusic.do',
						type:'POST',
						data : {
							'musicId' : $(this).find("[name=musicId]").val()
							
						},
						success : function(data) {
							var obj = eval("(" + data + ")");
							$(audioPlayer).attr('src', obj.filePath);
							audioPlayer.play();
						}
					});
				
				}
			});
		 
		 $(".memberInfo").click(function(e) {
				var target = $(e.target);
				if (target.hasClass("nickName")) {
					$(this).attr("action", "MemberInfo.do");
					$(this).attr("method", "post");
					$(this).submit();
				}
			});
		 
		 $(".playlistInfo").click(function(e) {
				var target = $(e.target);
				if (target.hasClass("playPlaylist")) {
						
					 $.ajax({
							url : 'PlayPlaylist.do',
							type:'POST',
							data : {
								'playlistId' : $(this).find("[name=playlistId]").val()
								
							},
							success : function(data) {
								var obj = eval("(" + data + ")");
								
						 			$(audioPlayer).attr('src',obj.list[0]);
						 			
						 			for(var a = 0; a <3; a++){
						 				$(audioPlayer).append("<source src="+obj.list[a+1]+" type='audio/mpeg'></source>");
						 			}
						 			
						 			audioPlayer.play();
							}
						});
					 
					}
				});
		 
	});
	 
 

	

</script>
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

${member.memberNickName}님이 좋아요한 목록입니다.<br><br>

<h3>Music</h3>
<c:forEach var="music" items="${musiclists}">
<div>
	<form class="musicInfo">
	<input type="hidden" name="musicId" value="${music.musicId}"><br>
	<span class="musicTitle">${music.musicTitle}</span><br>
	<img class="playMusic" src=<c:out value="${music.imagePath}"/>><br>
	</form>
	<form class="memberInfo">
	<input type="hidden" name="memberId" value="${music.memberId}"><br>
	<span class="nickName">${music.memberNickName}</span><br>
	</form>
	genreName:${music.genreName}<br>
	tagName:${music.tagName}<br>
	likeCnt:${music.likeCnt}<br>
</div>
</c:forEach>

<h3>Playlist</h3>

<c:forEach var="playlist" items="${playlists}">
	<div>
	<form class="playlistInfo">
	<span class="playlistTitle">${playlist.playlistTitle}</span><br>
	<!-- 플레이리스트 타이틀 누르면 플레이리스트 페이지로 이동해야함 -->
	<input type="hidden" name="playlistId" value="${playlist.playlistId}">
	<img class="playPlaylist" src=<c:out value="${playlist.imagePath}"/>>
	</form>
	<br>
	<form class="memberInfo">
	<input type="hidden" name="memberId" value="${playlist.memberId}">
	<span class="nickName">${playlist.memberNickName}</span><br>
	</form>
	${playlist.tagName}<br>
	${playlist.playlistIntro}<br>
	${playlist.playlistDate}<br>
	
		<c:forEach var="music" items="${playlist.musicList}">
			<form class="musicInfo">
			<span class="musicTitle">${music.musicTitle}</span>
			<input type="hidden" name="musicId" value="${music.musicId}"><br>
			${music.likeCnt}<br>
			<img class="playMusic" src=<c:out value="${music.imagePath}"/>>
			</form>
			<br>
		</c:forEach>
	</div>
</c:forEach>

</body>
</html>