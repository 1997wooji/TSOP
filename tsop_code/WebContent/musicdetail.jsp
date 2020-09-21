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
				<div class="music music-info p-5">
					<!-- 여기 플레이리스트 목록이 옴 forEach 써서 가즈아 -->
					<div class="d-flex">
						<div class="music-image">
							<img src="${music.imagePath}" class="img-jumbo">
						</div>
						<div class="card flex-fill pl-5">
							<div class="card-header">
								<div>
									<div class="music-title" name="musicTitle">${music.musicTitle }</div>
									<div class="music-nickname" id="memberNickName">${music.memberNickName }</div>
								</div>
							</div>
							<div class="card-body">								
								<div>
									${music.musicIntro }
								</div>
								<div>
									${music.tagname }
								</div>
							</div>
							<div class="card-footer">
								<button class="btn-tsop btn-like fa fa-heart <c:if test="${member.memberId ne sessionScope.loginId }">like-active</c:if>" name="listMusicBtn" id="likeBtn"></button>
								<input type="hidden" name="isLike" value="true">
								<button class="btn-tsop btn-play-music fa fa-play"></button>
								<button class="btn-tsop btn-play-playlist fas fa-list" data-toggle="dropdown" name="addMusicPlaylistBtn"></button>
								<c:if test="${member.memberId eq sessionScope.loginId }">
								<button type="button" class="btn-tsop btn-edit fa fa-edit" data-toggle="modal" data-target="#myModal" ></button>
								</c:if>
								<div class="dropdown-menu test" aria-labelledby="dropdownMenuButton">
								</div>									
							</div>
						</div>
					</div>
					<input type="hidden" id="musicId" name="musicId" value="${music.musicId }">
					<input type="hidden" id="musicId" name="mId" value="${music.musicId }">
					<input type="hidden" id="memId" name="memId" value="${music.memberId }">
				</div>
				
				
				
<div class="container" >
  <!-- Trigger the modal with a button -->
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content bg-white">
        <div class="modal-header">
          <h4 class="modal-title">곡 수정하기</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
          <div name="updateDiv">
         <img src="${music.imagePath}" class="updateImg img-big py-1 border">
         </div>
         <form id="fileSubmit" enctype="multipart/form-data">
        	 <input class="hidden" type="file" name="uploadFile">
         </form>
         <div class="form-group">
         <label>제목</label><input type="text" class="form-control mt-1" name="Title" value="${music.musicTitle }">
         <label>태그</label><input input="text" class="form-control" name="Tag" value="${music.tagname }">
         <label>장르</label><input type="text" class="form-control" name="Genre" value="${music.genreName }">
         <label>소개</label><input type="text" class="form-control" name="Intro" value="${music.musicIntro }">
         </div>
         
		 <div class="form-check form-check-inline hidden">
		 <label class="form-check-label">곡 공개</label>
		  <input type="radio" id="customRadio1" name="visibility"  class="form-check-input" value="true" <c:if test="${music.visibility eq true }"> checked </c:if>>
		  <label class="form-check-label" for="customRadio1">공개</label>
		  <input type="radio" id="customRadio2" name="visibility"  class="form-check-input" value="false"  <c:if test="${music.visibility eq false }"> checked </c:if>>
		  <label  class="form-check-label" for="customRadio2">비공개</label>
		</div>
         <div class="hidden">
         <span>다운로드 허용</span>
               <input type="radio" name="downAccept" value="true" <c:if test="${music.downAccept eq 'true' }">checked</c:if>>공개
                <input type="radio" name="downAccept" value="false" <c:if test="${music.downAccept eq 'false' }">checked</c:if>>비 공개
         </div>
         <div class="hidden">
            
            <button name="cancelBtn">취소</button>
            <button name="deleteBtn">곡 삭제</button>
         </div>
      </div>
        <div class="modal-footer">
        <button name="updateOkBtn" type="button" class="btn btn-default" data-dismiss="modal">수정</button>
        </div>
      </div>
     </div>
    </div>
</div>
</body>
</html>