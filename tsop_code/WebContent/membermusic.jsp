<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script src="./tsop/js/musicinfo.js"></script>
<script src="./tsop/js/navSearch.js"></script>
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
							alert(obj.filePath);
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
 
	});
	

</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		  <a class="nav-link active" href="./memberinfo.do?memberId=${member.memberId }">Tracks</a>
		  <a class="nav-link " href="./memberplaylist.do?memberId=${member.memberId }">Playlist</a>
		  <a class="nav-link" href="./memberfollows.do?memberId=${member.memberId }">Follows</a>
		  <a class="nav-link" href="./memberfollowers.do?memberId=${member.memberId }">Followers</a>
		</nav>
			
		<div class="container p-5">
			
			<c:forEach items="${musics }" var="music" varStatus="i">
				<c:if test="${i.index mod 3 eq 0 }">
				<div class="card-deck">
				</c:if>
				  <div class="card music-card">
				    <img class="card-img-top" src="${music.musicImagePath }" alt="Card image cap">
				    <div class="card-body">
				      <h5 class="card-title"><a href="./musicinfo.do?memberId=${music.memberId}&musicId=${music.musicId}" class="text-link">${music.musicTitle }</a></h5>
				      <small class="text-muted">${music.memberNickName }</small>
				    </div>
				    <div class="card-footer">
				    <c:if test="${member.memberId ne sessionScope.loginId }">
				      <button type="button" class="btn-tsop btn-like fa fa-heart"></button>
				    </c:if>
				    	<button type="button" class="btn-tsop btn-play-music fa fa-play"></button>
				    </div>
				  </div>
				<c:choose>
				<c:when test="${index.index % 3 eq 2 }">
					</div>
				</c:when>
				<c:when test="${i.last }">
					</div>
				</c:when>
				</c:choose>
			</c:forEach>
		</div>
	</div>	
</div>

<!-- 플레이어 -->
<jsp:include page="/player.jsp"></jsp:include>

<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" style="background-color:black; color:white">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">곡 수정하기.</h4>
        </div>
        <div class="modal-body">
          <div name="updateDiv">
         <img src="${music.imagePath}" class="updateImg" style="width:100px; height:100px"></div>
         <form id="fileSubmit" enctype="multipart/form-data">
         <input type="file" name="uploadFile">
         </form>
         <div>제목<input type="text" name="Title" value="${music.musicTitle }"></div>
         <div>태그<input input="text" name="Tag" value="${music.tagname }"></div>
         <div>장르<input type="text" name="Genre" value="${music.genreName }"></div>
         <div>소개<input type="text" name="Intro" value="${music.musicIntro }"></div>
         <div>
         <span>곡 공개</span> 
               <input type="radio" name="visibility" value="true" <c:if test="${music.visibility eq true }"> checked </c:if> >공개
               <input type="radio" name="visibility" value="false" <c:if test="${music.visibility eq false }"> checked </c:if> >비 공개
         </div>
         <div>
         <span>다운로드 허용</span>
               <input type="radio" name="downAccept" value="true" <c:if test="${music.downAccept eq 'true' }">checked</c:if>>공개
                <input type="radio" name="downAccept" value="false" <c:if test="${music.downAccept eq 'false' }">checked</c:if>>비 공개
         </div>
         <div>
            <button name="updateOkBtn">수정</button>
            <button name="cancelBtn">취소</button>
            <button name="deleteBtn">곡 삭제</button>
         </div>
      </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>

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
</body>
</html>